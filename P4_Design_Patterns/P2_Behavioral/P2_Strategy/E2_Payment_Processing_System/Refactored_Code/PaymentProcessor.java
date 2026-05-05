package P4_Design_Patterns.P2_Behavioral.P2_Strategy.E2_Payment_Processing_System.Refactored_Code;

import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E2_Payment_Processing_System.Refactored_Code.strategies.IPaymentStrategy;

public class PaymentProcessor {
    private IPaymentStrategy strategy;

    public void setPaymentStrategy(IPaymentStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Payment strategy should be passed!");
        }
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        if (strategy == null) {
            throw new IllegalStateException("Payment strategy is not set!");
        }
        strategy.processPayment(amount);
    }
}
