package P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code;

import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.observers.impl.CallCenter;
import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.observers.impl.Customer;
import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.observers.impl.DeliveryDriver;
import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.observers.impl.Restaurant;
import P4_Design_Patterns.P2_Behavioral.P1_Observer.E1_Order_Status.Refactored_Code.model.subjects.impl.Order;

public class OrderStatus {
    public static void main(String[] args) {
        Order order = new Order(123);
        Customer customer = new Customer("Customer 1");
        Restaurant restaurant = new Restaurant("Rest 1");
        DeliveryDriver driver = new DeliveryDriver("Driver 1");
        CallCenter callCenter = new CallCenter();
        order.attach(customer);
        order.attach(restaurant);
        order.attach(driver);
        order.attach(callCenter);
        order.updateStatus("Out for Delivery");
        order.updateStatus("Delivered");
    }
}
