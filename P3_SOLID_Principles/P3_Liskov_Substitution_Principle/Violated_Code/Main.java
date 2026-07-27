package P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Violated_Code;

import P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Violated_Code.impl.Penguin;
import P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Violated_Code.impl.Sparrow;

public class Main {
    public static void main(String[] args) {
        Bird sparrow = new Sparrow();
        Bird penguin = new Penguin(); // subtype substitution

        makeBirdFly(sparrow);
        makeBirdFly(penguin); // runtime failure -> LSP violation
    }

    private static void makeBirdFly(Bird bird) {
        System.out.println("Making bird fly: " + bird.name());
        bird.fly();
        System.out.println("Done.\n");
    }
}
