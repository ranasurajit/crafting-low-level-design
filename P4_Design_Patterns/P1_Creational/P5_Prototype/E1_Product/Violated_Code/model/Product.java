package P4_Design_Patterns.P1_Creational.P5_Prototype.E1_Product.Violated_Code.model;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void display() {
        System.out.println("Product: " + name);
        System.out.println("Price: $" + price);
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
