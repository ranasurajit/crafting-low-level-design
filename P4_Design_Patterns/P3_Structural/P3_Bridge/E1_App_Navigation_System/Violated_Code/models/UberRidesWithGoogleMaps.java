package P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Violated_Code.models;

public class UberRidesWithGoogleMaps {
    public void navigateToDestination(String source, String destination) {
        System.out.println("Uber Rides using Google Maps:");
        System.out.println("Calculating route from " + source + " to " + destination + " via Google Maps...");
    }

    public void startRide() {
        System.out.println("Ride started using Google Maps navigation");
    }
}
