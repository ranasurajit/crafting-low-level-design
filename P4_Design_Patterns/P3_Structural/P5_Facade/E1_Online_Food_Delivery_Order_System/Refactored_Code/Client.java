package P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code;

import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.FoodOrderFacade;
import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.services.DeliveryService;
import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.services.NotificationService;
import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.services.PaymentService;
import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.services.RestaurantService;
import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.services.UserService;
import P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.models.OrderResult;

public class Client {
    public static void main(String[] args) {
        FoodOrderFacade facade = new FoodOrderFacade(new UserService(), new RestaurantService(), new PaymentService(),
                new DeliveryService(), new NotificationService());
        String userId = "U123";
        String restaurant = "Dominos";
        double amount = 500;
        OrderResult orderResult = facade.orderFood(userId, restaurant, amount);
        System.out.println(orderResult.getMessage());
    }
}
