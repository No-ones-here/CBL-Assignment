package Launcher;

import InputHandlers.KeyHandler;
import InputHandlers.MouseHandler;
import States.GameState;
import States.MenuState;
import States.State;
import Window.Window;
import World.World;
import java.awt.Toolkit;

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
    private World world;
    private Handler handler;
    private GameState gameState;
    private MenuState menuState;
    private boolean running;
    
    /**
     * Constructor method that initializes all objects to be used in the game.
     */
    public Game() {
        title = "Wheelie it Up!";
        width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();

        //Handler
        handler = new Handler(this);

        //GUIs
        window = new Window(width, height, title);
        mH = new MouseHandler(handler);
        kH = new KeyHandler();

        window.addKeyListener(kH);

        //States
        gameState = new GameState(handler);
        menuState = new MenuState(handler);
        
        //Set Handler in Window
        window.setHandler(handler);
    }

    public void run() {

        if (State.getCurrentState() == null) {
            State.setCurrentState(gameState);
        }
        
        State.getCurrentState().start();

        State.getCurrentState().render();

        double delta = 0;
        int fps = 30;
        double timePerTick = 1000000000 / fps;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;
        running = true;

        while (running) {

            now = System.nanoTime();
            delta += (now - lastTime) / timePerTick;
            timer += (now - lastTime);
            lastTime = now;

            if (delta >= 1) {
                tick();
                ticks++;
                delta--;
            }

            if (timer >= 1000000000) {
                System.out.println("Ticks: " + ticks);
                ticks = 0;
                timer = 0;
            }

        }
        
    }
        

    private void tick() {
        kH.tick();

        if (State.getCurrentState() == gameState) {
            gameState.tick();
            if (!getPlaying()) {
                State.setCurrentState(menuState);
            }
        } else if (State.getCurrentState() == menuState) { 
            menuState.tick();
        }
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

    public World getWorld() {
        return this.world;
    }

    public void setWorld(World world) {
        this.world = world;
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

    public boolean getPlaying() {
        return gameState.getPlaying();
    }

    public void setPlaying(boolean playing) {
        this.gameState.setPlaying(playing);
    }

    /**
     * Method that allows other classes to change the current state of the Game.
     * @param st integer that represents a state of the Game.
     */
    public void setState(int st) {
        if (st == 0) {
            State.setCurrentState(menuState);
        } else if (st == 1) {
            State.setCurrentState(gameState);
        } else {
            System.out.print("Invalid State Input");
        }
    }
}
