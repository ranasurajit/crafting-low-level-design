package P3_SOLID_Principles.P4_Interface_Segregation_Principle.Violated_Code.models.impl;

import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Violated_Code.models.OfficeMachine;

public class BasicPrinter implements OfficeMachine {
    @Override
    public void print(String document) {
        System.out.println("BasicPrinter printing: " + document);
    }

    @Override
    public void scan(String document) {
        // Forced to implement: violates ISP
        throw new UnsupportedOperationException("BasicPrinter cannot scan");
    }

    @Override
    public void fax(String document, String phoneNumber) {
        // Forced to implement: violates ISP
        throw new UnsupportedOperationException("BasicPrinter cannot fax");
    }

    @Override
    public void staple(int pages) {
        // Forced to implement: violates ISP
        throw new UnsupportedOperationException("BasicPrinter cannot staple");
    }
}
