package Controlador;

import IGU.Principal;
import Modelo.Datos;
import Modelo.DatosDAO;
import Modelo.usuarios;
import Modelo.usuariosDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Chrys
 */
public class Controlador implements ActionListener {

    DatosDAO dao = new DatosDAO();
    Datos d = new Datos();
    Principal cd = new Principal();
    usuarios usuario = new usuarios();
    usuariosDAO udao = new usuariosDAO();

    DefaultTableModel modelo = new DefaultTableModel();

    public Controlador(IGU.Principal cd) {
        this.cd = cd;
        this.cd.guardar.addActionListener(this);
        this.cd = cd;
        this.cd.refrescar.addActionListener(this);
        this.cd.BtnEliminar.addActionListener(this);
        this.cd.btnEliminarUsuario.addActionListener(this);
        this.cd.btnbuscar.addActionListener(this);
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
            try {
                listar(cd.Tabla);
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
                if (e.getSource() == cd.btnEliminarUsuario) {
            deleteUser();
            refrescar();
            try {
                listarUser(cd.TablaUser);
            } catch (SQLException ex) {
                Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (e.getSource() == cd.btnbuscar) {
            buscar();
        }
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
            JOptionPane.showMessageDialog(null, "Debe seleccionar un proyecto");
        } else {
            String[] options = {"Salir", "Continuar"};
            int choice = JOptionPane.showOptionDialog(null, "¿Está seguro de eliminar los siguientes datos?", "Opciones", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);

            if (choice == 0) {
                //
            } else {
                int id = Integer.parseInt((String) cd.Tabla.getValueAt(fila, 0).toString());
                dao.delete(id);
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

            if (choice == 0) {
                //
            } else {
                int id = Integer.parseInt((String) cd.TablaUser.getValueAt(fila, 0).toString());
                udao.deleteUser(id);
            }
        }
    }

    public void agregar() {
        String sede = cd.sede.getSelectedItem().toString();
        String pnf = cd.pnf.getSelectedItem().toString();
        String trayecto = cd.trayecto.getSelectedItem().toString();
        String tproyecto = cd.tproyecto.getText();
        Calendar fechaSeleccionada = cd.fdpresentacion.getCalendar();
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy");
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
        } else {
            JOptionPane.showMessageDialog(cd, "Hubo un error al cargar la información, contacta con el administrador.");
        }
    }

    public void listar(JTable Tabla) throws SQLException {
        modelo = (DefaultTableModel) Tabla.getModel();
        modelo.getDataVector().removeAllElements();
        List<Datos> lista = dao.listar();
        Object[] object = new Object[10];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getId();
            object[1] = lista.get(i).getPnf();
            object[2] = lista.get(i).getSede();
            object[3] = lista.get(i).getTrayecto();
            object[4] = lista.get(i).getSeccion();
            object[5] = lista.get(i).getProfesor();
            object[6] = lista.get(i).getTproyecto();
            object[7] = lista.get(i).getTxtnom();
            object[8] = lista.get(i).getFdpresentacion();
            object[9] = lista.get(i).getUrl();
            modelo.addRow(object);
        }
        Tabla.setModel(modelo);
    }

    public void listarUser(JTable TablaUser) throws SQLException {
        modelo = (DefaultTableModel) TablaUser.getModel();
        modelo.getDataVector().removeAllElements();
        List<usuarios> lista = udao.listarUser();
        if (lista != null) {
            Object[] object = new Object[5];
            for (int i = 0; i < lista.size(); i++) {
                object[0] = lista.get(i).getId();
                object[1] = lista.get(i).getCi();
                object[2] = lista.get(i).getNombre();
                object[3] = lista.get(i).getLast_session();
                object[4] = lista.get (i).getNombre_tipo();
                modelo.addRow(object);
            }
        }
        TablaUser.setModel(modelo);
    }

    public void buscar() {
        String filtroSeleccionado = cd.filtrar.getSelectedItem().toString();
        String buscarTexto = cd.txtBuscar.getText();

        // Realizar la búsqueda utilizando el filtro seleccionado
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
            case "ID":
                return 0; // Columna del ID en la tabla
            case "Sede":
                return 2; // Columna de la Sede en la tabla
            case "PNF":
                return 1; // Columna del PNF en la tabla
            case "Trayecto":
                return 3; // Columna del Trayecto en la tabla
            case "Seccion":
                return 4; // Columna de la Sección en la tabla
            case "Titulo de proyecto":
                return 6; // Columna del Título de proyecto en la tabla
            case "Nombres de integrantes":
                return 7; // Columna de los Nombres de integrantes en la tabla
            case "Fecha de presentacion":
                return 8; // Columna de la Fecha de presentacion en la tabla
            case "Profesor":
                return 5;
            default:
                return -1; // Valor de columna inválida
        }
    }
}
