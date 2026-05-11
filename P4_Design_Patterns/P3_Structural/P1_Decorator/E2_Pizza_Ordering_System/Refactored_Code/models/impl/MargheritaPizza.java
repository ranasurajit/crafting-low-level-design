package P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.models.impl;

import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.models.FoodItem;

public class MargheritaPizza implements FoodItem {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 200.0;
    }
}
