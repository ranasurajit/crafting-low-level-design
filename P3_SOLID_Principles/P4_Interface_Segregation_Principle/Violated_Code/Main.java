package P3_SOLID_Principles.P4_Interface_Segregation_Principle.Violated_Code;

import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Violated_Code.models.OfficeMachine;
import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Violated_Code.models.impl.BasicPrinter;
import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Violated_Code.services.PrintService;

public class Main {
    public static void main(String[] args) {
        OfficeMachine basic = new BasicPrinter();
        PrintService service = new PrintService(basic);
        service.printInvoice();

        // This will compile, but will fail at runtime due to ISP-violating design:
        // basic.scan("contract.pdf");
    }
}
