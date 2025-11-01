package Controlador;

import IGU.Principal;
import Modelo.Datos;
import Modelo.DatosDAO;
import Modelo.usuarios;
import Modelo.usuariosDAO;
import notification.PrevisualizarInfo;
import notification.NotificacionFaltaInfo;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class Controlador implements ActionListener {

    private void setDBButtonsEnabled(boolean enabled) {
        cd.btnCargarDatos.setEnabled(enabled);
        cd.btnConfig.setEnabled(enabled);
        cd.btnVisualizar.setEnabled(enabled);
        cd.btnGestionarUsuarios.setEnabled(enabled);
        cd.btnInicio.setEnabled(enabled);
        cd.guardar.setEnabled(enabled);
        cd.refrescar.setEnabled(enabled);
        cd.BtnEliminar.setEnabled(enabled);
        cd.btnEliminarUsuario.setEnabled(enabled);

    }
    // Mantenemos las variables originales para compatibilidad
    private final DatosDAO dao = new DatosDAO();
    private final usuariosDAO udao = new usuariosDAO();
    private final Principal cd;

    public Controlador(Principal cd) {
        this.cd = cd;
        // Asignamos los listeners a los componentes de la vista
        this.cd.guardar.addActionListener(this);
        this.cd.refrescar.addActionListener(this);
        this.cd.BtnEliminar.addActionListener(this);
        this.cd.btnEliminarUsuario.addActionListener(this);
        this.cd.btnbuscar.addActionListener(this);

        this.cd.Tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tablaDobleClic(evt);
            }
        });

        // Al iniciar, cargamos los datos por primera vez.
        refrescarDatos();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == cd.guardar) {
            agregarDatos();
        } else if (source == cd.refrescar) {
            refrescarDatos();
        } else if (source == cd.BtnEliminar) {
            eliminarDatos();
        } else if (source == cd.btnEliminarUsuario) {
            eliminarUsuario();
        } else if (source == cd.btnbuscar) {
            buscar();
        }
    }

    /**
     * Inicia la carga en segundo plano de ambas tablas.
     */
    public void refrescarDatos() {
        cargarTablaProyectos();
        setDBButtonsEnabled(false);
        cd.guardar.setEnabled(false);
        //cargarTablaUsuarios();
    }

    // --- MÉTODOS CON SWINGWORKER PARA NO CONGELAR LA GUI ---
    /**
     * Carga los datos de los proyectos en un hilo de fondo.
     */
    private void cargarTablaProyectos() {
    // Ya no necesita apagar botones, 'refrescarDatos' lo hizo.

    SwingWorker<List<Datos>, Void> worker = new SwingWorker<List<Datos>, Void>() {
        @Override
        protected List<Datos> doInBackground() throws Exception {
            return dao.listar();
        }

        @Override
        protected void done() {
            try {
                List<Datos> lista = get(); 
                actualizarModeloTablaProyectos(lista);
            } catch (Exception e) { // Usamos Exception para capturar todo
                e.printStackTrace();
                JOptionPane.showMessageDialog(cd, "Error al cargar los datos de proyectos.", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                // ✅ ¡LA MAGIA DE LA CADENA!
                // Al terminar, llamamos a la siguiente tarea.
                cargarTablaUsuarios();
            }
        }
    };
    worker.execute();
}
    /**
     * Carga los datos de los usuarios en un hilo de fondo.
     */
    private void cargarTablaUsuarios() {
    SwingWorker<List<usuarios>, Void> worker = new SwingWorker<List<usuarios>, Void>() {
        @Override
        protected List<usuarios> doInBackground() throws Exception {
            return udao.listarUser();
        }

        @Override
        protected void done() {
            try {
                List<usuarios> lista = get();
                actualizarModeloTablaUsuarios(lista);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(cd, "Error al cargar los datos de usuarios.", "Error", JOptionPane.ERROR_MESSAGE);
            } finally {
                // ✅ ¡FIN DE LA CADENA!
                // Como esta es la última tarea, volvemos a encender
                // todos los botones para el usuario.
                setDBButtonsEnabled(true);
            }
        }
    };
    worker.execute();
}
    /**
     * Agrega un nuevo proyecto en un hilo de fondo.
     */
    private void agregarDatos() {
        setDBButtonsEnabled(false);
        Datos d = new Datos();
        try {
            d.setSede(cd.sede.getSelectedItem().toString());
            d.setPnf(cd.pnf.getSelectedItem().toString());
            d.setTrayecto(cd.trayecto.getSelectedItem().toString());
            d.setTproyecto(cd.tproyecto.getText());
            Calendar fechaSeleccionada = cd.fdpresentacion.getCalendar();
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            d.setFdpresentacion(format.format(fechaSeleccionada.getTime()));
            d.setSeccion(cd.seccion.getText());
            d.setTxtnom(cd.txtnom.getText());
            d.setProfesor(cd.profesor.getText());
            d.setUrl(cd.url.getText());
        } catch (Exception ex) {
            setDBButtonsEnabled(true);
            JOptionPane.showMessageDialog(cd, "Verifique que todos los campos estén llenos.", "Datos Incompletos", JOptionPane.WARNING_MESSAGE);
            return;
        }

        cd.guardar.setEnabled(false);

        SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                return dao.agregar(d);
            }

            @Override
            protected void done() {
                try {
                    boolean exito = get();
                    if (exito) {
                        JOptionPane.showMessageDialog(cd, "Información cargada exitosamente.");
                        refrescarDatos(); // Recargamos las tablas
                    } else {
                        JOptionPane.showMessageDialog(cd, "Hubo un error al cargar la información.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(cd, "Error grave al agregar el proyecto.", "Error", JOptionPane.ERROR_MESSAGE);
                } finally {
                    cd.guardar.setEnabled(false);
                    setDBButtonsEnabled(true);
                }
            }
        };
        worker.execute();
    }

    /**
     * Elimina un proyecto seleccionado en un hilo de fondo.
     */
    private void eliminarDatos() {
        int fila = cd.Tabla.getSelectedRow();
        if (fila == -1) {
            mostrarNotificacionFaltaInfo();
            return;
        }

        int choice = JOptionPane.showConfirmDialog(cd, "¿Está seguro de eliminar el proyecto seleccionado?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            try {
                int modelRow = cd.Tabla.convertRowIndexToModel(fila);
                int id = Integer.parseInt(cd.Tabla.getModel().getValueAt(modelRow, 0).toString());

                cd.BtnEliminar.setEnabled(false);

                SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
                    @Override
                    protected Boolean doInBackground() throws Exception {
                        return dao.delete(id);
                    }

                    @Override
                    protected void done() {
                        try {
                            boolean exito = get();
                            if (exito) {
                                JOptionPane.showMessageDialog(cd, "El proyecto ha sido eliminado.");
                                refrescarDatos();
                            } else {
                                JOptionPane.showMessageDialog(cd, "No se pudo eliminar el proyecto.", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (InterruptedException | ExecutionException e) {
                            e.printStackTrace();
                            JOptionPane.showMessageDialog(cd, "Error grave al eliminar el proyecto.", "Error", JOptionPane.ERROR_MESSAGE);
                        } finally {
                            cd.BtnEliminar.setEnabled(true);
                        }
                    }
                };
                worker.execute();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(cd, "Error: El ID del proyecto no es válido.");
            }
        }
    }

    /**
     * Elimina un usuario seleccionado en un hilo de fondo.
     */
    private void eliminarUsuario() {
        int fila = cd.TablaUser.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(cd, "Debe seleccionar un perfil de usuario.");
            return;
        }

        int choice = JOptionPane.showConfirmDialog(cd, "¿Está seguro de eliminar el usuario seleccionado?", "Confirmar Eliminación", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            int modelRow = cd.TablaUser.convertRowIndexToModel(fila);
            int id = Integer.parseInt(cd.TablaUser.getModel().getValueAt(modelRow, 0).toString());

            cd.btnEliminarUsuario.setEnabled(false);

            SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
                @Override
                protected Boolean doInBackground() throws Exception {
                    return udao.deleteUser(id);
                }

                @Override
                protected void done() {
                    try {
                        if (get()) {
                            JOptionPane.showMessageDialog(cd, "Usuario eliminado exitosamente.");
                            refrescarDatos();
                        } else {
                            JOptionPane.showMessageDialog(cd, "No se pudo eliminar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (InterruptedException | ExecutionException e) {
                        e.printStackTrace();
                        JOptionPane.showMessageDialog(cd, "Error grave al eliminar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        cd.btnEliminarUsuario.setEnabled(true);
                    }
                }
            };
            worker.execute();
        }
    }

    // --- MÉTODOS AUXILIARES PARA ACTUALIZAR LA GUI ---
    private void actualizarModeloTablaProyectos(List<Datos> lista) {
        DefaultTableModel tablaModelo = (DefaultTableModel) cd.Tabla.getModel();
        tablaModelo.setRowCount(0); // Limpia la tabla
        for (Datos dato : lista) {
            // El orden aquí debe coincidir EXACTAMENTE con el de tus columnas en la GUI
            Object[] fila = {
                dato.getId(),
                dato.getPnf(),
                dato.getSede(),
                dato.getTrayecto(),
                dato.getSeccion(),
                dato.getProfesor(),
                dato.getTproyecto(),
                dato.getTxtnom(),
                dato.getFdpresentacion(),
                dato.getUrl()
            };
            tablaModelo.addRow(fila);
        }
    }

    private void actualizarModeloTablaUsuarios(List<usuarios> lista) {
        DefaultTableModel userTableModel = (DefaultTableModel) cd.TablaUser.getModel();
        userTableModel.setRowCount(0); // Limpia la tabla
        for (usuarios user : lista) {
            Object[] fila = {
                user.getId(),
                user.getCi(),
                user.getNombre(),
                user.getLast_session(),
                user.getNombre_tipo() // Nota: necesitarás un JOIN en tu udao.listarUser() para que esto funcione
            };
            userTableModel.addRow(fila);
        }
    }

    // --- MÉTODOS DE LA GUI QUE NO NECESITAN SWINGWORKER (SON RÁPIDOS) ---
    public void buscar() {
        String filtroSeleccionado = cd.filtrar.getSelectedItem().toString();
        String buscarTexto = cd.txtBuscar.getText();

        DefaultTableModel tableModel = (DefaultTableModel) cd.Tabla.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(tableModel);
        cd.Tabla.setRowSorter(tr);

        if ("Todas".equals(filtroSeleccionado)) {
            tr.setRowFilter(RowFilter.regexFilter("(?i)" + buscarTexto));
        } else {
            int columna = getColumnaFiltro(filtroSeleccionado);
            if (columna != -1) {
                tr.setRowFilter(RowFilter.regexFilter("(?i)" + buscarTexto, columna));
            }
        }
    }

    private int getColumnaFiltro(String filtro) {
        // La forma clásica del switch, compatible con Java 8
        switch (filtro) {
            case "ID":
                return 0;
            case "PNF":
                return 1;
            case "Sede":
                return 2;
            case "Trayecto":
                return 3;
            case "Seccion":
                return 4;
            case "Profesor":
                return 5;
            case "Titulo de proyecto":
                return 6;
            case "Nombres de integrantes":
                return 7;
            case "Fecha de presentacion":
                return 8;
            default:
                return -1; // Si no coincide con ninguno, devuelve -1
        }
    }

    public void tablaDobleClic(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JTable tabla = (JTable) evt.getSource();
            int filaSeleccionada = tabla.getSelectedRow();
            if (filaSeleccionada < 0) {
                return;
            }

            try {
                DefaultTableModel model = (DefaultTableModel) tabla.getModel();
                int filaModelo = tabla.convertRowIndexToModel(filaSeleccionada);

                PrevisualizarInfo dialog = new PrevisualizarInfo(cd, true);
                dialog.txtIdPre.setText(model.getValueAt(filaModelo, 0).toString());
                dialog.txtPNFPre.setText(model.getValueAt(filaModelo, 1).toString());
                dialog.txtSedePre.setText(model.getValueAt(filaModelo, 2).toString());
                dialog.txtTrayectoPre.setText(model.getValueAt(filaModelo, 3).toString());
                dialog.txtSeccionPre.setText(model.getValueAt(filaModelo, 4).toString());
                dialog.txtProfesorPre.setText(model.getValueAt(filaModelo, 5).toString());
                dialog.txtTituloPre.setText(model.getValueAt(filaModelo, 6).toString());
                dialog.txtIntegrantesPre.setText(model.getValueAt(filaModelo, 7).toString());
                dialog.txtFDPresentacionPre.setText(model.getValueAt(filaModelo, 8).toString());
                dialog.setProyectoUrl(model.getValueAt(filaModelo, 9).toString());

                dialog.setLocationRelativeTo(cd);
                dialog.setVisible(true);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(cd, "Hubo un error al mostrar los datos del proyecto.");
                e.printStackTrace();
            }
        }
    }

    private void mostrarNotificacionFaltaInfo() {
        NotificacionFaltaInfo notificacion = new NotificacionFaltaInfo();
        Rectangle screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
        notificacion.setLocation(screen.width - notificacion.getWidth() - 10, 10);
        notificacion.setBackground(new Color(0, 0, 0, 0));
        Timer timer = new Timer(5000, e -> notificacion.dispose());
        timer.setRepeats(false);
        timer.start();
        notificacion.setVisible(true);
    }
}
