package P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.models.impl;

import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.models.Printable;
import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.models.Stapleable;

public class StaplePrinter implements Printable, Stapleable {
    @Override
    public void print(String document) {
        System.out.println("StaplePrinter printing: " + document);
    }

    @Override
    public void staple(int pages) {
        System.out.println("StaplePrinter stapling " + pages + " pages");
    }
}
