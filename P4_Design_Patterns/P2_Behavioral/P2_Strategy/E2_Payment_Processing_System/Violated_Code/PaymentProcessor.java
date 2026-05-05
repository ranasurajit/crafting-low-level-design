package P4_Design_Patterns.P2_Behavioral.P2_Strategy.E2_Payment_Processing_System.Violated_Code;

import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E2_Payment_Processing_System.Violated_Code.models.PaymentType;

public class PaymentProcessor {
    public void processPayment(PaymentType type, double amount) {
        if (type == PaymentType.CREDIT_CARD) {
            processCreditCard(amount);

        } else if (type == PaymentType.DEBIT_CARD) {
            processDebitCard(amount);

        } else if (type == PaymentType.UPI) {
            processUPI(amount);

        } else {
            throw new IllegalArgumentException("Unsupported payment type");
        }
    }

    private void processCreditCard(double amount) {
        System.out.println("Processing CREDIT CARD payment of ₹" + amount);
        // complex logic here...
    }

    private void processDebitCard(double amount) {
        System.out.println("Processing DEBIT CARD payment of ₹" + amount);
        // complex logic here...
    }

    private void processUPI(double amount) {
        System.out.println("Processing UPI payment of ₹" + amount);
        // complex logic here...
    }
}
