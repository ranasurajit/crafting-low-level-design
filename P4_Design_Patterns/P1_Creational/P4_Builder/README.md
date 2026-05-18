# 🧱 Builder Design Pattern --- Complete Guide

## 📌 Definition

The **Builder Design Pattern** is a creational pattern used to construct
complex objects step-by-step, allowing different representations using
the same construction process.

------------------------------------------------------------------------

## 🧠 Intent

-   Separate **construction logic** from **representation**
-   Provide control over object creation
-   Improve readability and maintainability

------------------------------------------------------------------------

## ❗ Problem It Solves

When an object has: - Many optional parameters - Complex construction
logic - Multiple configurations

### ❌ Without Builder

``` java
new User("John", 25, "India", null, null, true, false);
```

Problems: - Poor readability - Hard to maintain - Error-prone - Forces
null values

------------------------------------------------------------------------

## ✅ Solution: Builder Pattern

### ✔ Key Idea

Construct object step-by-step instead of using large constructors.

------------------------------------------------------------------------

## 🧩 Types of Builder Pattern

### 1. 🏭 GoF Builder (Classic)

-   Uses Director + Builder classes
-   Fixed construction steps
-   Example: Meal builder, house builder

### Structure:

-   Product (CPU)
-   Builder (CPUBuilder)
-   Concrete Builder (IntelBuilder)
-   Director (CPUDirector)

------------------------------------------------------------------------

### 2. 🧱 Fluent Builder (Modern / Effective Java)

-   Uses method chaining
-   Client controls object creation
-   Most commonly used in interviews

------------------------------------------------------------------------

## 🏗️ Structure (Fluent Builder)

``` java
public class User {
    private final String name;
    private final int age;
    private final String city;

    public static class Builder {
        private String name;
        private int age;
        private String city;

        public Builder(String name) {
            this.name = name;
        }

        public Builder age(int age) {
            this.age = age;
            return this;
        }

        public Builder city(String city) {
            this.city = city;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.city = builder.city;
    }
}
```

------------------------------------------------------------------------

## 🚀 Example Usage

``` java
User user = new User.Builder("John")
                    .age(25)
                    .city("Bangalore")
                    .build();
```

------------------------------------------------------------------------

## 🔥 Advantages

-   ✅ Improves readability
-   ✅ Avoids telescoping constructors
-   ✅ Eliminates null handling issues
-   ✅ Supports immutability
-   ✅ Flexible object creation

------------------------------------------------------------------------

## ⚠️ Disadvantages

-   ❌ More boilerplate code
-   ❌ Slightly complex for simple objects

------------------------------------------------------------------------

## 🎯 When to Use

Use Builder when: - Object has many optional parameters - Object
creation is complex - You need immutable objects - You want clean API
design

------------------------------------------------------------------------

## 🚫 When NOT to Use

Avoid when: - Few parameters exist - Object creation is simple - No need
for flexibility

------------------------------------------------------------------------

## 🧠 Best Practices

-   Use **static inner Builder class**
-   Make fields **final** in main class
-   Perform **validation in build()**
-   Avoid exposing setters
-   Keep Builder methods descriptive

------------------------------------------------------------------------

## 🔄 Builder vs Other Patterns

  Pattern            Purpose
  ------------------ -------------------------------------
  Factory            Creates objects
  Builder            Builds complex objects step-by-step
  Abstract Factory   Creates families of objects

------------------------------------------------------------------------

## 💡 Real-World Examples

-   StringBuilder (Java)
-   Lombok @Builder
-   HTTP Request Builders
-   Configuration objects

------------------------------------------------------------------------

## 🏁 Final Takeaway

> "Builder Pattern is about constructing objects in a **readable,
> flexible, and safe way**, especially when dealing with optional
> parameters and complex configurations."

------------------------------------------------------------------------

## 🚀 Next Steps

-   Practice Fluent Builder
-   Learn Step Builder Pattern
-   Apply in LLD problems (Parking Lot, Splitwise, etc.)
