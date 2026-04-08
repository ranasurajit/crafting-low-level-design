package P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Violated_Code.model.impl;

import P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Violated_Code.model.Coffee;

public class EspressoWithMilkAndSugar extends Coffee {
    @Override
    public String getDescription() {
        return "Espresso + Milk + Sugar";
    }

    @Override
    public double getCost() {
        return 130;
    }
}
