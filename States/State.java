package States;

public abstract class State {
    private static State currentState = null;
    public static State getCurrentState() {
        return currentState;
    }
    public static void setCurrentState(State state) {
        currentState = state;
    }

    //Abstract Methods
    public abstract void run();
}
