# 📡 Observer Design Pattern — Refactoring Journey

## 🚀 Overview

This project demonstrates the evolution of a system from a tightly coupled design to a loosely coupled, scalable architecture using the **Observer Design Pattern**.

The use case models a real-world **Order Tracking System** where multiple stakeholders (Customer, Restaurant, Delivery Driver, Call Center) need to be notified whenever an order status changes.

---

## ❌ Problem Before Refactoring

Initially, the system suffers from the following issues:

* ❌ Tight coupling between `Order` and multiple stakeholders
* ❌ Adding a new stakeholder requires modifying existing code
* ❌ Violates **Open/Closed Principle**
* ❌ Hard to maintain and extend

Example problem:

```
Order directly calls:
- customer.update()
- restaurant.update()
- driver.update()
- callCenter.update()
```

👉 This leads to rigid and unscalable design.

---

## ✅ Solution: Observer Design Pattern

The Observer Pattern introduces a **publisher-subscriber model**:

* **Subject (Publisher)** → `Order`
* **Observers (Subscribers)** → `Customer`, `Restaurant`, `DeliveryDriver`, `CallCenter`

---

## 🏗️ Final Design Structure

### 1. Subject Interface

```java
public interface IObservable {
    void attach(IClient obs);
    void detach(IClient obs);
    void notifyObservers();
}
```

### 2. Observer Interface

```java
public interface IClient {
    void update(Order order);
}
```

### 3. Concrete Subject

```java
public class Order implements IObservable {
    private Set<IClient> observers = new HashSet<>();
    private int id;
    private String status;

    public Order(int id) {
        this.id = id;
        this.status = "Order Placed";
    }

    @Override
    public void attach(IClient obs) {
        observers.add(obs);
    }

    @Override
    public void detach(IClient obs) {
        observers.remove(obs);
    }

    @Override
    public void notifyObservers() {
        for (IClient obs : observers) {
            obs.update(this);
        }
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
        notifyObservers();
    }
}
```

---

## 🔄 Flow of Execution

```
1. Observers subscribe using attach()
2. Order status changes
3. notifyObservers() is triggered
4. All observers receive updated state
```

---

## 🎯 Key Learnings

### 1️⃣ Loose Coupling

* `Order` does not depend on concrete classes
* Works with abstraction (`IClient`)

### 2️⃣ Open/Closed Principle

* New observers can be added without modifying `Order`

### 3️⃣ Scalability

* Supports dynamic subscription/unsubscription

### 4️⃣ Real-world Mapping

* Event-driven systems
* Notification services
* Pub-sub architectures

---

## ⚠️ Important Fixes During Refactoring

### 🔥 Correct Order of Operations

```java
// ❌ Wrong
notifyObservers();
this.status = newStatus;

// ✅ Correct
this.status = newStatus;
notifyObservers();
```

👉 Observers must receive the **latest state**.

---

## 🧠 Design Insights

* Prefer **interfaces over concrete classes**
* Favor **composition over direct dependencies**
* Think in terms of **events and reactions**

---

## ⚡ Possible Enhancements

### 🔹 Thread Safety

```java
Set<IClient> observers = ConcurrentHashMap.newKeySet();
```

### 🔹 Safe Iteration

```java
for (IClient obs : new HashSet<>(observers)) {
    obs.update(this);
}
```

### 🔹 Better Naming (GoF Standard)

* `IObservable` → `Subject`
* `IClient` → `Observer`

---

## 📌 When to Use Observer Pattern

Use this pattern when:

* Multiple objects need to react to state changes
* You want to avoid tight coupling
* You need dynamic subscription/unsubscription

---

## 🏁 Conclusion

This refactoring journey highlights how applying the Observer Pattern:

* Improves maintainability
* Enhances extensibility
* Aligns with SOLID principles

👉 From rigid design → to flexible, event-driven architecture.

---

## 📚 Next Steps

To deepen understanding, explore:

* Strategy Pattern (behavior switching)
* Decorator Pattern (dynamic behavior extension)
* Combining Observer + Strategy in real systems (e.g., Uber, Swiggy)

---

✨ *Design patterns are not about memorizing code — they are about recognizing problems and applying proven solutions.*
