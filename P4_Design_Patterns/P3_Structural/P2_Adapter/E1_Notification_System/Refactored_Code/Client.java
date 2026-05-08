package P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code;

import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.models.NotificationRequest;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.models.NotificationsType;

public class Client {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        manager.notifyUser(NotificationsType.EMAIL, new NotificationRequest("Sending EMAIL", null, "Welcome!"));
        manager.notifyUser(NotificationsType.SMS, new NotificationRequest(null, "+91-9999999999", "Your OTP is 1234"));
        manager.notifyUser(NotificationsType.PUSH, new NotificationRequest("Alert", null, "New message received"));
    }
}
