package P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Refactored_Code;

import P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Refactored_Code.factory.LoggerFactory;
import P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Refactored_Code.logger.ILogger;
import P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Refactored_Code.models.LogLevel;

public class Client {
    public static void main(String[] args) {
        ILogger infoLogger = LoggerFactory.createLogger(LogLevel.INFO);
        infoLogger.log("This is an info log msg");

        ILogger errorLogger = LoggerFactory.createLogger(LogLevel.ERROR);
        errorLogger.log("This is an error log msg");

        ILogger debugLogger = LoggerFactory.createLogger(LogLevel.DEBUG);
        debugLogger.log("This is an debug log msg");

        ILogger verboseLogger = LoggerFactory.createLogger(LogLevel.VERBOSE);
        verboseLogger.log("This is an verbose log msg");
    }
}
