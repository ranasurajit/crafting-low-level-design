package P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.decorators;

import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.models.FoodItem;

public abstract class FoodItemDecorator implements FoodItem {
    protected final FoodItem item;

    protected FoodItemDecorator(FoodItem item) {
        if (item == null) {
            throw new IllegalArgumentException("FoodItem cannot be null");
        }
        this.item = item;
    }
}
