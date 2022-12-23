/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testHarnesses;

import model.BorderEntity;

public class BorderEntityTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // No-arg constructor
        BorderEntity be = new BorderEntity();
        System.out.println("No-arg BorderEntity:\n" + be);
        System.out.println();
        
        // Testing the setters
        be.setHeight(150);
        be.setWidth(100);
        be.setId("Corner");
        System.out.println("Setters:\n" + be);
        System.out.println();
        
        // All-arg Constructor
        BorderEntity be2 = new BorderEntity("SH173", 50, -50, 200, 200);
        System.out.println("All-arg BorderEntity:\n" + be2);
        
        // Testing the getters
        System.out.println("Getters:\n Height: " + be2.getHeight());
        System.out.println("Width: " + be2.getWidth());
        System.out.println("ID: " + be2.getId());
        
        // Testing the last two constructors
        BorderEntity be3 = new BorderEntity("CYN155", 175, 125);
        System.out.println("ID, Width, Height:\n" + be3);
        System.out.println();
        BorderEntity be4 = new BorderEntity(0, 0, 200, 250);
        System.out.println("X, Y, Width, Height:\n" + be4);
    }

}
