package P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Violated_Code.services.impl;

import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Violated_Code.services.NotificationService;

public class EmailService implements NotificationService {
    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}
