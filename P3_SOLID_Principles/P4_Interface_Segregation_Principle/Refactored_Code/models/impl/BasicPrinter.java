package P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.models.impl;

import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.models.Printable;

public class BasicPrinter implements Printable {
    @Override
    public void print(String document) {
        System.out.println("BasicPrinter printing: " + document);
    }
}
