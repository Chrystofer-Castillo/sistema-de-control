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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.ExecutionException;
import notification.NotificacionError;
import notification.NotificacionExitosa;

public class Controlador implements ActionListener {

private void setDBButtonsEnabled(boolean enabled) {
    cd.btnCargarDatos.setEnabled(enabled);
    cd.btnTheme.setEnabled(enabled);
    cd.btnVisualizar.setEnabled(enabled);
    cd.btnGestionarUsuarios.setEnabled(enabled);
    cd.btnInicio.setEnabled(enabled);
    cd.refrescar.setEnabled(enabled);
    cd.BtnEliminar.setEnabled(enabled);
    cd.btnEliminarUsuario.setEnabled(enabled);

}
// Mantenemos las variables originales para compatibilidad
private final DatosDAO dao = new DatosDAO();
private final usuariosDAO udao = new usuariosDAO();
private final Principal cd;
private volatile boolean isDatabaseBusy = false;

public Controlador(Principal cd) {
    this.cd = cd;
    // Asignamos los listeners a los componentes de la vista
    this.cd.guardar.addActionListener(this);
    this.cd.refrescar.addActionListener(this);
    this.cd.BtnEliminar.addActionListener(this);
    this.cd.btnEliminarUsuario.addActionListener(this);
    this.cd.btnbuscar.addActionListener(this);
    this.cd.btnTheme.addActionListener(this);

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

// --- Tus otros botones (se quedan igual) ---
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

// --- ✅ LA LÓGICA (Lo que faltaba) ---
// Esto es lo que se ejecuta al presionar el botón de tema


if (source == cd.btnTheme) {

// 1. Obtenemos la Cédula (ID) del usuario
//    Cambiamos la línea roja por esta:
String ci = cd.getUsuarioCi(); // ✅ ¡Solucionado!

// 2. Le decimos al 'SettingsManager' que escriba en el XML
Modelo.SettingsManager.toggleThemePreference(ci);

// 3. Mostramos el mensaje de advertencia
JOptionPane.showMessageDialog(cd, 
    "Los cambios se aplicarán en el próximo reinicio.", 
    "ATENCIÓN", 
    JOptionPane.WARNING_MESSAGE);


}
}

/**
 * Inicia la carga en segundo plano de ambas tablas.
 */
public void refrescarDatos() {
    cargarTablaProyectos();
    setDBButtonsEnabled(false);
    cd.guardar.setEnabled(false);
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
                //------------------------------------------------------------------
                    String mensajeUno = "Error al cargar los datos de proyectos";
                    String mensajeDos = "Intente mas tarde";
                    NotificacionError notificacion = new NotificacionError(cd, true, mensajeUno, mensajeDos);
                    notificacion.setVisible(true);
                //------------------------------------------------------------------
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
                
                //------------------------------------------------------------------
                    String mensajeUno = "Error al cargar los datos del Usuario";
                    String mensajeDos = "";
                    NotificacionError notificacion = new NotificacionError(cd, true, mensajeUno, mensajeDos);
                    notificacion.setVisible(true);
                //------------------------------------------------------------------

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
private void actualizarDatos(Datos datosNuevos) {
    // 1. Verificamos el "letrero".
    if (isDatabaseBusy) {
        //------------------------------------------------------------------
        String msjfalta1 = "Espere a que termine la operación actual...";
        String msjfalta2 = "";
        NotificacionFaltaInfo notificacion = new NotificacionFaltaInfo(cd, true, msjfalta1, msjfalta2);
        notificacion.setVisible(true);
        //------------------------------------------------------------------

        return;
    }

    // 2. Ponemos el "letrero" y apagamos botones.
    isDatabaseBusy = true;
    setDBButtonsEnabled(false);

    SwingWorker<Boolean, Void> worker = new SwingWorker<Boolean, Void>() {
        @Override
        protected Boolean doInBackground() throws Exception {
            // 3. Llamamos al DAO para que haga el trabajo pesado
            return dao.actualizar(datosNuevos);
        }

        @Override
        protected void done() {
            boolean exito = false;
            try {
                exito = get();
                if (exito) {
                    //------------------------------------------------------------------
                    String mensajeUno = "Proyecto actualizado";
                    String mensajeDos = "exitosamente";
                    NotificacionExitosa notificacion = new NotificacionExitosa(cd, true, mensajeUno, mensajeDos);
                    notificacion.setVisible(true);
                    //------------------------------------------------------------------
                } else {
                    //------------------------------------------------------------------
                    String mensajeUno = "No se pudo actualizar el proyecto.";
                    String mensajeDos = "";
                    NotificacionError notificacion = new NotificacionError(cd, true, mensajeUno, mensajeDos);
                    notificacion.setVisible(true);
                    //------------------------------------------------------------------

                }
            } catch (Exception e) {
                e.printStackTrace();
            //------------------------------------------------------------------
            String mensajeUno = "Error grave al actualizar el proyecto.";
            String mensajeDos = "";
            NotificacionError notificacion = new NotificacionError(cd, true, mensajeUno, mensajeDos);
            notificacion.setVisible(true);
            //------------------------------------------------------------------

            } finally {
                // 4. SIEMPRE desbloqueamos, pero solo refrescamos si tuvo éxito.
                isDatabaseBusy = false;
                setDBButtonsEnabled(true);
            }

            if (exito) {
                refrescarDatos(); // Refrescamos la tabla principal
            }
        }
    };
    worker.execute();
}

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
        
        //------------------------------------------------------------------
        String msjfalta1 = "Verifique que todos los campos estén llenos.";
        String msjfalta2 = "";
        NotificacionFaltaInfo notificacion = new NotificacionFaltaInfo(cd, true, msjfalta1, msjfalta2);
        notificacion.setVisible(true);
        //------------------------------------------------------------------
        
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
                //------------------------------------------------------------------
                String msjexito1 = "Información cargada exitosamente.";
                String msjexito2 = "";
                NotificacionExitosa notificacion = new NotificacionExitosa(cd, true, msjexito1, msjexito2);
                notificacion.setVisible(true);
                //------------------------------------------------------------------
                    refrescarDatos(); // Recargamos las tablas
                } else {
                    //------------------------------------------------------------------
                    String mensajeUno = "Hubo un error al cargar la información.";
                    String mensajeDos = "";
                    NotificacionError notificacion = new NotificacionError(cd, true, mensajeUno, mensajeDos);
                    notificacion.setVisible(true);
                    //------------------------------------------------------------------
                }
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                //------------------------------------------------------------------
                    String mensajeUno = "Error grave al agregar el proyecto.";
                    String mensajeDos = "";
                    NotificacionError notificacion = new NotificacionError(cd, true, mensajeUno, mensajeDos);
                    notificacion.setVisible(true);
                //------------------------------------------------------------------
               
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

