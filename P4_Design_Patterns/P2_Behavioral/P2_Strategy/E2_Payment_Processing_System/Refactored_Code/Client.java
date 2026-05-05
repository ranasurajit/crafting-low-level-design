package P4_Design_Patterns.P2_Behavioral.P2_Strategy.E2_Payment_Processing_System.Refactored_Code;

import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E2_Payment_Processing_System.Refactored_Code.strategies.impl.CreditCardPaymentStrategy;
import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E2_Payment_Processing_System.Refactored_Code.strategies.impl.DebitCardPaymentStrategy;
import P4_Design_Patterns.P2_Behavioral.P2_Strategy.E2_Payment_Processing_System.Refactored_Code.strategies.impl.UPIPaymentStrategy;

public class Client {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        processor.setPaymentStrategy(new CreditCardPaymentStrategy());
        processor.processPayment(1000);

        processor.setPaymentStrategy(new DebitCardPaymentStrategy());
        processor.processPayment(500);

        processor.setPaymentStrategy(new UPIPaymentStrategy());
        processor.processPayment(200);
    }
}
