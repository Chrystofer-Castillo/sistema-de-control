package IGU;

import Modelo.usuarios;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import Controlador.Controlador;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import notification.Csesion;
import notification.NotiReiniciar;

public class Principal extends javax.swing.JFrame {

    public Controlador c;
    private JButton[] botones;

    usuarios mod;

    CardLayout cardLayout;

    public Principal() {
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
        FondoPanel fondo = new FondoPanel();
        this.setContentPane(new FondoPanel());
        initComponents();
        //ocultarMenu.setBackground(javax.swing.UIManager.getColor("Button.background"));
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        botones = new JButton[]{
            btnInicio,
            btnCargarDatos,
            btnVisualizar,
            btnGestionarUsuarios,
            btnTheme
        };
        for (JButton boton : botones) {
            boton.setContentAreaFilled(true);
            boton.setOpaque(true);
            boton.setBorderPainted(false);
        }
        this.setTitle("Menú Principal");
        fdpresentacion.toString();
        guardar.setEnabled(false);
        cardLayout = (CardLayout) (ventana.getLayout());
        lblNombre = new javax.swing.JLabel("Nombre de usuario");
        add(lblNombre);
    }

    public Principal(usuarios mod) {
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
        this.setContentPane(new FondoPanel());

        initComponents();              //initcomponent
        setLocationRelativeTo(null);
//        this.c = new Controlador(this);
        this.mod = mod;
        profesor.setText(mod.getCi());
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
    }
public String getUsuarioCi() {
    return this.mod.getCi();
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

        hotbar = new componentes.round1();
        lblNombre = new javax.swing.JLabel();
        lblRol = new javax.swing.JLabel();
        logo = new javax.swing.JLabel();
        titulo1 = new javax.swing.JLabel();
        ocultarMenu = new componentes.MyButton();
        ventana = new componentes.round1();
        inicio = new javax.swing.JPanel();
        pnlCargarDatos = new javax.swing.JPanel();
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
        fdpresentacion = new com.toedter.calendar.JCalendar();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtnom = new javax.swing.JTextArea();
        btnlimpiar = new componentes.MyButton();
        guardar = new componentes.MyButton();
        jLabel9 = new javax.swing.JLabel();
        pnlVisualizarDatos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        pnlMenuVisualizarDatos = new javax.swing.JPanel();
        txtBuscar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        filtrar = new javax.swing.JComboBox<>();
        btnExtraerTabla = new componentes.MyButton();
        BtnEliminar = new componentes.MyButton();
        btnbuscar = new componentes.MyButton();
        refrescar = new componentes.MyButton();
        pnlGestionUsuarios = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaUser = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnRegistrarU = new componentes.MyButton();
        btnEliminarUsuario = new componentes.MyButton();
        pnlConfiguracion = new componentes.round1();
        jLabel1 = new javax.swing.JLabel();
        btnModoClaro = new javax.swing.JButton();
        btnModoOscuro = new javax.swing.JButton();
        menu = new componentes.round1();
        btnCargarDatos = new componentes.MyButton();
        btnCerrarSesion = new componentes.MyButton();
        btnTheme = new componentes.MyButton();
        btnVisualizar = new componentes.MyButton();
        btnGestionarUsuarios = new componentes.MyButton();
        btnInicio = new componentes.MyButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(164, 166, 162));
        setUndecorated(true);

        hotbar.setRoundBottomLeft(20);
        hotbar.setRoundBottomRight(20);
        hotbar.setRoundTopLeft(20);
        hotbar.setRoundTopRight(25);

