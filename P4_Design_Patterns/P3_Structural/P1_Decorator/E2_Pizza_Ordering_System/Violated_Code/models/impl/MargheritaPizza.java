package P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Violated_Code.models.impl;

import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Violated_Code.models.Pizza;

public class MargheritaPizza implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 200.0;
    }
}
