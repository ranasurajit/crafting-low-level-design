package P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Violated_Code;

import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Violated_Code.external.PushNotificationService;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Violated_Code.services.LegacySMSService;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Violated_Code.services.NotificationService;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Violated_Code.services.impl.EmailService;

public class NotificationManager {
    public void notifyUser(String type, String message) {
        if (type.equalsIgnoreCase("email")) {
            NotificationService service = new EmailService();
            service.send(message);

        } else if (type.equalsIgnoreCase("sms")) {
            // ❌ incompatible API handling here
            LegacySMSService sms = new LegacySMSService();
            sms.sendSMS("+91-9999999999", message);

        } else if (type.equalsIgnoreCase("push")) {
            // ❌ different method signature
            PushNotificationService push = new PushNotificationService();
            push.push("Alert", message);

        } else {
            throw new IllegalArgumentException("Unsupported notification type");
        }
    }
}
