package PointsSystem;

import Launcher.Handler;

/**
 * Class that handles the way the points increment during Gameplay.
 * 
 * @author Luis Santos
 * @id 1998544
 * 
 */
public class PointsHandler {
    private int points;
    private int pointMultiplier;
    private Handler handler;
    private int counter;

    /**
     * Constructor that initialises the variables of the class.
     * 
     * @param handler object that allows access to variable in Game class
     */
    public PointsHandler(Handler handler) {
        this.handler = handler;
        counter = 0;
        points = 0;
    }

    /**
     * Code that is to be run per tick in the Game class.
     */
    public void tick() {
        if (handler.getWorld().getPlayer().isWheelieState()) {
            counter++;
        } else {
            counter = 0;
        }

        if (counter >= 600 && handler.getWorld().getPlayer().isWheelieState()) {
            pointMultiplier = 5;
            points += 5;
        } else if (counter >= 300 && handler.getWorld().getPlayer().isWheelieState()) {
            pointMultiplier = 4;
            points += 4;
        } else if (counter >= 150 && handler.getWorld().getPlayer().isWheelieState()) {
            pointMultiplier = 3;
            points += 3; 
        } else if (counter >= 100 && handler.getWorld().getPlayer().isWheelieState()) {
            pointMultiplier = 2;
            points += 2;
        } else {
            pointMultiplier = 1;
            points++;
        }
    }

    //Getters
    public int getPoints() {
        return this.points;
    }

    public int getPointMultiplier() {
        return this.pointMultiplier;
    }
}
