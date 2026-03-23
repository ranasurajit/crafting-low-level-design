package P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.observers.impl;

import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.observers.IClient;
import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.subjects.impl.Order;

public class Customer implements IClient {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public void update(Order order) {
        System.out.println("Hello, " + name +
                "! Order #" + order.getId() +
                " is now " + order.getStatus() + ".");
    }
}
