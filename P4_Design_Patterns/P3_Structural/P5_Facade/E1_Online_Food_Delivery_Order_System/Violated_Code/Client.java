package P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Violated_Code;

import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Violated_Code.services.DeliveryService;
import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Violated_Code.services.NotificationService;
import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Violated_Code.services.PaymentService;
import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Violated_Code.services.RestaurantService;
import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Violated_Code.services.UserService;

public class Client {
    public static void main(String[] args) {
        UserService userService = new UserService();
        RestaurantService restaurantService = new RestaurantService();
        PaymentService paymentService = new PaymentService();
        DeliveryService deliveryService = new DeliveryService();
        NotificationService notificationService = new NotificationService();

        String userId = "U123";
        String restaurant = "Dominos";
        double amount = 500;

        if (!userService.validateUser(userId)) {
            System.out.println("Invalid user!");
            return;
        }

        if (!restaurantService.isRestaurantOpen(restaurant)) {
            System.out.println("Restaurant is closed!");
            return;
        }

        if (!paymentService.processPayment(userId, amount)) {
            System.out.println("Payment failed!");
            return;
        }

        String deliveryPartner = deliveryService.assignPartner(restaurant);

        notificationService.sendNotification(userId,
                "Order placed successfully! Delivery partner: " + deliveryPartner);
    }
}
