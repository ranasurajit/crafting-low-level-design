package P3_SOLID_Principles.P4_Interface_Segregation_Principle.Violated_Code.models.impl;

import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Violated_Code.models.OfficeMachine;

public class PrintScanCombo implements OfficeMachine {
    @Override
    public void print(String document) {
        System.out.println("PrintScanCombo printing: " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("PrintScanCombo scanning: " + document);
    }

    @Override
    public void fax(String document, String phoneNumber) {
        // Forced to implement: violates ISP
        throw new UnsupportedOperationException("PrintScanCombo cannot fax");
    }

    @Override
    public void staple(int pages) {
        // Forced to implement: violates ISP
        throw new UnsupportedOperationException("PrintScanCombo cannot staple");
    }
}
