package P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Refactored_Code;

import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Refactored_Code.strategies.impl.FlatDiscountStrategy;
import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Refactored_Code.strategies.impl.NoDiscountStrategy;
import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Refactored_Code.strategies.impl.PercentageDiscountStrategy;
import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Refactored_Code.services.DiscountService;

public class ShoppingCart {
    public static void main(String[] args) {
        DiscountService service1 = new DiscountService(new FlatDiscountStrategy(100));
        double finalPrice1 = service1.applyDiscount(1000);
        System.out.println("Final Price (Flat Discount): ₹" + finalPrice1);

        DiscountService service2 = new DiscountService(new PercentageDiscountStrategy(20));
        double finalPrice2 = service2.applyDiscount(1000);
        System.out.println("Final Price (Percentage Discount): ₹" + finalPrice2);

        DiscountService service3 = new DiscountService(new NoDiscountStrategy());
        double finalPrice3 = service3.applyDiscount(1000);
        System.out.println("Final Price (No Discount): ₹" + finalPrice3);
    }
}
