package P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Violated_Code;

import P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Violated_Code.logger.ILogger;
import P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Violated_Code.logger.impl.DebugLogger;
import P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Violated_Code.logger.impl.ErrorLogger;
import P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Violated_Code.logger.impl.InfoLogger;
import P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Violated_Code.models.LogLevel;

public class Client {
    public static void main(String[] args) {
        ILogger debugLogger;
        ILogger infoLogger;
        ILogger errorLogger;

        // ❌ Direct object creation logic in client
        LogLevel debugLevel = LogLevel.DEBUG;
        LogLevel infoLevel = LogLevel.INFO;
        LogLevel errorLevel = LogLevel.ERROR;

        if (debugLevel == LogLevel.DEBUG) {
            debugLogger = new DebugLogger();
        } else if (debugLevel == LogLevel.INFO) {
            debugLogger = new InfoLogger();
        } else {
            debugLogger = new ErrorLogger();
        }

        if (infoLevel == LogLevel.DEBUG) {
            infoLogger = new DebugLogger();
        } else if (infoLevel == LogLevel.INFO) {
            infoLogger = new InfoLogger();
        } else {
            infoLogger = new ErrorLogger();
        }

        if (errorLevel == LogLevel.DEBUG) {
            errorLogger = new DebugLogger();
        } else if (errorLevel == LogLevel.INFO) {
            errorLogger = new InfoLogger();
        } else {
            errorLogger = new ErrorLogger();
        }

        debugLogger.log("This is a debug log msg");
        infoLogger.log("This is an info log msg");
        errorLogger.log("This is an error log msg");
    }
}
