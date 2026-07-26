package P3_SOLID_Principles.P2_Open_Closed_Principle.Refactored_Code.models.impl;

public abstract class PriceCalculator {
    protected abstract double discount();

    public double finalPrice(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("amount must be > 0");
        }
        double disc = discount();
        if (disc < 0.0d || disc > 1.0d) {
            throw new IllegalStateException("discount must be between 0 and 1");
        }
        return amount - (amount * disc);
    }
}
