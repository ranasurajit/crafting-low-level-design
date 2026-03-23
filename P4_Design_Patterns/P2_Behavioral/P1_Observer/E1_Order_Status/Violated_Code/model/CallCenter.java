package P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Violated_Code.model;

public class CallCenter {
    public void update(Order order) {
        System.out.println("Call center: Order #" +
                order.getId() +
                " is now " + order.getStatus() + ".");
    }
}
