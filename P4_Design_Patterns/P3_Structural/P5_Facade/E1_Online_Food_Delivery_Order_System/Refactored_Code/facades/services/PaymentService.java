package P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.services;

public class PaymentService {
    public boolean processPayment(String userId, double amount) {
        System.out.println("Processing payment of ₹" + amount + " for user " + userId);
        return true;
    }
}
