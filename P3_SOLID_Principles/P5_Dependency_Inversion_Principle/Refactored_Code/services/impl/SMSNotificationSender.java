package P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Refactored_Code.services.impl;

import P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Refactored_Code.services.NotificationSender;

public class SMSNotificationSender implements NotificationSender {
    @Override
    public void notify(String to, String subject, String body) {
        System.out.println("[SMS] To=" + to + " Subject=" + subject + " Body=" + body);
    }
}
