package model;

/**
 * <p>
 * Title: Collection of Entity objects</p>
 * <p>
 * Description: Organises for a collection of entities that we want to treat as a group. Acts as a farcade for the
 * collection of entities but adds functionality applicable to all entities in the list, such as Move</p>
 * <p>
 * Copyright: Copyright (c) 2004</p>
 * <p>
 * Company: TAFE SA</p>
 *
 * @author Santi Ruiz
 * @author Julie Ruiz
 * @author Amos Chamberlain
 * @version 1.0 - Initial Version
 * @version 2.0 - Changed collision checking to use new version of Entity Collision check
 */
import java.awt.Graphics2D;
import java.util.Set;
import model.events.EntityDiedEvent;
import model.events.EntityEventListener;
import model.events.EntityHitEvent;
import model.events.EntityMoveEvent;

/**
 *
 * @author sruiz
 */
public class EntityListArray implements EntityListInterface, EntityEventListener {

    //set constant MAX_SIZE 100
    public static final int MAX_SIZE = 100;

    /**
     * The entities in the array. Make it protected to allow sub-classes access but noone else.
     */
    protected Entity[] entities;
    /**
     * The entities to be removed on next game cycle
     */
    protected Entity[] removeEntities;

    protected int numEntities;
    protected int numRemoveEntities;

    /**
     * Sets up the array entities and removeEntities of MAX_SIZE set numEntires to 0
     *
     * @param entities
     * @param removeEntities
     */
    public EntityListArray() {
        this.entities = new Entity[MAX_SIZE];
        this.removeEntities = new Entity[MAX_SIZE];
        
        this.numEntities = 0;
    }

    /**
     * Clear the array by creating a new array of entities and removeEntities
     */
    @Override
    public void clear() {
        this.entities = new Entity[MAX_SIZE];
        this.removeEntities = new Entity[MAX_SIZE];
        
        this.numEntities = 0;
        this.numRemoveEntities = 0;
    }

    /**
     * Add an entity
     *
     * @param e the entity to be added to the array increase the number of entities
     */
    @Override
    public void add(Entity e) {
        if (this.numEntities < this.MAX_SIZE) {
            this.entities[numEntities] = e;
        numEntities++;
        // We make sure the array gets told about events on each of its entities
        
        e.addEntityEventListener(this);
        }
    }

    /**
     * Increase the speed of all members of the array by a certain percentage
     *
     * @param percentIncr as whole number
     */
    @Override
    public void increaseSpeed(int percentIncr) {
        //loop through each entity in the array entities and
        //Increase the speed of all members of the array by a certain percentage
        //using setHorizontalMovement and setVerticalMovement
        
        for (int i = 0; i < this.numEntities; i++) {
            this.entities[i].setHorizontalMovement(this.entities[i].getHorizontalMovement()
                + this.entities[i].getHorizontalMovement() * (percentIncr / 100));
            this.entities[i].setVerticalMovement(this.entities[i].getVerticalMovement()
                + this.entities[i].getVerticalMovement() * (percentIncr / 100));
        }
    }

    /**
     * Move all entities in the array according to time passed delta using updateState
     *
     * @param delta Time passed since last updateState (ms)
     */
    @Override
    public void updateState(long delta) {
        //loop through each entity in the array entities and updateState
        for (int i = 0; i < this.numEntities; i++) {
            this.entities[i].updateState(delta);
        }

        // If after all the moving (for whatever reason) the entity needs to be
        // removed from the array then it would have been added to the removeEntities array and now
        // need to be removed.
        // Loop through each entity in the removeEntities array and remove the entity from the current
        // EntitListArray object by calling this.remove
        
        for (int i = 0; i < this.numRemoveEntities; i++) {
            this.remove(this.removeEntities[i]);
        }
        // clear the removeEntities array by creating a new array of removeEntities
        this.removeEntities = new Entity[MAX_SIZE];
        this.numRemoveEntities = 0;
    }

    /**
     * draw all entities in the array using draw
     *
     * @param g The graphics context to draw to
     */
    @Override
    public void draw(Graphics2D g) {
        //loop through each entity in the array entities and draw
        
        for (int i = 0; i < this.numEntities; i++) {
            this.entities[i].draw(g);
        }

    }

