package P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Violated_Code;

import P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Violated_Code.model.Coffee;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Violated_Code.model.impl.CappuccinoWithMilkSugarCaramel;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Violated_Code.model.impl.CappuccinoWithWhippedCream;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Violated_Code.model.impl.Espresso;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Violated_Code.model.impl.EspressoWithMilk;
import P4_Design_Patterns.P3_Structural.P1_Decorator.E1_Coffee_Ordering_System.Violated_Code.model.impl.EspressoWithMilkAndSugar;

public class CoffeeShop {
    public static void main(String[] args) {

        Coffee order1 = new Espresso();
        System.out.println(order1.getDescription() + " = ₹" + order1.getCost());

        Coffee order2 = new EspressoWithMilk();
        System.out.println(order2.getDescription() + " = ₹" + order2.getCost());

        Coffee order3 = new EspressoWithMilkAndSugar();
        System.out.println(order3.getDescription() + " = ₹" + order3.getCost());

        Coffee order4 = new CappuccinoWithWhippedCream();
        System.out.println(order4.getDescription() + " = ₹" + order4.getCost());

        Coffee order5 = new CappuccinoWithMilkSugarCaramel();
        System.out.println(order5.getDescription() + " = ₹" + order5.getCost());
    }
}
