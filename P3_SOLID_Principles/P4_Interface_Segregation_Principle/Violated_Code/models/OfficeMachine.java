package P3_SOLID_Principles.P4_Interface_Segregation_Principle.Violated_Code.models;

public interface OfficeMachine {
    void print(String document);

    void scan(String document);

    void fax(String document, String phoneNumber);

    void staple(int pages);
}
