package P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Refactored_Code.models;

public abstract class UberApp {
    protected NavigationSystem navSystem;

    public void setLocations(String source, String destination) {
        if (navSystem == null) {
            throw new IllegalStateException("Navigation System is not instantiated!");
        }
        navSystem.setLocations(source, destination);
    }

    public void setNavigationSystem(NavigationSystem navSystem) {
        if (navSystem == null) {
            throw new IllegalArgumentException("Navigation System cannot be null");
        }
        this.navSystem = navSystem;
    }

    public abstract void start();

    public abstract void track();
}
