# 🌉 Bridge Design Pattern

---

## 📌 Overview

The **Bridge Design Pattern** is a **structural design pattern** that decouples an abstraction from its implementation so that the two can vary independently.

---

## 🎯 Intent

> Separate **what a class does (abstraction)** from **how it does it (implementation)**.

---

## ❓ When to Use

Use the Bridge Pattern when:

* ✅ You want to avoid **class explosion** due to multiple dimensions of variation
* ✅ You have **independent hierarchies** that should evolve separately
* ✅ You want to **switch implementations at runtime**
* ✅ You want to **hide implementation details from clients**

---

## ❌ Problem Without Bridge

When two dimensions vary independently:

```id="p0n8wr"
Shape × Color
```

You might end up with:

```id="v6o2cf"
RedCircle, BlueCircle, GreenCircle
RedSquare, BlueSquare, GreenSquare
```

👉 This leads to:

* ❌ Class explosion
* ❌ Tight coupling
* ❌ Difficult maintenance

---

## ✅ Solution (Using Bridge)

Separate into two hierarchies:

```id="y3k7uv"
Abstraction  ───────►  Implementor
```

---

## 🏗️ Structure

### 🔹 1. Abstraction

Defines high-level control logic and maintains a reference to the implementor.

```java id="a1z3xp"
abstract class Abstraction {
    protected Implementor implementor;

    protected Abstraction(Implementor implementor) {
        this.implementor = implementor;
    }

    abstract void operation();
}
```

---

### 🔹 2. Refined Abstraction

Extends abstraction with specific behavior.

```java id="c4m8qt"
class RefinedAbstraction extends Abstraction {

    public RefinedAbstraction(Implementor implementor) {
        super(implementor);
    }

    @Override
    void operation() {
        implementor.operationImpl();
    }
}
```

---

### 🔹 3. Implementor

Defines the interface for implementation classes.

```java id="t8l2wd"
interface Implementor {
    void operationImpl();
}
```

---

### 🔹 4. Concrete Implementations

```java id="k5r9yu"
class ConcreteImplementorA implements Implementor {
    public void operationImpl() {
        System.out.println("Implementation A");
    }
}

class ConcreteImplementorB implements Implementor {
    public void operationImpl() {
        System.out.println("Implementation B");
    }
}
```

---

## 💡 How It Works

* Abstraction delegates work to the Implementor
* Both can evolve independently
* Client interacts only with abstraction

---

## 🚀 Example Use Cases

* 🗺️ Navigation systems (Google Maps, Apple Maps)
* 🎮 Game engines (Rendering APIs)
* 💳 Payment systems (UPI, Credit Card, Wallet)
* 📺 Remote controls (TV, Radio)
* 🖥️ Cross-platform UI frameworks

---

## ⚖️ Bridge vs Strategy

| Feature   | Bridge                                | Strategy                     |
| --------- | ------------------------------------- | ---------------------------- |
| Purpose   | Decouple abstraction & implementation | Swap algorithms              |
| Structure | Two hierarchies                       | One interchangeable behavior |
| Focus     | Structural                            | Behavioral                   |

---

## 🎯 Benefits

* ✅ Eliminates class explosion
* ✅ Promotes composition over inheritance
* ✅ Improves scalability and flexibility
* ✅ Enables runtime switching
* ✅ Follows Open/Closed Principle

---

## ⚠️ Drawbacks

* ❌ Increases complexity (more classes/interfaces)
* ❌ Requires upfront design thinking

---

## 🧠 Key Takeaways

* 🔥 Separate things that change independently
* 🔥 Prefer composition over inheritance
* 🔥 Design for scalability early
* 🔥 Avoid tight coupling between layers

---

## 🏁 Conclusion

The Bridge Pattern is ideal when dealing with **multiple dimensions of variation**, helping build systems that are **flexible, maintainable, and scalable**.

---

## 🔖 Tags

`#DesignPatterns` `#BridgePattern` `#LowLevelDesign` `#SystemDesign` `#Java` `#OOP` `#CleanArchitecture`

---
