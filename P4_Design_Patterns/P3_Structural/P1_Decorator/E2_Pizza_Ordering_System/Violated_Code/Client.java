package P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Violated_Code;

import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Violated_Code.models.Pizza;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Violated_Code.models.impl.FarmhousePizza;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Violated_Code.models.impl.MargheritaPizza;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Violated_Code.models.impl.MargheritaWithCheese;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Violated_Code.models.impl.MargheritaWithCheeseAndMushroom;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E2_Pizza_Ordering_System.Violated_Code.models.impl.MargheritaWithMushroom;

public class Client {
    public static void main(String[] args) {

        // Simple base pizza
        Pizza pizza1 = new MargheritaPizza();
        System.out.println(pizza1.getDescription() + " -> ₹" + pizza1.getCost());

        // Margherita + Cheese
        Pizza pizza2 = new MargheritaWithCheese();
        System.out.println(pizza2.getDescription() + " -> ₹" + pizza2.getCost());

        // Margherita + Mushroom
        Pizza pizza3 = new MargheritaWithMushroom();
        System.out.println(pizza3.getDescription() + " -> ₹" + pizza3.getCost());

        // Margherita + Cheese + Mushroom
        Pizza pizza4 = new MargheritaWithCheeseAndMushroom();
        System.out.println(pizza4.getDescription() + " -> ₹" + pizza4.getCost());

        // Farmhouse base
        Pizza pizza5 = new FarmhousePizza();
        System.out.println(pizza5.getDescription() + " -> ₹" + pizza5.getCost());

        // 🚨 Problem starts here:
        // Want: Farmhouse + Cheese + Olives
        // But class may not exist → need to create new class manually

        // Pizza pizza6 = new FarmhouseWithCheeseAndOlives(); // may not exist ❌

        // 🚨 Another case:
        // Want: Margherita + Cheese + Olives + Jalapeno
        // → You must create a NEW class for this exact combination

        // Pizza pizza7 = new MargheritaWithCheeseOlivesJalapeno(); ❌

        // 🚨 Runtime flexibility? Impossible
        // boolean addCheese = true;
        // boolean addMushroom = false;

        // You cannot dynamically construct pizza like this:
        // Pizza dynamicPizza = new ??? ❌

    }
}
