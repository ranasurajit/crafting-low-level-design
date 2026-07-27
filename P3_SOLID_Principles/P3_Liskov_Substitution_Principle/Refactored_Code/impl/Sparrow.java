package P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Refactored_Code.impl;

import P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Refactored_Code.FlyableBird;

public class Sparrow extends FlyableBird {
    @Override
    public String name() {
        return "Sparrow";
    }

    @Override
    public void fly() {
        System.out.println("Sparrow flying...");
    }
}
