package P3_SOLID_Principles.P1_Single_Responsibility_Principle.Violated_Code;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class UserRegistrationService {
    // SRP violation: validation + password hashing + persistence + email + logging
    // in one class/method
    public void register(String username, String email, String password) {
        log("Starting registration for " + username);

        if (username == null || username.isBlank())
            throw new IllegalArgumentException("username required");
        if (email == null || !email.contains("@"))
            throw new IllegalArgumentException("invalid email");
        if (password == null || password.length() < 6)
            throw new IllegalArgumentException("weak password");

        String hashed = "HASH(" + password + ")"; // fake hashing

        saveToFile(username, email, hashed);

        sendWelcomeEmail(email, username);

        log("Registration completed for " + username);
    }

    private void saveToFile(String username, String email, String hashed) {
        try (FileWriter fw = new FileWriter("users.txt", true)) {
            fw.write(username + "," + email + "," + hashed + "\n");
        } catch (IOException e) {
            throw new RuntimeException("could not save user", e);
        }
    }

    private void sendWelcomeEmail(String email, String username) {
        System.out.println("Sending welcome EMAIL to " + email + " (Hi " + username + ")");
    }

    private void log(String msg) {
        System.out.println("[" + LocalDateTime.now() + "] " + msg);
    }
}
