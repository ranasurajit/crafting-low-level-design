package P4_Design_Patterns.P2_Behavioral.P2_Strategy.E2_Payment_Processing_System.Refactored_Code.strategies.impl;

import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E2_Payment_Processing_System.Refactored_Code.strategies.IPaymentStrategy;

public class UPIPaymentStrategy implements IPaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of ₹" + amount);
    }
}
