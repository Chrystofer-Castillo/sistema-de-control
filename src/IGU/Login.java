package IGU;

import Modelo.Hash;
import Modelo.usuarios;
import Modelo.usuariosDAO;
import componentes.SplashScreen;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/*
@author Chrys
 */
public class Login extends javax.swing.JFrame {

    private int xMouse;
    private int yMouse;
   // FondoPanel fondo = new FondoPanel();

    public Login() {
//        this.setContentPane(fondo);
        this.setTitle("Iniciar Sesión");
        initComponents();
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.jpg")).getImage());

        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                xMouse = e.getX(); // Obtener la posición X del mouse
                yMouse = e.getY(); // Obtener la posición Y del mouse
            }
        });

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new componentes.round1();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCi = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        txtPassword = new javax.swing.JPasswordField();
        anunciousuario = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        login = new componentes.MyButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        minimizar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setFocusCycleRoot(false);
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                formMouseDragged(evt);
            }
        });

        panel.setBackground(new java.awt.Color(217, 216, 217));
        panel.setRoundBottomLeft(30);
        panel.setRoundBottomRight(30);
        panel.setRoundTopLeft(30);
        panel.setRoundTopRight(30);
        panel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelMouseDragged(evt);
            }
        });
        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Araboto-Light", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(75, 75, 78));
        jLabel3.setText("V -");
        panel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Araboto-Light", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 153));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Olvidaste la contraseña?");
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        panel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 130, -1));

        txtCi.setBackground(new java.awt.Color(217, 216, 217));
        txtCi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtCi.setBorder(null);
        txtCi.setSelectedTextColor(new java.awt.Color(242, 242, 242));
        txtCi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCiActionPerformed(evt);
            }
        });
        panel.add(txtCi, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 270, 31));

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator2.setForeground(new java.awt.Color(153, 153, 153));
        panel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 280, 10));

        txtPassword.setBackground(new java.awt.Color(217, 216, 217));
        txtPassword.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        txtPassword.setBorder(null);
        txtPassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPasswordActionPerformed(evt);
            }
        });
        panel.add(txtPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 270, 30));

        anunciousuario.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        anunciousuario.setForeground(new java.awt.Color(255, 0, 0));
        anunciousuario.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel.add(anunciousuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 310, 330, 20));

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 0));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panel.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 330, -1));

        login.setBackground(new java.awt.Color(16, 120, 17));
        login.setBorder(null);
        login.setForeground(new java.awt.Color(255, 255, 255));
        login.setText("Iniciar Sesión");
        login.setBorderColor(new java.awt.Color(217, 216, 217));
        login.setColor(new java.awt.Color(16, 120, 17));
        login.setColorClick(new java.awt.Color(21, 27, 41));
        login.setColorOver(new java.awt.Color(41, 53, 82));
        login.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        login.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        login.setRadius(30);
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });
        panel.add(login, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 310, 60));

        jSeparator3.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator3.setForeground(new java.awt.Color(0, 51, 204));
        panel.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 130, 10));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Araboto-Black", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(45, 44, 44));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("INICIAR SESIÓN");
        jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        panel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 210, 40));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Araboto-Light", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(75, 75, 78));
        jLabel6.setText("USUARIO");
        panel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Araboto-Light", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(75, 75, 78));
        jLabel7.setText("Ej: V- 10.XXX.XXX");
        panel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Araboto-Light", 0, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(75, 75, 78));
        jLabel8.setText("CONTRASEÑA");
        panel.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        jSeparator4.setForeground(new java.awt.Color(153, 153, 153));
        panel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 280, 10));

        minimizar.setBackground(new java.awt.Color(0, 0, 0));
        minimizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizar.setText("—");
        minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        panel.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 24, 30));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 0, 30, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 452, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
//BLABLABLABLEBLEBLEBLUBLUBU
    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizarMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
