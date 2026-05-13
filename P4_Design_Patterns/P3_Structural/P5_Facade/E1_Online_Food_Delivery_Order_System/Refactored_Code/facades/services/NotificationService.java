package P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.services;

public class NotificationService {
    public void sendNotification(String userId, String message) {
        System.out.println("Sending notification to " + userId + ": " + message);
    }
}