    notification.NotiEliminar dialog = new notification.NotiEliminar(cd, true);
    dialog.setLocationRelativeTo(cd);
    dialog.setVisible(true);

    if (dialog.isContinuePressed()) {
        try {
            int modelRow = cd.Tabla.convertRowIndexToModel(fila);
            int id = Integer.parseInt(cd.Tabla.getModel().getValueAt(modelRow, 0).toString());

            // ¡NO bloqueamos nada!
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
                            //------------------------------------------------------------------
                            String msjexito1 = "El proyecto ha sido eliminado";
                            String msjexito2 = "Exitosamente";
                            NotificacionExitosa notificacion = new NotificacionExitosa(cd, true, msjexito1, msjexito2);
                            notificacion.setVisible(true);
                            //------------------------------------------------------------------

                            refrescarDatos();
                        } else {
                            //------------------------------------------------------------------
                            String mensajeUno = "No se pudo eliminar el proyecto.";
                            String mensajeDos = "";
                            NotificacionError notificacion = new NotificacionError(cd, true, mensajeUno, mensajeDos);
                            notificacion.setVisible(true);
                            //------------------------------------------------------------------
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        //------------------------------------------------------------------
                        String mensajeUno = "Error grave al eliminar el proyecto.";
                        String mensajeDos = "";
                        NotificacionError notificacion = new NotificacionError(cd, true, mensajeUno, mensajeDos);
                        notificacion.setVisible(true);
                        //------------------------------------------------------------------

                    }
                    // ¡NO hay 'finally' aquí!
                }
            };
            worker.execute();

        } catch (NumberFormatException e) {
                //------------------------------------------------------------------
                    String mensajeUno = "Error: El ID del proyecto no es válido.";
                    String mensajeDos = "";
                    NotificacionError notificacion = new NotificacionError(cd, true, mensajeUno, mensajeDos);
                    notificacion.setVisible(true);
                //------------------------------------------------------------------

        }
    }
}

/**
 * Elimina un usuario seleccionado en un hilo de fondo.
 */
