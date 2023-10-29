package States;

/**
 * Abstract representation of a State of the game.
 * @author Daniele Guggino
 * @id 1933620
 * 
 * @author Luis Santos
 * @id 1998544
 * 
 * @date 29/10/2023
 */
public abstract class State {
    private static State currentState = null;

    public static State getCurrentState() {
        return currentState;
    }
    
    public static void setCurrentState(State state) {
        currentState = state;
    }

    //Abstract Methods
    public abstract void tick();
    
    public abstract void render();

    public abstract void start();
}
