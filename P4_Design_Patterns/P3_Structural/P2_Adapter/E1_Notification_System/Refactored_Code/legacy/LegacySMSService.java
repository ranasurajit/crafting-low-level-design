package P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.legacy;

public class LegacySMSService {
    public void sendSMS(String phoneNumber, String message) {
        System.out.println("Sending SMS to " + phoneNumber + ": " + message);
    }
}
