package P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Refactored_Code.strategies.impl;

import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Refactored_Code.strategies.IDiscountStrategy;

public class FlatDiscountStrategy implements IDiscountStrategy {
    private double discount;

    public FlatDiscountStrategy(double discount) {
        this.discount = discount;
    }

    @Override
    public double applyDiscount(double price) {
        return price - discount;
    }
}
