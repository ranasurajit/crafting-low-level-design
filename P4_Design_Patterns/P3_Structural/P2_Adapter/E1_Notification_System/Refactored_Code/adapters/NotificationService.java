package P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.adapters;

import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.models.NotificationRequest;

public interface NotificationService {
    void send(NotificationRequest request);
}
