package P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Violated_Code;

public abstract class Bird {
    public abstract String name();

    // Bad base contract: assumes all birds can fly
    public abstract void fly();
}
