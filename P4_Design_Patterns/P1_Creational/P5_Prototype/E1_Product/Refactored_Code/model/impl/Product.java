package P4_Design_Patterns.P1_Creational.P5_Prototype.E1_Product.Refactored_Code.model.impl;

import P4_Design_Patterns.P1_Creational.P5_Prototype.E1_Product.Refactored_Code.model.IPrototype;

public class Product implements IPrototype<Product> {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public Product clone() {
        return new Product(this.name, this.price);
    }

    @Override
    public String toString() {
        return "Product { name:" + this.name + ", price:" + this.price + "}";
    }
}
