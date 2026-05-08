package P4_Design_Patterns.P2_Behavioral.P4_Template_Method.E1_Data_Processing_System.Violated_Code;

public class CSVDataProcessor {
    public void process() {
        readData();
        parseData();
        processData();
        saveData();
    }

    private void readData() {
        System.out.println("Reading CSV data...");
    }

    private void parseData() {
        System.out.println("Parsing CSV data...");
    }

    private void processData() {
        System.out.println("Processing CSV data...");
    }

    private void saveData() {
        System.out.println("Saving CSV data...");
    }
}
