package IGU;

import Controlador.Controlador;
import Modelo.usuarios;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import Controlador.Controlador;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import notification.Csesion;
import notification.NotiEliminar;
import notification.PrevisualizarInfo;

/**
 *
 * @author Chrys y Manuel
 */
public class Principal extends javax.swing.JFrame {

  //  private Controlador c;
    private JButton[] botones;

    usuarios mod;

    CardLayout cardLayout;

    /**
     * Creates new form Login
     */
    public Principal() {
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());
        FondoPanel fondo = new FondoPanel();

        // 2. Establece ESE panel como el contenedor principal de la ventana
        this.setContentPane(new FondoPanel());
        initComponents();
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //FondoPanell.setBackground(new Color(0, 0, 0, 0));

        botones = new JButton[]{
            btnInicio,
            btnCargarDatos,
            btnVisualizar,
            btnGestionarUsuarios,
            btnConfig
        };
        for (JButton boton : botones) {
            boton.setContentAreaFilled(true); // Asegura que el área de contenido use el setBackground
            boton.setOpaque(true);           // Asegura que el componente sea totalmente opaco
            // Opcional: Esto ayuda en botones con imágenes
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

//        Tabla.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent evt) {
//                TablaMouseClicked(evt);
//            }
//        });
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
        guardar = new javax.swing.JButton();
        fdpresentacion = new com.toedter.calendar.JCalendar();
        btnlimpiar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtnom = new javax.swing.JTextArea();
        myButton1 = new componentes.MyButton();
        pnlVisualizarDatos = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tabla = new javax.swing.JTable();
        pnlMenuVisualizarDatos = new javax.swing.JPanel();
        btnbuscar = new javax.swing.JButton();
        refrescar = new javax.swing.JButton();
        txtBuscar = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        filtrar = new javax.swing.JComboBox<>();
        btnEditarTabla = new componentes.MyButton();
        BtnEliminar = new componentes.MyButton();
        pnlGestionUsuarios = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TablaUser = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        btnEditar = new javax.swing.JButton();
        btnEliminarUsuario = new javax.swing.JButton();
        btnRegistrarU = new javax.swing.JButton();
        config = new javax.swing.JPanel();
        menu = new componentes.round1();
        btnCargarDatos = new componentes.MyButton();
        btnCerrarSesion = new componentes.MyButton();
        btnConfig = new componentes.MyButton();
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
        lblNombre.setFont(new java.awt.Font("Araboto-Normal", 0, 18)); // NOI18N
        lblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNombre.setText("prueba");
        lblNombre.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblNombre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNombreMouseClicked(evt);
            }
        });

        lblRol.setBackground(new java.awt.Color(204, 204, 204));
        lblRol.setFont(new java.awt.Font("Araboto-Normal", 0, 18)); // NOI18N
        lblRol.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblRol.setText("prueba");
        lblRol.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
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
        titulo1.setFont(new java.awt.Font("Segoe UI Black", 1, 30)); // NOI18N
        titulo1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo1.setText("Inicio");
        titulo1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

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
                .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(titulo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRol, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ocultarMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        hotbarLayout.setVerticalGroup(
            hotbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblRol, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(hotbarLayout.createSequentialGroup()
                .addGroup(hotbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ocultarMenu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, hotbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(logo, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(titulo1)))
                .addGap(0, 6, Short.MAX_VALUE))
            .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
            .addGap(0, 693, Short.MAX_VALUE)
        );
        inicioLayout.setVerticalGroup(
            inicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
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
                    .addComponent(pnf, 0, 541, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tpro1)
                    .addComponent(url))
                .addContainerGap())
        );

        guardar.setBackground(new java.awt.Color(62, 115, 248));
        guardar.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        guardar.setForeground(new java.awt.Color(255, 255, 255));
        guardar.setText("Guardar");
        guardar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        fdpresentacion.setToolTipText("");
        fdpresentacion.setAutoscrolls(true);
        fdpresentacion.setDoubleBuffered(false);
        fdpresentacion.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        fdpresentacion.setOpaque(false);

        btnlimpiar.setBackground(new java.awt.Color(254, 61, 61));
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
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Fecha de Presentacion");

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

        myButton1.setText("Pre-Visualizar (prueba)");
        myButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlCargarDatosLayout = new javax.swing.GroupLayout(pnlCargarDatos);
        pnlCargarDatos.setLayout(pnlCargarDatosLayout);
        pnlCargarDatosLayout.setHorizontalGroup(
            pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                                .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(myButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fdpresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE))
                .addGap(12, 12, 12))
            .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlCargarDatosLayout.setVerticalGroup(
            pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlCargarDatosLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 4, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(fdpresentacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnlCargarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnlimpiar, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                    .addComponent(guardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(25, 25, 25))
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

        btnEditarTabla.setText("btnEditar");
        btnEditarTabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarTablaActionPerformed(evt);
            }
        });

        BtnEliminar.setText("eliminar");

        javax.swing.GroupLayout pnlMenuVisualizarDatosLayout = new javax.swing.GroupLayout(pnlMenuVisualizarDatos);
        pnlMenuVisualizarDatos.setLayout(pnlMenuVisualizarDatosLayout);
        pnlMenuVisualizarDatosLayout.setHorizontalGroup(
            pnlMenuVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuVisualizarDatosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEditarTabla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(pnlMenuVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuVisualizarDatosLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(376, 376, 376))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuVisualizarDatosLayout.createSequentialGroup()
                        .addGroup(pnlMenuVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBuscar)
                            .addComponent(filtrar, 0, 301, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(refrescar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(7, 7, 7))))
        );
        pnlMenuVisualizarDatosLayout.setVerticalGroup(
            pnlMenuVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlMenuVisualizarDatosLayout.createSequentialGroup()
                .addGroup(pnlMenuVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMenuVisualizarDatosLayout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlMenuVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlMenuVisualizarDatosLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnbuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(refrescar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlMenuVisualizarDatosLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlMenuVisualizarDatosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditarTabla, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(BtnEliminar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
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
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
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

        btnEditar.setBackground(new java.awt.Color(41, 165, 232));
        btnEditar.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        btnEditar.setForeground(new java.awt.Color(255, 255, 255));
        btnEditar.setText("Editar");
        btnEditar.setBorder(null);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnEliminarUsuario.setBackground(new java.awt.Color(254, 61, 61));
        btnEliminarUsuario.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        btnEliminarUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnEliminarUsuario.setText("Eliminar");
        btnEliminarUsuario.setBorder(null);
        btnEliminarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarUsuarioActionPerformed(evt);
            }
        });

        btnRegistrarU.setBackground(new java.awt.Color(41, 165, 232));
        btnRegistrarU.setFont(new java.awt.Font("Yu Gothic UI", 1, 18)); // NOI18N
        btnRegistrarU.setForeground(new java.awt.Color(255, 255, 255));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
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

        javax.swing.GroupLayout pnlGestionUsuariosLayout = new javax.swing.GroupLayout(pnlGestionUsuarios);
        pnlGestionUsuarios.setLayout(pnlGestionUsuariosLayout);
        pnlGestionUsuariosLayout.setHorizontalGroup(
            pnlGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlGestionUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnlGestionUsuariosLayout.setVerticalGroup(
            pnlGestionUsuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGestionUsuariosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        ventana.add(pnlGestionUsuarios, "pnlGestionUsuarios");

        javax.swing.GroupLayout configLayout = new javax.swing.GroupLayout(config);
        config.setLayout(configLayout);
        configLayout.setHorizontalGroup(
            configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 693, Short.MAX_VALUE)
        );
        configLayout.setVerticalGroup(
            configLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 546, Short.MAX_VALUE)
        );

        ventana.add(config, "config");

        menu.setRoundBottomLeft(30);
        menu.setRoundBottomRight(30);
        menu.setRoundTopLeft(30);
        menu.setRoundTopRight(30);

        btnCargarDatos.setBackground(new java.awt.Color(62, 115, 248));
        btnCargarDatos.setBorder(null);
        btnCargarDatos.setForeground(new java.awt.Color(255, 255, 255));
        btnCargarDatos.setText("Cargar datos");
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

        btnConfig.setBackground(new java.awt.Color(62, 115, 248));
        btnConfig.setBorder(null);
        btnConfig.setForeground(new java.awt.Color(255, 255, 255));
        btnConfig.setText("Configuración");
        btnConfig.setBorderColor(new java.awt.Color(242, 242, 242));
        btnConfig.setColor(new java.awt.Color(62, 115, 248));
        btnConfig.setColorClick(new java.awt.Color(62, 96, 234));
        btnConfig.setColorOver(new java.awt.Color(103, 181, 255));
        btnConfig.setFont(new java.awt.Font("Segoe UI Black", 0, 12)); // NOI18N
        btnConfig.setRadius(15);
        btnConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfigActionPerformed(evt);
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
                    .addComponent(btnConfig, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addComponent(btnConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        c.refrescar();
    }//GEN-LAST:event_btnGestionarUsuariosActionPerformed

    private void btnConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfigActionPerformed
titulo1.setText("queso");
    }//GEN-LAST:event_btnConfigActionPerformed

    private void btnCargarDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarDatosActionPerformed
        titulo1.setText("Subir Datos");
        //CATEGORIA BOTONES 

        //FINCATEGORIA :)
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
        //c.refrescar();
    }//GEN-LAST:event_btnVisualizarActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        //CATEGORIA BOTONES 

        //FINCATEGORIA :)
        titulo1.setText("Inicio");
        cardLayout.show(ventana, "inicio");     // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_btnInicioActionPerformed

    private void btnCerrarSesion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarSesion1ActionPerformed
        cardLayout.show(ventana, "config");
    }//GEN-LAST:event_btnCerrarSesion1ActionPerformed

    private void lblRolMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblRolMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_lblRolMouseClicked

    private void lblNombreMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNombreMouseClicked
        JOptionPane.showMessageDialog(null, "Fruto de la colaboración entre el equipo de investigación CVAM y la dirección de PNF UNERMB, con sede en Los Laureles, bajo la guía de la Profesora Ana Capielo.", "Creditos", JOptionPane.WARNING_MESSAGE);        // TODO add your handling code here:
    }//GEN-LAST:event_lblNombreMouseClicked

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

    private void filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filtrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filtrarActionPerformed

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed

    private void refrescarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarActionPerformed

    }//GEN-LAST:event_refrescarActionPerformed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void TablaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablaMouseClicked
        /*        Principal princ = new Principal();

        Controlador c = new Controlador(princ);*/
     /*   if (evt.getClickCount() == 2) { // Verificar si es un doble clic
            int fila = Tabla.getSelectedRow(); // Obtener la fila seleccionada

            if (fila != -1) { // Verificar que se ha seleccionado una fila

                // 💡 REEMPLAZA el código de la URL con la llamada al controlador
                if (this.c != null) {
                    // Llama al método 'editar()' de tu controlador para abrir el JDialog 'EditarDatos'.
                    this.c.editar();
                } else {
                    // Esto es solo una advertencia si el controlador no está enlazado
                    JOptionPane.showMessageDialog(this, "El controlador no está inicializado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
                // FIN DE LA MODIFICACIÓN
            }
        }
*/
//        if (evt.getClickCount() == 2) { // Verificar si es un doble clic
//            int fila = Tabla.getSelectedRow(); // Obtener la fila seleccionada
//            if (fila != -1) { // Verificar que se ha seleccionado una fila
//                String url = Tabla.getValueAt(fila, 9).toString(); // Obtener la URL de la columna 10 (índice 9)
//                try {
//                    Desktop.getDesktop().browse(new URI(url)); // Abrir la URL en el navegador
//                } catch (IOException | URISyntaxException ex) {
//                    ex.printStackTrace(); // Manejar excepciones
//                    JOptionPane.showMessageDialog(this, "Error al abrir la URL: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
//                }
//            }
//
//        }
    }//GEN-LAST:event_TablaMouseClicked

    private void txtnomKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnomKeyReleased
        validar();        // TODO add your handling code here:
    }//GEN-LAST:event_txtnomKeyReleased

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed

    }//GEN-LAST:event_btnlimpiarActionPerformed

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

    private void urlKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_urlKeyReleased
        // TODO add your handling code here:
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
        validar();        // TODO add your handling code here:
    }//GEN-LAST:event_pnfKeyReleased

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

    private void seccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_seccionKeyReleased
        validar();        // TODO add your handling code here:
    }//GEN-LAST:event_seccionKeyReleased

    private void profesorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_profesorKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_profesorKeyReleased

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
        cs.setLocationRelativeTo(null);
        cs.setBackground(new Color(0, 0, 0, 0));
    }//GEN-LAST:event_btnCerrarSesionActionPerformed

    private void myButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButton1ActionPerformed
