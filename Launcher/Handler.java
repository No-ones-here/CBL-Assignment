package Launcher;

import Entities.Background;
import InputHandlers.KeyHandler;
import InputHandlers.MouseHandler;
import PointsSystem.PointsHandler;
import Window.Window;
import World.World;

/**
 * Handler through which objects in the Game class are accessed by other classes.
 * @author Daniele Guggino
 * @id 1933620
 * 
 * @author Luis Santos
 * @id 1998544
 * 
 * @date 29/10/2023
 */
public class Handler {
    private static Game game;

    public Handler(Game g) {
        game = g;
    } 

    //Getters and Setters
    public int getWidth() {
        return game.getWidth();
    }

    public int getHeight() {
        return game.getHeight();
    }

    public Window getWindow() {
        return game.getWindow();
    }

    public KeyHandler getKeyHandler() {
        return game.getkH();
    }

    public MouseHandler getMouseHandler() {
        return game.getmH();
    }

    public void setState(int i) {
        game.setState(i);
    }

    public World getWorld() {
        return game.getWorld();
    }

    public PointsHandler getPointsHandler() {
        return game.getPointsHandler();
    }

    public void setWorld(World world) {
        game.setWorld(world);
    }

    public boolean getPlaying() {
        return game.getPlaying();
    }

    public void setPlaying(boolean playing) {
        game.setPlaying(playing);
    }

    public Background getBackground() {
        return game.getBackground();
    }
}
