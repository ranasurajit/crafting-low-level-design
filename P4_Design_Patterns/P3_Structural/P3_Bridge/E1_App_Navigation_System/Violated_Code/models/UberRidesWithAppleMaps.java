package P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Violated_Code.models;

public class UberRidesWithAppleMaps {
    public void navigateToDestination(String source, String destination) {
        System.out.println("Uber Rides using Apple Maps:");
        System.out.println("Calculating route from " + source + " to " + destination + " via Apple Maps...");
    }

    public void startRide() {
        System.out.println("Ride started using Apple Maps navigation");
    }
}
