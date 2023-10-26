package Window;

import Entities.Background;
import Entities.Entity;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;

public class ImageComponent extends JComponent{
    private Entity currentEntity;
    private Background bg;

    public ImageComponent(Entity e) {
        super();
        this.currentEntity = e;
    }

    public ImageComponent(Background background) {
        super();
        this.bg = background;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        if (currentEntity == null) {
            g.drawImage(bg.getSprite().getImage(), bg.getX(), bg.getY(), null);
        } else {
            g.drawImage((Image) currentEntity.getSprite().getImage(),
                    currentEntity.getX(), currentEntity.getY(), null);
        }

        g.dispose();
    }
}