        lblNombre.setBackground(new java.awt.Color(204, 204, 204));
        lblNombre.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setBorder(new javax.swing.border.MatteBorder(null));
        lblNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNombreMouseClicked(evt);
            }
        });

        lblRol.setBackground(new java.awt.Color(204, 204, 204));
        lblRol.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRol.setBorder(new javax.swing.border.MatteBorder(null));
        lblRol.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblRolMouseClicked(evt);
            }
        });

        logo.setBackground(new java.awt.Color(0, 0, 0));
        logo.setFont(new java.awt.Font("Araboto-Bold", 1, 30)); // NOI18N
        logo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/logoEsquina.png"))); // NOI18N
        logo.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        titulo1.setBackground(new java.awt.Color(0, 0, 0));
        titulo1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1.setText("INICIO");

        ocultarMenu.setBorder(null);
        ocultarMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/botonHamburguesa.png"))); // NOI18N
        ocultarMenu.setBorderColor(new java.awt.Color(242, 242, 242));
        ocultarMenu.setColorClick(new java.awt.Color(202, 218, 227));
        ocultarMenu.setColorOver(new java.awt.Color(213, 231, 241));
        ocultarMenu.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        ocultarMenu.setMargin(new java.awt.Insets(2, 14, 17, 14));
        ocultarMenu.setRadius(15);
        ocultarMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ocultarMenuActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout hotbarLayout = new javax.swing.GroupLayout(hotbar);
        hotbar.setLayout(hotbarLayout);
        hotbarLayout.setHorizontalGroup(
            hotbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hotbarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo1, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRol, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ocultarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        hotbarLayout.setVerticalGroup(
            hotbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hotbarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(hotbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblRol, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(hotbarLayout.createSequentialGroup()
                        .addGroup(hotbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ocultarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        ventana.setRoundBottomLeft(30);
        ventana.setRoundBottomRight(30);
        ventana.setRoundTopLeft(30);
        ventana.setRoundTopRight(30);
        ventana.setLayout(new java.awt.CardLayout());

        inicio.setFocusable(false);
        inicio.setOpaque(false);

        javax.swing.GroupLayout inicioLayout = new javax.swing.GroupLayout(inicio);
        inicio.setLayout(inicioLayout);
        inicioLayout.setHorizontalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 652, Short.MAX_VALUE)
        );
        inicioLayout.setVerticalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 525, Short.MAX_VALUE)
        );

        ventana.add(inicio, "inicio");

        pnlCargarDatos.setOpaque(false);

        jPanel3.setOpaque(false);

        tra.setBackground(new java.awt.Color(255, 255, 255));
        tra.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tra.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tra.setText("Trayecto:");

        tpro.setBackground(new java.awt.Color(255, 255, 255));
        tpro.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        tpro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tpro.setText("Titulo de proyecto:");

        pn.setBackground(new java.awt.Color(255, 255, 255));
        pn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        pn.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pn.setText("PNF:");

        prof.setBackground(new java.awt.Color(255, 255, 255));
        prof.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
        prof1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prof1.setText("Sección:");

        prof2.setBackground(new java.awt.Color(255, 255, 255));
        prof2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        prof2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        prof2.setText("Sede:");

        tpro1.setBackground(new java.awt.Color(255, 255, 255));
        tpro1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
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
                    .addComponent(tpro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prof, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prof1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tra, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(prof2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tpro1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(trayecto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seccion)
                    .addComponent(profesor)
                    .addComponent(tproyecto)
                    .addComponent(url)
                    .addComponent(sede, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnf, 0, 178, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(profesor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(prof))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tproyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tpro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tpro1)
                    .addComponent(url, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        fdpresentacion.setToolTipText("");
        fdpresentacion.setAutoscrolls(true);
        fdpresentacion.setDoubleBuffered(false);
        fdpresentacion.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        fdpresentacion.setOpaque(false);

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Datos");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
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

        btnlimpiar.setBackground(new java.awt.Color(254, 61, 61));
        btnlimpiar.setBorder(null);
        btnlimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnlimpiar.setText("Limpiar");
        btnlimpiar.setBorderColor(new java.awt.Color(242, 242, 242));
        btnlimpiar.setColor(new java.awt.Color(254, 61, 61));
        btnlimpiar.setColorClick(new java.awt.Color(254, 50, 18));
        btnlimpiar.setColorOver(new java.awt.Color(254, 61, 84));
        btnlimpiar.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnlimpiar.setRadius(20);
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        guardar.setBackground(new java.awt.Color(62, 115, 248));
        guardar.setForeground(new java.awt.Color(255, 255, 255));
        guardar.setText("Guardar");
        guardar.setBorderColor(new java.awt.Color(242, 242, 242));
        guardar.setBorderPainted(false);
        guardar.setColor(new java.awt.Color(62, 115, 248));
        guardar.setColorClick(new java.awt.Color(62, 96, 234));
        guardar.setColorOver(new java.awt.Color(103, 181, 255));
        guardar.setEnabled(false);
        guardar.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        guardar.setRadius(20);
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Fecha de Presentacion");

        javax.swing.GroupLayout pnlCargarDatosLayout = new javax.swing.GroupLayout(pnlCargarDatos);
        pnlCargarDatos.setLayout(pnlCargarDatosLayout);
        pnlCargarDatosLayout.setHorizontalGroup(
            pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                        .addComponent(fdpresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCargarDatosLayout.createSequentialGroup()
                        .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26))))
            .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlCargarDatosLayout.createSequentialGroup()
                        .addComponent(jScrollPane2)
                        .addGap(12, 12, 12))
                    .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
            .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                    .addGap(382, 382, 382)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGap(2, 2, 2)))
        );
        pnlCargarDatosLayout.setVerticalGroup(
            pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fdpresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(guardar, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE))
                .addGap(14, 14, 14))
            .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(474, Short.MAX_VALUE)))
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

        pnlMenuVisualizarDatos.setOpaque(false);

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Roboto", 1, 12)); // NOI18N

        filtrar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "ID", "Sede", "PNF", "Trayecto", "Seccion", "Profesor", "Titulo de proyecto", "Nombres de integrantes", "Fecha de presentacion" }));
        filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filtrarActionPerformed(evt);
            }
        });

        btnExtraerTabla.setBackground(new java.awt.Color(62, 115, 248));
        btnExtraerTabla.setBorder(null);
        btnExtraerTabla.setForeground(new java.awt.Color(255, 255, 255));
        btnExtraerTabla.setText("Extraer");
        btnExtraerTabla.setBorderColor(new java.awt.Color(242, 242, 242));
        btnExtraerTabla.setColor(new java.awt.Color(62, 115, 248));
        btnExtraerTabla.setColorClick(new java.awt.Color(62, 115, 248));
        btnExtraerTabla.setColorOver(new java.awt.Color(103, 181, 255));
        btnExtraerTabla.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnExtraerTabla.setRadius(20);
        btnExtraerTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExtraerTablaActionPerformed(evt);
            }
        });

        BtnEliminar.setBorder(null);
        BtnEliminar.setForeground(new java.awt.Color(255, 255, 255));
        BtnEliminar.setText("Eliminar");
        BtnEliminar.setBorderColor(new java.awt.Color(242, 242, 242));
        BtnEliminar.setColor(new java.awt.Color(254, 61, 61));
        BtnEliminar.setColorClick(new java.awt.Color(254, 50, 18));
        BtnEliminar.setColorOver(new java.awt.Color(254, 61, 84));
        BtnEliminar.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        BtnEliminar.setRadius(20);
        BtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnEliminarActionPerformed(evt);
            }
        });

        btnbuscar.setBackground(new java.awt.Color(62, 115, 248));
        btnbuscar.setBorder(null);
        btnbuscar.setForeground(new java.awt.Color(255, 255, 255));
        btnbuscar.setText("Buscar");
        btnbuscar.setBorderColor(new java.awt.Color(242, 242, 242));
        btnbuscar.setColor(new java.awt.Color(62, 115, 248));
        btnbuscar.setColorClick(new java.awt.Color(62, 96, 234));
        btnbuscar.setColorOver(new java.awt.Color(62, 96, 234));
        btnbuscar.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnbuscar.setRadius(20);
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });

        refrescar.setBackground(new java.awt.Color(62, 115, 248));
        refrescar.setBorder(null);
        refrescar.setForeground(new java.awt.Color(255, 255, 255));
        refrescar.setText("Refrescar");
        refrescar.setBorderColor(new java.awt.Color(242, 242, 242));
        refrescar.setColor(new java.awt.Color(62, 115, 248));
        refrescar.setColorClick(new java.awt.Color(62, 96, 234));
        refrescar.setColorOver(new java.awt.Color(62, 96, 234));
        refrescar.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        refrescar.setRadius(20);

        javax.swing.GroupLayout pnlMenuVisualizarDatosLayout = new javax.swing.GroupLayout(pnlMenuVisualizarDatos);
        pnlMenuVisualizarDatos.setLayout(pnlMenuVisualizarDatosLayout);
        pnlMenuVisualizarDatosLayout.setHorizontalGroup(
            pnlMenuVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuVisualizarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExtraerTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMenuVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuVisualizarDatosLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlMenuVisualizarDatosLayout.createSequentialGroup()
                        .addGroup(pnlMenuVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscar)
                            .addComponent(filtrar, 0, 279, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlMenuVisualizarDatosLayout.setVerticalGroup(
            pnlMenuVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuVisualizarDatosLayout.createSequentialGroup()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlMenuVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlMenuVisualizarDatosLayout.createSequentialGroup()
                        .addComponent(filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlMenuVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnExtraerTabla, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout pnlVisualizarDatosLayout = new javax.swing.GroupLayout(pnlVisualizarDatos);
        pnlVisualizarDatos.setLayout(pnlVisualizarDatosLayout);
        pnlVisualizarDatosLayout.setHorizontalGroup(
            pnlVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVisualizarDatosLayout.createSequentialGroup()
                .addGroup(pnlVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlMenuVisualizarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlVisualizarDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3)))
                .addContainerGap())
        );
        pnlVisualizarDatosLayout.setVerticalGroup(
            pnlVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlVisualizarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pnlMenuVisualizarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

        btnRegistrarU.setBackground(new java.awt.Color(62, 115, 248));
        btnRegistrarU.setBorder(null);
        btnRegistrarU.setForeground(new java.awt.Color(255, 255, 255));
        btnRegistrarU.setText("Registrar Usuarios");
        btnRegistrarU.setBorderColor(new java.awt.Color(242, 242, 242));
        btnRegistrarU.setColor(new java.awt.Color(62, 115, 248));
        btnRegistrarU.setColorClick(new java.awt.Color(62, 96, 234));
        btnRegistrarU.setColorOver(new java.awt.Color(103, 181, 255));
        btnRegistrarU.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        btnRegistrarU.setRadius(25);
        btnRegistrarU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarUActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setBackground(new java.awt.Color(254, 61, 61));
        btnEliminarUsuario.setBorder(null);
        btnEliminarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarUsuario.setText("Eliminar");
        btnEliminarUsuario.setBorderColor(new java.awt.Color(242, 242, 242));
        btnEliminarUsuario.setColor(new java.awt.Color(254, 61, 61));
        btnEliminarUsuario.setColorClick(new java.awt.Color(254, 50, 18));
        btnEliminarUsuario.setColorOver(new java.awt.Color(254, 61, 84));
        btnEliminarUsuario.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnEliminarUsuario.setRadius(25);
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(btnRegistrarU, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(403, 403, 403)
                .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 91, Short.MAX_VALUE)
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRegistrarU, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlGestionUsuariosLayout = new javax.swing.GroupLayout(pnlGestionUsuarios);
        pnlGestionUsuarios.setLayout(pnlGestionUsuariosLayout);
        pnlGestionUsuariosLayout.setHorizontalGroup(
            pnlGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlGestionUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 640, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlGestionUsuariosLayout.setVerticalGroup(
            pnlGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGestionUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 445, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ventana.add(pnlGestionUsuarios, "pnlGestionUsuarios");

        pnlConfiguracion.setRoundBottomLeft(26);
        pnlConfiguracion.setRoundBottomRight(26);
        pnlConfiguracion.setRoundTopLeft(26);
        pnlConfiguracion.setRoundTopRight(26);

        jLabel1.setText("Look And Feels");

        btnModoClaro.setText("Tema Claro");
        btnModoClaro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModoClaroActionPerformed(evt);
            }
        });

        btnModoOscuro.setText("Tema Oscuro");
        btnModoOscuro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModoOscuroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlConfiguracionLayout = new javax.swing.GroupLayout(pnlConfiguracion);
        pnlConfiguracion.setLayout(pnlConfiguracionLayout);
        pnlConfiguracionLayout.setHorizontalGroup(
            pnlConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfiguracionLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(pnlConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModoClaro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModoOscuro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(505, Short.MAX_VALUE))
        );
        pnlConfiguracionLayout.setVerticalGroup(
            pnlConfiguracionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlConfiguracionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnModoClaro)
                .addGap(18, 18, 18)
                .addComponent(btnModoOscuro)
                .addContainerGap(438, Short.MAX_VALUE))
        );

        ventana.add(pnlConfiguracion, "pnlConfiguracion");

        menu.setRoundBottomLeft(30);
        menu.setRoundBottomRight(30);
        menu.setRoundTopLeft(30);
        menu.setRoundTopRight(30);

        btnCargarDatos.setBackground(new java.awt.Color(62, 115, 248));
        btnCargarDatos.setBorder(null);
        btnCargarDatos.setForeground(new java.awt.Color(255, 255, 255));
        btnCargarDatos.setText("Cargar Datos");
        btnCargarDatos.setBorderColor(new java.awt.Color(242, 242, 242));
        btnCargarDatos.setColor(new java.awt.Color(62, 115, 248));
        btnCargarDatos.setColorClick(new java.awt.Color(62, 96, 234));
        btnCargarDatos.setColorOver(new java.awt.Color(103, 181, 255));
        btnCargarDatos.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnCargarDatos.setMaximumSize(new java.awt.Dimension(29, 16));
        btnCargarDatos.setMinimumSize(new java.awt.Dimension(29, 16));
        btnCargarDatos.setRadius(25);
        btnCargarDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarDatosActionPerformed(evt);
            }
        });

        btnCerrarSesion.setBackground(new java.awt.Color(254, 61, 61));
        btnCerrarSesion.setBorder(null);
        btnCerrarSesion.setForeground(new java.awt.Color(255, 255, 255));
        btnCerrarSesion.setText("Cerrar Sesión");
        btnCerrarSesion.setBorderColor(new java.awt.Color(242, 242, 242));
        btnCerrarSesion.setColor(new java.awt.Color(254, 61, 61));
        btnCerrarSesion.setColorClick(new java.awt.Color(254, 50, 18));
        btnCerrarSesion.setColorOver(new java.awt.Color(254, 61, 84));
        btnCerrarSesion.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnCerrarSesion.setRadius(25);
        btnCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarSesionActionPerformed(evt);
            }
        });

        btnTheme.setBackground(new java.awt.Color(62, 115, 248));
        btnTheme.setBorder(null);
        btnTheme.setForeground(new java.awt.Color(255, 255, 255));
        btnTheme.setText("Cambiar Tema");
        btnTheme.setBorderColor(new java.awt.Color(242, 242, 242));
        btnTheme.setColor(new java.awt.Color(62, 115, 248));
        btnTheme.setColorClick(new java.awt.Color(62, 96, 234));
        btnTheme.setColorOver(new java.awt.Color(103, 181, 255));
        btnTheme.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnTheme.setRadius(15);
        btnTheme.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemeActionPerformed(evt);
            }
        });

        btnVisualizar.setBackground(new java.awt.Color(62, 115, 248));
        btnVisualizar.setBorder(null);
        btnVisualizar.setForeground(new java.awt.Color(255, 255, 255));
        btnVisualizar.setText("Visualizar Datos");
        btnVisualizar.setBorderColor(new java.awt.Color(242, 242, 242));
        btnVisualizar.setColor(new java.awt.Color(62, 115, 248));
        btnVisualizar.setColorClick(new java.awt.Color(62, 96, 234));
        btnVisualizar.setColorOver(new java.awt.Color(103, 181, 255));
        btnVisualizar.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnVisualizar.setRadius(25);
        btnVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisualizarActionPerformed(evt);
            }
        });

        btnGestionarUsuarios.setBackground(new java.awt.Color(62, 115, 248));
        btnGestionarUsuarios.setBorder(null);
        btnGestionarUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnGestionarUsuarios.setText("Gestion de Usuario");
        btnGestionarUsuarios.setBorderColor(new java.awt.Color(242, 242, 242));
        btnGestionarUsuarios.setColor(new java.awt.Color(62, 115, 248));
        btnGestionarUsuarios.setColorClick(new java.awt.Color(62, 96, 234));
        btnGestionarUsuarios.setColorOver(new java.awt.Color(103, 181, 255));
        btnGestionarUsuarios.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnGestionarUsuarios.setRadius(25);
        btnGestionarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionarUsuariosActionPerformed(evt);
            }
        });

        btnInicio.setBackground(new java.awt.Color(62, 115, 248));
        btnInicio.setBorder(null);
        btnInicio.setForeground(new java.awt.Color(255, 255, 255));
        btnInicio.setText("Inicio");
        btnInicio.setBorderColor(new java.awt.Color(242, 242, 242));
        btnInicio.setColor(new java.awt.Color(62, 115, 248));
        btnInicio.setColorClick(new java.awt.Color(62, 96, 234));
        btnInicio.setColorOver(new java.awt.Color(103, 181, 255));
        btnInicio.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnInicio.setRadius(25);
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuLayout = new javax.swing.GroupLayout(menu);
        menu.setLayout(menuLayout);
        menuLayout.setHorizontalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnCerrarSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnVisualizar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnGestionarUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE)
                    .addComponent(btnInicio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCargarDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnTheme, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        menuLayout.setVerticalGroup(
            menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCargarDatos, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnGestionarUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnTheme, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrarSesion, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(hotbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ventana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(hotbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ventana, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGestionarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionarUsuariosActionPerformed
        titulo1.setText("Gestión de Usuarios");
        cardLayout.show(ventana, "pnlGestionUsuarios");
        Principal princ = new Principal();
        Controlador c = new Controlador(princ);
        c.refrescarDatos();
    }//GEN-LAST:event_btnGestionarUsuariosActionPerformed

    private void btnThemeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemeActionPerformed
NotiReiniciar nr = new NotiReiniciar(this, true, this);
nr.setVisible(true);

    }//GEN-LAST:event_btnThemeActionPerformed


    private void btnCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarDatosActionPerformed
        guardar.setEnabled(false);
        titulo1.setText("Subir Datos");
        sede.removeAllItems();
        cardLayout.show(ventana, "pnlCargarDatos");
        Principal princ = new Principal();

        Controlador c = new Controlador(princ);
        princ.setTitle("Cargar Datos");
    }//GEN-LAST:event_btnCargarDatosActionPerformed

    private void btnVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisualizarActionPerformed
        titulo1.setText("Visualizar Datos");
        cardLayout.show(ventana, "pnlVisualizarDatos");
        Principal princ = new Principal();
        Controlador c = new Controlador(princ);
        Tabla.getColumnModel().getColumn(9).setMinWidth(0);
        Tabla.getColumnModel().getColumn(9).setMaxWidth(0);
        Tabla.getColumnModel().getColumn(9).setPreferredWidth(0);
        c.refrescarDatos();
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        titulo1.setText("Inicio");
        cardLayout.show(ventana, "inicio");     // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnEliminarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarUsuarioActionPerformed
  
    }//GEN-LAST:event_btnEliminarUsuarioActionPerformed

    private void lblRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRolMouseClicked
    }//GEN-LAST:event_lblRolMouseClicked

    private void lblNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNombreMouseClicked
        JOptionPane.showMessageDialog(null, "Fruto de la colaboración entre el equipo de investigación CVAM y la dirección de PNF UNERMB, con sede en Los Laureles, bajo la guía de la Profesora Ana Capielo.", "Creditos", JOptionPane.WARNING_MESSAGE);        // TODO add your handling code here:
    }//GEN-LAST:event_lblNombreMouseClicked

    private void filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarActionPerformed
    }//GEN-LAST:event_filtrarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked

    }//GEN-LAST:event_TablaMouseClicked

    private void ocultarMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ocultarMenuActionPerformed
        if (menu.isVisible()) {
            menu.setVisible(false);
        } else {
            menu.setVisible(true);
        }

    }//GEN-LAST:event_ocultarMenuActionPerformed

    private void btnCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesionActionPerformed
        Csesion cs = new Csesion();
        cs.setVisible(true);
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void btnExtraerTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExtraerTablaActionPerformed
    System.out.println("--> Botón Extraer presionado. Iniciando exportación a CSV...");

    try {
        // --- 1. Obtener el modelo de la tabla y el TableRowSorter para filas visibles ---
        javax.swing.table.TableModel model = Tabla.getModel();
        javax.swing.RowSorter<? extends javax.swing.table.TableModel> sorter = Tabla.getRowSorter();
        
        int rowCount = Tabla.getRowCount(); // Esto devuelve las filas VISIBLES después del filtro
        int colCount = model.getColumnCount();

        System.out.println("--> Filas VISIBLES a exportar: " + rowCount + ", Columnas: " + colCount);

        if (rowCount == 0) {
            javax.swing.JOptionPane.showMessageDialog(this,
                "No hay datos visibles para exportar.\n" +
                "Puede que el filtro aplicado no muestre resultados.",
                "Sin Datos Visibles",
                javax.swing.JOptionPane.WARNING_MESSAGE);
            return;
        }

        // --- 2. Preparar el contenido CSV ---
        StringBuilder csvContent = new StringBuilder();

        // --- 3. Agregar encabezados ---
        for (int col = 0; col < colCount; col++) {
            csvContent.append("\"").append(model.getColumnName(col).replace("\"", "\"\"")).append("\"");
            if (col < colCount - 1) {
                csvContent.append(",");
            }
        }
        csvContent.append("\n");

        // --- 4. Agregar solo las filas VISIBLES ---
        for (int viewRowIndex = 0; viewRowIndex < rowCount; viewRowIndex++) {
            // Convertir índice de vista a índice del modelo
            int modelRowIndex;
            if (sorter != null) {
                modelRowIndex = sorter.convertRowIndexToModel(viewRowIndex);
            } else {
                modelRowIndex = viewRowIndex;
            }
            
            for (int col = 0; col < colCount; col++) {
                Object value = model.getValueAt(modelRowIndex, col);
                if (value != null) {
                    // Escapar comillas y agregar comillas alrededor del texto
                    String cellValue = value.toString().replace("\"", "\"\"");
                    csvContent.append("\"").append(cellValue).append("\"");
                } else {
                    csvContent.append("\"\"");
                }
                if (col < colCount - 1) {
                    csvContent.append(",");
                }
            }
            csvContent.append("\n");
        }

        // --- 5. Guardar el archivo ---
        // Obtener nombre del archivo del JLabel txtIdPre
        String nombreArchivo = lblNombre.getText().trim();
        if (nombreArchivo.isEmpty()) {
            nombreArchivo = "exportacion_tabla";
        }
        nombreArchivo = nombreArchivo.replaceAll("[^a-zA-Z0-9_\\-]", "_");
        
        // Agregar "_filtrado" al nombre para indicar que es una exportación filtrada
        nombreArchivo += "_filtrado";
        
        String outputPath = "Exportaciones/" + nombreArchivo + ".csv";
        java.io.File outputFile = new java.io.File(outputPath);
        
        // Crear directorio si no existe
        java.io.File directory = outputFile.getParentFile();
        if (directory != null && !directory.exists()) {
            System.out.println("--> Creando directorio: " + directory.getAbsolutePath());
            boolean dirCreated = directory.mkdirs();
            if (!dirCreated) {
                throw new java.io.IOException("No se pudo crear el directorio: " + directory.getAbsolutePath());
            }
        }

        System.out.println("--> Guardando archivo CSV en: " + outputFile.getAbsolutePath());
        
        // Escribir el contenido al archivo
        try (java.io.FileWriter writer = new java.io.FileWriter(outputFile)) {
            writer.write(csvContent.toString());
        }

        System.out.println("--> ¡ÉXITO! Archivo CSV exportado correctamente.");

        // --- 6. Mensaje de éxito ---
        javax.swing.JOptionPane.showMessageDialog(this,
            "¡Datos FILTRADOS exportados exitosamente!\n" +
            "Archivo: " + outputPath + "\n" +
            "Filas exportadas: " + rowCount + "\n\n" +
            "Nota: Se exportaron solo los datos visibles (filtrados).",
            "Exportación Filtrada Exitosa",
            javax.swing.JOptionPane.INFORMATION_MESSAGE);

    } catch (Exception ex) {
        System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        System.err.println("!!! ERROR EN LA EXPORTACIÓN CSV !!!");
        System.err.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        ex.printStackTrace();

        javax.swing.JOptionPane.showMessageDialog(this,
            "Error al exportar a CSV: " + ex.getMessage() +
            "\nRevisa la consola para más detalles.",
            "Error de Exportación",
            javax.swing.JOptionPane.ERROR_MESSAGE);
    }

    }//GEN-LAST:event_btnExtraerTablaActionPerformed

    private void BtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnEliminarActionPerformed
    }//GEN-LAST:event_BtnEliminarActionPerformed

    private void btnRegistrarUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarUActionPerformed
        Rusuario RU = new Rusuario();
        RU.setVisible(true);
        RU.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnRegistrarUActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
        tproyecto.setText("");
        sede.setSelectedIndex(0);
        pnf.setSelectedIndex(0);
        trayecto.setSelectedIndex(0);
        seccion.setText("");
        txtnom.setText("");
        profesor.setText(mod.getCi());
        url.setText("");
    }//GEN-LAST:event_guardarActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        tproyecto.setText("");
        sede.setSelectedIndex(0);
        pnf.setSelectedIndex(0);
        trayecto.setSelectedIndex(0);
        seccion.setText("");
        txtnom.setText("");
        profesor.setText(mod.getCi());
        url.setText("");
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void txtnomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyReleased
        validar();
    }//GEN-LAST:event_txtnomKeyReleased

    private void urlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_urlKeyReleased
    }//GEN-LAST:event_urlKeyReleased

    private void tproyectoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tproyectoKeyReleased
        validar();
    }//GEN-LAST:event_tproyectoKeyReleased

    private void sedeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_sedeKeyReleased
        validar();        // TODO add your handling code here:
    }//GEN-LAST:event_sedeKeyReleased

    private void sedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sedeActionPerformed

    }//GEN-LAST:event_sedeActionPerformed

    private void pnfKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pnfKeyReleased
        validar();        // TODO adadd your handling code here:
    }//GEN-LAST:event_pnfKeyReleased

    private void pnfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pnfActionPerformed
        String seleccion = (String) pnf.getSelectedItem();
        sede.removeAllItems();

        if (seleccion.equals("-")) {
            sede.addItem("-");
        } else if (seleccion.equals("Informática")) {
            sede.addItem("Cabimas");
            sede.addItem("Ciudad Ojeda");
            sede.addItem("Los Puertos de Altagracia");
            sede.addItem("San Francisco");
            sede.addItem("San Pedro");
        } else if (seleccion.equals("Contaduría Pública")) {
            sede.addItem("Cabimas");
            sede.addItem("Mene Grande");
            sede.addItem("Ciudad Ojeda");
            sede.addItem("Los Puertos de Altagracia");
            sede.addItem("San Francisco");
            sede.addItem("San Pedro");
        } else if (seleccion.equals("Educación Especial")) {
            sede.addItem("Cabimas");
            sede.addItem("Trujillo");
        } else if (seleccion.equals("Agroalimentación")) {

            sede.addItem("Cabimas");
            sede.addItem("San Francisco");
            sede.addItem("Bobures");
            sede.addItem("Trujillo");
            sede.addItem("San Pedro");
            sede.addItem("Bachaquero");
            sede.addItem("Ciudad Ojeda");
        } else if (seleccion.equals("Historia")) {
            sede.addItem("Trujillo");
        }
    }//GEN-LAST:event_pnfActionPerformed

    private void seccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seccionKeyReleased
        validar();
    }//GEN-LAST:event_seccionKeyReleased

    private void profesorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_profesorKeyReleased

    }//GEN-LAST:event_profesorKeyReleased

    private void btnModoClaroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModoClaroActionPerformed
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }//GEN-LAST:event_btnModoClaroActionPerformed

    private void btnModoOscuroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModoOscuroActionPerformed

    }//GEN-LAST:event_btnModoOscuroActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public componentes.MyButton BtnEliminar;
    public javax.swing.JTable Tabla;
    public javax.swing.JTable TablaUser;
    public componentes.MyButton btnCargarDatos;
    public componentes.MyButton btnCerrarSesion;
    public componentes.MyButton btnEliminarUsuario;
    public componentes.MyButton btnExtraerTabla;
    public componentes.MyButton btnGestionarUsuarios;
    public componentes.MyButton btnInicio;
    private javax.swing.JButton btnModoClaro;
    private javax.swing.JButton btnModoOscuro;
    public componentes.MyButton btnRegistrarU;
    public componentes.MyButton btnTheme;
    public componentes.MyButton btnVisualizar;
    public componentes.MyButton btnbuscar;
    public componentes.MyButton btnlimpiar;
    public com.toedter.calendar.JCalendar fdpresentacion;
    public javax.swing.JComboBox<String> filtrar;
    public componentes.MyButton guardar;
    private componentes.round1 hotbar;
    private javax.swing.JPanel inicio;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRol;
    public javax.swing.JLabel logo;
    public componentes.round1 menu;
    private componentes.MyButton ocultarMenu;
    private javax.swing.JLabel pn;
    public javax.swing.JComboBox<String> pnf;
    public javax.swing.JPanel pnlCargarDatos;
    private componentes.round1 pnlConfiguracion;
    private javax.swing.JPanel pnlGestionUsuarios;
    private javax.swing.JPanel pnlMenuVisualizarDatos;
    private javax.swing.JPanel pnlVisualizarDatos;
    private javax.swing.JLabel prof;
    private javax.swing.JLabel prof1;
    private javax.swing.JLabel prof2;
    public javax.swing.JTextField profesor;
    public componentes.MyButton refrescar;
    public javax.swing.JTextField seccion;
    public javax.swing.JComboBox<String> sede;
    public javax.swing.JLabel titulo1;
    private javax.swing.JLabel tpro;
    private javax.swing.JLabel tpro1;
    public javax.swing.JTextField tproyecto;
    private javax.swing.JLabel tra;
    public javax.swing.JComboBox<String> trayecto;
    public javax.swing.JTextField txtBuscar;
    public javax.swing.JTextArea txtnom;
    public javax.swing.JTextField url;
    private componentes.round1 ventana;
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
