package model;

import dao.GameDetailsDAOText;
import java.io.Serializable;
import java.sql.SQLException;

/**
 * <p>
 * The details for one game, including the user playing, the game settings the scoring (shots fired, ships destroyed,
 * score and previous high score)
 * </p>
 * <p>
 * Company: TAFE SA</p>
 *
 * @author Santi Ruiz
 * @author Julie Ruiz 
 * @author Amos Chamberlain
 * @version 1.0 Initial version
 * @version 2.0 Updated to improve setting of highscore
 */
public class GameDetails implements Serializable {

    //constants
    public static final int POINTS_GAINED_FOR_SHIP_DESTROYED = 100;
    public static final int POINTS_LOST_FOR_WASTED_SHOT = 50;

    //instance variables
    private UserDetails userDetails;
    private GameSettings gameSettings;
    private int highScore;
    private int score;
    private int shipsDestroyed;
    private int shotsFired;
    private boolean newHighScore;

    //only 2 constructors required
 
    //no arg constructor
    public GameDetails() throws Exception {
        this(new UserDetails(), new GameSettings());
    }

    //all args constructor
    public GameDetails(UserDetails user, GameSettings gameSettings) throws Exception {
        this.userDetails = user;
        this.gameSettings = gameSettings;
        //TODO
        resetTheScoringDetails();
    }

    //Getters and Setters

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public GameSettings getGameSettings() {
        return gameSettings;
    }

    public void setGameSettings(GameSettings gameSettings) {
        this.gameSettings = gameSettings;
    }

    public int getHighScore() {
        return highScore;
    }

    public void setHighScore(int highScore) {
        this.highScore = highScore;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getShipsDestroyed() {
        return shipsDestroyed;
    }

    public void setShipsDestroyed(int shipsDestroyed) {
        this.shipsDestroyed = shipsDestroyed;
    }

    public int getShotsFired() {
        return shotsFired;
    }

    public void setShotsFired(int shotsFired) {
        this.shotsFired = shotsFired;
    }

    public boolean isNewHighScore() {
        return newHighScore;
    }

    public void setNewHighScore(boolean newHighScore) {
        this.newHighScore = newHighScore;
    }
    
    
    
    //toString method
    @Override
    //TODO
    public String toString() {
        StringBuilder inStringBuilder = new StringBuilder();
        inStringBuilder.append(super.toString());
        inStringBuilder.append(" = [userDetails:");
        inStringBuilder.append(this.userDetails);
        inStringBuilder.append(",\n[gameSettings:");
        inStringBuilder.append(this.gameSettings);
        inStringBuilder.append(",\n[highScore:");
        inStringBuilder.append(this.highScore);
        inStringBuilder.append(", [score:");
        inStringBuilder.append(this.score);
        inStringBuilder.append(", [shipsDestroyed:");
        inStringBuilder.append(this.shipsDestroyed);
        inStringBuilder.append(", [shotsFired:");
        inStringBuilder.append(this.shotsFired);
        inStringBuilder.append(", [newHighScore:");
        inStringBuilder.append(this.newHighScore);
        inStringBuilder.append("]");
        return inStringBuilder.toString();
    }

 
    //equals method
    @Override
    public boolean equals(Object obj) {
        //objects are equal if equal userDetails and gameSettings objects
        if ((obj instanceof GameDetails)) {
            return false;
        }
        
        boolean result = false;
        GameDetails gameDetails = (GameDetails) obj;
        
        result = gameDetails.getUserDetails().equals(this.userDetails) && gameDetails.getGameSettings().equals(this.gameSettings);
        
        return result;
    }


    public int calculateScoreChanges() {

        //missedShots = shotsFired - shipsDestroyed
        int missedShots = this.shotsFired - this.shipsDestroyed;

        //currentScore = shipsDestroyed*POINTS - missedShots*POINTS
        int currentScore = (this.shipsDestroyed * POINTS_GAINED_FOR_SHIP_DESTROYED)
            - (missedShots * POINTS_LOST_FOR_WASTED_SHOT);

        //set score to currentScore
        this.score = currentScore;

        // check if it's a new high score
        if (this.score > this.highScore) {
            newHighScore = true;
            this.highScore = this.score;
        } else {
            newHighScore = false;
        }

        //return currentScore, set to 0 if currentScore negative
        if (currentScore < 0) {
            currentScore = 0;
        }
        return currentScore;
    }

    public final void resetTheScoringDetails() throws Exception {
		GameDetailsDAOText.saveHighScore(this);
        //reset newHighScore flag
        newHighScore = false;

        // reset score, shipsDestroyed, shotsFired to 0
        this.score = 0;
        this.shipsDestroyed = 0;
        this.shotsFired = 0;

        //Load the previous high score for this user for these settings
        //If there is an error then set highscore to 0 and continue
        try {
            GameDetailsDAOText.loadHighScore(this);
        } catch (Exception ex) {
            this.highScore = 0;
        }
    }

 
    public void saveData() throws Exception {
        GameDetailsDAOText.saveData(this);
    }

 
    public void loadData() throws Exception {
        GameDetailsDAOText.loadData(this);
    }
}
