package P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Refactored_Code.models;

public interface NavigationSystem {
    public void setLocations(String source, String destination);

    public void navigate();

    public void track();
}
