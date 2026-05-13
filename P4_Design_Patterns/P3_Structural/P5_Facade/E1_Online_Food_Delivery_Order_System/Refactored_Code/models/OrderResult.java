package P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.models;

public class OrderResult {
    private boolean status;
    private String message;

    public OrderResult(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public boolean getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }
}
