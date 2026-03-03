package P4_Design_Patterns.P1_Creational.P2_Factory_Method.E1_Loggers.Refactored_Code.factory.impl;

import P4_Design_Patterns.P1_Creational.P2_Factory_Method.E1_Loggers.Refactored_Code.factory.ILoggerFactory;
import P4_Design_Patterns.P1_Creational.P2_Factory_Method.E1_Loggers.Refactored_Code.logger.ILogger;
import P4_Design_Patterns.P1_Creational.P2_Factory_Method.E1_Loggers.Refactored_Code.logger.impl.InfoLogger;

public class InfoLoggerFactory implements ILoggerFactory {
    @Override
    public ILogger createLogger() {
        return new InfoLogger();
    }
}
