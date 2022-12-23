
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testHarnesses;

import model.GameSettings;

/**
 * 
 * @author Amos Chamberlain
 */
public class GameSettingsTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Testing the no-arg constructor
        GameSettings gs = new GameSettings();
        System.out.println("No-arg GameSettings:\n" + gs);
        System.out.println();
        
        // Testing the setters
        gs.setMoveSpeed(333.33);
        gs.setFiringInterval(650);
        System.out.println("Setters:\n" + gs);
        System.out.println();
        
        // Testing the all-arg constructor
        GameSettings gs2 = new GameSettings(500.0, 750);
        System.out.println("All-arg GameSettings:\n" + gs2);
        System.out.println();
        // Testing the getters
        System.out.println("Getters:\n" + gs2.getMoveSpeed());
        System.out.println(gs2.getFiringInterval());
        System.out.println();
        
        // Testing the equals
        GameSettings gs3 = new GameSettings(gs.getMoveSpeed(), gs.getFiringInterval());
        System.out.println(gs);
        System.out.println(gs2);
        System.out.println(gs3);
        System.out.println("\ngs == gs2?");
        System.out.println(gs.equals(gs2));
        System.out.println("\ngs == gs3?");
        System.out.println(gs.equals(gs3));
    }

}
