package P3_SOLID_Principles.P4_Interface_Segregation_Principle.Violated_Code.services;

import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Violated_Code.models.OfficeMachine;

public class PrintService {
    private final OfficeMachine machine;

    public PrintService(OfficeMachine machine) {
        this.machine = machine;
    }

    public void printInvoice() {
        machine.print("invoice.pdf");
    }
}
