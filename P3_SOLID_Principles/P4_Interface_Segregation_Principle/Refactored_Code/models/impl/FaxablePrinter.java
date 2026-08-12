package P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.models.impl;

import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.models.Faxable;
import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.models.Printable;

public class FaxablePrinter implements Printable, Faxable {
    public void print(String document) {
        System.out.println("FaxablePrinter printing: " + document);
    }

    @Override
    public void fax(String document, String phoneNumber) {
        System.out.println("FaxablePrinter faxing: " + document + " to " + phoneNumber);
    }
}
