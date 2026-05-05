# 🎯 Strategy Design Pattern — Payment Processing System

## 📌 Intuition

Initially, the system used **conditional logic (`if-else`)** to handle different payment methods such as Credit Card, Debit Card, and UPI.

This approach led to:

* ❌ Tight coupling between payment logic and processor
* ❌ Violation of Open/Closed Principle (OCP)
* ❌ Difficult scalability when adding new payment methods
* ❌ Poor testability and maintainability

👉 The need was to **decouple payment behavior from the processor** and make it **pluggable at runtime**.

---

## 🧠 Approach

To solve this, we applied the **Strategy Design Pattern**, which allows selecting an algorithm's behavior at runtime.

### 🔹 Key Idea

Encapsulate each payment method into a separate class and make them interchangeable.

---

## 🏗️ Design Breakdown

### 1️⃣ Strategy Interface

```java
public interface IPaymentStrategy {
    void processPayment(double amount);
}
```

---

### 2️⃣ Concrete Strategies

```java
public class CreditCardPaymentStrategy implements IPaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing CREDIT CARD payment of ₹" + amount);
    }
}
```

```java
public class DebitCardPaymentStrategy implements IPaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing DEBIT CARD payment of ₹" + amount);
    }
}
```

```java
public class UPIPaymentStrategy implements IPaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing UPI payment of ₹" + amount);
    }
}
```

---

### 3️⃣ Context Class

```java
public class PaymentProcessor {
    private IPaymentStrategy strategy;

    public void setPaymentStrategy(IPaymentStrategy strategy) {
        if (strategy == null) {
            throw new IllegalArgumentException("Payment strategy should be passed!");
        }
        this.strategy = strategy;
    }

    public void processPayment(double amount) {
        if (strategy == null) {
            throw new IllegalStateException("Payment strategy is not set!");
        }
        strategy.processPayment(amount);
    }
}
```

---

### 4️⃣ Client Code

```java
public class Client {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();

        processor.setPaymentStrategy(new CreditCardPaymentStrategy());
        processor.processPayment(1000);

        processor.setPaymentStrategy(new DebitCardPaymentStrategy());
        processor.processPayment(500);

        processor.setPaymentStrategy(new UPIPaymentStrategy());
        processor.processPayment(200);
    }
}
```

---

## 🚀 Improvements Achieved

### ✅ Eliminated Conditional Logic

Replaced `if-else` with polymorphism.

---

### ✅ Open/Closed Principle (OCP)

New payment methods can be added **without modifying existing code**.

---

### ✅ Loose Coupling

`PaymentProcessor` depends only on abstraction (`IPaymentStrategy`).

---

### ✅ Runtime Flexibility

Payment strategy can be switched dynamically.

---

### ✅ Better Testability

Each payment strategy can be tested independently.

---

## ⚠️ Trade-offs / Limitations

* Client still needs to know **concrete strategy classes**
* Slight increase in number of classes
* Requires proper initialization to avoid runtime errors

---

## 🔥 Key Learnings

* Strategy Pattern helps **encapsulate varying behavior**
* Promotes **composition over inheritance**
* Eliminates large conditional blocks
* Improves **scalability and maintainability**
* Works best when multiple algorithms exist for the same task

---

## 🚀 Future Enhancements

### 🔹 Strategy + Factory Pattern

Introduce a factory to remove client dependency on concrete strategies:

```java
PaymentStrategy strategy = PaymentStrategyFactory.getStrategy(type);
```

---

### 🔹 Use Domain Objects

Replace primitive inputs:

```java
processPayment(PaymentRequest request)
```

---

### 🔹 Add Response Handling

Return structured result:

```java
PaymentResponse processPayment(...)
```

---

### 🔹 Add Decorators

Enhance strategies with:

* Logging
* Retry mechanism
* Metrics collection

---

## 📊 Complexity

* **Time Complexity:** Depends on strategy implementation (generally O(1))
* **Space Complexity:** O(1)

---

## 🧩 Summary

The Strategy Pattern transformed the system from:

```text
Rigid, conditional-based logic ❌
```

to:

```text
Flexible, extensible, and polymorphic design ✅
```

---

## 🏁 Final Thought

> "Encapsulate what varies, and program to an interface — not an implementation."

---

## 🏷️ Tags

`#LLD` `#DesignPatterns` `#StrategyPattern` `#OCP` `#Java` `#SystemDesign` `#CleanCode`

