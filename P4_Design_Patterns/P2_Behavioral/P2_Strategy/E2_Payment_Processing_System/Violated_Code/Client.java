package P4_Design_Patterns.P2_Behavioral.P2_Strategy.E2_Payment_Processing_System.Violated_Code;

import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E2_Payment_Processing_System.Violated_Code.models.PaymentType;

public class Client {
    public static void main(String[] args) {

        PaymentProcessor processor = new PaymentProcessor();

        processor.processPayment(PaymentType.CREDIT_CARD, 1000);
        processor.processPayment(PaymentType.DEBIT_CARD, 500);
        processor.processPayment(PaymentType.UPI, 200);
    }
}
