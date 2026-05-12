package P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Refactored_Code.models.impl;

import P4_Design_Patterns.P3_Structural.P3_Bridge.E1_App_Navigation_System.Refactored_Code.models.UberApp;

public class UberEats extends UberApp {
    @Override
    public void start() {
        navSystem.navigate();
    }

    @Override
    public void track() {
        navSystem.track();
    }
}
