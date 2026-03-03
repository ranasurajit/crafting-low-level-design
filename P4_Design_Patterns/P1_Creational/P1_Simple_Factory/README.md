# Simple Factory Design Pattern

## 📌 Overview

The **Simple Factory Design Pattern** centralizes object creation logic in a single factory class. Instead of creating objects directly using `new`, the client delegates creation responsibility to a factory method.

Although not part of the original GoF 23 patterns, it is a widely used design idiom.

---

## 🧠 Problem It Solves

When object creation logic is scattered across the codebase:

* Multiple `if-else` or `switch` statements
* Tight coupling with concrete classes
* Difficult to maintain and extend

Simple Factory moves this logic into one place.

---

## 🏗 Structure

* **Product Interface** → `ILogger`
* **Concrete Products** → `DebugLogger`, `InfoLogger`, `ErrorLogger`
* **Factory Class** → `LoggerFactory`
* **Client** → Depends only on `ILogger` and `LoggerFactory`

---

## 🔄 Flow

1. Client calls `LoggerFactory.createLogger(level)`
2. Factory decides which concrete logger to instantiate
3. Factory returns abstraction (`ILogger`)
4. Client uses logger without knowing concrete implementation

---

## ✅ Advantages

* Centralized object creation
* Reduces code duplication
* Client depends on abstraction
* Cleaner structure compared to scattered conditionals

---

## ❌ Limitations

* Violates **Open/Closed Principle (OCP)**
* Adding a new logger requires modifying `LoggerFactory`
* Factory can become large with many conditions

---

## 🎯 When To Use

* Small to medium systems
* Limited number of product types
* When centralizing creation improves clarity

---

## 💡 My Key Learnings

* Simple Factory improves structure but does not fully solve extensibility.
* It reduces duplication but still requires modification for new product types.
* Using enums improves type safety over strings.
* Static factory methods are common in Simple Factory.

---

## 🚀 Takeaways

* Good first step before evolving to Factory Method.
* Helps understand separation of creation and usage.
* Useful in interview problems like Parking Lot, Payment Systems, or Notification Systems.

---

## 📌 Final Verdict

Simple Factory is a structural improvement over naive object creation, but it is not fully extensible. For OCP compliance, Factory Method is preferred.

