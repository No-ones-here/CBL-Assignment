package InputHandlers;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import Launcher.Handler;

public class KeyHandler implements KeyListener{

    Handler handler;
    
    public KeyHandler(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 87) {
            
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
}