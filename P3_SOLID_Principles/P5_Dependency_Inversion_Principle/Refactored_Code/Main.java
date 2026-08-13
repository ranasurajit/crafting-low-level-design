package P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Refactored_Code;

import P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Refactored_Code.services.UserRegistrationService;
import P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Refactored_Code.services.impl.EmailNotificationSender;
import P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Refactored_Code.services.impl.MySqlUserRepository;

public class Main {
    public static void main(String[] args) {
        UserRegistrationService service = new UserRegistrationService(
                new MySqlUserRepository(),
                new EmailNotificationSender());
        service.register("u1", "Alice", "alice@example.com");
        System.out.println("Name: " + service.getUserName("u1"));
    }
}
