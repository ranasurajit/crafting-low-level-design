package P4_Design_Patterns.P1_Creational.P2_Factory_Method.E1_Loggers.Refactored_Code.logger.impl;

import P4_Design_Patterns.P1_Creational.P2_Factory_Method.E1_Loggers.Refactored_Code.logger.ILogger;

public class InfoLogger implements ILogger {
    @Override
    public void log(String msg) {
        System.out.println("INFO: " + msg);
    }
}
