package InputHandlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Handles Keyboard Inputs in the game.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class KeyHandler implements KeyListener{
    //TODO: Implement Unimplemented Abstract Methods.
    private boolean[] keys;
    private boolean jump;
    private boolean wheelie;
    
    public KeyHandler() {
        keys = new boolean[256];
    }

    public void tick() {
            jump = keys[KeyEvent.VK_SPACE];
            wheelie = keys[KeyEvent.VK_W];
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        keys[e.getKeyCode()] = true;
        //TODO: TEMPORARY CODE///////////////
        System.out.println("Pressed");
        ////////////////////////////////////
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