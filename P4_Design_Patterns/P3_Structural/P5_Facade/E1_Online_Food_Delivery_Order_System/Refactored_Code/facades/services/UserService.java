package P4_Design_Patterns.P3_Structural.P5_Facade.E1_Online_Food_Delivery_Order_System.Refactored_Code.facades.services;

public class UserService {
    public boolean validateUser(String userId) {
        System.out.println("Validating user: " + userId);
        return true;
    }
}
