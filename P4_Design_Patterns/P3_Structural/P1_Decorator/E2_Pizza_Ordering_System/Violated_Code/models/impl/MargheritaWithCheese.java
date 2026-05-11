package P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Violated_Code.models.impl;

import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Violated_Code.models.Pizza;

public class MargheritaWithCheese implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza + Cheese";
    }

    @Override
    public double getCost() {
        return 250.0;
    }
}
