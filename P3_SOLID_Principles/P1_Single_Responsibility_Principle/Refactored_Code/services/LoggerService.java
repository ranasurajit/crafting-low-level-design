package P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.services;

import java.time.LocalDateTime;

public class LoggerService {
    public void log(String msg) {
        System.out.println("[" + LocalDateTime.now() + "] " + msg);
    }
}
