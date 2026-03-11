# Prototype Design Pattern

## 📌 Overview

The **Prototype Design Pattern** is a **creational design pattern** that allows objects to be **copied or cloned without exposing their internal structure**.

Instead of creating new objects using constructors, the client creates new objects by **cloning an existing instance (prototype)**.

This is useful when:

* Object creation is **expensive**
* Objects have **many fields**
* We want to **avoid constructor duplication**
* We want to **decouple object creation from the client**

---

# 🚨 Problem Without Prototype

Consider a simple `Product` class:

```java
public class Product {
    private String name;
    private double price;
}
```

Without Prototype, the client must manually copy fields to duplicate objects:

```java
Product product1 = new Product("Laptop", 999.99);

Product copy = new Product(
    product1.getName(),
    product1.getPrice()
);
```

### Problems

❌ Client must know the **internal structure of the object**

❌ Tight coupling between client and product fields

❌ If fields increase, duplication logic increases

❌ Violates **Encapsulation**

Example when object grows:

```java
new Product(
    p.getName(),
    p.getPrice(),
    p.getCategory(),
    p.getManufacturer(),
    p.getDiscount(),
    p.getRating()
);
```

The client becomes **responsible for object copying**, which is bad design.

---

# ✅ Solution — Prototype Pattern

Instead of copying fields manually, objects **clone themselves**.

The client simply calls:

```java
Product newProduct = product.clone();
```

The **object itself knows how to duplicate its state**.

---

# 🏗 Implementation

## 1️⃣ Prototype Interface

```java
public interface IPrototype<T> {
    T clone();
}
```

Defines the cloning contract.

---

## 2️⃣ Concrete Prototype

```java
public class Product implements IPrototype<Product> {

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

    @Override
    public Product clone() {
        return new Product(this.name, this.price);
    }
}
```

The object **duplicates itself**.

---

## 3️⃣ Client Code

```java
public class Client {

    public static void main(String[] args) {

        Product product1 = new Product("Laptop", 999.99);
        Product product2 = new Product("Smartphone", 499.99);

        Product newProduct1 = product1.clone();
        Product newProduct2 = product2.clone();

        System.out.println("Original Products:");
        product1.display();
        product2.display();

        System.out.println("\nCopied Products:");
        newProduct1.display();
        newProduct2.display();
    }
}
```

---

# 📊 UML Diagram

```
        <<interface>>
        IPrototype<T>
        ----------------
        + clone() : T
              ▲
              │
              │ implements
              │
           Product
      ----------------------
      - name : String
      - price : double
      ----------------------
      + clone() : Product
      + display() : void
              ▲
              │ uses
              │
           Client
```

---

# ⚙️ Execution Flow

```
Client
   ↓
Create Product
   ↓
clone()
   ↓
New Product Instance
```

Example:

```
product1 → Product(Laptop, 999.99)
product2 → Product(Laptop, 999.99)
```

Two **independent objects**.

---

# 🧠 Key Learnings

### 1️⃣ Encapsulation is preserved

Before:

```
Client copies object fields
```

After:

```
Object copies itself
```

---

### 2️⃣ Client is decoupled from object structure

Client only calls:

```java
clone()
```

No knowledge of internal fields.

---

### 3️⃣ Useful for complex objects

Prototype is valuable when objects contain:

* Many fields
* Nested objects
* Expensive initialization logic

---

### 4️⃣ Two Types of Copying

#### Shallow Copy

Copies primitive values and references.

Example:

```
String
int
double
```

#### Deep Copy

Copies **entire object graph**.

Example:

```
Product
 ├─ Manufacturer
 └─ Address
```

---

# ⚖️ Advantages

✔ Eliminates complex constructor duplication

✔ Preserves encapsulation

✔ Faster object creation in some cases

✔ Reduces coupling between client and classes

---

# ⚠️ Disadvantages

❌ Cloning complex objects can be tricky

❌ Deep copy logic may be complicated

❌ Debugging cloned objects may be harder

---

# 🧩 When to Use Prototype

Use Prototype when:

* Object creation is **expensive**
* Objects have **many configuration fields**
* You need **object templates**
* System needs **runtime object duplication**

---

# 🌍 Real World Examples

Prototype pattern appears in:

### Game Development

Cloning characters or enemies.

### UI Frameworks

Duplicating UI component templates.

### Network Configuration

Cloning device configurations.

### Document Editors

Duplicating document templates.

---

# 🏁 Conclusion

The **Prototype Pattern** provides a clean way to **create new objects by cloning existing ones**.

Instead of exposing object structure to the client, the object itself manages how it should be copied.

This leads to:

* Better **encapsulation**
* Lower **coupling**
* Cleaner **object creation logic**

---

# 📚 Related Creational Patterns

* **Factory Method**
* **Abstract Factory**
* **Builder**
* **Singleton**

These patterns often work together to manage **object creation in scalable systems**.
