# 🧱 Builder Design Pattern --- Learning README

## 🚀 Overview

This document summarizes my learning of the **Builder Design Pattern**
through hands-on design and refactoring.

------------------------------------------------------------------------

## ❌ Initial Problem (Without Builder)

When designing objects like: - CPU Configurator - Food Orders

I faced: - Too many constructor parameters - Poor readability - Null
handling issues - Invalid object states

### Example Problem

``` java
new CPU("Intel", "i7", 3.4, 5.4, true, true, 16, 24, 30, 125, null, null);
```

### Issues

-   ❌ Hard to read
-   ❌ Easy to make mistakes
-   ❌ Forces null values
-   ❌ Not scalable

------------------------------------------------------------------------

## 🧠 Key Insight

There are **two types of Builder Patterns**:

### 1. GoF Builder (Director-Based)

-   Uses Director + Builder classes
-   Fixed construction steps
-   Produces predefined objects

### 2. Fluent Builder (Effective Java)

-   Uses method chaining
-   Client controls construction
-   Ideal for optional parameters

------------------------------------------------------------------------

## ⚖️ My Initial Approach

I implemented: - `CPUBuilder` (abstract) - `IntelCPUBuilder`,
`AMDCPUBuilder`, `AppleCPUBuilder` - `CPUDirector`

### What it achieved

-   Separation of construction logic
-   Encapsulation of build steps

### What it lacked

-   ❌ No flexibility
-   ❌ No immutability
-   ❌ Still used null values
-   ❌ Overuse of Director

------------------------------------------------------------------------

## ✅ Correct Approach: Fluent Builder

### Example Usage

``` java
CPU cpu = new CPU.Builder("Intel", "i7", 3.4)
                .coreCount(16)
                .threadCount(24)
                .turboBoost(5.4)
                .build();
```

------------------------------------------------------------------------

## 🔥 Advantages of Fluent Builder

-   ✅ Readable code
-   ✅ No null pollution
-   ✅ Flexible configuration
-   ✅ Supports immutability
-   ✅ Easy to extend

------------------------------------------------------------------------

## 🧱 Design Principles Applied

-   **Encapsulation**
-   **Immutability**
-   **Separation of Concerns**
-   **Single Responsibility Principle**

------------------------------------------------------------------------

## ⚠️ Important Learnings

### 1. Builder is not just syntax

It changes: - Who controls object creation - How flexible the system is

### 2. Director is not always needed

Use only when: - Construction process is fixed

### 3. Immutability is critical

Final object should not change after creation

------------------------------------------------------------------------

## 🎯 When to Use Builder Pattern

Use when: - Many optional parameters exist - Object creation is
complex - You want readable object construction - You want immutable
objects

------------------------------------------------------------------------

## 🚫 When NOT to Use

Avoid when: - Object has very few fields - No optional parameters -
Construction is simple

------------------------------------------------------------------------

## 🚀 Next Steps

-   Implement Fluent Builder for Course system
-   Explore Step Builder Pattern
-   Practice real-world LLD problems

------------------------------------------------------------------------

## 💡 Final Takeaway

> "Builder Pattern is not about avoiding constructors ---\
> it's about designing **flexible, readable, and safe object
> creation**."
