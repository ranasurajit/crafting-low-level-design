package P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Refactored_Code.services;

public interface NotificationSender {
    void notify(String to, String subject, String body);
}
