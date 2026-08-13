package P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Violated_Code.services;

public class EmailSender {
    public void sendEmail(String to, String subject, String body) {
        System.out.println("[Email] To=" + to + " Subject=" + subject + " Body=" + body);
    }
}
