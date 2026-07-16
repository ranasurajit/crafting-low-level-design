package P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code;

import P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.models.impl.EmailValidator;
import P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.models.impl.PasswordValidator;
import P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.models.impl.UserValidator;
import P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.services.HashingService;
import P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.services.IStorageService;
import P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.services.LoggerService;
import P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.services.NotificationService;
import P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.services.UserRegistrationService;
import P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.services.impl.FileService;

public class Main {
    public static void main(String[] args) {
        LoggerService loggerService = new LoggerService();
        UserValidator userValidator = new UserValidator();
        EmailValidator emailValidator = new EmailValidator();
        PasswordValidator passwordValidator = new PasswordValidator();
        HashingService hashingService = new HashingService();
        IStorageService storageService = new FileService();
        NotificationService notificationService = new NotificationService();
        UserRegistrationService service = new UserRegistrationService(loggerService, userValidator,
                emailValidator, passwordValidator, hashingService,
                storageService, notificationService);
        service.register("alice", "alice@example.com", "pass123");
    }
}
