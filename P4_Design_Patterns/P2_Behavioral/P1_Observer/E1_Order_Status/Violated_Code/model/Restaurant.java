package P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Violated_Code.model;

public class Restaurant {
    private String restaurantName;

    public Restaurant(String name) {
        this.restaurantName = name;
    }

    public void update(Order order) {
        System.out.println("Restaurant " + restaurantName +
                ": Order #" + order.getId() +
                " is now " + order.getStatus() + ".");
    }
}
