package Controlador;

import IGU.Principal;
import notification.PrevisualizarInfo;
import Modelo.Datos;
import Modelo.DatosDAO;
import Modelo.usuarios;
import Modelo.usuariosDAO;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.GraphicsEnvironment;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import notification.NotificacionFaltaInfo;

public class Controlador implements ActionListener {

    DatosDAO dao = new DatosDAO();
    Datos d = new Datos();
    Principal cd = new Principal();
    usuarios usuario = new usuarios();
    usuariosDAO udao = new usuariosDAO();

    public Controlador(IGU.Principal cd) {
        this.cd = cd;
        this.cd.guardar.addActionListener(this);
        this.cd.refrescar.addActionListener(this);
        this.cd.BtnEliminar.addActionListener(this);
        this.cd.btnEliminarUsuario.addActionListener(this);
        this.cd.btnbuscar.addActionListener(this);
        // La siguiente línea asume que 'btnEnlace' está en 'Principal', si no lo está, debe ser eliminada.
        // this.cd.btnEnlace.addActionListener(this); 

        this.cd.Tabla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                tablaDobleClic(evt);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cd.guardar) {
            agregar();
        }
        if (e.getSource() == cd.refrescar) {
            refrescar();
        }
        if (e.getSource() == cd.BtnEliminar) {
            delete();
            refrescar();
        }
        if (e.getSource() == cd.btnEliminarUsuario) {
            deleteUser();
            refrescar();
        }
        if (e.getSource() == cd.btnbuscar) {
            buscar();
        }
        /* La siguiente sección debe ser eliminada si 'btnEnlace' no está en 'Principal'
        if (e.getSource() == cd.btnEnlace) {
            abrirEnlace();
        }*/
    }

    public void refrescar() {
        try {
            listar(cd.Tabla);
            listarUser(cd.TablaUser);
        } catch (SQLException ex) {
            Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete() {
        int fila = cd.Tabla.getSelectedRow();
        if (fila == -1) {
            NotificacionFaltaInfo notificacion = new NotificacionFaltaInfo();
            Rectangle screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();
            int x = screen.width - notificacion.getWidth() - 10;
            int y = 10;
            notificacion.setLocation(x, y);
            notificacion.setBackground(new Color(0, 0, 0, 0));
            Timer timer = new Timer(5000, e -> notificacion.dispose());
            timer.setRepeats(false);
            timer.start();
            notificacion.setVisible(true);
        } else {
            String[] options = {"Salir", "Continuar"};
            int choice = JOptionPane.showOptionDialog(null, "¿Está seguro de eliminar los siguientes datos?", "Confirmar Eliminación", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (choice == 1) {
                try {
                    int modelRow = cd.Tabla.convertRowIndexToModel(fila);
                    int id = Integer.parseInt(cd.Tabla.getModel().getValueAt(modelRow, 0).toString());
                    dao.delete(id);
                    JOptionPane.showMessageDialog(null, "El proyecto ha sido eliminado.");
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Error: El ID del proyecto no es válido.");
                }
            }
        }
    }

    public void deleteUser() {
        int fila = cd.TablaUser.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un perfil.");
        } else {
            String[] options = {"Salir", "Continuar"};
            int choice = JOptionPane.showOptionDialog(null, "¿Está seguro de eliminar los siguientes datos?", "Opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
            if (choice == 1) {
                int id = Integer.parseInt(cd.TablaUser.getValueAt(fila, 0).toString());
                udao.deleteUser(id);
            }
        }
    }

    /**
    * Este método ahora refresca la tabla automáticamente después de un registro exitoso.
    */
    public void agregar() {
        String sede = cd.sede.getSelectedItem().toString();
        String pnf = cd.pnf.getSelectedItem().toString();
        String trayecto = cd.trayecto.getSelectedItem().toString();
        String tproyecto = cd.tproyecto.getText();
        Calendar fechaSeleccionada = cd.fdpresentacion.getCalendar();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String fdpresentacion = format.format(fechaSeleccionada.getTime());
        String seccion = cd.seccion.getText();
        String txtnom = cd.txtnom.getText();
        String profesor = cd.profesor.getText();
        String url = cd.url.getText();
        
        d.setFdpresentacion(fdpresentacion);
        d.setPnf(pnf);
        d.setSeccion(seccion);
        d.setSede(sede);
        d.setTrayecto(trayecto);
        d.setTproyecto(tproyecto);
        d.setTxtnom(txtnom);
        d.setProfesor(profesor);
        d.setUrl(url);
        
        int r = dao.agregar(d);
        if (r == 1) {
            JOptionPane.showMessageDialog(cd, "Información cargada exitosamente.");
            refrescar(); // <-- ¡AQUÍ ESTÁ LA LÍNEA AÑADIDA!
        } else {
            JOptionPane.showMessageDialog(cd, "Hubo un error al cargar la información, contacta con el administrador.");
        }
    }

    public void listar(JTable Tabla) throws SQLException {
        DefaultTableModel tablaModelo = (DefaultTableModel) Tabla.getModel();
        tablaModelo.setRowCount(0); // Limpia la tabla
        List<Datos> lista = dao.listar();
        for (Datos dato : lista) {
            Object[] object = new Object[10];
            object[0] = dato.getId();
            object[1] = dato.getPnf();
            object[2] = dato.getSede();
            object[3] = dato.getTrayecto();
            object[4] = dato.getSeccion();
            object[5] = dato.getProfesor();
            object[6] = dato.getTproyecto();
            object[7] = dato.getTxtnom();
            object[8] = dato.getFdpresentacion();
            object[9] = dato.getUrl();
            tablaModelo.addRow(object);
        }
    }

    public void listarUser(JTable TablaUser) throws SQLException {
        DefaultTableModel userTableModel = (DefaultTableModel) TablaUser.getModel();
        userTableModel.setRowCount(0); // Limpia la tabla
        List<usuarios> lista = udao.listarUser();
        if (lista != null) {
            for (usuarios user : lista) {
                Object[] object = new Object[5];
                object[0] = user.getId();
                object[1] = user.getCi();
                object[2] = user.getNombre();
                object[3] = user.getLast_session();
                object[4] = user.getNombre_tipo();
                userTableModel.addRow(object);
            }
        }
    }

    public void buscar() {
        String filtroSeleccionado = cd.filtrar.getSelectedItem().toString();
        String buscarTexto = cd.txtBuscar.getText();
        buscar(filtroSeleccionado, buscarTexto);
    }

    public void buscar(String filtroSeleccionado, String buscarTexto) {
        DefaultTableModel tableModel = (DefaultTableModel) cd.Tabla.getModel();
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<>(tableModel);
        cd.Tabla.setRowSorter(tr);
        if (filtroSeleccionado.equals("Todas")) {
            tr.setRowFilter(RowFilter.regexFilter("(?i)" + buscarTexto));
        } else {
            int columna = getColumnaFiltro(filtroSeleccionado);
            if (columna != -1) {
                tr.setRowFilter(RowFilter.regexFilter("(?i)" + buscarTexto, columna));
            }
        }
    }

    private int getColumnaFiltro(String filtroSeleccionado) {
        switch (filtroSeleccionado) {
            case "ID": return 0;
            case "Sede": return 2;
            case "PNF": return 1;
            case "Trayecto": return 3;
            case "Seccion": return 4;
            case "Titulo de proyecto": return 6;
            case "Nombres de integrantes": return 7;
            case "Fecha de presentacion": return 8;
            case "Profesor": return 5;
            default: return -1;
        }
    }
    
    public void tablaDobleClic(MouseEvent evt) {
        if (evt.getClickCount() == 2) {
            JTable tabla = (JTable) evt.getSource();
            int filaSeleccionada = tabla.getSelectedRow();

            if (filaSeleccionada >= 0) {
                try {
                    DefaultTableModel currentModel = (DefaultTableModel) tabla.getModel();
                    int filaModelo = tabla.convertRowIndexToModel(filaSeleccionada);
                    
                    String id = currentModel.getValueAt(filaModelo, 0).toString();
                    String pnf = currentModel.getValueAt(filaModelo, 1).toString();
                    String sede = currentModel.getValueAt(filaModelo, 2).toString();
                    String trayecto = currentModel.getValueAt(filaModelo, 3).toString();
                    String seccion = currentModel.getValueAt(filaModelo, 4).toString();
                    String profesor = currentModel.getValueAt(filaModelo, 5).toString();
                    String titulo = currentModel.getValueAt(filaModelo, 6).toString();
                    String integrantes = currentModel.getValueAt(filaModelo, 7).toString();
                    String fechaPresentacion = currentModel.getValueAt(filaModelo, 8).toString();
                    String url = currentModel.getValueAt(filaModelo, 9).toString();

                    PrevisualizarInfo previsualizarDialog = new PrevisualizarInfo(cd, true);
                    
                    previsualizarDialog.txtIdPre.setText(id);
                    previsualizarDialog.txtPNFPre.setText(pnf);
                    previsualizarDialog.txtSedePre.setText(sede);
                    previsualizarDialog.txtTrayectoPre.setText(trayecto);
                    previsualizarDialog.txtSeccionPre.setText(seccion);
                    previsualizarDialog.txtProfesorPre.setText(profesor);
                    previsualizarDialog.txtTituloPre.setText(titulo);
                    previsualizarDialog.txtIntegrantesPre.setText(integrantes);
                    previsualizarDialog.txtFDPresentacionPre.setText(fechaPresentacion);
                    previsualizarDialog.setProyectoUrl(url);
                    
                    previsualizarDialog.setLocationRelativeTo(cd);
                    previsualizarDialog.setVisible(true);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(cd, "Hubo un error al mostrar los datos del proyecto.");
                    e.printStackTrace();
                }
            }
        }
    }
}