package P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Violated_Code;

import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Violated_Code.model.CallCenter;
import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Violated_Code.model.Customer;
import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Violated_Code.model.DeliveryDriver;
import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Violated_Code.model.Order;
import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Violated_Code.model.Restaurant;

public class OrderStatus {
    public static void main(String[] args) {
        Customer customer = new Customer("Customer 1");
        Restaurant restaurant = new Restaurant("Rest 1");
        DeliveryDriver driver = new DeliveryDriver("Driver 1");
        CallCenter callCenter = new CallCenter();

        // ❌ All dependencies injected directly
        Order order = new Order(
                123,
                customer,
                restaurant,
                driver,
                callCenter);

        order.setStatus("Out for Delivery");
        order.setStatus("Delivered");
    }
}