    /**
     *
     * @param delta Time passed since last updateState (ms)
     * @param g The graphics context to draw to
     */
    @Override
    public void moveAndDraw(long delta, Graphics2D g) {
        //loop through each entity in the array entities and updateState and draw
        
        for (int i = 0; i < this.numEntities; i++) {
            this.entities[i].updateState(delta);
            this.entities[i].draw(g);
        }
    }

    /**
     * Check if this entity collides with any entity in this entity array.
     *
     * @param other The entity to check collision against
     * @return null if there is no collision, return the entity if there is a collision
     */
    @Override
    public Entity collidesWith(Entity other) {

        //loop through each entity in the array entities
        //if one of the entities in the list collides with the entity 'other'
        //return the entity it collides with.
        //Note: need to make use of the Entity class collidesWith method
//        for (Entity e : this.entities) {
//            if (other.collidesWith(e)) {
//                return e;
//            }
//        }

        for (int i = 0; i < this.numEntities; i++) {
            if (this.entities[i].collidesWith(other)) {
                return this.entities[i];
            }
        }
        return null;
    }

    /**
     * Manage event listener registration
     *
     * @param l the listener to add
     */
    @Override
    public void addEntityEventListener(EntityEventListener l) {

        //loop through each entity in the array entities and addEntityEventListener l        
        for (int i = 0; i < this.numEntities; i++) {
            this.entities[i].addEntityEventListener(l);
        }
    }

    /**
     * Remove an entity from the array
     *
     * @param e The entity to remove
     */
    @Override
    public void remove(Entity e) { // D
        //create a newArray of Entity
        Entity[] newArray = new Entity[MAX_SIZE];
        //count the numNewEntries
        int newNumEntities = 0;

        //The approach is to create a new array with all the entitiies from the existing array except for the one
        //that we want to remove (e). Once this new array is created then we replace the old array with the new one.
        //Hence we have a new version with e removed.
        //loop through each entity in the array entities
        //if the entity is not equal to e then add the entity to the newArray
        //and increment numNewEntries
        
//        for (Entity i : this.entities) {
//            // 何か？？？これは何ですか？？？
//            if (i == null) {
//                break;
//            }
//            if (!e.equals(i)) {
//                newArray[newNumEntities] = i;
//                System.out.println();
//                System.out.println("newArray[" + newNumEntities + "] = " + i);
//            newNumEntities++;
//            }
//        }
        
        
        for (int i = 0; i < this.numEntities; i++) {
            if (!this.entities[i].equals(e)) {
                newArray[newNumEntities] = this.entities[i];
                newNumEntities++;
            }
        }
        //set the entities array to the newArray
        //set numEntities to newNumEntities
        this.entities = newArray;
        this.numEntities = newNumEntities;
    }

    /**
     * Number of entities
     *
     * @return numEntities
     */
    @Override
    public int getNumEntities() {

        return numEntities;
    }

    /**
     * if there are no entities in the list return null return one of the entities in the array - choosing it randomly
     *
     * @return Entity
     */
    @Override
    public Entity getRandom() {

        //if there are no entities in the list return null
        if (this.entities[0] == null) {
            return null;
        } //generate a random integer by rounding Math.random() * (this.numEntities - 1)
        else {
            double random = Math.random() * (this.numEntities - 1);
            int index = (int) random;
            return this.entities[index];
        }

    }

    /*
        Registers an entity for removal next time the state of the list is updated
     */
    public void registerEntityForRemoval(Entity e) {
        removeEntities[numRemoveEntities] = e;
        numRemoveEntities++;
    }

    // Entity Event Handling Methods
    // By default no Action is taken by the array for entity events
    @Override
    public void collisionHasOccured(EntityHitEvent e) {
    }

    @Override
    public void entityMoved(EntityMoveEvent e) {
    }

    @Override
    public void entityDied(EntityDiedEvent e) {
        this.remove((Entity) e.getSource());
    }

    @Override
    public String toString() {
        String result = "";
        result = super.toString() + ", NumEntities = " + this.numEntities + ", NumRemoveEntities = " + this.numRemoveEntities;
        result = result + "\nEntites:";
        for (int i = 0; i < numEntities; i++) {
            result = result + "\n" + this.entities[i];
        }
        result = result + "\nRemoveEntities:";
        for (int i = 0; i < numRemoveEntities; i++) {
            result = result + "\n" + this.removeEntities[i];
        }
        return result;
    }
}
