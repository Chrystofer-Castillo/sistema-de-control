package IGU;

import Controlador.Controlador;
import Modelo.usuarios;
import java.awt.CardLayout;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Chrys y Manuel
 */
public class Principal extends javax.swing.JFrame {

    usuarios mod;
    FondoPanel fondo = new FondoPanel();
    CardLayout cardLayout;

    /**
     * Creates new form Login
     */
    public Principal() {

        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
        this.setContentPane(fondo);
        initComponents();
        this.setTitle("Menú Principal");
        fdpresentacion.toString();
        guardar.setEnabled(false);
        cardLayout = (CardLayout) (ventana.getLayout());
        lblNombre = new javax.swing.JLabel("Nombre de usuario");
        add(lblNombre);
    }

    public Principal(usuarios mod) {
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
        this.setContentPane(fondo);
        initComponents();
        setLocationRelativeTo(null);
        this.mod = mod;
        this.setTitle("Menú Principal");
        fdpresentacion.toString();
        guardar.setEnabled(false);
        cardLayout = (CardLayout) (ventana.getLayout());

        lblNombre.setText(mod.getNombre());
        lblRol.setText(mod.getNombre_tipo());

        lblNombre.setText(mod.getNombre());
        if (mod.getId_tipo() == 1) { // Administrador

        } else if (mod.getId_tipo() == 2) { //  Profesor

            btnGestionarUsuarios.setVisible(false);
        } else if (mod.getId_tipo() == 3) {  //Asistente

            btnGestionarUsuarios.setVisible(false);
            btnCargarDatos.setVisible(false);
            BtnEliminar.setVisible(false);
        }

        Tabla.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
    }