/*
        usuariosDAO modSql = new usuariosDAO();
        usuarios mod = new usuarios();

        Date date = new Date();
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String password = new String(txtPassword.getPassword());
        if (!txtCi.getText().equals("") && !password.equals("")) {
            String nuevoPass = Hash.sha1(password);

            mod.setCi(txtCi.getText());
            mod.setPassword(nuevoPass);
            mod.setLast_session(fechaHora.format(date));
            if (modSql.login(mod)) {
                Principal princ = new Principal(mod);
                princ.setVisible(true);
                princ.setLocationRelativeTo(null);
                princ.setExtendedState(JFrame.MAXIMIZED_BOTH);
                this.dispose();
                Controlador c = new Controlador(princ);
                c.refrescar();

            } else {

                JOptionPane.showMessageDialog(null, "Datos Incorrectos");

            }

        } else {

            JOptionPane.showMessageDialog(null, "Debe ingresar sus datos.");
        }*/
usuariosDAO modSql = new usuariosDAO();
        usuarios mod = new usuarios();

        Date date = new Date();
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        String password = new String(txtPassword.getPassword());
        
        if (!txtCi.getText().equals("") && !password.equals("")) {
            String nuevoPass = Hash.sha1(password);

            mod.setCi(txtCi.getText());
            mod.setPassword(nuevoPass);
            mod.setLast_session(fechaHora.format(date));
            
            // **********************************************************
            // PUNTO DE INTEGRACIÓN: Login exitoso
            // **********************************************************
            if (modSql.login(mod)) {
                
                // 1. Ocultar la ventana de Login
                this.dispose();

                // 2. Preparar la ventana Principal, pero NO hacerla visible AÚN.
                // Le pasamos el objeto 'mod' con los datos del usuario.
                Principal ventanaPrincipal = new Principal(mod); 
                
                // 3. Crear y mostrar la pantalla de carga (SplashScreen)
                // Usamos 'null' como parent ya que la ventana de Login ya se cerró.
                SplashScreen pantallaCarga = new SplashScreen(null, false); 
                pantallaCarga.setVisible(true);
                pantallaCarga.setLocationRelativeTo(this);
                // 4. Iniciar el cargador de datos en segundo plano (SwingWorker)
                // Le pasamos la referencia del Splash y de la ventana Principal.
                SplashScreen.MiCargadorDatos cargador = 
                    new SplashScreen.MiCargadorDatos(pantallaCarga, ventanaPrincipal);
                cargador.execute();
                
                // NOTA: La configuración final de la ventana Principal (setMaximized, setLocation, 
                // y el Controlador c.refrescar()) se mueven al método 'done()' del SwingWorker,
                // ya que eso debe ocurrir después de que la base de datos haya cargado.
                
            } else {

                
                anunciousuario.setText("Datos Incorrectos");

            }
            // **********************************************************

        } else {
                anunciousuario.setText("Datos Incorrectos");
            
        }

    }//GEN-LAST:event_loginActionPerformed

    private void txtPasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPasswordActionPerformed

    }//GEN-LAST:event_txtPasswordActionPerformed

    private void txtCiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCiActionPerformed

    }//GEN-LAST:event_txtCiActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        Ayuda ayu = new Ayuda();
        ayu.setVisible(true);
        ayu.setLocationRelativeTo(null);
    }//GEN-LAST:event_jLabel4MouseClicked

    private void formMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseDragged
        // TODO add your handling code here:
    }//GEN-LAST:event_formMouseDragged

    private void panelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelMouseDragged
        int x = this.getLocation().x + evt.getX() - xMouse;
        int y = this.getLocation().y + evt.getY() - yMouse; 
        this.setLocation(x, y);           // TODO add your handling code here:
    }//GEN-LAST:event_panelMouseDragged

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel anunciousuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private componentes.MyButton login;
    private javax.swing.JLabel minimizar;
    private componentes.round1 panel;
    private javax.swing.JTextField txtCi;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables

/*    class FondoPanel extends JPanel {

        private Image imagen;

        @Override
        public void paint(Graphics g) {
            imagen = new ImageIcon(getClass().getResource("/imagenes/uno.jpg")).getImage();

            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);

            setOpaque(false);

            super.paint(g);
        }
    }
*/
}
