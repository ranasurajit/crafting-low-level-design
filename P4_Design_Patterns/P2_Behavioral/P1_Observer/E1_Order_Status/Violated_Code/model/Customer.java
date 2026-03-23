package P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Violated_Code.model;

public class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public void update(Order order) {
        System.out.println("Hello, " + name +
                "! Order #" + order.getId() +
                " is now " + order.getStatus() + ".");
    }
}
