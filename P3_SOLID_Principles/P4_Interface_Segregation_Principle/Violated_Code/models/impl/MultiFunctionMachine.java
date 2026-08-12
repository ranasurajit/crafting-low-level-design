package P3_SOLID_Principles.P4_Interface_Segregation_Principle.Violated_Code.models.impl;

import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Violated_Code.models.OfficeMachine;

public class MultiFunctionMachine implements OfficeMachine {
    @Override
    public void print(String document) {
        System.out.println("MultiFunctionMachine printing: " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("MultiFunctionMachine scanning: " + document);
    }

    @Override
    public void fax(String document, String phoneNumber) {
        System.out.println("MultiFunctionMachine faxing: " + document + " to " + phoneNumber);
    }

    @Override
    public void staple(int pages) {
        System.out.println("MultiFunctionMachine stapling " + pages + " pages");
    }
}
