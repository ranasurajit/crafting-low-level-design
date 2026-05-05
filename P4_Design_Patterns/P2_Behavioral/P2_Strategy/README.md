# 🎯 Strategy Design Pattern

## 📌 Overview

The **Strategy Design Pattern** is a **behavioral design pattern** that allows you to define a family of algorithms, encapsulate each one, and make them interchangeable at runtime.

👉 It enables selecting an algorithm’s behavior **dynamically without changing the client code**.

---

## 🧠 Intuition

Imagine a system where behavior varies based on conditions:

```text
if (type == A) → do A
else if (type == B) → do B
else → do C
```

❌ Problems:

* Violates **Open/Closed Principle (OCP)**
* Becomes hard to maintain
* Difficult to extend
* Leads to tightly coupled code

---

### 💡 Solution

Encapsulate each behavior into separate classes and make them interchangeable.

```text
Behavior → Strategy Interface → Concrete Strategies
```

---

## 🏗️ Structure

### 🔹 Components

1. **Strategy (Interface)**

   * Declares a common interface for all supported algorithms

2. **Concrete Strategies**

   * Implement the algorithm using the strategy interface

3. **Context**

   * Maintains a reference to a strategy object
   * Delegates execution to the strategy

4. **Client**

   * Chooses and sets the strategy

---

## 📊 UML Representation (Conceptual)

```text
Client -----> Context -----> Strategy (interface)
                              ▲
                              │
         ----------------------------------------
         |                |                     |
ConcreteStrategyA  ConcreteStrategyB  ConcreteStrategyC
```

---

## 💻 Generic Example (Java)

### 1️⃣ Strategy Interface

```java
public interface Strategy {
    void execute();
}
```

---

### 2️⃣ Concrete Strategies

```java
public class StrategyA implements Strategy {
    public void execute() {
        System.out.println("Executing Strategy A");
    }
}
```

```java
public class StrategyB implements Strategy {
    public void execute() {
        System.out.println("Executing Strategy B");
    }
}
```

---

### 3️⃣ Context

```java
public class Context {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Strategy cannot be null");
        }
        this.strategy = strategy;
    }

    public void performAction() {
        if (strategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        strategy.execute();
    }
}
```

---

### 4️⃣ Client

```java
public class Client {
    public static void main(String[] args) {
        Context context = new Context();

        context.setStrategy(new StrategyA());
        context.performAction();

        context.setStrategy(new StrategyB());
        context.performAction();
    }
}
```

---

## ✅ Advantages

* ✔ Eliminates complex conditional statements
* ✔ Follows **Open/Closed Principle (OCP)**
* ✔ Promotes **composition over inheritance**
* ✔ Enables **runtime behavior switching**
* ✔ Improves **testability and maintainability**

---

## ⚠️ Disadvantages

* ❌ Increases number of classes
* ❌ Client must be aware of different strategies
* ❌ Slight overhead in object creation

---

## 🎯 When to Use

Use Strategy Pattern when:

* You have **multiple ways to perform a task**
* You want to **avoid large conditional logic**
* You need **runtime flexibility**
* Algorithms can be **interchanged independently**

---

## 🚫 When NOT to Use

* When there is only **one fixed behavior**
* When added abstraction makes code unnecessarily complex

---

## 🔥 Real-World Examples

* 💳 Payment processing (Credit Card, UPI, Wallet)
* 🚗 Ride fare calculation (Mini, Sedan, SUV)
* 🧾 Discount calculation (Seasonal, Coupon-based)
* 📦 Sorting algorithms (QuickSort, MergeSort)
* 🧠 AI strategies / Game behaviors

---

## 🔗 Related Design Patterns

* **Factory Pattern** → Helps in selecting strategy without exposing client to implementations
* **Decorator Pattern** → Enhances strategies dynamically
* **State Pattern** → Similar structure but different intent (state-driven behavior)

---

## 🚀 Key Takeaways

* Encapsulate what varies
* Prefer **composition over inheritance**
* Replace conditionals with polymorphism
* Keep behavior **open for extension, closed for modification**

---

## 🏁 Summary

The Strategy Pattern transforms code from:

```text
Rigid and condition-heavy ❌
```

to:

```text
Flexible, extensible, and clean ✔
```

---

## 🏷️ Tags

`#DesignPatterns` `#StrategyPattern` `#LLD` `#OCP` `#Java` `#CleanCode` `#SystemDesign`

