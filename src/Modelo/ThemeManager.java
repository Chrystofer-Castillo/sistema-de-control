package Modelo;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ThemeManager {

    /**
     * ✅ ESTE ES EL MÉTODO CLAVE ✅
     * Restaura la apariencia original y personalizada de tu programa.
     * Lo hace aplicando el Look and Feel "Metal" de Java, que es el más
     * flexible y permite que tus colores y estilos personalizados se vean.
     * @param frame La ventana principal de tu aplicación.
     */
    public static void restaurarTemaOriginal(JFrame frame) {
        try {
            // UIManager.getCrossPlatformLookAndFeelClassName() carga el tema "Metal" de Java.
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            
            // Actualiza la apariencia de toda la aplicación para reflejar el cambio.
            SwingUtilities.updateComponentTreeUI(frame);
            
        } catch (Exception ex) {
            System.err.println("Error al restaurar el tema original.");
        }
    }

    /**
     * Aplica el tema oscuro de la librería FlatLaf.
     * @param frame La ventana principal de tu aplicación.
     */
    public static void aplicarTemaOscuro(JFrame frame) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception ex) {
            System.err.println("Error al aplicar el tema oscuro.");
        }
    }
    
    /**
     * Nota: Ya no necesitamos el método aplicarTemaInicial() en el 'main',
     * porque el tema inicial del programa ES tu tema original.
     */
}