package P4_Design_Patterns.P2_Behavioral.P4_Template_Method.E1_Data_Processing_System.Refactored_Code;

import P4_Design_Patterns.P2_Behavioral.P4_Template_Method.E1_Data_Processing_System.Refactored_Code.models.DataProcessor;
import P4_Design_Patterns.P2_Behavioral.P4_Template_Method.E1_Data_Processing_System.Refactored_Code.models.impl.CSVDataProcessor;
import P4_Design_Patterns.P2_Behavioral.P4_Template_Method.E1_Data_Processing_System.Refactored_Code.models.impl.JSONDataProcessor;
import P4_Design_Patterns.P2_Behavioral.P4_Template_Method.E1_Data_Processing_System.Refactored_Code.models.impl.XMLDataProcessor;

public class Client {
    public static void main(String[] args) {
        DataProcessor csvDataProcessor = new CSVDataProcessor();
        csvDataProcessor.process();

        DataProcessor jsonDataProcessor = new JSONDataProcessor();
        jsonDataProcessor.process();

        DataProcessor xmlDataProcessor = new XMLDataProcessor();
        xmlDataProcessor.process();
    }
}
