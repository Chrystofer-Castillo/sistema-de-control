package notification;

import Controlador.Controlador;
import Modelo.Datos;
import javax.swing.JOptionPane;
import java.awt.Color;


/**
 *
 * @author Chrys
 */
public class EditarDatos extends javax.swing.JDialog {

    // Variables de clase para el manejo de datos y control
    private Datos datosOriginales;
    private Controlador controlador;

    // Asumo que estos componentes existen en tu initComponents()
    // Debes añadir tus ComboBox y JDateChooser si los tienes
    // -------------------------------------------------------------------------
    // 💡 CONSTRUCTOR UNIFICADO Y CORREGIDO
    // -------------------------------------------------------------------------
    public EditarDatos(java.awt.Frame parent, boolean modal, Datos datos, Controlador controlador) {
        super(parent, modal);

        // 💡 PASO 1: Quitar la decoración primero
        setUndecorated(true);

        // 💡 PASO 2: Inicializar componentes
        initComponents();

        // 💡 PASO 3: Ahora es seguro establecer el fondo transparente (si es necesario)
        // Ya que el diálogo ya no está 'decorated'
        this.setBackground(new Color(0, 0, 0, 0));
        this.datosOriginales = datos;
        this.controlador = controlador;

        // ✅ ¡ASEGÚRATE DE QUE ESTA LÍNEA ESTÉ AQUÍ!
        // Esta es la línea que llena los campos de texto.
        cargarDatos(datos);
        this.datosOriginales = datos;
        this.controlador = controlador;

    }
    private Datos datosActualizados = null;

    public Datos getDatosActualizados() {
        return datosActualizados;
    }

    private void cargarDatos(Datos d) {

        // Usamos los getters del objeto 'Datos' para poblar los campos
        textFieldIdentificador.setText(String.valueOf(d.getId()));
        textFieldPNF.setText(d.getPnf());
        textFieldSede.setText(d.getSede());
        textFieldTrayecto.setText(d.getTrayecto());
        textFieldSeccion.setText(d.getSeccion());
        textFieldProfesor.setText(d.getProfesor());
        textFieldTitulo.setText(d.getTproyecto());      // Asumo que Titulo es Tproyecto
        textFieldIntegrantes.setText(d.getTxtnom()); // Asumo que Integrantes es Txtnom
        textFieldURL.setText(d.getUrl());

        // ¡Importante! Hacemos que el ID no se pueda editar.
        textFieldIdentificador.setEditable(false);
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new componentes.round1();
        panelRound2 = new Clases.PanelRound();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btnSalir = new componentes.MyButton();
        btnEditar = new componentes.MyButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        textFieldSede = new javax.swing.JTextField();
        textFieldTitulo = new javax.swing.JTextField();
        textFieldIntegrantes = new javax.swing.JTextField();
        textFieldProfesor = new javax.swing.JTextField();
        textFieldURL = new javax.swing.JTextField();
        textFieldPNF = new javax.swing.JTextField();
        textFieldSeccion = new javax.swing.JTextField();
        textFieldTrayecto = new javax.swing.JTextField();
        textFieldIdentificador = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        panelRound1.setBackground(new java.awt.Color(217, 216, 217));
        panelRound1.setRoundBottomLeft(40);
        panelRound1.setRoundBottomRight(40);
        panelRound1.setRoundTopLeft(40);
        panelRound1.setRoundTopRight(40);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(82, 197, 255));
        panelRound2.setRoundBottomLeft(20);
        panelRound2.setRoundBottomRight(20);
        panelRound2.setRoundTopLeft(20);
        panelRound2.setRoundTopRight(20);
        panelRound2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Editar Datos");
        panelRound2.add(jLabel1, new java.awt.GridBagConstraints());

        panelRound1.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, 680, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Enlace:");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 120, 30));

