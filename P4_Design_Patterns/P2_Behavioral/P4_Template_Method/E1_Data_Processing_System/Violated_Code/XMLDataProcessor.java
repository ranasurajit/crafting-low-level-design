package P4_Design_Patterns.P2_Behavioral.P4_Template_Method.E1_Data_Processing_System.Violated_Code;

public class XMLDataProcessor {
    public void process() {
        readData();
        parseData();
        processData();
        saveData();
    }

    private void readData() {
        System.out.println("Reading XML data...");
    }

    private void parseData() {
        System.out.println("Parsing XML data...");
    }

    private void processData() {
        System.out.println("Processing XML data...");
    }

    private void saveData() {
        System.out.println("Saving XML data...");
    }
}
