package model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * Entity of the game which is a Border. Borders will have IDs so that we can query which border we are working with
 * Extends Entity class with width, height and border id
 *
 * @author sruiz
 * @author jruiz
 * ADD YOUR NAME HERE
 * @version 1.0 initial version
 * @version 2.0 updated to get better consistency in the order of parameters
 *
 */
public class BorderEntity extends Entity {

    //constants
    public static final int DEFAULT_WIDTH = 0;
    public static final int DEFAULT_HEIGHT = 0;
    public static final String DEFAULT_ID = "None";

    //instance variables
    private int width;
    private int height;
    private String id;

    //no args constructors
    public BorderEntity() {
        //TODO

    }

    public BorderEntity(String id, int width, int height) {
        //TODO

    }

    public BorderEntity(int initalXPos, int initialYPos, int width, int height) {
        //TODO

    }

    //all args constructor
    public BorderEntity(String id, int initalXPos, int initialYPos, int width, int height) {
        //TODO

    }

    //Getters and Setters
    //TODO
    //toString (no equals)
    @Override
    public String toString() {
        //TODO
        StringBuilder toStringBuilder = new StringBuilder();

        return toStringBuilder.toString();
    }

    /**
     * Define the area of the Entity to use for collision detection. This default uses the location and size of sprite.
     *
     * @return the Rectangle this border covers
     */
    @Override
    protected Rectangle collisionArea() {
        return new Rectangle(this.getX(), this.getY(), this.width, this.height);
    }

    @Override
    public void draw(Graphics g) {

        g.setColor(Color.red);
        g.fillRect(this.getX(), this.getY(), width, height);
        g.drawRect(this.getX(), this.getY(), width, height);
    }

}
