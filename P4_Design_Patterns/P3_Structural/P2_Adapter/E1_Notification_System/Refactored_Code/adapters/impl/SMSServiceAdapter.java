package P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.adapters.impl;

import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.adapters.NotificationService;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.legacy.LegacySMSService;
import P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.models.NotificationRequest;

public class SMSServiceAdapter implements NotificationService {
    private LegacySMSService smsService;

    public SMSServiceAdapter() {
        this.smsService = new LegacySMSService();
    }

    @Override
    public void send(NotificationRequest request) {
        smsService.sendSMS(request.getPhoneNumber(), request.getMessage());
    }
}
