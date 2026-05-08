package P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code;

import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.adapters.NotificationService;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.factories.NotificationFactory;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.models.NotificationRequest;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.models.NotificationsType;

public class NotificationManager {
    public void notifyUser(NotificationsType type, NotificationRequest request) {
        NotificationService service = NotificationFactory.getNotificationSystem(type, request);
        service.send(request);
    }
}
