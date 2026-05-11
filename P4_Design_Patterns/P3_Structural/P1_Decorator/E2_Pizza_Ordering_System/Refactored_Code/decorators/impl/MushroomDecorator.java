package P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.decorators.impl;

import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.decorators.FoodItemDecorator;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.models.FoodItem;

public class MushroomDecorator extends FoodItemDecorator {
    private double price = 80.0;

    public MushroomDecorator(FoodItem item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " with Mushroom Toppings";
    }

    @Override
    public double getCost() {
        return item.getCost() + price;
    }
}
