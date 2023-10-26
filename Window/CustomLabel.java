package Window;

import java.awt.Graphics;
import javax.swing.JLabel;

public class CustomLabel extends JLabel{
    private int x;
    private int y;

    public CustomLabel(int x, int y, String text) {
        super(text);
        this.x = x;
        this.y = y;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString(super.getText(), x, y);
        g.dispose();
    }
}
