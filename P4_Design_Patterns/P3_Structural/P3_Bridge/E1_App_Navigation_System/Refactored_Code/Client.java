package P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Refactored_Code;

import P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Refactored_Code.models.UberApp;
import P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Refactored_Code.models.impl.AppleNavigationSystem;
import P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Refactored_Code.models.impl.GoogleNavigationSystem;
import P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Refactored_Code.models.impl.UberEats;
import P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Refactored_Code.models.impl.UberRides;

public class Client {
    public static void main(String[] args) {
        UberApp uberEats = new UberEats();
        uberEats.setNavigationSystem(new AppleNavigationSystem());
        uberEats.setLocations("Pizza Store", "Cajon Street");
        uberEats.start();
        uberEats.track();

        UberApp uberRides = new UberRides();
        uberRides.setNavigationSystem(new GoogleNavigationSystem());
        uberRides.setLocations("Whitefield", "M.G.Road");
        uberRides.start();
        uberRides.track();
    }
}
