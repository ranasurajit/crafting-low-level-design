package P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.models.impl;

import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.models.Printable;
import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.models.Scannable;

public class ScannablePrinter implements Printable, Scannable {
    @Override
    public void print(String document) {
        System.out.println("ScannablePrinter printing: " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("ScannablePrinter scanning: " + document);
    }
}
