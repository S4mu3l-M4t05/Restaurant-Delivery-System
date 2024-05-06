package deliverySystem.models;
import javax.swing.*;
import java.awt.*;

public class RoundPanel extends JPanel {
    private int radius;

    public RoundPanel(int radius) {
        super();
        this.radius = radius;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.white);
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
    }

    @Override
    protected void paintBorder(Graphics g) {
        g.setColor(Color.white);
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, radius, radius);
    }
}
