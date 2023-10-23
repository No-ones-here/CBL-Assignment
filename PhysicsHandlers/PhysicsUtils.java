package PhysicsHandlers;

import Entities.Entity;

/**
 * Contains methods that handle physics events such as collisions.
 * 
 * @author Luis Santos
 * @id 1998544
 */
public class PhysicsUtils {
    public static final int GRAVITY = 10;
    
    public PhysicsUtils() {
        
    }

    /**
     * Checks for collisions between a moving and static entity along the x axis.
     * 
     * @param movingEntity object that is moving
     * @param staticEntity object that may be collided into
     * @return whether a collision has occurred or not.
     */
    public boolean checkCollisionX(Entity movingEntity, Entity staticEntity) {
        if (((staticEntity.getX() 
            - (movingEntity.getX() + movingEntity.getxSize() + movingEntity.getXStepSize())) < 0) 
            || (((staticEntity.getX() + staticEntity.getxSize()) 
            - (movingEntity.getX() + movingEntity.getXStepSize())) < 0)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Checks for collisions between a moving and a static entity along the y axis.
     * 
     * @param movingEntity object that is moving
     * @param staticEntity object that may be collided into
     * @return whether a collision has occurred or not.
     */
    public boolean checkCollisionY(Entity movingEntity, Entity staticEntity) {
        if (staticEntity.getY() - (movingEntity.getY() + movingEntity.getySize() + movingEntity.getYStepSize()) < 0) {         //Check approach from top     
            return true;
        } else if ((staticEntity.getY() + staticEntity.getySize()) - (movingEntity.getY() + movingEntity.getYStepSize()) < 0) {    //Check approach from bottom
            return true;
        } else {
            return false;
        }
    }
}
