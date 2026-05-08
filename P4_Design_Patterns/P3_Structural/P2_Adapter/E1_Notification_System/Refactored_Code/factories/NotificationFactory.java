package P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.factories;

import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.adapters.NotificationService;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.adapters.impl.EmailService;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.adapters.impl.PushNotificationAdapter;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.adapters.impl.SMSServiceAdapter;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.models.NotificationRequest;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.models.NotificationsType;

public class NotificationFactory {
    public static NotificationService getNotificationSystem(NotificationsType type, NotificationRequest request) {
        switch (type) {
            case EMAIL:
                return new EmailService();
            case SMS:
                return new SMSServiceAdapter();
            case PUSH:
                return new PushNotificationAdapter();
            default:
                throw new IllegalArgumentException("Invalid Notification Type was used");
        }
    }
}
