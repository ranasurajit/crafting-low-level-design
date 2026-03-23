package P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.observers.impl;

import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.observers.IClient;
import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.subjects.impl.Order;

public class CallCenter implements IClient {

    public CallCenter() {}

    @Override
    public void update(Order order) {
        System.out.println("Call center: Order #" +
                order.getId() +
                " is now " + order.getStatus() + ".");
    }
}
