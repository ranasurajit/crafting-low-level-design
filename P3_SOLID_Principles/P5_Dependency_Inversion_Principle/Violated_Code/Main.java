package P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Violated_Code;

import P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Violated_Code.services.UserRegistrationService;

public class Main {
    public static void main(String[] args) {
        UserRegistrationService service = new UserRegistrationService();
        service.register("u1", "Alice", "alice@example.com");

        System.out.println("Name: " + service.getUserName("u1"));
    }
}
