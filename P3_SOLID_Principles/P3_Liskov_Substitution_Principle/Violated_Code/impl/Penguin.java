package P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Violated_Code.impl;

import P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Violated_Code.Bird;

public class Penguin extends Bird {
    @Override
    public String name() {
        return "Penguin";
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguins cannot fly");
    }
}
