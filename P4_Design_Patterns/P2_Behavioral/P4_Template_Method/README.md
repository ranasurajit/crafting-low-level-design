# 🎯 Template Method Design Pattern

## 📌 Overview

The **Template Method Design Pattern** is a **behavioral design pattern** that defines the **skeleton of an algorithm** in a base class while allowing subclasses to override specific steps of the algorithm **without changing its overall structure**.

👉 It promotes **code reuse** and ensures a consistent workflow across implementations.

---

## 🧠 Intuition

Many systems follow a **fixed sequence of steps**, but the implementation of each step may vary.

### Example Workflow:

```text
Read Data → Parse Data → Process Data → Save Data
```

❌ Without Template Pattern:

* Duplicate code across classes
* Hard to maintain
* Violates DRY principle

✅ With Template Pattern:

* Common workflow defined once
* Steps customized in subclasses
* Clean and extensible design

---

## 🏗️ Structure

### 🔹 Key Components

1. **Abstract Class (Template Class)**

   * Defines the template method (final)
   * Declares abstract methods for steps

2. **Template Method**

   * Defines the algorithm skeleton
   * Calls step methods in order

3. **Concrete Classes**

   * Implement specific steps

---

## 📊 UML (Conceptual)

```text
AbstractClass
 ├── templateMethod()  ← defines algorithm
 ├── step1() (abstract)
 ├── step2() (abstract)
 └── step3() (concrete/optional)

        ▲
        │
 -------------------------
 |                       |
ConcreteA           ConcreteB
```

---

## 💻 Generic Example (Java)

### 1️⃣ Template Class

```java
public abstract class DataProcessor {

    public final void process() {
        readData();
        parseData();
        processData();
        saveData();
    }

    protected abstract void readData();
    protected abstract void parseData();
    protected abstract void processData();

    protected void saveData() {
        System.out.println("Saving data (default implementation)");
    }
}
```

---

### 2️⃣ Concrete Implementation

```java
public class CSVDataProcessor extends DataProcessor {

    protected void readData() {
        System.out.println("Reading CSV data...");
    }

    protected void parseData() {
        System.out.println("Parsing CSV data...");
    }

    protected void processData() {
        System.out.println("Processing CSV data...");
    }
}
```

---

### 3️⃣ Client

```java
public class Client {
    public static void main(String[] args) {
        DataProcessor processor = new CSVDataProcessor();
        processor.process();
    }
}
```

---

## ✅ Advantages

* ✔ Eliminates code duplication
* ✔ Enforces a fixed algorithm structure
* ✔ Supports **Open/Closed Principle (OCP)**
* ✔ Promotes **code reuse**
* ✔ Improves maintainability

---

## ⚠️ Disadvantages

* ❌ Can increase number of classes
* ❌ Rigid algorithm structure
* ❌ Changes in template affect all subclasses

---

## 🎯 When to Use

Use Template Method Pattern when:

* Multiple classes share the **same workflow**
* Only certain steps differ
* You want to enforce **execution order**
* You need **centralized control of logic**

---

## 🚫 When NOT to Use

* When algorithm steps vary significantly
* When flexibility is more important than structure
* When subclassing becomes too complex

---

## 🔥 Real-World Examples

* Data processing pipelines
* File parsing systems
* Game engines (game loop)
* Build systems
* ETL workflows

---

## 🔗 Related Design Patterns

* **Strategy Pattern** → changes behavior dynamically
* **Factory Pattern** → handles object creation
* **Builder Pattern** → step-by-step object construction

---

## 🚀 Key Takeaways

* Define the **algorithm once**, reuse everywhere
* Separate **invariant (fixed)** and **variant (custom)** parts
* Use `final` for template method
* Prefer abstraction for flexibility

---

## 🏁 Summary

Template Method Pattern transforms:

```text
Duplicate logic across classes ❌
```

into:

```text
Reusable algorithm skeleton with flexible steps ✅
```

---

## 🏷️ Tags

`#DesignPatterns` `#TemplateMethod` `#LLD` `#Java` `#OCP` `#CleanCode`

