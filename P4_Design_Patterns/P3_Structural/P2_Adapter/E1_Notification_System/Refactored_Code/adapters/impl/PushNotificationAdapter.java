package P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.adapters.impl;

import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.adapters.NotificationService;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.external.PushNotificationService;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.models.NotificationRequest;

public class PushNotificationAdapter implements NotificationService {
    private PushNotificationService service;

    public PushNotificationAdapter() {
        this.service = new PushNotificationService();
    }

    @Override
    public void send(NotificationRequest request) {
        service.push(request.getTitle(), request.getMessage());
    }
}
