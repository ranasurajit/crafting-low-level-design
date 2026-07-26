package P3_SOLID_Principles.P2_Open_Closed_Principle.Refactored_Code.models.impl;

public class StudentPriceCalculator extends PriceCalculator {
    @Override
    public double discount() {
        return 0.10d;
    }
}
