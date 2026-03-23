package P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Violated_Code.model;

public class DeliveryDriver {
    private String driverName;

    public DeliveryDriver(String name) {
        this.driverName = name;
    }

    public void update(Order order) {
        System.out.println("Driver " + driverName +
                ": Order #" + order.getId() +
                " is now " + order.getStatus() + ".");
    }
}
