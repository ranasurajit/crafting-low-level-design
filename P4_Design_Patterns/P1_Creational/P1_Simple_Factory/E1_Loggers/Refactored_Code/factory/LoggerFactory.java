package P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Refactored_Code.factory;

import P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Refactored_Code.logger.ILogger;
import P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Refactored_Code.logger.impl.DebugLogger;
import P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Refactored_Code.logger.impl.ErrorLogger;
import P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Refactored_Code.logger.impl.InfoLogger;

public class LoggerFactory {
    public static ILogger createLogger(
            P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Refactored_Code.models.LogLevel info) {
        switch (info) {
            case INFO:
                return new InfoLogger();
            case ERROR:
                return new ErrorLogger();
            case DEBUG:
                return new DebugLogger();
            default:
                throw new IllegalArgumentException("LogLevel " + info + " is not yet implemented");
        }
    }
}
