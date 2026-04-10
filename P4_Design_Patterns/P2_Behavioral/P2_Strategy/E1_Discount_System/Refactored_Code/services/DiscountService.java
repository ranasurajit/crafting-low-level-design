package P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Refactored_Code.services;

import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Refactored_Code.strategies.IDiscountStrategy;

public class DiscountService {
    private IDiscountStrategy strategy;

    public DiscountService(IDiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double applyDiscount(double price) {
        return strategy.applyDiscount(price);
    }
}
