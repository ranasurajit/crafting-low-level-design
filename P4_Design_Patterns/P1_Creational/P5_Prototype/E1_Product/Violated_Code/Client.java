package P4_Design_Patterns.P1_Creational.P5_Prototype.E1_Product.Violated_Code;

import P4_Design_Patterns.P1_Creational.P5_Prototype.E1_Product.Violated_Code.model.Product;

public class Client {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 999.99);
        Product product2 = new Product("Smartphone", 499.99);

        // To create similar products we must manually copy data
        Product newProduct1 = new Product(product1.getName(), product1.getPrice());
        Product newProduct2 = new Product(product2.getName(), product2.getPrice());

        System.out.println("Original Products:");
        product1.display();
        product2.display();

        System.out.println("\nCopied Products:");
        newProduct1.display();
        newProduct2.display();
    }
}