        btnSalir.setBackground(new java.awt.Color(254, 61, 61));
        btnSalir.setBorder(null);
        btnSalir.setForeground(new java.awt.Color(255, 248, 248));
        btnSalir.setText("Cancelar");
        btnSalir.setBorderColor(new java.awt.Color(217, 216, 217));
        btnSalir.setColor(new java.awt.Color(254, 61, 61));
        btnSalir.setColorClick(new java.awt.Color(254, 50, 18));
        btnSalir.setColorOver(new java.awt.Color(254, 61, 84));
        btnSalir.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnSalir.setRadius(20);
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        panelRound1.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 220, 120, 50));

        btnEditar.setBackground(new java.awt.Color(62, 115, 248));
        btnEditar.setBorder(null);
        btnEditar.setForeground(new java.awt.Color(255, 248, 248));
        btnEditar.setText("EDITAR");
        btnEditar.setBorderColor(new java.awt.Color(217, 216, 217));
        btnEditar.setColor(new java.awt.Color(62, 115, 248));
        btnEditar.setColorClick(new java.awt.Color(62, 96, 234));
        btnEditar.setColorOver(new java.awt.Color(103, 181, 255));
        btnEditar.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        btnEditar.setRadius(15);
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });
        panelRound1.add(btnEditar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 120, 50));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Integrantes:");
        jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 120, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Profesor/a:");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 120, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Sede:");
        jLabel7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 100, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Trayecto:");
        jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 120, 30));

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Sección:");
        jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, 120, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("PNF:");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 120, 30));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Titulo:");
        jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 100, 30));
        panelRound1.add(textFieldSede, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 210, 30));
        panelRound1.add(textFieldTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 240, 30));
        panelRound1.add(textFieldIntegrantes, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 240, 30));
        panelRound1.add(textFieldProfesor, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 240, 30));
        panelRound1.add(textFieldURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 240, 30));
        panelRound1.add(textFieldPNF, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 210, 30));

        textFieldSeccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSeccionActionPerformed(evt);
            }
        });
        panelRound1.add(textFieldSeccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 130, 210, 30));
        panelRound1.add(textFieldTrayecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 210, 30));
        panelRound1.add(textFieldIdentificador, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 240, 30));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Identificador:");
        jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        panelRound1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 753, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelRound1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed

// 1. Validamos que los campos importantes no estén vacíos (opcional pero recomendado)
        if (textFieldTitulo.getText().trim().isEmpty() || textFieldPNF.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "El Título y el PNF no pueden estar vacíos.", "Error", JOptionPane.WARNING_MESSAGE);
            return; // Detiene la acción si la validación falla
        }

        // 2. Si todo está bien, leemos TODOS los campos y creamos un objeto 'Datos'
        try {
            Datos d = new Datos();

            // 3. Obtenemos el ID del campo (que no se podía editar)
            d.setId(Integer.parseInt(textFieldIdentificador.getText()));

            // 4. Obtenemos los valores nuevos de los campos que sí se podían editar
            d.setPnf(textFieldPNF.getText());
            d.setSede(textFieldSede.getText());
            d.setTrayecto(textFieldTrayecto.getText());
            d.setSeccion(textFieldSeccion.getText());
            d.setProfesor(textFieldProfesor.getText());
            d.setTproyecto(textFieldTitulo.getText());      // Asumo que Titulo es Tproyecto
            d.setTxtnom(textFieldIntegrantes.getText()); // Asumo que Integrantes es Txtnom
            d.setUrl(textFieldURL.getText());

            // 5. ¡MUY IMPORTANTE! Mantenemos la fecha original, ya que no la editamos aquí.
            //    La tomamos del objeto que guardamos en el constructor.
            d.setFdpresentacion(this.datosOriginales.getFdpresentacion());

            // 6. Guardamos el "paquete" (el objeto 'Datos' actualizado)
            //    para que el Controlador lo recoja.
            this.datosActualizados = d;

            // 7. Cerramos esta ventana
            this.dispose();

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error: El ID no es un número válido.");
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void textFieldSeccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textFieldSeccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textFieldSeccionActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private componentes.MyButton btnEditar;
    private componentes.MyButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private componentes.round1 panelRound1;
    private Clases.PanelRound panelRound2;
    private javax.swing.JTextField textFieldIdentificador;
    private javax.swing.JTextField textFieldIntegrantes;
    private javax.swing.JTextField textFieldPNF;
    private javax.swing.JTextField textFieldProfesor;
    private javax.swing.JTextField textFieldSeccion;
    private javax.swing.JTextField textFieldSede;
    private javax.swing.JTextField textFieldTitulo;
    private javax.swing.JTextField textFieldTrayecto;
    private javax.swing.JTextField textFieldURL;
    // End of variables declaration//GEN-END:variables
}
