package P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Violated_Code.impl;

import P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Violated_Code.Bird;

public class Sparrow extends Bird {
    @Override
    public String name() {
        return "Sparrow";
    }

    @Override
    public void fly() {
        System.out.println("Sparrow flying...");
    }
}
