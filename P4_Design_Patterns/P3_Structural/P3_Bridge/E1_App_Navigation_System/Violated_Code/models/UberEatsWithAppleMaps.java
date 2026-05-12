package P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Violated_Code.models;

public class UberEatsWithAppleMaps {
    public void navigateToRestaurant(String location) {
        System.out.println("Uber Eats using Apple Maps:");
        System.out.println("Navigating to restaurant at " + location + " via Apple Maps...");
    }

    public void trackDelivery() {
        System.out.println("Tracking delivery using Apple Maps");
    }
}
