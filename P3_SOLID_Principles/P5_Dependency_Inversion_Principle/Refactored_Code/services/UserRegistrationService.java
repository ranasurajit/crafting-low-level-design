package P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Refactored_Code.services;

import java.util.Objects;

public class UserRegistrationService {
    private final UserRepository repository;
    private final NotificationSender sender;

    public UserRegistrationService(UserRepository repository, NotificationSender sender) {
        this.repository = Objects.requireNonNull(repository, "Repository to connect with DB is not passed");
        this.sender = Objects.requireNonNull(sender, "Sender is not passed");
    }

    public void register(String userId, String name, String email) {
        // business logic
        repository.save(userId, name);
        // notification
        sender.notify(email,
                "Welcome, " + name,
                "Thanks for registering, " + name + "!");
    }

    public String getUserName(String userId) {
        return repository.findNameById(userId);
    }
}
