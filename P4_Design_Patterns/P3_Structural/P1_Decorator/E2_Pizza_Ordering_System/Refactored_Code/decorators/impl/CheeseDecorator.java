package P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.decorators.impl;

import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.decorators.FoodItemDecorator;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.models.FoodItem;

public class CheeseDecorator extends FoodItemDecorator {
    private double price = 110.0;

    public CheeseDecorator(FoodItem item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + " with Cheese Toppings";
    }

    @Override
    public double getCost() {
        return item.getCost() + price;
    }
}
