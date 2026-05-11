package P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code;

import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.decorators.impl.CheeseDecorator;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.decorators.impl.MushroomDecorator;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.models.FoodItem;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.models.impl.Burger;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.models.impl.FarmhousePizza;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Refactored_Code.models.impl.MargheritaPizza;

public class Client {
    public static void main(String[] args) {
        // Simple base pizza
        FoodItem pizza1 = new MargheritaPizza();
        System.out.println(pizza1.getDescription() + " -> ₹" + pizza1.getCost());

        FoodItem pizza2 = new CheeseDecorator(pizza1);
        System.out.println(pizza2.getDescription() + " -> ₹" + pizza2.getCost());

        FoodItem pizza3 = new MushroomDecorator(pizza1);
        System.out.println(pizza3.getDescription() + " -> ₹" + pizza3.getCost());

        FoodItem pizza4 = new MushroomDecorator(pizza2);
        System.out.println(pizza4.getDescription() + " -> ₹" + pizza4.getCost());

        FoodItem pizza5 = new FarmhousePizza();
        FoodItem pizza6 = new CheeseDecorator(new MushroomDecorator(pizza5));
        System.out.println(pizza6.getDescription() + " -> ₹" + pizza6.getCost());

        FoodItem burger1 = new Burger();
        System.out.println(burger1.getDescription() + " -> ₹" + burger1.getCost());

        FoodItem burger2 = new CheeseDecorator(new MushroomDecorator(burger1));
        System.out.println(burger2.getDescription() + " -> ₹" + burger2.getCost());
    }
}
