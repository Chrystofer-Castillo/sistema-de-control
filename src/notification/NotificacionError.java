/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package notification;

import java.awt.Color;

/**
 *
 * @author Chrys
 */
public class NotificacionError extends javax.swing.JDialog {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NotificacionError.class.getName());

    /**
     * Creates new form NotificacionError
     */
    public NotificacionError(java.awt.Frame parent, boolean modal, String mensajeUno, String mensajeDos) {
        super(parent, modal);

        initComponents();
         setBackground(new Color (0,0,0,0));
    this.msj1error.setText(mensajeUno);
    this.msj2error.setText(mensajeDos);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        round11 = new componentes.round1();
        panelRound2 = new Clases.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        msj2error = new javax.swing.JLabel();
        msj1error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        round11.setBackground(new java.awt.Color(217, 216, 217));
        round11.setRoundBottomLeft(40);
        round11.setRoundBottomRight(40);
        round11.setRoundTopLeft(40);
        round11.setRoundTopRight(40);
        round11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(255, 54, 54));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);
        panelRound2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(30, 30, 30));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ERROR");
        panelRound2.add(jLabel1, new java.awt.GridBagConstraints());

        round11.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 330, -1));

        msj2error.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        msj2error.setForeground(new java.awt.Color(30, 30, 30));
        msj2error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj2error.setText("MSJ2");
        round11.add(msj2error, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 370, -1));

        msj1error.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        msj1error.setForeground(new java.awt.Color(30, 30, 30));
        msj1error.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj1error.setText("MSJ1");
        round11.add(msj1error, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 370, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(round11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(round11, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel msj1error;
    private javax.swing.JLabel msj2error;
    private Clases.PanelRound panelRound2;
    private componentes.round1 round11;
    // End of variables declaration//GEN-END:variables
}
