package P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Refactored_Code.impl;

import P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Refactored_Code.Bird;

public class Penguin extends Bird {
    @Override
    public String name() {
        return "Penguin";
    }
}
