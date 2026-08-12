package P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.services;

import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.models.Printable;

public class PrintService {
    private final Printable machine;

    public PrintService(Printable machine) {
        this.machine = machine;
    }

    public void printInvoice() {
        machine.print("invoice.pdf");
    }
}
