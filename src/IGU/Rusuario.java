/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package IGU;

import Modelo.Hash;
import Modelo.usuarios;
import Modelo.usuariosDAO;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JFrame;
public class Rusuario extends javax.swing.JFrame {

    public Rusuario() {
        initComponents();
        setBackground(new Color(0,0,0,0));
        round11.setBackground(javax.swing.UIManager.getColor("Panel.background"));
        this.setTitle("Registrar Usuario");
        jLabel7.setForeground(javax.swing.UIManager.getColor("Label.foreground"));
        Nomlabel.setForeground(javax.swing.UIManager.getColor("Label.foreground"));
        Cilabel.setForeground(javax.swing.UIManager.getColor("Label.foreground"));
        Conlabel.setForeground(javax.swing.UIManager.getColor("Label.foreground"));
        Conlabel2.setForeground(javax.swing.UIManager.getColor("Label.foreground"));
        Conlabel3.setForeground(javax.swing.UIManager.getColor("Label.foreground"));
        id_tipo.setForeground(javax.swing.UIManager.getColor("Label.foreground"));
        id_tipo.setBackground(javax.swing.UIManager.getColor("Label.background"));
        nombre.setForeground(javax.swing.UIManager.getColor("Label.foreground"));
        nombre.setBackground(javax.swing.UIManager.getColor("Label.background"));
        ci.setForeground(javax.swing.UIManager.getColor("Label.foreground"));
        ci.setBackground(javax.swing.UIManager.getColor("Label.background"));
        password.setForeground(javax.swing.UIManager.getColor("Label.foreground"));
        password.setBackground(javax.swing.UIManager.getColor("Label.background"));
        passconfirm.setForeground(javax.swing.UIManager.getColor("Label.foreground"));
        passconfirm.setBackground(javax.swing.UIManager.getColor("Label.background"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        round11 = new componentes.round1();
        nombre = new javax.swing.JTextField();
        Nomlabel = new javax.swing.JLabel();
        ci = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        passconfirm = new javax.swing.JPasswordField();
        id_tipo = new javax.swing.JComboBox<>();
        botones = new componentes.MyButton();
        Cilabel = new javax.swing.JLabel();
        Conlabel = new javax.swing.JLabel();
        Conlabel2 = new javax.swing.JLabel();
        Conlabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        minimizar = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        round11.setBackground(new java.awt.Color(217, 216, 217));
        round11.setAlignmentX(0.0F);
        round11.setAlignmentY(0.0F);
        round11.setRoundBottomLeft(30);
        round11.setRoundBottomRight(30);
        round11.setRoundTopLeft(30);
        round11.setRoundTopRight(30);
        round11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        nombre.setBackground(new java.awt.Color(195, 195, 195));
        nombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nombreActionPerformed(evt);
            }
        });
        round11.add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 131, 173, 16));

        Nomlabel.setBackground(new java.awt.Color(255, 255, 255));
        Nomlabel.setFont(new java.awt.Font("Araboto-Light", 0, 12)); // NOI18N
        Nomlabel.setForeground(new java.awt.Color(75, 75, 78));
        Nomlabel.setText("Nombre y Apellido:");
        round11.add(Nomlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(28, 130, -1, -1));

        ci.setBackground(new java.awt.Color(195, 195, 195));
        ci.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ciActionPerformed(evt);
            }
        });
        round11.add(ci, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 166, 173, 16));

        password.setBackground(new java.awt.Color(195, 195, 195));
        round11.add(password, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 201, 173, 16));

        passconfirm.setBackground(new java.awt.Color(195, 195, 195));
        passconfirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passconfirmActionPerformed(evt);
            }
        });
        round11.add(passconfirm, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 236, 173, 16));

        id_tipo.setBackground(new java.awt.Color(195, 195, 195));
        id_tipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-", "Administrador", "Profesor", "Asistente" }));
        id_tipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                id_tipoActionPerformed(evt);
            }
        });
        round11.add(id_tipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(152, 271, 173, 16));

        botones.setBackground(new java.awt.Color(16, 120, 17));
        botones.setBorder(null);
        botones.setForeground(new java.awt.Color(255, 255, 255));
        botones.setText("Registrar");
        botones.setColor(new java.awt.Color(16, 120, 17));
        botones.setColorClick(new java.awt.Color(16, 168, 2));
        botones.setColorOver(new java.awt.Color(16, 84, 17));
        botones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        botones.setRadius(30);
        botones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonesActionPerformed(evt);
            }
        });
        round11.add(botones, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 350, 200, 60));

        Cilabel.setBackground(new java.awt.Color(255, 255, 255));
        Cilabel.setFont(new java.awt.Font("Araboto-Light", 0, 12)); // NOI18N
        Cilabel.setForeground(new java.awt.Color(75, 75, 78));
        Cilabel.setText("Cedula de Identidad:");
        round11.add(Cilabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 165, -1, -1));

        Conlabel.setBackground(new java.awt.Color(255, 255, 255));
        Conlabel.setFont(new java.awt.Font("Araboto-Light", 0, 12)); // NOI18N
        Conlabel.setForeground(new java.awt.Color(75, 75, 78));
        Conlabel.setText("Contraseña:");
        round11.add(Conlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(66, 200, -1, -1));

        Conlabel2.setBackground(new java.awt.Color(255, 255, 255));
        Conlabel2.setFont(new java.awt.Font("Araboto-Light", 0, 12)); // NOI18N
        Conlabel2.setForeground(new java.awt.Color(75, 75, 78));
        Conlabel2.setText("Confirmar Contraseña:");
        round11.add(Conlabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 235, -1, -1));

        Conlabel3.setBackground(new java.awt.Color(255, 255, 255));
        Conlabel3.setFont(new java.awt.Font("Araboto-Light", 0, 12)); // NOI18N
        Conlabel3.setForeground(new java.awt.Color(75, 75, 78));
        Conlabel3.setText("Rol del Usuario:");
        round11.add(Conlabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 270, -1, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Araboto-Black", 0, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(45, 44, 44));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("REGISTRAR USUARIO");
        jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jLabel7.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        round11.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 36, 336, 40));

        minimizar.setBackground(new java.awt.Color(0, 0, 0));
        minimizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        minimizar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        minimizar.setText("—");
        minimizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                minimizarMouseClicked(evt);
            }
        });
        round11.add(minimizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, 24, 30));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("X");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        round11.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 0, 40, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(round11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(round11, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void id_tipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_id_tipoActionPerformed

    }//GEN-LAST:event_id_tipoActionPerformed

    private void nombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nombreActionPerformed

    private void ciActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ciActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ciActionPerformed

    private void passconfirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passconfirmActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passconfirmActionPerformed

    private void botonesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonesActionPerformed
      
	usuariosDAO modSql = new usuariosDAO();
        usuarios mod = new usuarios();

        String pass = new String(password.getPassword());
        String passcon = new String(passconfirm.getPassword());

        if (ci.getText().equals("") || password.equals("") || passconfirm.equals("") || nombre.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Los campos están vacíos, por favor, llenar todos los campos.");
        } else {
            if (pass.equals(passcon)) {

                if (modSql.existeUsuario(ci.getText()) == 0) {

                    String nuevoPass = Hash.sha1(pass);
                    mod.setCi(ci.getText());
                    mod.setPassword(nuevoPass);
                    mod.setNombre(nombre.getText());

                    int selectedIndex = id_tipo.getSelectedIndex(); // Obtiene el índice seleccionado

                    switch (selectedIndex) {
                        case 1: // Administrador
                        mod.setId_tipo(1);
                        break;
                        case 2: // Profesor
                        mod.setId_tipo(2);
                        break;
                        case 3: // Asistente
                        mod.setId_tipo(3);
                        break;
                        default:
                        JOptionPane.showMessageDialog(null, "Por favor seleccione un tipo de usuario.");
                        return; // Salir del método si no se selecciona un tipo válido
                    }

                    if (modSql.registrar(mod)) {
                        JOptionPane.showMessageDialog(null, "Registro guardado exitosamente");
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Error al guardar el usuario");
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "El usuario ya existe");
                }
            } else {
                JOptionPane.showMessageDialog(null, "las contraseñas no coinciden");
            }

        }               // TODO add your handling code here:
    }//GEN-LAST:event_botonesActionPerformed

    private void minimizarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_minimizarMouseClicked
        this.setState(JFrame.ICONIFIED);
    }//GEN-LAST:event_minimizarMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
this.dispose();
    }//GEN-LAST:event_jLabel1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Cilabel;
    private javax.swing.JLabel Conlabel;
    private javax.swing.JLabel Conlabel2;
    private javax.swing.JLabel Conlabel3;
    private javax.swing.JLabel Nomlabel;
    private componentes.MyButton botones;
    public javax.swing.JTextField ci;
    private javax.swing.JComboBox<String> id_tipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel minimizar;
    private javax.swing.JTextField nombre;
    private javax.swing.JPasswordField passconfirm;
    private javax.swing.JPasswordField password;
    private componentes.round1 round11;
    // End of variables declaration//GEN-END:variables
}
