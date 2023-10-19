package Launcher;
import Window.*;
import InputHandlers.*;

/**
 * Handler through which objects in the Game class are accessed by other classes.
 * 
 * @author Luis Santos
 * @id 1998544
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
}
