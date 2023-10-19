package Launcher;

import Window.Window;
import InputHandlers.*;
import States.*;

/**
 * Handles games.
 * 
 * @author Luis Santos
 * @id 1998544
 * 
 */
public class Game {
    private int width;
    private int height;
    private String title;
    private Window window;
    private MouseHandler mH;
    private KeyHandler kH;
    private Handler handler;
    private GameState gameState;
    private MenuState menuState;
    
    
    public Game() {
        width = 900;
        height = 900 / 12 * 9;
        title = "Object-Oriented Wheelies";
        
        //GUIs
        window = new Window(width, height, title);
        mH = new MouseHandler(handler);
        kH = new KeyHandler(handler);

        //States
        gameState = new GameState();
        menuState = new MenuState();

        handler = new Handler(this);
    }

    public void run() {
        //TODO: Implement Run Method
    }

    //Getters and Setters
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getTitle() {
        return title;
    }

    public Window getWindow() {
        return window;
    }

    public MouseHandler getmH() {
        return mH;
    }

    public KeyHandler getkH() {
        return kH;
    }

    public Handler getHandler() {
        return handler;
    }

    public void setState(int st) {
        switch(st) {
            case 0:
                State.setCurrentState(menuState);
                break;
            case 1:
                State.setCurrentState(gameState);
                break;
            default:
                System.out.print("Invalid State Input");
                break;
        }
    }
}
