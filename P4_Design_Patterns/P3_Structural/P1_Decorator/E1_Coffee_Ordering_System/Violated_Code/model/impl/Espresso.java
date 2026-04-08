package P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Violated_Code.model.impl;

import P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Violated_Code.model.Coffee;

public class Espresso extends Coffee {
    @Override
    public String getDescription() {
        return "Espresso";
    }

    @Override
    public double getCost() {
        return 100;
    }
}
