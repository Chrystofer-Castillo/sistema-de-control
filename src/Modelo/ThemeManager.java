package Modelo;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class ThemeManager {
    public static void restaurarTemaOriginal(JFrame frame) {
        try {
            UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
            
            SwingUtilities.updateComponentTreeUI(frame);
            
        } catch (Exception ex) {
            System.err.println("Error al restaurar el tema original.");
        }
    }

    public static void aplicarTemaOscuro(JFrame frame) {
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
            SwingUtilities.updateComponentTreeUI(frame);
        } catch (Exception ex) {
            System.err.println("Error al aplicar el tema oscuro.");
        }
    }
    
}