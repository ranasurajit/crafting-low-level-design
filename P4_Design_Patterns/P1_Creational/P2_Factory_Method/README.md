# Factory Method Design Pattern

## 📌 Overview

The **Factory Method Design Pattern** defines an interface for creating an object but lets subclasses decide which class to instantiate.

It promotes extensibility by delegating object creation to subclasses.

---

## 🧠 Problem It Solves

Simple Factory centralizes object creation but violates OCP when new products are added.

Factory Method solves this by:

* Removing conditional logic
* Using inheritance and polymorphism
* Allowing new products without modifying existing code

---

## 🏗 Structure

* **Product Interface** → `ILogger`
* **Concrete Products** → `DebugLogger`, `InfoLogger`, `ErrorLogger`
* **Creator Interface** → `ILoggerFactory`
* **Concrete Factories** → `DebugLoggerFactory`, `InfoLoggerFactory`, `ErrorLoggerFactory`
* **Client** → Depends only on abstraction (`ILoggerFactory`)

---

## 🔄 Flow

1. Client receives an `ILoggerFactory`
2. Calls `createLogger()`
3. Concrete factory decides which logger to create
4. Returns abstraction (`ILogger`)

---

## ✅ Advantages

* Satisfies Open/Closed Principle
* Eliminates switch-case logic
* Supports polymorphism
* Easily extensible (add new logger + new factory)

---

## ❌ Trade-Offs

* Increases number of classes
* Client still needs a mechanism to select the correct factory
* Concrete factory knowledge must exist at composition root

---

## 🧠 Important Architectural Insight

Factory Method solves product extensibility, NOT factory selection.

To avoid client knowing concrete factories:

* Use Dependency Injection
* Use configuration-based wiring
* Use a DI container (e.g., Spring)

Concrete knowledge should exist only in the composition root.

---

## 🎯 When To Use

* When new product types are expected frequently
* When adhering strictly to OCP
* When building scalable, maintainable systems

---

## 💡 My Key Learnings

* Static methods cannot be used in Factory Method because polymorphism is required.
* Factory Method relies on inheritance and method overriding.
* Client should depend on abstractions, not concrete factories.
* Dependency Injection complements Factory Method in real-world systems.

---

## 🚀 Takeaways

* Factory Method is an evolution of Simple Factory.
* It pushes object creation responsibility to subclasses.
* Proper use requires understanding composition root and dependency inversion.

---

## 📌 Final Verdict

Factory Method provides extensibility and OCP compliance. Combined with Dependency Injection, it forms the foundation of modern scalable architectures.


