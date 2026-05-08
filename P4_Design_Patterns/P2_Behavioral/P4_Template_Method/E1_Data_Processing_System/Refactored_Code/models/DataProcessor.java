package P4_Design_Patterns.P2_Behavioral.P4_Template_Method.E1_Data_Processing_System.Refactored_Code.models;

public abstract class DataProcessor {
    public final void process() {
        readData();
        parseData();
        processData();
        saveData();
    }

    protected abstract void readData();

    protected abstract void parseData();

    protected abstract void processData();

    protected abstract void saveData();
}
