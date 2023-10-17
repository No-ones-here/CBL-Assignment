package Entities;

public class Player extends Entity{
    private boolean wheelieState;

    public Player() {
        super();
    }


    
    //Getters and Setters
    public boolean isWheelieState() {
        return wheelieState;
    }

    public void setWheelieState(boolean wheelieState) {
        this.wheelieState = wheelieState;
    }
    
}
