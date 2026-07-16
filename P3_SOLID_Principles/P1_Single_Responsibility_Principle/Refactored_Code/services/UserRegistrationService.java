package P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.services;

import java.util.Objects;

import P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.models.impl.EmailValidator;
import P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.models.impl.PasswordValidator;
import P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.models.impl.UserValidator;

public class UserRegistrationService {
    private final LoggerService loggerService;
    private final UserValidator userValidator;
    private final EmailValidator emailValidator;
    private final PasswordValidator passwordValidator;
    private final HashingService hashingService;
    private final IStorageService storageService;
    private final NotificationService notificationService;

    public UserRegistrationService(
            LoggerService loggerService,
            UserValidator userValidator,
            EmailValidator emailValidator,
            PasswordValidator passwordValidator,
            HashingService hashingService,
            IStorageService storageService,
            NotificationService notificationService) {
        this.loggerService = Objects.requireNonNull(loggerService);
        this.userValidator = Objects.requireNonNull(userValidator);
        this.emailValidator = Objects.requireNonNull(emailValidator);
        this.passwordValidator = Objects.requireNonNull(passwordValidator);
        this.hashingService = Objects.requireNonNull(hashingService);
        this.storageService = Objects.requireNonNull(storageService);
        this.notificationService = Objects.requireNonNull(notificationService);
    }

    public void register(String username, String email, String password) {
        loggerService.log("Starting registration for " + username);
        if (!userValidator.isValid(username) ||
                !emailValidator.isValid(email) ||
                !passwordValidator.isValid(password)) {
            return;
        }
        String hashed = hashingService.getHash(password); // fake hashing
        storageService.save(username, email, hashed);
        notificationService.sendWelcomeEmail(email, username);
        loggerService.log("Registration completed for " + username);
    }
}
