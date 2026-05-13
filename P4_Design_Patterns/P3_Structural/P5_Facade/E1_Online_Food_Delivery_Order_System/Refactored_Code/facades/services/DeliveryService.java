package P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.services;

public class DeliveryService {
    public String assignPartner(String restaurant) {
        System.out.println("Assigning delivery partner for " + restaurant);
        return "DeliveryBoy123";
    }
}
