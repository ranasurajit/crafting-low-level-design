package P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.observers;

import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.subjects.impl.Order;

public interface IClient {
    public void update(Order order);
}
