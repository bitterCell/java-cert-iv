/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testHarnesses;

import java.sql.SQLException;
import model.GameDetails;
import model.GameSettings;
import model.UserDetails;

/**
 * 
 * @author Amos Chamberlain
 */
public class GameDetailsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, Exception {
        GameDetails gd = new GameDetails();
        System.out.println("No-arg GameDetails:\n" + gd);
        System.out.println();
        
        // Testing the setters;
        gd.setUserDetails(new UserDetails());
        gd.setGameSettings(new GameSettings());
        gd.setHighScore(200);
        gd.setScore(160);
        gd.setShipsDestroyed(20);
        gd.setShotsFired(23);
        gd.setNewHighScore(false);
        System.out.println("Setters:\n" + gd);
        System.out.println();
        
        // Testing the all-arg constructor
        UserDetails ud = new UserDetails("Username", "Password", false);
        GameSettings gs = new GameSettings(500.0, 750);
        GameDetails gd2 = new GameDetails(ud, gs);
        System.out.println("All-arg GameDetails:\n" + gd2);
        System.out.println();
        
        // Testing the getters
        System.out.println("Getters::\n UserDetails: " + gd2.getUserDetails());
        System.out.println("GameSettings: " + gd2.getGameSettings());
        System.out.println("High score: " + gd2.getHighScore());
        System.out.println("Score: " + gd2.getScore());
        System.out.println("Ships destroyed: " + gd2.getShipsDestroyed());
        System.out.println("Shots fired: " + gd2.getShotsFired());
        System.out.println("New high score: " + gd2.isNewHighScore());
        System.out.println();
        
        // Testing the equals
        GameDetails gd3 = new GameDetails(ud, gs);
        System.out.println(gd);
        System.out.println(gd2);
        System.out.println(gd3);
        System.out.println("\ngd == gd2? (false)");
        System.out.println(gd.equals(gd2));
        System.out.println("\ngd2 == gd3? (true)");
        System.out.println(gd2.equals(gd3));
    }

}
