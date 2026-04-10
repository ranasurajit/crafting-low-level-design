package P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Refactored_Code.strategies.impl;

import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Refactored_Code.strategies.IDiscountStrategy;

public class NoDiscountStrategy implements IDiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
