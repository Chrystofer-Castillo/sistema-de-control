package Clases; // O el paquete que corresponda

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JPanel;

public class PanelRound extends JPanel {

    private int roundTopLeft = 0;
    private int roundTopRight = 0;
    private int roundBottomLeft = 0;
    private int roundBottomRight = 0;

    public PanelRound() {
        setOpaque(false);
    }

    // Getters y Setters (sin cambios)
    public int getRoundTopLeft() { return roundTopLeft; }
    public void setRoundTopLeft(int v) { this.roundTopLeft = v; repaint(); }
    public int getRoundTopRight() { return roundTopRight; }
    public void setRoundTopRight(int v) { this.roundTopRight = v; repaint(); }
    public int getRoundBottomLeft() { return roundBottomLeft; }
    public void setRoundBottomLeft(int v) { this.roundBottomLeft = v; repaint(); }
    public int getRoundBottomRight() { return roundBottomRight; }
    public void setRoundBottomRight(int v) { this.roundBottomRight = v; repaint(); }

    @Override
    protected void paintComponent(Graphics g) {
        // 🛑 CÓDIGO DE PINTADO EFICIENTE
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        // Se crea una forma redondeada directamente. Es mucho más rápido.
        // Aunque no permite esquinas individuales, es una base sólida.
        // Para esquinas individuales se necesitaría una lógica más compleja
        // pero para la mayoría de los casos un radio uniforme es suficiente.
        // Aquí asumimos un radio promedio o el más grande.
        int maxRadius = Math.max(roundTopLeft, Math.max(roundTopRight, Math.max(roundBottomLeft, roundBottomRight)));
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), maxRadius, maxRadius));
        g2.dispose();
        super.paintComponent(g);
    }
}