private void eliminarUsuario() {
    int fila = cd.TablaUser.getSelectedRow();
    if (fila == -1) {
        //------------------------------------------------------------------
        String msjfalta1 = "Debe seleccionar un perfil de usuario.";
        String msjfalta2 = "";
        NotificacionFaltaInfo notificacion = new NotificacionFaltaInfo(cd, true, msjfalta1, msjfalta2);
        notificacion.setVisible(true);
        //------------------------------------------------------------------
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
                        //------------------------------------------------------------------
                        String msjexito1 = "Usuario eliminado exitosamente.";
                        String msjexito2 = "";
                        NotificacionExitosa notificacion = new NotificacionExitosa(cd, true, msjexito1, msjexito2);
                        notificacion.setVisible(true);
                        //------------------------------------------------------------------
                        refrescarDatos();
                    } else {
                        //------------------------------------------------------------------
                        String mensajeUno = "No se pudo eliminar el usuario.";
                        String mensajeDos = "";
                        NotificacionError notificacion = new NotificacionError(cd, true, mensajeUno, mensajeDos);
                        notificacion.setVisible(true);
                        //------------------------------------------------------------------
                    }
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                        //------------------------------------------------------------------
                        String mensajeUno = "Error grave al eliminar el usuario.";
                        String mensajeDos = "";
                        NotificacionError notificacion = new NotificacionError(cd, true, mensajeUno, mensajeDos);
                        notificacion.setVisible(true);
                        //------------------------------------------------------------------
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
            user.getNombre_tipo()
        };
        userTableModel.addRow(fila);
    }
}

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
            return -1; 
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

            // --- 1. Obtenemos los datos de la fila (como Strings) ---
            String id = model.getValueAt(filaModelo, 0).toString();
            String pnf = model.getValueAt(filaModelo, 1).toString();
            String sede = model.getValueAt(filaModelo, 2).toString();
            String trayecto = model.getValueAt(filaModelo, 3).toString();
            String seccion = model.getValueAt(filaModelo, 4).toString();
            String profesor = model.getValueAt(filaModelo, 5).toString();
            String titulo = model.getValueAt(filaModelo, 6).toString();
            String integrantes = model.getValueAt(filaModelo, 7).toString();
            String fecha = model.getValueAt(filaModelo, 8).toString();
            String url = model.getValueAt(filaModelo, 9).toString();

            // --- 2. Abrimos la ventana de PREVISUALIZACIÓN ---
            PrevisualizarInfo previsualizarDialog = new PrevisualizarInfo(cd, true);

            // Llenamos los campos del previsualizador (ajusta los nombres si es necesario)
            previsualizarDialog.txtIdPre.setText(id);
            previsualizarDialog.txtPNFPre.setText(pnf);
            previsualizarDialog.txtSedePre.setText(sede);
            previsualizarDialog.txtTrayectoPre.setText(trayecto);
            previsualizarDialog.txtSeccionPre.setText(seccion);
            previsualizarDialog.txtProfesorPre.setText(profesor);
            previsualizarDialog.txtTituloPre.setText(titulo);
            previsualizarDialog.txtIntegrantesPre.setText(integrantes);
            previsualizarDialog.txtFDPresentacionPre.setText(fecha);
            previsualizarDialog.setProyectoUrl(url);

            previsualizarDialog.setLocationRelativeTo(cd);
            previsualizarDialog.setVisible(true);
            if (previsualizarDialog.isEditPressed()) {
                Datos datosParaEditar = new Datos();
                datosParaEditar.setId(Integer.parseInt(id));
                datosParaEditar.setPnf(pnf);
                datosParaEditar.setSede(sede);
                datosParaEditar.setTrayecto(trayecto);
                datosParaEditar.setSeccion(seccion);
                datosParaEditar.setProfesor(profesor);
                datosParaEditar.setTproyecto(titulo);
                datosParaEditar.setTxtnom(integrantes);
                datosParaEditar.setFdpresentacion(fecha);
                datosParaEditar.setUrl(url);

                notification.EditarDatos dialogEditar = new notification.EditarDatos(cd, true, datosParaEditar, this);

                dialogEditar.setLocationRelativeTo(cd);
                dialogEditar.setVisible(true);
                Datos datosParaActualizar = dialogEditar.getDatosActualizados();

                if (datosParaActualizar != null) {
                    actualizarDatos(datosParaActualizar);
                }
            }


        } catch (Exception e) {
            //------------------------------------------------------------------
                String mensajeUno = "Hubo un error al mostrar";
                String mensajeDos = "los datos del proyecto.";
                NotificacionError notificacion = new NotificacionError(cd, true, mensajeUno, mensajeDos);
                notificacion.setVisible(true);
            //------------------------------------------------------------------
            e.printStackTrace();
        }
    }
}

private void mostrarNotificacionFaltaInfo() {
                    String msjfalta1 = "Falta rellenar informacion en";
                    String msjfalta2 = "el formulario para continuar";
                    NotificacionFaltaInfo notificacion = new NotificacionFaltaInfo(cd, true, msjfalta1, msjfalta2);
                    notificacion.setVisible(true);

}


}