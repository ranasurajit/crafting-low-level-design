package P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Refactored_Code.decorators.impl;

import P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Refactored_Code.decorators.CoffeeDecorator;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Refactored_Code.model.Coffee;

public class CaramelDecorator extends CoffeeDecorator {
    public CaramelDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " + Caramel";
    }

    @Override
    public double getCost() {
        return super.getCost() + 70.0;
    }
}
