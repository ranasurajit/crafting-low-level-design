package P3_SOLID_Principles.P2_Open_Closed_Principle.Violated_Code;

public class DiscountCalculator {
    // OCP violation: adding a new discount type requires modifying this method
    public double finalPrice(double amount, String discountType) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be > 0");
        }
        double discount = 0;
        if ("NONE".equalsIgnoreCase(discountType)) {
            discount = 0;
        } else if ("STUDENT".equalsIgnoreCase(discountType)) {
            discount = 0.10;
        } else if ("FESTIVAL".equalsIgnoreCase(discountType)) {
            discount = 0.20;
        } else if ("EMPLOYEE".equalsIgnoreCase(discountType)) {
            discount = 0.30;
        } else {
            System.out.println("Unknown discount type: " + discountType);
        }
        return amount - (amount * discount);
    }
}
