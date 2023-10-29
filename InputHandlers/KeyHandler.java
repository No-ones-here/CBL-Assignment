package InputHandlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Handles Keyboard Inputs in the game.
 * @author Daniele Guggino
 * @id 1933620
 * 
 * @author Luis Santos
 * @id 1998544
 * 
 * @date 29/10/2023
 */
public class KeyHandler implements KeyListener {
    private boolean[] keys;
    private boolean jump;
    private boolean wheelie;
    
    public KeyHandler() {
        keys = new boolean[256];
    }

    /**
     * Code that is run everytime the game ticks.
     * Updates the necessary variables per tick.
     */
    public void tick() {
        jump = keys[KeyEvent.VK_SPACE];
        wheelie = keys[KeyEvent.VK_W];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Implemented Abstract Method Unnecessary.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        keys[e.getKeyCode()] = false;
    }

    //Getters
    public boolean getJump() {
        return this.jump;
    }
    
    public boolean getWheelie() {
        return this.wheelie;
    }
}