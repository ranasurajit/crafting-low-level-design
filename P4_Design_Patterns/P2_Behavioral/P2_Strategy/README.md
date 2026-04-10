# 💡 Strategy Design Pattern — Learning Journey (Discount System)

## 🚀 Overview

This document captures my hands-on learning of the **Strategy Design Pattern** by refactoring a discount system from a rigid, conditional-based implementation to a clean, extensible, and runtime-configurable design.

---

## ❌ Initial Design (Without Strategy Pattern)

```java
public class DiscountService {
    public double applyDiscount(String type, double price) {
        if (type.equals("FLAT")) {
            return price - 100;
        } else if (type.equals("PERCENTAGE")) {
            return price - (price * 0.10);
        } else if (type.equals("NONE")) {
            return price;
        } else {
            throw new IllegalArgumentException("Invalid type");
        }
    }
}
```

### Problems

* ❌ Violates **Open/Closed Principle**
* ❌ Hard to extend (new discount requires modifying class)
* ❌ Poor testability
* ❌ Bloated conditional logic

---

## 🎯 Goal

Refactor to:

* Encapsulate discount algorithms
* Enable **runtime switching** of discount logic
* Improve extensibility and maintainability

---

## ✅ Final Design (Strategy Pattern)

### 🧱 1. Strategy Interface

```java
public interface DiscountStrategy {
    double applyDiscount(double price);
}
```

---

### ⚙️ 2. Concrete Strategies

#### Flat Discount

```java
public class FlatDiscountStrategy implements DiscountStrategy {
    private final double discount;

    public FlatDiscountStrategy(double discount) {
        this.discount = discount;
    }

    @Override
    public double applyDiscount(double price) {
        return Math.max(0, price - discount);
    }
}
```

#### Percentage Discount

```java
public class PercentageDiscountStrategy implements DiscountStrategy {
    private final double percentage;

    public PercentageDiscountStrategy(double percentage) {
        if (percentage < 0 || percentage > 100) {
            throw new IllegalArgumentException("Invalid percentage");
        }
        this.percentage = percentage;
    }

    @Override
    public double applyDiscount(double price) {
        return Math.max(0, price - (price * percentage / 100));
    }
}
```

#### No Discount

```java
public class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double price) {
        return price;
    }
}
```

---

### 🧠 3. Context Class

```java
public class DiscountService {
    private DiscountStrategy strategy;

    public DiscountService(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    public double applyDiscount(double price) {
        return strategy.applyDiscount(price);
    }
}
```

---

### ▶️ 4. Usage Example

```java
public class ShoppingCart {
    public static void main(String[] args) {
        DiscountService service = new DiscountService(new FlatDiscountStrategy(100));
        System.out.println(service.applyDiscount(1000));

        service.setStrategy(new PercentageDiscountStrategy(20));
        System.out.println(service.applyDiscount(1000));

        service.setStrategy(new NoDiscountStrategy());
        System.out.println(service.applyDiscount(1000));
    }
}
```

---

## 🧠 Key Learnings

### 1. Encapsulation of Behavior

* Each discount logic is isolated in its own class

### 2. Open/Closed Principle

* New strategies can be added **without modifying existing code**

### 3. Runtime Flexibility

* Strategy can be changed dynamically using `setStrategy()`

### 4. Parameterized Strategies

* Strategies accept runtime parameters (e.g., percentage, flat amount)

### 5. Cleaner Code

* Eliminated `if-else` chains
* Improved readability and maintainability

---

## ⚠️ Mistakes Made (and Fixed)

| Mistake                     | Fix                               |
| --------------------------- | --------------------------------- |
| Hardcoded discount values   | Introduced constructor parameters |
| No runtime switching        | Added `setStrategy()`             |
| Risk of negative prices     | Used `Math.max(0, ...)`           |
| Non-idiomatic naming (`I*`) | Switched to `DiscountStrategy`    |

---

## 🏗️ Design Benefits

* ✅ Highly extensible
* ✅ Testable (each strategy independently)
* ✅ Maintainable
* ✅ Flexible for future requirements

---

## 🔥 Real-World Applications

* E-commerce discounts (Flipkart, Amazon)
* Payment methods (UPI, Card, Wallet)
* Ride pricing (Uber surge, pool)
* Sorting strategies

---

## 🔗 Strategy vs Decorator (Quick Comparison)

| Feature | Strategy        | Decorator          |
| ------- | --------------- | ------------------ |
| Purpose | Choose behavior | Add behavior       |
| Usage   | One at a time   | Can stack multiple |
| Example | Discount type   | Coffee add-ons     |

---

## 🚀 Future Enhancements

* Combine with **Decorator Pattern** (add-ons + discounts)
* Plug strategies via configuration (DB / config files)
* Integrate with dependency injection (Spring)

---

## 🏁 Summary

The Strategy Pattern helps in:

* Eliminating conditional logic
* Enabling runtime behavior changes
* Building scalable and maintainable systems

> "Encapsulate what varies" — Strategy Pattern is a direct application of this principle.

