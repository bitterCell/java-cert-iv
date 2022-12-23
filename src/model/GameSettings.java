package model;

import dao.GameSettingsDAOText;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * <p>
 * Title: GameSettings</p>
 * <p>
 * Description: This describes the move speed and firing interval of the player during the game.</p>
 * <p>
 * Copyright: Copyright (c) 2005</p>
 * <p>
 * Company: TAFE SA</p>
 *
 * @author Santi Ruiz
 * @author Julie Ruiz
 * @author Amos Chamberlain
 * @version 1.0
 */
public class GameSettings implements Serializable {
    public static final double MOVE_SPEED = 300.0;
    public static final int FIRING_INTERVAL = 700;
    
    /**
     * Move speed of the player
     */
    private double moveSpeed;
    /**
     * Firing speed of the player
     */
    private int firingInterval;

    /*
     * ************************* constructors *********************************
     */
    public GameSettings() {
        this(MOVE_SPEED, FIRING_INTERVAL);
    }

    /**
     * Construct the game settings based on the move speed and firing interval of the player.
     * @param moveSpeed double
     * @param firingInterval int
     */
    public GameSettings(double moveSpeed, int firingInterval) {
        this.moveSpeed = moveSpeed;
        this.firingInterval = firingInterval;
    }

    /**
     * Get the move speed.
     * @return moveSpeed
     */
    public double getMoveSpeed() {
        return moveSpeed;
    }

    /**
     * Sets the move speed.
     * @param moveSpeed double
     */
    public void setMoveSpeed(double moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    /**
     * Gets the firing interval
     * @return firingInterval
     */
    public int getFiringInterval() {
        return firingInterval;
    }

    /**
     * Sets the firing interval
     * @param firingInterval int
     */
    public void setFiringInterval(int firingInterval) {
        this.firingInterval = firingInterval;
    }
    
    /*
     * ************************* Usual Overrides*******************************
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof GameSettings)) {
            return false;
        }
        
        GameSettings gameSettings = (GameSettings) o;
        return gameSettings.getMoveSpeed() == this.getMoveSpeed()
            && gameSettings.getFiringInterval() == this.getFiringInterval();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" = [moveSpeed:");
        sb.append(this.moveSpeed);
        sb.append(", firingInterval:");
        sb.append(this.firingInterval);
        sb.append("]");
        return sb.toString();
    }
 
    public void saveData(UserDetails user) throws Exception {
        GameSettingsDAOText.saveData(user, this);
    }

    public void loadData(UserDetails user) throws Exception {
        GameSettingsDAOText.loadData(user, this);
    }
}
