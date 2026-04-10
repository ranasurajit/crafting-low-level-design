package P4_Design_Patterns.P2_Behavioral.P2_Strategy.E1_Discount_System.Violated_Code.services;

public class DiscountService {
    public double applyDiscount(String discountType, double price) {
        if (discountType.equals("FLAT")) {
            return price - 100;
        } else if (discountType.equals("PERCENTAGE")) {
            return price - (price * 0.20);
        } else if (discountType.equals("NONE")) {
            return price;
        } else {
            throw new IllegalArgumentException("Invalid discount type");
        }
    }
}
