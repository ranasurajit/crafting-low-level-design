package P3_SOLID_Principles.P2_Open_Closed_Principle.Violated_Code;

public class Main {
    public static void main(String[] args) {
        DiscountCalculator calc = new DiscountCalculator();
        System.out.println("Final price: " + calc.finalPrice(1000, "STUDENT"));
    }
}
