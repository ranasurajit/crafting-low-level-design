package P4_Design_Patterns.P3_Structural.P2_Adapter.E1_Notification_System.Refactored_Code.models;

public class NotificationRequest {
    private String message;
    private String phoneNumber;
    private String title;

    public NotificationRequest(String title, String phoneNumber, String message) {
        this.title = title;
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getTitle() {
        return this.title;
    }
}
