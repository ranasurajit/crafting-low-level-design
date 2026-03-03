package P4_Design_Patterns.P1_Creational.P2_Factory_Method.E1_Loggers.Refactored_Code;

import P4_Design_Patterns.P1_Creational.P2_Factory_Method.E1_Loggers.Refactored_Code.factory.ILoggerFactory;
import P4_Design_Patterns.P1_Creational.P2_Factory_Method.E1_Loggers.Refactored_Code.factory.impl.DebugLoggerFactory;
import P4_Design_Patterns.P1_Creational.P2_Factory_Method.E1_Loggers.Refactored_Code.factory.impl.ErrorLoggerFactory;
import P4_Design_Patterns.P1_Creational.P2_Factory_Method.E1_Loggers.Refactored_Code.factory.impl.InfoLoggerFactory;
import P4_Design_Patterns.P1_Creational.P2_Factory_Method.E1_Loggers.Refactored_Code.logger.ILogger;

public class Client {
    public static void main(String[] args) {
        ILoggerFactory debugLoggerFactory = new DebugLoggerFactory();
        ILogger debugLogger = debugLoggerFactory.createLogger();
        debugLogger.log("This is an debug log msg");

        ILoggerFactory errorLoggerFactory = new ErrorLoggerFactory();
        ILogger errorLogger = errorLoggerFactory.createLogger();
        errorLogger.log("This is an error log msg");

        ILoggerFactory infoLoggerFactory = new InfoLoggerFactory();
        ILogger infoLogger = infoLoggerFactory.createLogger();
        infoLogger.log("This is an info log msg");
    }
}
