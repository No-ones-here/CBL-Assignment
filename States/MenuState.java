package States;

import Window.Images;
import Launcher.Handler;
import Entities.Background;

/**
 * Handles processes of the Main Menu of the Game.
 * 
 * @author Luis Santos
 * @id 1996544
 */
public class MenuState extends State {
    private Handler handler;
    private Images imge;
    private Background bgmimage;
    

    public MenuState(Handler handler) {
        this.imge = new Images();
        this.bgmimage = new Background(0, 0, imge.getBgm());
        this.handler = handler;
    }

    @Override
    public void tick() {
        //TODO: Add Processes.
    }

    @Override
    public void render() {
        handler.getWindow().clearFrame();
        handler.getWindow().mainMenu();
    }

    @Override
    public void start() {
        // TODO Implement Method
    }

    public Background getBackground() {
        return this.bgmimage;
    }
    
}
