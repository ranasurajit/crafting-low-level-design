# ☕ Decorator Design Pattern — Refactoring Journey

## 🚀 Overview

This document captures my hands-on learning and refactoring journey for understanding the **Decorator Design Pattern** using a Coffee Ordering System example.

---

## ❌ Initial Problem (Without Decorator Pattern)

The system was originally designed using **inheritance-based combinations**:

* `EspressoWithMilk`
* `EspressoWithMilkAndSugar`
* `CappuccinoWithWhippedCream`

### Issues:

* 💥 Class explosion
* ❌ Not scalable
* ❌ Violates Open/Closed Principle
* ❌ Hard to maintain and extend

---

## 🎯 Goal

Refactor the system to:

* Support dynamic combinations of add-ons
* Avoid subclass explosion
* Follow SOLID principles
* Use **composition over inheritance**

---

## ✅ Final Design (Decorator Pattern)

### 🧱 Core Components

#### 1. Base Abstraction

```java
public abstract class Coffee {
    public abstract String getDescription();
    public abstract double getCost();
}
```

#### 2. Concrete Components

* `Espresso`
* `Cappuccino`

#### 3. Decorator Base Class

```java
public abstract class CoffeeDecorator extends Coffee {
    protected Coffee coffee;

    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public double getCost() {
        return coffee.getCost();
    }
}
```

#### 4. Concrete Decorators

* `MilkDecorator`
* `SugarDecorator`
* `CaramelDecorator`
* `WhippedCreamDecorator`

Each decorator:

* Wraps a `Coffee` object
* Adds its own behavior (cost + description)

---

## 🔄 Example Usage

```java
Coffee coffee = new CaramelDecorator(
                    new SugarDecorator(
                        new MilkDecorator(
                            new Espresso()
                        )
                    )
                );

System.out.println(coffee.getDescription());
System.out.println("Cost: ₹" + coffee.getCost());
```

---

## 🧠 Key Learnings

### 1. Composition > Inheritance

* Behavior is added dynamically
* No need for multiple subclasses

### 2. Open/Closed Principle

* Open for extension (new decorators)
* Closed for modification (existing code unchanged)

### 3. Avoid State Duplication

* Initially duplicated `Coffee` reference in child classes ❌
* Fixed by using `protected` field in base decorator ✅

### 4. Encapsulation of Logic

* Pricing logic moved inside decorators
* Avoided passing price from client

### 5. Clean Chaining

* Decorators can be nested infinitely

---

## ⚠️ Mistakes Made (and Fixed)

| Mistake                                | Fix                                           |
| -------------------------------------- | --------------------------------------------- |
| Duplicate `Coffee` field in decorators | Use inherited protected field                 |
| Passing price via constructor          | Hardcode or encapsulate cost inside decorator |
| Tight coupling with combinations       | Use dynamic wrapping                          |
| Minor naming inconsistencies           | Standardized naming                           |

---

## 🏗️ Design Benefits

* ✅ Scalable
* ✅ Flexible
* ✅ Maintainable
* ✅ Extensible (easy to add new toppings)

---

## 🔥 Real-World Applications

* Food ordering systems (Swiggy, Zomato)
* UI frameworks (adding scrollbars, borders)
* Logging frameworks
* Payment systems (adding taxes, discounts)

---

## 🚀 Future Improvements

* Support multiple quantities (e.g., double milk)
* Introduce size-based pricing (Small/Medium/Large)
* Use Strategy Pattern for dynamic pricing
* Make pricing configurable (DB/config driven)

---

## 🧾 Summary

The Decorator Pattern allows:

* Dynamic behavior addition
* Cleaner and scalable design
* Elimination of subclass explosion

This exercise reinforced practical understanding of:

* SOLID principles
* Object composition
* Real-world extensibility patterns

---

## 🏁 Final Thought

> "Favor composition over inheritance" — This pattern is a perfect demonstration of that principle.
