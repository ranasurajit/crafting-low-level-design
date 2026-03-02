package P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Violated_Code.logger.impl;

import P4_Design_Patterns.P1_Creational.P1_Simple_Factory.E1_Loggers.Violated_Code.logger.ILogger;

public class InfoLogger implements ILogger {
    @Override
    public void log(String msg) {
        System.out.println("INFO: " + msg);
    }
}
