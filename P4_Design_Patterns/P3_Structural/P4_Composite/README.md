# 🌳 Composite Design Pattern — Generic Guide

---

## 📌 Overview

The **Composite Design Pattern** is a **structural design pattern** that allows you to treat **individual objects (leaf nodes)** and **compositions of objects (composite nodes)** **uniformly**.

It is commonly used to represent **tree-like hierarchical structures**.

---

## 💡 Intent

> Compose objects into tree structures to represent part-whole hierarchies.  
> Composite lets clients treat individual objects and compositions uniformly.

---

## 🧠 Key Idea

Instead of handling objects differently based on their type:

```java
if (object instanceof Leaf) { ... }
else if (object instanceof Composite) { ... }
```

Define a **common interface**, and both:
- Leaf (single object)
- Composite (group of objects)

implement it.

---

## 🧩 Structure

### 🔹 1. Component (Interface / Abstract Class)

```java
public interface Component {
    void operation();
}
```

---

### 🔹 2. Leaf

```java
public class Leaf implements Component {
    @Override
    public void operation() {
        System.out.println("Leaf operation");
    }
}
```

---

### 🔹 3. Composite

```java
import java.util.ArrayList;
import java.util.List;

public class Composite implements Component {
    private List<Component> children = new ArrayList<>();

    public void add(Component component) {
        children.add(component);
    }

    public void remove(Component component) {
        children.remove(component);
    }

    @Override
    public void operation() {
        for (Component child : children) {
            child.operation();
        }
    }
}
```

---

## 🧪 Example Usage

```java
public class Client {
    public static void main(String[] args) {
        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();

        Composite composite = new Composite();
        composite.add(leaf1);
        composite.add(leaf2);

        Composite root = new Composite();
        root.add(composite);

        root.operation();
    }
}
```

---

## 🔥 Key Characteristics

- 🌳 Represents **tree structures**
- 🔁 Uses **recursive composition**
- 🎯 Enables **uniform treatment**
- ❌ Eliminates `instanceof` checks
- 🔄 Promotes **polymorphism**

---

## ✅ Advantages

- ✔️ Simplifies client code  
- ✔️ Supports recursive structures naturally  
- ✔️ Easy to extend (Open/Closed Principle)  
- ✔️ Reduces conditional complexity  

---

## ❌ Disadvantages

- ❗ Can make design overly generic  
- ❗ Hard to restrict operations (e.g., leaf vs composite)  
- ❗ May blur responsibilities if not designed carefully  

---

## 📌 When to Use

Use Composite Pattern when:

- You are working with **hierarchical/tree structures**
- You want **uniform operations across objects**
- You want to avoid:
  - type checking (`instanceof`)
  - complex conditional logic

---

## 📊 Complexity

| Operation | Complexity |
|----------|------------|
| add() | O(1) |
| remove() | O(n) |
| traversal | O(n) |

---

## 🌍 Real-World Examples

- 📁 File Systems (Files & Folders)  
- 🧱 UI Components (Buttons, Panels)  
- 🏢 Organization Hierarchies  
- 🍔 Menu Systems  
- 🎮 Game Scene Graphs  

---

## 🧠 Design Principles Used

- ✔️ Open/Closed Principle  
- ✔️ Single Responsibility Principle  
- ✔️ Composition over Inheritance  
- ✔️ Polymorphism  

---

## ⚠️ Best Practices

- ❌ Do not expose internal child collections  
- ✔️ Provide controlled methods (`add/remove`)  
- ✔️ Use immutability where possible  
- ✔️ Avoid redundant null checks  

---

## 🏁 Conclusion

The Composite Design Pattern simplifies **hierarchical systems** by allowing clients to treat **individual objects and compositions uniformly**, resulting in cleaner and more maintainable code.
