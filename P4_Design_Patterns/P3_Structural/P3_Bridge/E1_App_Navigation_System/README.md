# 🌉 Bridge Design Pattern — Learning Journey (Uber Navigation System)

---

## 🚀 Problem Statement

While designing an Uber-like system, I encountered a **design scalability issue** when integrating:

* 🚗 Applications → `UberRides`, `UberEats`
* 🗺️ Navigation Providers → `Google Maps`, `Apple Maps`

---

## ❌ Initial Design (Before Refactoring)

The system was tightly coupled:

```
UberRidesWithGoogleMaps
UberRidesWithAppleMaps
UberEatsWithGoogleMaps
UberEatsWithAppleMaps
```

---

### ⚠️ Problems Identified

* ❌ **Class Explosion**
  Adding a new app or map provider multiplies classes

* ❌ **Tight Coupling**
  Apps directly depended on specific map implementations

* ❌ **Code Duplication**
  Navigation logic repeated across classes

* ❌ **Poor Extensibility**
  Adding new features required modifying multiple classes

---

## 💡 Key Insight

> The abstraction (Uber App) and implementation (Navigation System) vary independently.

👉 This is a classic use case for the **Bridge Design Pattern**

---

## ✅ Refactored Design (Using Bridge Pattern)

### 🔹 Separation Achieved

| Layer                        | Responsibility                                    |
| ---------------------------- | ------------------------------------------------- |
| **Abstraction**              | Uber App (`UberApp`)                              |
| **Refined Abstraction**      | `UberRides`, `UberEats`                           |
| **Implementor**              | `NavigationSystem`                                |
| **Concrete Implementations** | `GoogleNavigationSystem`, `AppleNavigationSystem` |

---

## 🧠 Core Idea

```
UberApp  ───────►  NavigationSystem
   (has-a)              (interface)
```

👉 Decouples app logic from navigation logic

---

## 🏗️ Final Structure

### 🔸 Abstraction

```java
public abstract class UberApp {
    protected NavigationSystem navSystem;

    public void setNavigationSystem(NavigationSystem navSystem) {
        if (navSystem == null) {
            throw new IllegalArgumentException("Navigation system cannot be null");
        }
        this.navSystem = navSystem;
    }

    protected NavigationSystem getNavSystem() {
        if (navSystem == null) {
            throw new IllegalStateException("Navigation system not set");
        }
        return navSystem;
    }

    public void planRoute(String source, String destination) {
        getNavSystem().setLocations(source, destination);
    }

    public void start() {
        getNavSystem().navigate();
    }

    public void track() {
        getNavSystem().track();
    }
}
```

---

### 🔸 Implementor

```java
public interface NavigationSystem {
    void setLocations(String source, String destination);
    void navigate();
    void track();
}
```

---

### 🔸 Concrete Implementations

```java
public class GoogleNavigationSystem implements NavigationSystem {
    // Implementation
}

public class AppleNavigationSystem implements NavigationSystem {
    // Implementation
}
```

---

### 🔸 Client Usage

```java
UberApp uberEats = new UberEats();
uberEats.setNavigationSystem(new AppleNavigationSystem());
uberEats.planRoute("Pizza Store", "Cajon Street");
uberEats.start();
uberEats.track();

UberApp uberRides = new UberRides();
uberRides.setNavigationSystem(new GoogleNavigationSystem());
uberRides.planRoute("Whitefield", "M.G.Road");
uberRides.start();
uberRides.track();
```

---

## 🎯 Benefits Achieved

### ✅ 1. Independent Scalability

* Add new app → No change in navigation system
* Add new map provider → No change in apps

---

### ✅ 2. Eliminated Class Explosion

From:

```
Apps × MapProviders
```

To:

```
Apps + MapProviders
```

---

### ✅ 3. Runtime Flexibility

```java
uberApp.setNavigationSystem(new GoogleNavigationSystem());
```

---

### ✅ 4. Better Code Reuse

* Shared logic moved to base abstraction
* No duplication across subclasses

---

## ⚖️ Bridge vs Strategy (Key Understanding)

| Aspect       | Bridge                                | Strategy                     |
| ------------ | ------------------------------------- | ---------------------------- |
| Purpose      | Separate abstraction & implementation | Switch algorithms            |
| Relationship | Two independent hierarchies           | One interchangeable behavior |
| Example      | UberApp ↔ NavigationSystem            | Pricing Strategy             |

---

## 🧠 Key Learnings

* 🔥 Prefer **composition over inheritance**
* 🔥 Separate concerns that change independently
* 🔥 Avoid forcing abstraction when behavior is identical
* 🔥 Use **fail-fast validation** for better robustness
* 🔥 Naming matters → use domain-driven methods (`planRoute` vs `setLocations`)

---

## 🚧 Possible Enhancements

* ➕ Add `HereMapsNavigation`
* ➕ Add `OfflineNavigationSystem`
* ➕ Introduce `Route` model instead of raw parameters
* ➕ Combine with **Strategy Pattern** (Pricing System)

---

## 🏁 Conclusion

The Bridge Pattern helped transform a tightly coupled system into a **flexible, scalable, and maintainable architecture** by decoupling abstraction from implementation.

---

## 🔖 Tags

`#DesignPatterns` `#BridgePattern` `#LowLevelDesign` `#SystemDesign` `#Java` `#OOP` `#CleanCode`

---
