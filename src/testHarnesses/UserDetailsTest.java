package testHarnesses;

import model.UserDetails;

/**
 * 
 * @author Amos Chamberlain
 */
public class UserDetailsTest {

    public static void main(String[] args) {
        // Testing no-arg constructor
        UserDetails ud = new UserDetails();
        System.out.println("No-arg UserDetails:\n" + ud);
        System.out.println();
        
        // Testing setters
        ud.setUserName("Serialain");
        ud.setPassword("Password123");
        ud.setWantingIntroInfo(true);
        System.out.println("Setters:\n" + ud);
        System.out.println();
        
        // Testing all-arg constructor
        UserDetails ud2 = new UserDetails("Username", "Safe_Password", false);
        System.out.println("All-arg UserDetails:\n" + ud2);
        System.out.println();
        // Testing getters
        System.out.println("Getters:\n" + ud2.getUserName());
        System.out.println(ud2.getPassword());
        System.out.println(ud2.isWantingIntroInfo());
        System.out.println();
        
        // Testing userName + password constructor
        UserDetails ud3 = new UserDetails("Serialain", "CorrectHorseBatteryStaple");
        System.out.println("Semi-arg UserDetails:\n" + ud3);
        System.out.println();
        
        // Testing userName constructor
        UserDetails ud4 = new UserDetails("userName");
        System.out.println("Single-arg constructor:\n" + ud4);
        System.out.println();
        
        // Testing equals
        System.out.println("ud == ud2? (Serialain == Username)");
        System.out.println(ud.equals(ud2));
        System.out.println("\nud == ud3? (Serialain == Serialain)");
        System.out.println(ud.equals(ud3));
    }
}
