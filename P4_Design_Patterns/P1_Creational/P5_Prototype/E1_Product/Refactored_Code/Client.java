package P4_Design_Patterns.P1_Creational.P5_Prototype.E1_Product.Refactored_Code;

import P4_Design_Patterns.P1_Creational.P5_Prototype.E1_Product.Refactored_Code.model.impl.Product;

public class Client {
    public static void main(String[] args) {
        Product product1 = new Product("Laptop", 999.99);
        Product product2 = new Product("Smartphone", 499.99);

        // To create similar products we must manually copy data
        Product newProduct1 = product1.clone();
        Product newProduct2 = product2.clone();

        System.out.println("Original Products:");
        System.out.println(product1);
        System.out.println(product2);

        System.out.println("\nCopied Products:");
        System.out.println(newProduct1);
        System.out.println(newProduct2);
    }
}
