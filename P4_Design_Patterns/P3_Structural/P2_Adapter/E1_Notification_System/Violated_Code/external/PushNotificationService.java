package P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Violated_Code.external;

public class PushNotificationService {
    public void push(String title, String body) {
        System.out.println("Sending PUSH -> Title: " + title + ", Body: " + body);
    }
}
