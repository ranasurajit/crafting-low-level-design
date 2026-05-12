package P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Refactored_Code.models.impl;

import P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Refactored_Code.models.NavigationSystem;

public class GoogleNavigationSystem implements NavigationSystem {
    private String source;
    private String destination;

    public void setLocations(String source, String destination) {
        this.source = source;
        this.destination = destination;
    }

    @Override
    public void navigate() {
        System.out.println("Navigating to " + destination + " from " + source + " via Google Maps...");
    }

    @Override
    public void track() {
        System.out.println("Tracking status using Google Maps");
    }
}
