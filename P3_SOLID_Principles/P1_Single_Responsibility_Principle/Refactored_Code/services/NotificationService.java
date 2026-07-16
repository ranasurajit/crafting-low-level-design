package P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.services;

public class NotificationService {
    public void sendWelcomeEmail(String email, String username) {
        System.out.println("Sending welcome EMAIL to " + email + " (Hi " + username + ")");
    }
}
