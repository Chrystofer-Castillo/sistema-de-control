package componentes;

import Controlador.Controlador;
import IGU.Principal;
import Modelo.usuarios;
import Modelo.usuariosDAO;
import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingWorker;
import javax.swing.JFrame;

/**
 *
 * @author Chrys
 */
public class SplashScreen extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SplashScreen.class.getName());

    // *****************************************************************
    // 1. CONSTANTE para la duración del intro (7 segundos)
    // *****************************************************************
    // Usamos 'final' para que no pueda cambiar.
    //private static final long TIEMPO_ESPERA_MS = 7000; 
    private static final long TIEMPO_ESPERA_MS = 4000;

    /**
     * Creates new form SplashScreen
     */
    public SplashScreen(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        // *****************************************************************
        // 2. Configuración esencial de la ventana Splash
        // *****************************************************************
        setUndecorated(true); // ¡Quita bordes y botones!
        setLocationRelativeTo(null);
        // Carga los componentes iniciales (el código generado por NetBeans)
        initComponents();

        // Inicia la lógica del GIF y Audio
        iniciarSplash();
    }

    // *****************************************************************
    // 3. Método para configurar el GIF y el Audio
    // *****************************************************************
    private void iniciarSplash() {
        // Cargar el GIF animado (visual)
        try {
            // 1. Cargas la imagen (tu GIF)
            ImageIcon gifIcon = new ImageIcon(getClass().getResource("/splashScreen/intro.gif"));

            // 2. Creas el JLabel y le pasas el GIF
            /* JLabel lblAnimacion = new JLabel(gifIcon); // <-- AQUÍ se crea y se llama

        // 3. Reemplazas el contenido vacío del JDialog por el JLabel
        this.getContentPane().removeAll();
        this.getContentPane().add(lblAnimacion);
             */
            // ... (código para pack y centrar) ...
        } catch (Exception e) {
            // ... (manejo de error) ...
        }

        // Iniciar la reproducción del Audio WAV
        ReproductorAudio.reproducir("/splashScreen/intro_audio.wav");
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        gifIcon = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        gifIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/splashScreen/intro.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gifIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(gifIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

// </editor-fold>                        
    // *****************************************************************
    // 4. CLASE SWINGWORKER (Para la carga pesada en segundo plano)
    // *****************************************************************
    public static class MiCargadorDatos extends SwingWorker<Void, Void> {

        private final SplashScreen pantallaSplash;
        private final JFrame ventanaPrincipal;

        public MiCargadorDatos(SplashScreen splash, JFrame principal) {
            this.pantallaSplash = splash;
            this.ventanaPrincipal = principal;
        }

        @Override
        protected Void doInBackground() throws Exception {

            System.out.println("Iniciando la carga de datos de la BD...");
            usuariosDAO modSql = new usuariosDAO();
            usuarios mod = new usuarios();

            Date date = new Date();
            DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            mod.setLast_session(fechaHora.format(date));

// ************ CÓDIGO PESADO DE CARGA DE BASE DE DATOS AQUÍ ************
            // (Reemplaza la simulación con tu lógica de conexión y consultas)
            try {
                long tiempoInicio = System.currentTimeMillis();

                // --- Aquí va tu código real de carga de datos ---
                long tiempoFin = System.currentTimeMillis();
                long tiempoTranscurrido = tiempoFin - tiempoInicio;

                // Si la carga real es más rápida que el intro (7000ms), esperamos.
                if (tiempoTranscurrido < TIEMPO_ESPERA_MS) {
                    Thread.sleep(TIEMPO_ESPERA_MS - tiempoTranscurrido);
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.println("Carga de datos completada.");
            return null;
        }

        @Override
        protected void done() {
            // Cierra el Splash y abre la ventana principal
            if (pantallaSplash != null) {
                pantallaSplash.dispose();
            }
            System.out.println("Ventana principal abierta.");
            Controlador c = new Controlador((Principal) ventanaPrincipal);
            c.refrescar();
            ventanaPrincipal.setVisible(true);
            ventanaPrincipal.setLocationRelativeTo(null);
            ventanaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
            //ventanaPrincipal.setBackground(new Color(233, 236, 240));

        }
    }

    // *****************************************************************
    // 5. CLASE ReproductorAudio (Manejo del sonido WAV)
    // *****************************************************************
    public static class ReproductorAudio {

        public static void reproducir(String rutaAudio) {
            new Thread(() -> {
                try {
                    java.net.URL url = ReproductorAudio.class.getResource(rutaAudio);
                    if (url == null) {
                        System.err.println("Error: Archivo de audio no encontrado en la ruta: " + rutaAudio);
                        return;
                    }

                    Clip clip = AudioSystem.getClip();
                    clip.open(AudioSystem.getAudioInputStream(url));

                    clip.loop(0); // Asegura que solo se reproduzca una vez.
                    clip.start();

                } catch (Exception e) {
                    logger.log(java.util.logging.Level.SEVERE, "Error al reproducir el audio: ", e);
                }
            }).start();
        }
    }

    // Aquí iría el código del main si lo necesitas para probar el JDialog independientemente.

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel gifIcon;
    // End of variables declaration//GEN-END:variables
}
