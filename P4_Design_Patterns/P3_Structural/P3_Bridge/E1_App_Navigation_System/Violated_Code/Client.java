package P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Violated_Code;

import P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Violated_Code.models.UberEatsWithAppleMaps;
import P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Violated_Code.models.UberRidesWithGoogleMaps;

public class Client {
    public static void main(String[] args) {
        UberRidesWithGoogleMaps ride = new UberRidesWithGoogleMaps();
        ride.navigateToDestination("Home", "Airport");
        ride.startRide();

        UberEatsWithAppleMaps eats = new UberEatsWithAppleMaps();
        eats.navigateToRestaurant("Pizza Store");
        eats.trackDelivery();
    }
}
