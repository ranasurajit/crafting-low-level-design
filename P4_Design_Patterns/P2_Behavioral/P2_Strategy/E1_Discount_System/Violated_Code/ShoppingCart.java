package P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Violated_Code;

import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Violated_Code.services.DiscountService;

public class ShoppingCart {
    public static void main(String[] args) {
        DiscountService service = new DiscountService();

        double finalPrice1 = service.applyDiscount("FLAT", 1000);
        System.out.println("Final Price (Flat Discount): ₹" + finalPrice1);

        double finalPrice2 = service.applyDiscount("PERCENTAGE", 1000);
        System.out.println("Final Price (Percentage Discount): ₹" + finalPrice2);

        double finalPrice3 = service.applyDiscount("NONE", 1000);
        System.out.println("Final Price (No Discount): ₹" + finalPrice3);
    }
}
