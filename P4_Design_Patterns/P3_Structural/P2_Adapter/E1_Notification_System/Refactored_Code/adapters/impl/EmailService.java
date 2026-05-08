package P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.adapters.impl;

import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.adapters.NotificationService;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.models.NotificationRequest;

public class EmailService implements NotificationService {
    @Override
    public void send(NotificationRequest request) {
        System.out.println(request.getTitle() + ": " + request.getMessage());
    }
}
