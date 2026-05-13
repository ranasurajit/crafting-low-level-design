package P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades;

import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.services.DeliveryService;
import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.services.NotificationService;
import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.services.PaymentService;
import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.services.RestaurantService;
import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.services.UserService;
import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.models.OrderResult;

public class FoodOrderFacade {
    private final UserService userService;
    private final RestaurantService restaurantService;
    private final PaymentService paymentService;
    private final DeliveryService deliveryService;
    private final NotificationService notificationService;

    public FoodOrderFacade(
            UserService userService,
            RestaurantService restaurantService,
            PaymentService paymentService,
            DeliveryService deliveryService,
            NotificationService notificationService) {
        if (userService == null || restaurantService == null ||
                paymentService == null || deliveryService == null ||
                notificationService == null) {
            throw new IllegalArgumentException("Parameters cannot be null!");
        }
        this.userService = userService;
        this.restaurantService = restaurantService;
        this.paymentService = paymentService;
        this.deliveryService = deliveryService;
        this.notificationService = notificationService;
    }

    public OrderResult orderFood(String userId, String restaurant, double amount) {
        if (!userService.validateUser(userId)) {
            return new OrderResult(false, "Invalid User!");
        }
        if (!restaurantService.isRestaurantOpen(restaurant)) {
            return new OrderResult(false, "Restaurant is closed!");
        }
        if (!paymentService.processPayment(userId, amount)) {
            return new OrderResult(false, "Payment has failed!");
        }
        String deliveryPartner = deliveryService.assignPartner(restaurant);
        if (deliveryPartner == null) {
            return new OrderResult(false, "Failed to assign Delivery Partner!");
        }
        notificationService.sendNotification(userId,
                "Order placed successfully! Delivery partner: " + deliveryPartner);
        return new OrderResult(true, "Order has been placed successfully!");
    }
}
