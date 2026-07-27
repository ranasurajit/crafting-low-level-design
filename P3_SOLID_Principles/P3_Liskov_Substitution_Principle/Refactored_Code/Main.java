package P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Refactored_Code;

import P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Refactored_Code.impl.Penguin;
import P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Refactored_Code.impl.Sparrow;

public class Main {
    public static void main(String[] args) {
        FlyableBird sparrow = new Sparrow();
        Bird penguin = new Penguin(); // subtype substitution - LSP

        makeBirdFly(sparrow);
        System.out.println(penguin.name() + " cannot fly!");
        // makeBirdFly(penguin); // throws Compile-Time Error
    }

    private static void makeBirdFly(FlyableBird bird) {
        System.out.println("Making bird fly: " + bird.name());
        bird.fly();
        System.out.println("Done.\n");
    }
}
