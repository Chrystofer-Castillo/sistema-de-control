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
import Modelo.SettingsManager;
import Modelo.ThemeManager;
import javax.swing.JPanel;

/**
 *
 * @author Chrys
 */
public class SplashScreen extends javax.swing.JDialog {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SplashScreen.class.getName());

    private static final long TIEMPO_ESPERA_MS = 4000;
    private final usuarios usuarioAutenticado;

public SplashScreen(java.awt.Frame parent, boolean modal, usuarios user) {
    super(parent, modal);
    this.usuarioAutenticado = user; // Guardamos el usuario
    
    setUndecorated(true); 
    initComponents();
    
    // Aplicamos la transparencia
    setBackground(new Color(0, 0, 0, 0));
    ((JPanel) getContentPane()).setOpaque(false);
    
    setLocationRelativeTo(null);
    iniciarSplash();
}

    // *****************************************************************
    // 3. Método para configurar el GIF y el Audio
    // *****************************************************************
private void iniciarSplash() {
    // Tu código de GIF y audio no cambia
    ReproductorAudio.reproducir("/splashScreen/intro_audio.wav");
    
    // Iniciamos el Cargador de Datos pasándole el usuario
    MiCargadorDatos cargador = new MiCargadorDatos(this, this.usuarioAutenticado);
    cargador.execute();
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
public static class MiCargadorDatos extends SwingWorker<String, Void> { // Devuelve String

    private final SplashScreen pantallaSplash;
    private final usuarios usuarioFinal; // Acepta 'usuarios'

    // Constructor actualizado
    public MiCargadorDatos(SplashScreen splash, usuarios user) {
        this.pantallaSplash = splash;
        this.usuarioFinal = user;
    }

    @Override
    protected String doInBackground() throws Exception {

        System.out.println("Iniciando la carga de datos de la BD...");
        
        // --- INICIO DE LA LÓGICA DEL TEMA ---
        String ci = (usuarioFinal != null) ? usuarioFinal.getCi() : null;
        String themePreference = SettingsManager.getThemePreference(ci);
        // --- FIN DE LA LÓGICA DEL TEMA ---

        // ... (Tu código de 'setLast_session' y 'Thread.sleep' se queda igual) ...
        usuariosDAO modSql = new usuariosDAO();
        usuarios mod = new usuarios();
        Date date = new Date();
        DateFormat fechaHora = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mod.setLast_session(fechaHora.format(date));
        
        try {
            long tiempoInicio = System.currentTimeMillis();
            long tiempoFin = System.currentTimeMillis();
            long tiempoTranscurrido = tiempoFin - tiempoInicio;

            if (tiempoTranscurrido < TIEMPO_ESPERA_MS) {
                Thread.sleep(TIEMPO_ESPERA_MS - tiempoTranscurrido);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Carga de datos completada.");
        return themePreference; // Devolvemos el tema
    }

    @Override
    protected void done() {
        String theme = "default";
        try {
            theme = get(); // Obtenemos el tema ("dark" o "default")
        } catch (Exception e) {
            e.printStackTrace();
        }

        // --- INICIO DE LA LÓGICA DEL TEMA ---
        if ("dark".equals(theme)) {
            System.out.println("Aplicando Tema Oscuro guardado...");
            ThemeManager.aplicarTemaOscuro(null);
        } else {
            System.out.println("Aplicando Tema Original (predeterminado)...");
            ThemeManager.aplicarTemaOriginal(null);
        }
        // --- FIN DE LA LÓGICA DEL TEMA ---

        // Cierra el Splash
        if (pantallaSplash != null) {
            pantallaSplash.dispose();
        }
        
        // CORRECCIÓN DE SEGURIDAD:
        // Creamos 'Principal' pasándole el usuario que inició sesión
        Principal ventanaPrincipal = new Principal(this.usuarioFinal);
        
        System.out.println("Ventana principal abierta.");
        
        // Atamos el Controlador a la ventana correcta
        Controlador c = new Controlador(ventanaPrincipal);
        c.refrescarDatos();
        
        // Mostramos la ventana
        ventanaPrincipal.setVisible(true);
        ventanaPrincipal.setLocationRelativeTo(null);
        ventanaPrincipal.setExtendedState(JFrame.MAXIMIZED_BOTH);
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