// 1. Crear la instancia (asumiendo que 'this' es el Frame padre)
        PrevisualizarInfo previ = new PrevisualizarInfo(this, true);

        // 2. Establecer el fondo transparente (Ahora funciona porque el diálogo NO está decorado)
//    previ.setBackground(new Color(0, 0, 0, 0));
        // 3. Empaquetar y Centrar (es el orden correcto)
        previ.pack();
        previ.setLocationRelativeTo(null);

        // 4. Mostrar
        previ.setVisible(true);

    }//GEN-LAST:event_myButton1ActionPerformed

    private void btnEditarTablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarTablaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEditarTablaActionPerformed

        /**
         * @param args the command line arguments
         */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public componentes.MyButton BtnEliminar;
    public javax.swing.JTable Tabla;
    public javax.swing.JTable TablaUser;
    private componentes.MyButton btnCargarDatos;
    private componentes.MyButton btnCerrarSesion;
    private componentes.MyButton btnConfig;
    private javax.swing.JButton btnEditar;
    public componentes.MyButton btnEditarTabla;
    public javax.swing.JButton btnEliminarUsuario;
    private componentes.MyButton btnGestionarUsuarios;
    private componentes.MyButton btnInicio;
    private javax.swing.JButton btnRegistrarU;
    private componentes.MyButton btnVisualizar;
    public javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JPanel config;
    public com.toedter.calendar.JCalendar fdpresentacion;
    public javax.swing.JComboBox<String> filtrar;
    public javax.swing.JButton guardar;
    private componentes.round1 hotbar;
    private javax.swing.JPanel inicio;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblRol;
    public javax.swing.JLabel logo;
    private componentes.round1 menu;
    private componentes.MyButton myButton1;
    private componentes.MyButton ocultarMenu;
    private javax.swing.JLabel pn;
    public javax.swing.JComboBox<String> pnf;
    private javax.swing.JPanel pnlCargarDatos;
    private javax.swing.JPanel pnlGestionUsuarios;
    private javax.swing.JPanel pnlMenuVisualizarDatos;
    private javax.swing.JPanel pnlVisualizarDatos;
    private javax.swing.JLabel prof;
    private javax.swing.JLabel prof1;
    private javax.swing.JLabel prof2;
    public javax.swing.JTextField profesor;
    public javax.swing.JButton refrescar;
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
