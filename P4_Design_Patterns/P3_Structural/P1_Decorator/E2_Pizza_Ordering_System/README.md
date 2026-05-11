# 🍕 Decorator Design Pattern — Learning Journey

## 📌 Overview
This project demonstrates my hands-on learning of the **Decorator Design Pattern** using a Pizza Ordering System scenario.

The goal was to deeply understand:
- Why traditional inheritance-based approaches fail ❌
- How Decorator enables dynamic behavior composition ✅
- How to write clean, extensible, and production-grade code 🚀

---

## ❌ Problem Statement (Without Decorator)

Initially, adding toppings required creating multiple classes like:

- `MargheritaWithCheese`
- `MargheritaWithMushroom`
- `MargheritaWithCheeseAndMushroom`
- `FarmhouseWithCheese`
- ...

### 🚨 Issues Faced

- 🔥 **Class Explosion** → 2ⁿ combinations
- ❌ Code duplication across classes
- ❌ No runtime flexibility
- ❌ Tight coupling
- ❌ Violates Open-Closed Principle

---

## ✅ Solution: Decorator Design Pattern

### 🎯 Key Idea

> Attach additional responsibilities to an object dynamically without modifying its structure.

Instead of creating multiple subclasses, we **wrap objects with decorators**.

---

## 🧱 System Design Structure

### 1️⃣ Component

```java
public interface FoodItem {
    String getDescription();
    double getCost();
}
```

### 2️⃣ Concrete Components

```java
public class MargheritaPizza implements FoodItem { ... }
public class FarmhousePizza implements FoodItem { ... }
public class Burger implements FoodItem { ... }
```

### 3️⃣ Base Decorator

```java
public abstract class FoodItemDecorator implements FoodItem {
    protected final FoodItem item;

    protected FoodItemDecorator(FoodItem item) {
        if (item == null) {
            throw new IllegalArgumentException("FoodItem cannot be null");
        }
        this.item = item;
    }
}
```

### 4️⃣ Concrete Decorators

```java
public class CheeseDecorator extends FoodItemDecorator {
    private static final double PRICE = 110.0;

    public CheeseDecorator(FoodItem item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", Cheese";
    }

    @Override
    public double getCost() {
        return item.getCost() + PRICE;
    }
}
```

```java
public class MushroomDecorator extends FoodItemDecorator {
    private static final double PRICE = 80.0;

    public MushroomDecorator(FoodItem item) {
        super(item);
    }

    @Override
    public String getDescription() {
        return item.getDescription() + ", Mushroom";
    }

    @Override
    public double getCost() {
        return item.getCost() + PRICE;
    }
}
```

### 🔄 Runtime Composition (Key Feature)

```java
FoodItem pizza = new MargheritaPizza();

pizza = new CheeseDecorator(pizza);
pizza = new MushroomDecorator(pizza);

System.out.println(pizza.getDescription());
System.out.println("₹" + pizza.getCost());
```

## UML Diagram

<img width="1940" height="1022" alt="Image" src="https://github.com/user-attachments/assets/b85151e9-5b47-424b-a3a6-3157a90451ce" />

## 💡 Key Learnings

### ✔️ 1. Composition over Inheritance
- Avoids exponential class growth
- Encourages flexible design

### ✔️ 2. Open-Closed Principle
- Open for extension
- Closed for modification

### ✔️ 3. Single Responsibility Principle
- Each decorator handles one feature

### ✔️ 4. Runtime Flexibility
- Add/remove behaviors dynamically

### ✔️ 5. Reusability
- Same decorators can be reused across:
    - Pizza 🍕
    - Burger 🍔
    - Any FoodItem

## ⚠️ Improvements Made During Refactoring

- ✅ Removed pricing from client (moved into decorators)
- ✅ Used final for immutability
- ✅ Added null safety (fail-fast design)
- ✅ Improved naming (FoodItemDecorator)
- ✅ Cleaned description formatting
- ✅ Ensured proper encapsulation

## 🧠 Interview Insights

### ❓ Why not inheritance?

→ Leads to class explosion and rigid design

### ❓ Why Decorator?

→ Enables dynamic and scalable behavior addition

### ❓ When to use?
- When behavior needs to be added dynamically
- When subclassing becomes unmanageable

### 🌍 Real-World Use Cases

- 🍕 Food ordering systems (Swiggy/Zomato)
- 📦 Pricing engines
- 🧾 Billing systems
- 🧵 Java I/O Streams
- 🖥️ UI frameworks (adding scrollbars, borders, etc.)
- 📜 Logging frameworks

## 🚀 Future Enhancements

- 🔄 Combine with Strategy Pattern (Discounts, Offers)
- 🏭 Use Factory Pattern to build decorator pipeline
- 🏗️ Introduce Builder Pattern for clean composition
- ⚙️ Config-driven dynamic topping selection

## 🎯 Final Takeaway

> Decorator Pattern helps build flexible, scalable, and maintainable systems by composing behavior dynamically at runtime instead of relying on rigid inheritance.
