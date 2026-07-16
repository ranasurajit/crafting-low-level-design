package P3_SOLID_Principles.P1_Single_Responsibility_Principle.Violated_Code;

public class Main {
    public static void main(String[] args) {
        UserRegistrationService service = new UserRegistrationService();
        service.register("alice", "alice@example.com", "pass123");
    }
}
