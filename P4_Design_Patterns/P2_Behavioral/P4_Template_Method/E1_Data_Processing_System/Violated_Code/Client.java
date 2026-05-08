package P4_Design_Patterns.P2_Behavioral.P4_Template_Method.E1_Data_Processing_System.Violated_Code;

public class Client {
    public static void main(String[] args) {
        CSVDataProcessor csv = new CSVDataProcessor();
        csv.process();

        JSONDataProcessor json = new JSONDataProcessor();
        json.process();

        XMLDataProcessor xml = new XMLDataProcessor();
        xml.process();
    }
}
