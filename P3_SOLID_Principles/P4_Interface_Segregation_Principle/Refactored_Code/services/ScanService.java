package P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.services;

import P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code.models.Scannable;

public class ScanService {
    private final Scannable machine;

    public ScanService(Scannable machine) {
        this.machine = machine;
    }

    public void scan(String document) {
        machine.scan(document);
    }
}
