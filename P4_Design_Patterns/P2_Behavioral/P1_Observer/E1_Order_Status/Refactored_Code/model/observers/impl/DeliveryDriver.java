package P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.observers.impl;

import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.observers.IClient;
import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.subjects.impl.Order;

public class DeliveryDriver implements IClient {
    private String driverName;

    public DeliveryDriver(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public void update(Order order) {
        System.out.println("Driver " + driverName +
                ": Order #" + order.getId() +
                " is now " + order.getStatus() + ".");
    }
}
