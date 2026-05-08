package P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Violated_Code;

public class Client {
    public static void main(String[] args) {
        NotificationManager manager = new NotificationManager();
        manager.notifyUser("email", "Welcome!");
        manager.notifyUser("sms", "Your OTP is 1234");
        manager.notifyUser("push", "New message received");
    }
}
