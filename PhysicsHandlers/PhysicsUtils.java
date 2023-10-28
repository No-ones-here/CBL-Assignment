package PhysicsHandlers;

import Entities.Entity;

/**
 * Contains methods that handle physics events such as collisions.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class PhysicsUtils {
    public static final int GRAVITY = 1;
    
    public PhysicsUtils() {
        
    }

    /**
     * Checks for collisions between a moving and static entity along the x axis.
     * 
     * @param e1 object that is moving
     * @param e2 object that may be collided into
     * @return whether a collision has occurred or not.
     */
    public boolean checkCollisionX(Entity e1, Entity e2) {
        int e1X = e1.getX();
        int e1XSize = e1.getxSize();
        int e1XStep = e1.getXStepSize();

        int e2X = e2.getX();
        int e2XSize = e2.getxSize();
        int e2XStep = e2.getXStepSize();

        if (e1XStep > 0) {                        //Moving Right
            return e1X + e1XSize + e1XStep >= e2X + e2XStep
                    && e1X + e1XSize + e1XStep <= e2X + e2XSize + e2XStep;
        } else if (e1XStep < 0) {                 //Moving Left
            return e1X + e1XStep <= e2X + e2XSize + e2XStep
                    && e1X + e1XStep >= e2X + e2XStep;
        }

        return false;
    }

    /**
     * Checks for collisions between a moving and a static entity along the y axis.
     * 
     * @param e1 moving entity
     * @param e2 another entity
     * @return whether a collision has occurred or not.
     */
    public boolean checkCollisionY(Entity e1, Entity e2) {
        int e1Y = e1.getY();
        int e1YSize = e1.getySize();
        int e1YStep = e1.getYStepSize();

        int e2Y = e2.getY();
        int e2YSize = e2.getySize();
        int e2YStep = e2.getYStepSize();

        if (e1YStep >= 0) {  // E1 moving down
            return e1Y + e1YSize + e1YStep >= e2Y + e2YStep
                    && e1Y + e1YSize + e1YStep <= e2Y + e2YSize + e2YStep;
        } else if (e1YStep < 0) { // E1 Moving up
            return e1Y + e1YStep <= e2Y + e2YSize + e2YStep
                    && e1Y + e1YStep >= e2Y + e2YStep;
        }

        return false;
    }

    /**
     * Collision Detection for Gravity related movement.
     * @param e moving entity 
     * @param groundLevel height of the ground from top left corner of the screen
     * @return boolean of whether a collision occurred
     */
    public boolean checkCollisionY(Entity e, int groundLevel) {
        if (e.getYStepSize() >= 0) {  //Moving down
            return (groundLevel - (e.getY() + e.getySize() 
                    + e.getYStepSize())) <= 0;
        }
        return false;
    }

    /**
     * Checks whether the entity will hit the jump ceiling.
     * 
     * @param e entity moving up
     * @param jumpCeiling y coordinate of the jump ceiling
     * @return boolean whether the entity hit the jump ceiling
     */
    public boolean checkJumpCollision(Entity e, int jumpCeiling) {
        if (e.getYStepSize() <= 0) {  //Moving up
            return (e.getY() + e.getYStepSize()) <= jumpCeiling;
        }
        return false;
    }
}
