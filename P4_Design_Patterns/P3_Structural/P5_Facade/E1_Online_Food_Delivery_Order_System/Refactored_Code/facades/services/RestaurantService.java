package P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.services;

public class RestaurantService {
    public boolean isRestaurantOpen(String restaurant) {
        System.out.println("Checking if " + restaurant + " is open...");
        return true;
    }
}
