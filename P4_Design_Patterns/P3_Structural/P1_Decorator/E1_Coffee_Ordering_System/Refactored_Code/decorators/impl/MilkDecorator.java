package P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Refactored_Code.decorators.impl;

import P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Refactored_Code.decorators.CoffeeDecorator;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Refactored_Code.model.Coffee;

public class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Milk";
    }

    @Override
    public double getCost() {
        return super.getCost() + 20.0;
    }
}
