package World;

import Entities.Background;
import Entities.Ground;
import Entities.Obstacle;
import Entities.Player;
import Launcher.Handler;
import ObstacleHandler.ObstacleList;
import Window.Images;

/**
 * Describes the world that the game takes place.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class World {
    private Player player;
    private Ground g1;
    private Ground g2;
    private ObstacleList obsList;
    private Obstacle nearestObstacle;
    private Background bg;
    private Images images;
    //TODO: Add Images!

    /**
     * Constructor method that initializes all instances of the entities
     * existing in the world.
     * 
     * @param handler object that allows access to variable in Game.
     */
    public World(Handler handler) {
        this.images = new Images();
        this.bg = new Background(0, 200, images.getbackground());
        this.player = new Player(50, 250, images.getpilot(), handler);
        this.g1 = new Ground(0, bg.getY() + bg.getySize(), images.getroad(), handler);
        this.g2 = new Ground(g1.getxSize(), bg.getY() + bg.getySize(), images.getroad(), handler);
        this.obsList = new ObstacleList(handler);
        
    }


    //Getters
    public Player getPlayer() {
        return player;
    }

    public Ground getG1() {
        return g1;
    }

    public Ground getG2() {
        return g2;
    }

    public Obstacle getNextObstacle() {
        return obsList.getNextObstacle();
    }

    public Background getBackground() {
        return this.bg;
    }
    
}
