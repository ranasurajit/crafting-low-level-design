package P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code;

import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.models.impl.BasicPrinter;
import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.models.impl.ScannablePrinter;
import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.services.PrintService;
import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.services.ScanService;

public class Main {
    public static void main(String[] args) {
        PrintService service = new PrintService(new BasicPrinter());
        service.printInvoice();

        ScanService scanService = new ScanService(new ScannablePrinter());
        scanService.scan("contract.pdf");
    }
}
