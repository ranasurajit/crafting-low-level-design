package P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Refactored_Code.strategies.impl;

import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Refactored_Code.strategies.IDiscountStrategy;

public class PercentageDiscountStrategy implements IDiscountStrategy {
    private double percentage;

    public PercentageDiscountStrategy(double percentage) {
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid percentage");
        }
        return price - (price * (percentage / 100));
    }
}
