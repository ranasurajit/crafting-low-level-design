package P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Violated_Code.services;

public class RestaurantService {
    public boolean isRestaurantOpen(String restaurant) {
        System.out.println("Checking if " + restaurant + " is open...");
        return true;
    }
}
