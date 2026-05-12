package P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Violated_Code.models;

public class UberEatsWithGoogleMaps {
    public void navigateToRestaurant(String location) {
        System.out.println("Uber Eats using Google Maps:");
        System.out.println("Navigating to restaurant at " + location + " via Google Maps...");
    }

    public void trackDelivery() {
        System.out.println("Tracking delivery using Google Maps");
    }
}
