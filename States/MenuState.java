package States;

import Entities.Background;
import Launcher.Handler;
import Window.Images;


/**
 * Handles processes of the Main Menu of the Game.
 * @author Daniele Guggino
 * @id 1933620
 * 
 * @author Luis Santos
 * @id 1996544
 * 
 * @date 29/10/2023
 */
public class MenuState extends State {
    private Handler handler;
    private Images imge;
    private Background bgmimage;
    
    /**
     * Constructor method to initialize imge and handler.
     * @param handler handler instance
     */
    public MenuState(Handler handler) {
        this.imge = new Images();
        this.bgmimage = new Background(0, 0, imge.getBgm());
        this.handler = handler;
    }

    @Override
    public void tick() {
        // Abstract method not required.
    }

    @Override
    public void render() {
        handler.getWindow().clearFrame();
        handler.getWindow().mainMenu();
    }

    @Override
    public void start() {
        // Abstract method not required.
    }

    public Background getBackground() {
        return this.bgmimage;
    }
    
}
