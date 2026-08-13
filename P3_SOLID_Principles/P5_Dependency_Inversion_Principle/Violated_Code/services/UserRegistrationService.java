package P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Violated_Code.services;

public class UserRegistrationService {
    private final MySqlUserRepository repository = new MySqlUserRepository(); // hard-coded dependency
    private final EmailSender emailSender = new EmailSender(); // hard-coded dependency

    public void register(String userId, String name, String email) {
        // business logic
        repository.save(userId, name);

        // notification
        emailSender.sendEmail(
                email,
                "Welcome, " + name,
                "Thanks for registering, " + name + "!");
    }

    public String getUserName(String userId) {
        return repository.findNameById(userId);
    }
}
