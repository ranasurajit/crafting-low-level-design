package P4_Design_Patterns.P1_Creational.P5_Prototype.E1_Product.Refactored_Code.model;

public interface IPrototype<T> {
    T clone();

    String toString();
}
