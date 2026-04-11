# 🔗 Chain of Responsibility Design Pattern — Learning Journey (Expense Approval System)

## 🚀 Overview

This document captures my hands-on learning of the **Chain of Responsibility (CoR) Design Pattern** by refactoring an expense approval system from a tightly coupled, conditional-based design to a flexible, decoupled chain of handlers.

---

## ❌ Initial Design (Without CoR)

```java
class ExpenseApprover {
    public void approveExpense(ExpenseRequest request) {
        double amount = request.getAmount();

        if (amount <= 1000) {
            System.out.println("Approved by Team Lead");
        } else if (amount <= 10000) {
            System.out.println("Approved by Manager");
        } else {
            System.out.println("Approved by Director");
        }
    }
}
```

### Problems

* ❌ Violates **Open/Closed Principle**
* ❌ Hard to extend (add VP, CFO, etc.)
* ❌ Centralized logic (God class)
* ❌ Not flexible to reorder approval flow

---

## 🎯 Goal

Refactor to:

* Decouple request handling
* Allow dynamic chaining of handlers
* Enable scalable approval hierarchy

---

## ✅ Final Design (Chain of Responsibility)

### 🧱 1. Request Class

```java
public class ExpenseRequest {
    private double amount;

    public ExpenseRequest(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
```

---

### 🔄 2. Abstract Handler

```java
public abstract class ExpenseHandler {
    protected ExpenseHandler nextHandler;

    public void setNextHandler(ExpenseHandler next) {
        this.nextHandler = next;
    }

    public void approveExpense(ExpenseRequest request) {
        if (canHandle(request)) {
            handle(request);
        } else if (nextHandler != null) {
            nextHandler.approveExpense(request);
        } else {
            throw new IllegalArgumentException("No handler found for this request");
        }
    }

    protected abstract boolean canHandle(ExpenseRequest request);
    protected abstract void handle(ExpenseRequest request);
}
```

---

### ⚙️ 3. Concrete Handlers

#### Team Lead

```java
public class TeamLeadExpenseHandler extends ExpenseHandler {
    private static final double LIMIT = 1000;

    @Override
    protected boolean canHandle(ExpenseRequest request) {
        return request.getAmount() <= LIMIT;
    }

    @Override
    protected void handle(ExpenseRequest request) {
        System.out.println("Approved by Team Lead");
    }
}
```

#### Manager

```java
public class ManagerExpenseHandler extends ExpenseHandler {
    private static final double LIMIT = 10000;

    @Override
    protected boolean canHandle(ExpenseRequest request) {
        return request.getAmount() <= LIMIT;
    }

    @Override
    protected void handle(ExpenseRequest request) {
        System.out.println("Approved by Manager");
    }
}
```

#### Director

```java
public class DirectorExpenseHandler extends ExpenseHandler {

    @Override
    protected boolean canHandle(ExpenseRequest request) {
        return request.getAmount() > 10000;
    }

    @Override
    protected void handle(ExpenseRequest request) {
        System.out.println("Approved by Director");
    }
}
```

---

### ▶️ 4. Usage Example

```java
public class Main {
    public static void main(String[] args) {
        ExpenseHandler teamLead = new TeamLeadExpenseHandler();
        ExpenseHandler manager = new ManagerExpenseHandler();
        ExpenseHandler director = new DirectorExpenseHandler();

        teamLead.setNextHandler(manager);
        manager.setNextHandler(director);

        teamLead.approveExpense(new ExpenseRequest(500));
        teamLead.approveExpense(new ExpenseRequest(5000));
        teamLead.approveExpense(new ExpenseRequest(20000));
    }
}
```

---

## UML Diagram

<img width="1122" height="528" alt="Image" src="https://github.com/user-attachments/assets/d92fbe8a-a0e0-4341-a9f3-281face9fe25" />

---

## 🧠 Key Learnings

### 1. Decoupled Request Handling

* Each handler is responsible for a specific range

### 2. Dynamic Chain Creation

* Handlers can be arranged or modified at runtime

### 3. Open/Closed Principle

* New handlers can be added without modifying existing code

### 4. Separation of Concerns

* Each class has a single responsibility

### 5. Template Method Synergy

* Common flow is centralized in the base class
* Subclasses only define decision + action

---

## 🧑‍💼 Interview Insights (What Makes This Strong)

### ✔️ Why this design is good

* Eliminates long if-else chains
* Promotes extensibility
* Follows SOLID principles (especially OCP & SRP)

### ❗ Important Edge Case

Current implementation relies on **chain order**:

```java
return request.getAmount() <= LIMIT;
```

👉 This means multiple handlers *can* technically handle the same request, but only the first one in the chain gets the chance.

### 💡 Better (Robust) Approach

Define **explicit responsibility ranges**:

```java
// Team Lead
return amount <= 1000;

// Manager
return amount > 1000 && amount <= 10000;

// Director
return amount > 10000 && amount <= 100000;
```

✅ Benefits:

* Removes dependency on chain order
* Makes responsibilities crystal clear
* Safer for future modifications

---

### 🧠 Senior-Level Insight

> "Chain order should control flow, not correctness. Each handler should independently define its responsibility."

---

## ⚠️ Mistakes Made (and Fixed)

| Mistake                      | Fix                                   |
| ---------------------------- | ------------------------------------- |
| Centralized if-else logic    | Distributed across handlers           |
| Duplicate forwarding logic   | Moved to base class (template method) |
| Hardcoded logic in one class | Decoupled into multiple handlers      |
| Magic numbers                | Replaced with constants               |

---

## 🏗️ Design Benefits

* ✅ Flexible
* ✅ Scalable
* ✅ Maintainable
* ✅ Easy to extend

---

## 🔥 Real-World Applications

* Logging frameworks (DEBUG → INFO → ERROR)
* Spring Security filter chain
* Middleware pipelines (Express.js)
* Event processing systems

---

## 🔗 Comparison with Other Patterns

| Pattern                 | Purpose                    |
| ----------------------- | -------------------------- |
| Strategy                | Choose one behavior        |
| Decorator               | Add multiple behaviors     |
| Chain of Responsibility | Pass request until handled |

---

## 🚀 Future Enhancements

* Add logging at each handler
* Support parallel approval chains
* Introduce fallback handler
* Combine with Strategy for approval policies

---

## 🏁 Summary

The Chain of Responsibility Pattern allows:

* Passing requests through multiple handlers
* Decoupling sender and receiver
* Building flexible processing pipelines

> "Avoid coupling the sender of a request to its receiver" — this is the essence of CoR.

