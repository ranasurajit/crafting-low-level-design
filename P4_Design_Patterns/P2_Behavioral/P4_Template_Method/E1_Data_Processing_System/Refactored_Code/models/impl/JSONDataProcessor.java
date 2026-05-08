package P4_Design_Patterns.P2_Behavioral.P4_Template_Method.E1_Data_Processing_System.Refactored_Code.models.impl;

import P4_Design_Patterns.P2_Behavioral.P4_Template_Method.E1_Data_Processing_System.Refactored_Code.models.DataProcessor;

public class JSONDataProcessor extends DataProcessor {
    @Override
    protected void readData() {
        System.out.println("Reading JSON data...");
    }

    @Override
    protected void parseData() {
        System.out.println("Parsing JSON data...");
    }

    @Override
    protected void processData() {
        System.out.println("Processing JSON data...");
    }

    @Override
    protected void saveData() {
        System.out.println("Saving JSON data...");
    }
}
