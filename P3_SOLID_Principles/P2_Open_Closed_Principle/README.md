# Open/Closed Principle (OCP) — Refactoring Demo (Core Java)

A small Core Java project demonstrating the **Open/Closed Principle** (the "O" in SOLID) by refactoring a discount calculation module from conditional logic to extensible polymorphism.

> **Open/Closed Principle:** Software entities (classes, modules, functions) should be **open for extension** but **closed for modification**.

---

## ✅ Problem (OCP Violation)

In the initial version, discount calculation was implemented using `if/else` or `switch` statements based on a discount type (e.g., `STUDENT`, `FESTIVAL`, `EMPLOYEE`).

**Issues:**
- Adding a new discount type required **modifying existing code** (the conditional block).
- Increased risk of regressions with every new discount.
- Pricing logic became a hotspot for changes.

---

## ✅ Refactored Solution (OCP Compliant)

The discount logic is refactored using **polymorphism**:

- A base abstract class: `PriceCalculator`
- Each discount type becomes a separate class extending it:
  - `NormalPriceCalculator`
  - `StudentPriceCalculator`
  - `FestivalPriceCalculator`
  - `EmployeePriceCalculator`

To add a new discount:
1. Create a new subclass.
2. Override `discount()`.
3. **No changes needed in existing classes** ✅

---

## 🧱 Key Classes

### `PriceCalculator` (Base Class)
- Defines the **stable pricing algorithm** in `finalPrice(amount)`
- Leaves the discount rate to subclasses through `discount()`
- Validates amount and discount range

```java
public abstract class PriceCalculator {
    protected abstract double discount();

    public final double finalPrice(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("amount must be > 0");

        double disc = discount();
        if (disc < 0.0d || disc > 1.0d) {
            throw new IllegalStateException("discount must be between 0 and 1");
        }
        return amount - (amount * disc);
    }
}
```

---

## Subclasses (Extensions)
Each subclass only provides its discount rate:

- NormalPriceCalculator → 0.0
- StudentPriceCalculator → 0.10
- FestivalPriceCalculator → 0.20
- EmployeePriceCalculator → 0.30

---

## 📁 Suggested Project Structure

```shell
P3_SOLID_Principles/
└── P2_Open_Closed_Principle/
    └── Refactored_Code/
        ├── Main.java
        └── models/
            └── impl/
                ├── PriceCalculator.java
                ├── NormalPriceCalculator.java
                ├── StudentPriceCalculator.java
                ├── FestivalPriceCalculator.java
                └── EmployeePriceCalculator.java
```

---

## 🧪 Example Output

```shell
Final price (no discount): 1000.0
Final price (student discount): 900.0
Final price (festival discount): 800.0
Final price (employee discount): 700.0
```

---

## 📌 What This Demonstrates
- ✅ Closed for modification: The algorithm in PriceCalculator.finalPrice() does not change when new discounts are added.
- ✅ Open for extension: New discounts are supported by adding new subclasses.
- ✅ Less risk & better maintainability: No conditional branching that keeps growing.

---

## 🔗 Part of the SOLID Series

- ✅ **S** — Single Responsibility Principle *(this project)*
- ✅ **O** — Open/Closed Principle
- ⬜ **L** — Liskov Substitution Principle
- ⬜ **I** — Interface Segregation Principle
- ⬜ **D** — Dependency Inversion Principle
