package notification;

import java.awt.Color;
import javax.swing.Timer;

public class NotificacionFaltaInfo extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(NotificacionFaltaInfo.class.getName());

    public NotificacionFaltaInfo(java.awt.Frame parent, boolean modal, String msjfalta1, String msjfalta2) {
        super(parent, modal);
        initComponents();
        setBackground(new Color(0, 0, 0, 0));
        jLabel1.setForeground(new Color(30, 30, 30));
        round11.setBackground(javax.swing.UIManager.getColor("Panel.background"));
        msj1falta.setForeground(javax.swing.UIManager.getColor("Label.foreground"));
        msj2falta.setForeground(javax.swing.UIManager.getColor("Label.foreground"));
        this.setBackground(new Color(0, 0, 0, 0));
        
        msj1falta.setText(msjfalta1);
        msj2falta.setText(msjfalta2);
        Timer timer = new Timer(4000, e -> {
            dispose();
        });

        // 3. Asegúrate de que el timer solo se ejecute UNA vez
        timer.setRepeats(false);

        // 4. Inicia el temporizador
        timer.start();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        round11 = new componentes.round1();
        panelRound2 = new Clases.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        msj2falta = new javax.swing.JLabel();
        msj1falta = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        round11.setBackground(new java.awt.Color(217, 216, 217));
        round11.setRoundBottomLeft(40);
        round11.setRoundBottomRight(40);
        round11.setRoundTopLeft(40);
        round11.setRoundTopRight(40);
        round11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(255, 150, 6));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);
        panelRound2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ATENCIÓN");
        panelRound2.add(jLabel1, new java.awt.GridBagConstraints());

        round11.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 330, -1));

        msj2falta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        msj2falta.setForeground(new java.awt.Color(30, 30, 30));
        msj2falta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj2falta.setText("MSJ2");
        round11.add(msj2falta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 370, 20));

        msj1falta.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        msj1falta.setForeground(new java.awt.Color(30, 30, 30));
        msj1falta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        msj1falta.setText("MSJ1");
        round11.add(msj1falta, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 370, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 370, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(round11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 120, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(round11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel msj1falta;
    private javax.swing.JLabel msj2falta;
    private Clases.PanelRound panelRound2;
    private componentes.round1 round11;
    // End of variables declaration//GEN-END:variables
}