    public void validar() {
        if (tproyecto.getText().isEmpty() || sede.getSelectedItem().toString().isEmpty() || pnf.getSelectedItem().toString().isEmpty() || trayecto.getSelectedItem().toString().isEmpty() || seccion.getText().isEmpty() || tproyecto.getText().isEmpty() || txtnom.getText().isEmpty() || url.getText().isEmpty()) {
            guardar.setEnabled(false);
        } else {
            guardar.setEnabled(true);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Menú = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        btnInicio = new IGU.MyButton();
        btnVisualizar = new IGU.MyButton();
        btnCargarDatos = new IGU.MyButton();
        btnCerrarSesion = new IGU.MyButton();
        btnGestionarUsuarios = new IGU.MyButton();
        ventana = new javax.swing.JPanel();
        inicio = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        pnlCargarDatos = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        tra = new javax.swing.JLabel();
        tpro = new javax.swing.JLabel();
        pn = new javax.swing.JLabel();
        prof = new javax.swing.JLabel();
        profesor = new javax.swing.JTextField();
        seccion = new javax.swing.JTextField();
        trayecto = new javax.swing.JComboBox<>();
        pnf = new javax.swing.JComboBox<>();
        sede = new javax.swing.JComboBox<>();
        tproyecto = new javax.swing.JTextField();
        prof1 = new javax.swing.JLabel();
        prof2 = new javax.swing.JLabel();
        tpro1 = new javax.swing.JLabel();
        url = new javax.swing.JTextField();
        guardar = new javax.swing.JButton();
        fdpresentacion = new com.toedter.calendar.JCalendar();
        btnlimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtnom = new javax.swing.JTextArea();
        pnlVisualizarDatos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        btnbuscar = new javax.swing.JButton();
        BtnEliminar = new javax.swing.JButton();
        refrescar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        filtrar = new javax.swing.JComboBox<>();
        pnlGestionUsuarios = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaUser = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnRegistrarU = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        Menú.setBackground(new java.awt.Color(24, 31, 51));
        Menú.setForeground(new java.awt.Color(0, 35, 35));

        lblNombre.setBackground(new java.awt.Color(204, 204, 204));
        lblNombre.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        lblNombre.setForeground(new java.awt.Color(204, 204, 204));
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblNombre.setBorder(new javax.swing.border.MatteBorder(null));
        lblNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNombreMouseClicked(evt);
            }
        });

        lblRol.setBackground(new java.awt.Color(204, 204, 204));
        lblRol.setFont(new java.awt.Font("Corbel", 1, 18)); // NOI18N
        lblRol.setForeground(new java.awt.Color(204, 204, 204));
        lblRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRol.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        lblRol.setBorder(new javax.swing.border.MatteBorder(null));
        lblRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRolMouseClicked(evt);
            }
        });

        btnInicio.setBackground(new java.awt.Color(50, 58, 79));
        btnInicio.setBorder(null);
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/home.png"))); // NOI18N
        btnInicio.setText("Inicio");
        btnInicio.setBorderColor(new java.awt.Color(50, 58, 79));
        btnInicio.setBorderPainted(false);
        btnInicio.setColor(new java.awt.Color(50, 58, 79));
        btnInicio.setColorClick(new java.awt.Color(21, 27, 41));
        btnInicio.setColorOver(new java.awt.Color(41, 53, 82));
        btnInicio.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnInicio.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnInicio.setRadius(30);
        btnInicio.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        btnVisualizar.setBackground(new java.awt.Color(50, 58, 79));
        btnVisualizar.setBorder(null);
        btnVisualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnVisualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/Search.png"))); // NOI18N
        btnVisualizar.setText("Visualizar");
        btnVisualizar.setBorderColor(new java.awt.Color(50, 58, 79));
        btnVisualizar.setBorderPainted(false);
        btnVisualizar.setColor(new java.awt.Color(50, 58, 79));
        btnVisualizar.setColorClick(new java.awt.Color(21, 27, 41));
        btnVisualizar.setColorOver(new java.awt.Color(41, 53, 82));
        btnVisualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnVisualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnVisualizar.setRadius(30);
        btnVisualizar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        btnCargarDatos.setBackground(new java.awt.Color(50, 58, 79));
        btnCargarDatos.setBorder(null);
        btnCargarDatos.setForeground(new java.awt.Color(255, 255, 255));
        btnCargarDatos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/Exportar.png"))); // NOI18N
        btnCargarDatos.setText("Subir Datos");
        btnCargarDatos.setBorderColor(new java.awt.Color(50, 58, 79));
        btnCargarDatos.setBorderPainted(false);
        btnCargarDatos.setColor(new java.awt.Color(50, 58, 79));
        btnCargarDatos.setColorClick(new java.awt.Color(21, 27, 41));
        btnCargarDatos.setColorOver(new java.awt.Color(41, 53, 82));
        btnCargarDatos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCargarDatos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCargarDatos.setRadius(30);
        btnCargarDatos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarDatosActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(50, 58, 79));
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/Cerrar Sesion.png"))); // NOI18N
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setBorderColor(new java.awt.Color(50, 58, 79));
        btnCerrarSesion.setBorderPainted(false);
        btnCerrarSesion.setColor(new java.awt.Color(50, 58, 79));
        btnCerrarSesion.setColorClick(new java.awt.Color(21, 27, 41));
        btnCerrarSesion.setColorOver(new java.awt.Color(41, 53, 82));
        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnCerrarSesion.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCerrarSesion.setRadius(30);
        btnCerrarSesion.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnGestionarUsuarios.setBackground(new java.awt.Color(50, 58, 79));
        btnGestionarUsuarios.setBorder(null);
        btnGestionarUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/assets/icon/usuario.png"))); // NOI18N
        btnGestionarUsuarios.setText("Gestión de Usuarios");
        btnGestionarUsuarios.setBorderColor(new java.awt.Color(50, 58, 79));
        btnGestionarUsuarios.setBorderPainted(false);
        btnGestionarUsuarios.setColor(new java.awt.Color(50, 58, 79));
        btnGestionarUsuarios.setColorClick(new java.awt.Color(21, 27, 41));
        btnGestionarUsuarios.setColorOver(new java.awt.Color(41, 53, 82));
        btnGestionarUsuarios.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGestionarUsuarios.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnGestionarUsuarios.setRadius(30);
        btnGestionarUsuarios.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnGestionarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarUsuariosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout MenúLayout = new javax.swing.GroupLayout(Menú);
        Menú.setLayout(MenúLayout);
        MenúLayout.setHorizontalGroup(
            MenúLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lblRol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(MenúLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MenúLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenúLayout.createSequentialGroup()
                        .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenúLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(MenúLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnInicio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCargarDatos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnVisualizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnGestionarUsuarios, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        MenúLayout.setVerticalGroup(
            MenúLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenúLayout.createSequentialGroup()
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCargarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnGestionarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ventana.setOpaque(false);
        ventana.setLayout(new java.awt.CardLayout());

        inicio.setFocusable(false);
        inicio.setOpaque(false);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/UNERMBosc.png"))); // NOI18N

        javax.swing.GroupLayout inicioLayout = new javax.swing.GroupLayout(inicio);
        inicio.setLayout(inicioLayout);
        inicioLayout.setHorizontalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 659, Short.MAX_VALUE)
        );
        inicioLayout.setVerticalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(inicioLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        ventana.add(inicio, "inicio");

        pnlCargarDatos.setOpaque(false);

        jLabel13.setBackground(new java.awt.Color(255, 255, 255));
        jLabel13.setFont(new java.awt.Font("Yu Gothic UI", 1, 30)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Cargar Datos.");

        jPanel3.setOpaque(false);

        tra.setBackground(new java.awt.Color(255, 255, 255));
        tra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tra.setForeground(new java.awt.Color(255, 255, 255));
        tra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tra.setText("Trayecto:");

        tpro.setBackground(new java.awt.Color(255, 255, 255));
        tpro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tpro.setForeground(new java.awt.Color(255, 255, 255));
        tpro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tpro.setText("Titulo de proyecto:");

        pn.setBackground(new java.awt.Color(255, 255, 255));
        pn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pn.setForeground(new java.awt.Color(255, 255, 255));
        pn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pn.setText("PNF:");

        prof.setBackground(new java.awt.Color(255, 255, 255));
        prof.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prof.setForeground(new java.awt.Color(255, 255, 255));
        prof.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prof.setText("Profesor:");

        profesor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                profesorKeyReleased(evt);
            }
        });

        seccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                seccionKeyReleased(evt);
            }
        });

        trayecto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "I", "II", "III", "IV" }));

        pnf.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Contaduría Pública", "Informática", "Educación Especial", "Agroalimentación", "Historia" }));
        pnf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pnfActionPerformed(evt);
            }
        });
        pnf.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                pnfKeyReleased(evt);
            }
        });

        sede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sedeActionPerformed(evt);
            }
        });
        sede.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                sedeKeyReleased(evt);
            }
        });

        tproyecto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tproyectoKeyReleased(evt);
            }
        });

        prof1.setBackground(new java.awt.Color(255, 255, 255));
        prof1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prof1.setForeground(new java.awt.Color(255, 255, 255));
        prof1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prof1.setText("Sección:");

        prof2.setBackground(new java.awt.Color(255, 255, 255));
        prof2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prof2.setForeground(new java.awt.Color(255, 255, 255));
        prof2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prof2.setText("Sede:");

        tpro1.setBackground(new java.awt.Color(255, 255, 255));
        tpro1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tpro1.setForeground(new java.awt.Color(255, 255, 255));
        tpro1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tpro1.setText("Enlace:");

        url.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                urlKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(tpro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tpro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prof, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prof1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prof2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tproyecto, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnf, 0, 507, Short.MAX_VALUE)
                    .addComponent(sede, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(trayecto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profesor)
                    .addComponent(seccion)
                    .addComponent(url, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pnf, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pn))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sede, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prof2))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(trayecto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tra))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(seccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prof1))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prof))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tproyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tpro1)
                    .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        guardar.setBackground(new java.awt.Color(50, 58, 79));
        guardar.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        guardar.setForeground(new java.awt.Color(255, 255, 255));
        guardar.setText("Guardar");
        guardar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        fdpresentacion.setBackground(new java.awt.Color(32, 41, 64));
        fdpresentacion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 102)));
        fdpresentacion.setToolTipText("");
        fdpresentacion.setAutoscrolls(true);
        fdpresentacion.setDoubleBuffered(false);
        fdpresentacion.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        fdpresentacion.setOpaque(false);

        btnlimpiar.setBackground(new java.awt.Color(50, 58, 79));
        btnlimpiar.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        btnlimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnlimpiar.setText("Limpiar");
        btnlimpiar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Fecha de Presentacion");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Integrantes");

        txtnom.setBackground(new java.awt.Color(32, 41, 64));
        txtnom.setColumns(20);
        txtnom.setRows(5);
        txtnom.setOpaque(false);
        txtnom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtnomKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(txtnom);

        javax.swing.GroupLayout pnlCargarDatosLayout = new javax.swing.GroupLayout(pnlCargarDatos);
        pnlCargarDatos.setLayout(pnlCargarDatosLayout);
        pnlCargarDatosLayout.setHorizontalGroup(
            pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                        .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 321, Short.MAX_VALUE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))
                    .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(193, 193, 193)))
                .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fdpresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCargarDatosLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                .addGap(12, 12, 12))
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCargarDatosLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCargarDatosLayout.setVerticalGroup(
            pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(47, 47, 47)
                .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(fdpresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(27, 27, 27)
                .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );

        ventana.add(pnlCargarDatos, "pnlCargarDatos");

        pnlVisualizarDatos.setFocusable(false);
        pnlVisualizarDatos.setOpaque(false);

        Tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "PNF", "Sede", "Trayecto", "Seccion", "Profesor", "Titulo de proyecto", "Nombres de integrantes", "Fecha de presentacion", "Url"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        Tabla.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(Tabla);

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Yu Gothic UI", 1, 30)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Visualizar Datos.");

        jPanel5.setOpaque(false);

        btnbuscar.setBackground(new java.awt.Color(0, 129, 176));
        btnbuscar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        btnbuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar.setText("Buscar");
        btnbuscar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        BtnEliminar.setBackground(new java.awt.Color(255, 0, 51));
        BtnEliminar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        BtnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        BtnEliminar.setText("Eliminar");
        BtnEliminar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        refrescar.setBackground(new java.awt.Color(0, 129, 176));
        refrescar.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        refrescar.setForeground(new java.awt.Color(255, 255, 255));
        refrescar.setText("Refrescar");
        refrescar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        refrescar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrescarActionPerformed(evt);
            }
        });

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        filtrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "ID", "Sede", "PNF", "Trayecto", "Seccion", "Titulo de proyecto", "Nombres de integrantes", "Fecha de presentacion" }));
        filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(280, 280, 280))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filtrar, 0, 137, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addComponent(refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)
                            .addComponent(filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(refrescar, javax.swing.GroupLayout.DEFAULT_SIZE, 49, Short.MAX_VALUE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlVisualizarDatosLayout = new javax.swing.GroupLayout(pnlVisualizarDatos);
        pnlVisualizarDatos.setLayout(pnlVisualizarDatosLayout);
        pnlVisualizarDatosLayout.setHorizontalGroup(
            pnlVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVisualizarDatosLayout.createSequentialGroup()
                .addGroup(pnlVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlVisualizarDatosLayout.setVerticalGroup(
            pnlVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVisualizarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7))
        );

        ventana.add(pnlVisualizarDatos, "pnlVisualizarDatos");

        pnlGestionUsuarios.setOpaque(false);

        TablaUser.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "C.I", "Nombre", "Rol", "Ultima conexion"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TablaUser.setOpaque(false);
        jScrollPane4.setViewportView(TablaUser);

        jPanel2.setOpaque(false);

        btnEditar.setBackground(new java.awt.Color(59, 57, 71));
        btnEditar.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(204, 204, 204));
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setBackground(new java.awt.Color(255, 0, 0));
        btnEliminarUsuario.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        btnEliminarUsuario.setForeground(new java.awt.Color(204, 204, 204));
        btnEliminarUsuario.setText("Eliminar");
        btnEliminarUsuario.setBorder(null);
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        btnRegistrarU.setBackground(new java.awt.Color(59, 57, 71));
        btnRegistrarU.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        btnRegistrarU.setForeground(new java.awt.Color(204, 204, 204));
        btnRegistrarU.setText("Registrar Usuarios");
        btnRegistrarU.setBorder(null);
        btnRegistrarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRegistrarU, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 254, Short.MAX_VALUE)
                .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditar, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                    .addComponent(btnRegistrarU, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addContainerGap())
        );

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Yu Gothic UI", 1, 30)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Gestion de usuarios");

        javax.swing.GroupLayout pnlGestionUsuariosLayout = new javax.swing.GroupLayout(pnlGestionUsuarios);
        pnlGestionUsuarios.setLayout(pnlGestionUsuariosLayout);
        pnlGestionUsuariosLayout.setHorizontalGroup(
            pnlGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlGestionUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 647, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGestionUsuariosLayout.setVerticalGroup(
            pnlGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGestionUsuariosLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 464, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ventana.add(pnlGestionUsuarios, "pnlGestionUsuarios");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(Menú, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ventana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Menú, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ventana, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void seccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seccionKeyReleased
        validar();        // TODO add your handling code here:
    }//GEN-LAST:event_seccionKeyReleased

    private void tproyectoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tproyectoKeyReleased
        validar();
    }//GEN-LAST:event_tproyectoKeyReleased

    private void txtnomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyReleased
        validar();        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomKeyReleased

    private void pnfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnfKeyReleased
        validar();        // TODO add your handling code here:
    }//GEN-LAST:event_pnfKeyReleased

    private void sedeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sedeKeyReleased
        validar();        // TODO add your handling code here:
    }//GEN-LAST:event_sedeKeyReleased

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        tproyecto.setText("");
        sede.setSelectedIndex(0);
        pnf.setSelectedIndex(0);
        trayecto.setSelectedIndex(0);
        seccion.setText("");
        txtnom.setText("");
        profesor.setText("");
        url.setText("");
    }//GEN-LAST:event_guardarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void refrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarActionPerformed

    }//GEN-LAST:event_refrescarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtrarActionPerformed

    private void btnRegistrarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUActionPerformed
        Rusuario RU = new Rusuario();
        RU.setVisible(true);
        RU.setLocationRelativeTo(null);

    }//GEN-LAST:event_btnRegistrarUActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

    }//GEN-LAST:event_btnEditarActionPerformed

    private void profesorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_profesorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_profesorKeyReleased

    private void sedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sedeActionPerformed


    }//GEN-LAST:event_sedeActionPerformed

    private void pnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnfActionPerformed
        String seleccion = (String) pnf.getSelectedItem();
        sede.removeAllItems(); // Limpiamos las sedes previas

        if (seleccion.equals("-")) {
            // Agregamos las sedes correspondientes a Contaduría Pública
            sede.addItem("-");
        } else if (seleccion.equals("Informática")) {
            // Agregamos las sedes correspondientes a Informática
            sede.addItem("Cabimas");
            sede.addItem("Ciudad Ojeda");
            sede.addItem("Los Puertos de Altagracia");
            sede.addItem("San Francisco");
            sede.addItem("San Pedro");
        } else if (seleccion.equals("Contaduría Pública")) {
            // Agregamos las sedes correspondientes a Informática
            sede.addItem("Cabimas");
            sede.addItem("Mene Grande");
            sede.addItem("Ciudad Ojeda");
            sede.addItem("Los Puertos de Altagracia");
            sede.addItem("San Francisco");
            sede.addItem("San Pedro");
        } else if (seleccion.equals("Educación Especial")) {
            // Agregamos las sedes correspondientes a Educación Especial
            sede.addItem("Cabimas");
            sede.addItem("Trujillo");
        } else if (seleccion.equals("Agroalimentación")) {
            // Agregamos las sedes correspondientes a Agroalimentación
            sede.addItem("Cabimas");
            sede.addItem("San Francisco");
            sede.addItem("Bobures");
            sede.addItem("Trujillo");
            sede.addItem("San Pedro");
            sede.addItem("Bachaquero");
            sede.addItem("Ciudad Ojeda");
        } else if (seleccion.equals("Historia")) {
            // Agregamos las sedes correspondientes a Historia
            sede.addItem("Trujillo");
        }
    }//GEN-LAST:event_pnfActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void btnGestionarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarUsuariosActionPerformed
        cardLayout.show(ventana, "pnlGestionUsuarios");
        Principal princ = new Principal();
        Controlador c = new Controlador(princ);
        c.refrescar();
    }//GEN-LAST:event_btnGestionarUsuariosActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        // Crea un objeto JOptionPane para mostrar el mensaje de confirmación
        int respuesta = JOptionPane.showConfirmDialog(null, "¿Estás seguro de que quieres cerrar sesión?", "Cerrar Sesión", JOptionPane.YES_NO_OPTION);

        // Si el usuario selecciona "Sí", cierra el programa
        if (respuesta == JOptionPane.YES_OPTION) {

            this.setVisible(false);
            Login index = new Login();
            index.setVisible(true);
            index.setLocationRelativeTo(null);

        } else {

            // Si el usuario selecciona "No" o cancela, no pasa nada
            // Puedes agregar aquí código para informar al usuario que la sesión no se ha cerrado
        }
    }//GEN-LAST:event_btnCerrarSesionActionPerformed


    private void btnCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarDatosActionPerformed
        sede.removeAllItems(); // Limpiamos las sedes previas
        cardLayout.show(ventana, "pnlCargarDatos");
        Principal princ = new Principal();

        Controlador c = new Controlador(princ);
        princ.setTitle("Cargar Datos");
    }//GEN-LAST:event_btnCargarDatosActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        cardLayout.show(ventana, "pnlVisualizarDatos");
        Principal princ = new Principal();
        Controlador c = new Controlador(princ);
        Tabla.getColumnModel().getColumn(9).setMinWidth(0);
        Tabla.getColumnModel().getColumn(9).setMaxWidth(0);
        Tabla.getColumnModel().getColumn(9).setPreferredWidth(0);
        c.refrescar();
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        cardLayout.show(ventana, "inicio");        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_btnInicioActionPerformed

    private void lblRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRolMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRolMouseClicked

    private void lblNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNombreMouseClicked
        JOptionPane.showMessageDialog(null, "Fruto de la colaboración entre el equipo de investigación CVAM y la dirección de PNF UNERMB, con sede en Los Laureles, bajo la guía de la Profesora Ana Capielo.", "Creditos", JOptionPane.WARNING_MESSAGE);        // TODO add your handling code here:
    }//GEN-LAST:event_lblNombreMouseClicked

    private void urlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_urlKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_urlKeyReleased

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
    if (evt.getClickCount() == 2) { // Verificar si es un doble clic
        int fila = Tabla.getSelectedRow(); // Obtener la fila seleccionada
        if (fila != -1) { // Verificar que se ha seleccionado una fila
            String url = Tabla.getValueAt(fila, 9).toString(); // Obtener la URL de la columna 10 (índice 9)
            try {
                Desktop.getDesktop().browse(new URI(url)); // Abrir la URL en el navegador
            } catch (IOException | URISyntaxException ex) {
                ex.printStackTrace(); // Manejar excepciones
                JOptionPane.showMessageDialog(this, "Error al abrir la URL: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    
    }

    }//GEN-LAST:event_TablaMouseClicked

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BtnEliminar;
    private javax.swing.JPanel Menú;
    public javax.swing.JTable Tabla;
    public javax.swing.JTable TablaUser;
    private IGU.MyButton btnCargarDatos;
    private IGU.MyButton btnCerrarSesion;
    private javax.swing.JButton btnEditar;
    public javax.swing.JButton btnEliminarUsuario;
    private IGU.MyButton btnGestionarUsuarios;
    private IGU.MyButton btnInicio;
    private javax.swing.JButton btnRegistrarU;
    private IGU.MyButton btnVisualizar;
    public javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnlimpiar;
    public com.toedter.calendar.JCalendar fdpresentacion;
    public javax.swing.JComboBox<String> filtrar;
    public javax.swing.JButton guardar;
    private javax.swing.JPanel inicio;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRol;
    private javax.swing.JLabel pn;
    public javax.swing.JComboBox<String> pnf;
    private javax.swing.JPanel pnlCargarDatos;
    private javax.swing.JPanel pnlGestionUsuarios;
    private javax.swing.JPanel pnlVisualizarDatos;
    private javax.swing.JLabel prof;
    private javax.swing.JLabel prof1;
    private javax.swing.JLabel prof2;
    public javax.swing.JTextField profesor;
    public javax.swing.JButton refrescar;
    public javax.swing.JTextField seccion;
    public javax.swing.JComboBox<String> sede;
    private javax.swing.JLabel tpro;
    private javax.swing.JLabel tpro1;
    public javax.swing.JTextField tproyecto;
    private javax.swing.JLabel tra;
    public javax.swing.JComboBox<String> trayecto;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextArea txtnom;
    public javax.swing.JTextField url;
    private javax.swing.JPanel ventana;
    // End of variables declaration//GEN-END:variables

    private static class setId_tipo {

        public setId_tipo() {
        }
    }

}

class FondoPanel extends JPanel {

    private Image imagen;

    @Override
    public void paint(Graphics g) {
        imagen = new ImageIcon(getClass().getResource("/imagenes/uno.jpg")).getImage();

        g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

        setOpaque(false);

        super.paint(g);
    }
}
