package P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.models.impl;

import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.models.FoodItem;

public class FarmhousePizza implements FoodItem {
    @Override
    public String getDescription() {
        return "Farmhouse Pizza";
    }

    @Override
    public double getCost() {
        return 300.0;
    }
}
