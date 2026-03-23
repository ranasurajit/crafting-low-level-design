package P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Violated_Code.model;

public class Order {
    private int id;
    private String status;

    // Direct dependencies ❌
    private Customer customer;
    private Restaurant restaurant;
    private DeliveryDriver driver;
    private CallCenter callCenter;

    public Order(int id,
            Customer customer,
            Restaurant restaurant,
            DeliveryDriver driver,
            CallCenter callCenter) {

        this.id = id;
        this.status = "Order Placed";

        this.customer = customer;
        this.restaurant = restaurant;
        this.driver = driver;
        this.callCenter = callCenter;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;

        // ❌ Direct method calls instead of notifyObservers()
        customer.update(this);
        restaurant.update(this);
        driver.update(this);
        callCenter.update(this);
    }
}
