# 🎯 Template Method Design Pattern

## 📌 Overview
The Template Method Design Pattern is a **behavioral design pattern** that defines the skeleton of an algorithm in a method, deferring some steps to subclasses.

👉 It allows subclasses to redefine certain steps of an algorithm **without changing its structure**.

---

## 🧠 Intuition

In many systems, we have workflows like:

Read Data → Parse Data → Process Data → Save Data

The structure remains the same, but implementation varies.

❌ Without Template Pattern:
- Code duplication
- Hard to maintain
- Violates DRY principle

✅ With Template Pattern:
- Centralized control of workflow
- Customizable steps
- Cleaner and extensible design

---

## 🏗️ Structure

### Components

1. **Abstract Class (Template)**
   - Defines the template method (final)
   - Contains abstract steps

2. **Concrete Classes**
   - Implement specific steps

3. **Template Method**
   - Defines algorithm skeleton

---

## 💻 Example (Your Implementation)

### Template Class

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
    protected abstract void saveData();
}
```

---

### Concrete Class Example

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

    protected void saveData() {
        System.out.println("Saving CSV data...");
    }
}
```

---

### Client

```java
DataProcessor processor = new CSVDataProcessor();
processor.process();
```

---

## ✅ Advantages

- Eliminates code duplication  
- Enforces algorithm structure  
- Supports Open/Closed Principle  
- Improves maintainability  
- Promotes code reuse  

---

## ⚠️ Disadvantages

- Can increase number of classes  
- Rigid algorithm structure  
- Requires careful design of steps  

---

## 🎯 When to Use

- When multiple classes share same workflow  
- When only some steps differ  
- When you want to enforce sequence  

---

## 🚫 When NOT to Use

- When workflow varies significantly  
- When flexibility is more important than structure  

---

## 🔥 Real-World Examples

- File processing systems  
- Data pipelines  
- Build systems  
- Game loops  

---

## 🔗 Related Patterns

- Strategy Pattern → interchangeable behavior  
- Factory Pattern → object creation  
- Builder Pattern → step-by-step construction  

---

## 🚀 Key Learnings

- “Don’t repeat the algorithm structure”  
- “Let subclasses handle variation”  
- “Make template method final”  
- “Separate invariant and variant parts”  

---

## 🏁 Summary

Template Method Pattern transforms code from:

❌ Duplicate workflow logic  
➡️  
✅ Reusable algorithm skeleton with flexible steps  

---

## 🏷️ Tags

#DesignPatterns #TemplateMethod #LLD #Java #CleanCode
