package Launcher;
import Window.*;
import InputHandlers.*;

public class Handler {
    private static Game game;

    public Handler(Game g) {
        this.game = g;
    } 

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
}
