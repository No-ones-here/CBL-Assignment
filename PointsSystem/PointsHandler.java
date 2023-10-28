package PointsSystem;

/**
 * Class that handles the way the points increment during Gameplay.
 * 
 * @author Luis Santos
 * @id 1998544
 * 
 */
public class PointsHandler {
    private int points;

    public PointsHandler() {
        points = 0;
    }

    public void tick() {
        points++;
    }

    //Getters
    public int getPoints() {
        return this.points;
    }
}
