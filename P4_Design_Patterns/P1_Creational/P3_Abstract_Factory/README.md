# Abstract Factory Design Pattern – Learnings & Implementation

## Overview

This project demonstrates the **Abstract Factory Design Pattern** using a simple **cross-platform GUI component example**. The goal is to create **families of related UI objects (Button and Textbox)** for different operating systems **without the client depending on concrete classes**.

Supported UI families in this implementation:

* **Mac UI**
* **Windows UI**

The client selects the operating system at runtime, and the system ensures that the correct family of UI components is created.

---

# Problem Before Using Abstract Factory

Without using Abstract Factory, the client might directly instantiate concrete classes:

```java
if(osType.equals("mac")) {
    button = new MacButton();
    textbox = new MacTextbox();
}
else if(osType.equals("windows")) {
    button = new WinButton();
    textbox = new WinTextbox();
}
```

### Problems with this approach

1. **Tight Coupling**

   The client knows all concrete classes:

   * `MacButton`
   * `MacTextbox`
   * `WinButton`
   * `WinTextbox`

2. **Violation of Open Closed Principle**

   Adding support for another OS like **Linux** requires modifying client code.

3. **Risk of Mixing UI Families**

   It is possible to accidentally create:

   ```
   MacButton + WinTextbox
   ```

   which results in inconsistent UI behavior.

4. **Client Handles Object Creation**

   The client becomes responsible for both:

   * business logic
   * object creation

---

# Solution: Abstract Factory Pattern

The **Abstract Factory Pattern** provides an interface for creating **families of related objects** without specifying their concrete classes.

Instead of creating objects directly, the client works with **factory interfaces**.

---

# Architecture

## Abstract Products

Interfaces that define UI components.

```
IButton
ITextbox
```

## Concrete Products

Platform-specific implementations.

```
MacButton
MacTextbox
WinButton
WinTextbox
```

## Abstract Factory

Factory interface responsible for creating UI components.

```
IGUIFactory
 ├── createButton()
 └── createTextbox()
```

## Concrete Factories

Factories responsible for creating platform-specific components.

```
MacGUIFactory
WinGUIFactory
```

Each factory ensures that **objects from the same family are created together**.

## Factory Provider

```
GUIFactoryProvider
```

This class determines which concrete factory should be used based on the OS type.

## Client

The client interacts only with:

```
IGUIFactory
IButton
ITextbox
```

It has **no knowledge of concrete classes**.

---

# UML Structure (Conceptual)

```
             IGUIFactory
            /          \
     MacGUIFactory   WinGUIFactory
         |      |        |      |
         |      |        |      |
     MacButton MacTextbox WinButton WinTextbox
          ^         ^          ^        ^
          |         |          |        |
       IButton   ITextbox   IButton  ITextbox

                GUIFactoryProvider
                         |
                       Client
```

---

# Runtime Flow

1. User inputs OS type.

2. The input is converted to an `OSTypeEnum`.

3. `GUIFactoryProvider` returns the appropriate factory.

4. The factory creates UI components.

5. The client uses the components through interfaces.

Example execution flow:

```
User Input -> OSTypeEnum
               |
               v
      GUIFactoryProvider
               |
               v
           IGUIFactory
           /        \
     createButton  createTextbox
           |             |
           v             v
        IButton       ITextbox
```

---

# Key Learnings

## 1. Abstract Factory Creates Families of Objects

The pattern is useful when multiple objects belong to a **single logical family**.

Example:

```
Mac UI Family
    MacButton
    MacTextbox

Windows UI Family
    WinButton
    WinTextbox
```

The factory guarantees that the correct combinations are used.

---

## 2. Client Should Depend Only on Interfaces

The client interacts only with:

```
IGUIFactory
IButton
ITextbox
```

This removes dependency on concrete classes.

---

## 3. Runtime Factory Selection Is Still Necessary

Even with Abstract Factory, **someone must decide which factory to use**.

This decision was moved to:

```
GUIFactoryProvider
```

This isolates the **creation logic from the client**.

---

## 4. Abstract Factory Works Best for Product Families

The pattern is most useful when:

* multiple related objects must be created together
* objects must remain consistent within a family

Example:

```
MacButton must be used with MacTextbox
```

The pattern enforces this constraint.

---

## 5. Abstract Factory Often Uses Other Patterns

This implementation naturally combines multiple patterns:

| Pattern          | Where Used                          |
| ---------------- | ----------------------------------- |
| Abstract Factory | `IGUIFactory`                       |
| Factory Method   | `createButton()`, `createTextbox()` |
| Simple Factory   | `GUIFactoryProvider`                |

Real-world systems often combine these patterns.

---

## 6. Benefits Achieved

### Decoupling

Client is independent of concrete classes.

### Consistency

Prevents mixing incompatible UI components.

### Extensibility

New UI families can be added easily.

Example: Adding **Linux UI**

```
LinuxButton
LinuxTextbox
LinuxGUIFactory
```

Only the provider needs to be extended.

---

# When to Use Abstract Factory

Use this pattern when:

* A system needs to create **multiple related objects**
* Objects must be **used together**
* You want to **decouple object creation from usage**
* The system must support **multiple product families**

---

# Conclusion

The Abstract Factory Pattern helps build systems that are:

* **Extensible**
* **Decoupled**
* **Consistent across product families**

By introducing **factories and product interfaces**, the client remains independent of platform-specific implementations while still allowing runtime selection of object families.

This approach is widely used in **UI frameworks, database drivers, and dependency injection frameworks**.
