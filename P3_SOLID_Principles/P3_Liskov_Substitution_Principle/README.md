# Liskov Substitution Principle (LSP) — Refactoring Demo (Core Java)

This project demonstrates the **Liskov Substitution Principle** (the “L” in SOLID) using a simple `Bird` example in **Core Java** (no Maven/Gradle).

> **LSP:** If a program works with a base type, it must also work with any of its subtypes without breaking correctness.  
> In other words, **subtypes must be substitutable for their base types**.

---

## 1) Problem (LSP Violation)

In the violated version:

- The base type `Bird` defines a method `fly()`.
- `Sparrow` (a flying bird) implements `fly()` normally.
- `Penguin` (a non-flying bird) is also a `Bird`, but cannot fly, so it throws an exception in `fly()`.

### Why this violates LSP
Client code that accepts a `Bird` assumes `fly()` will work:

- Works with `Sparrow`
- Breaks with `Penguin` at runtime (exception)

That means `Penguin` is **not substitutable** for `Bird` in all contexts where `Bird` is expected.

---

## 2) Refactored Solution (LSP Compliant)

The refactor fixes the root cause: **the base contract was wrong**.

### Key change
- `Bird` no longer promises `fly()`
- Only birds that can fly extend `FlyableBird`

So:
- `Penguin` can remain a `Bird` without violating any contract
- Code that requires flying depends on `FlyableBird`, not `Bird`

This prevents incorrect substitutions **at compile time**, not runtime.

---

## 3) Refactored Design

### `Bird` (General Contract)
- Every bird has a `name()`
- No assumption that every bird can fly

### `FlyableBird` (Stronger Contract)
- Only flying birds extend this type
- Adds `fly()`

---

## 4) Project Structure (Suggested)

```text
P3_SOLID_Principles/
|
└── P3_Liskov_Substitution_Principle/
    |
    └── Refactored_Code/
        |
        ├── Main.java
        ├── Bird.java
        ├── FlyableBird.java
        └── impl/
            |
            ├── Sparrow.java
            └── Penguin.java
```

## 5) Core Idea Shown in Code

Client depends on correct abstraction
`makeBirdFly` accepts FlyableBird, not Bird:

```java
private static void makeBirdFly(FlyableBird bird) {
    System.out.println("Making bird fly: " + bird.name());
    bird.fly();
    System.out.println("Done.\n");
}
```

So this becomes a compile-time error (good!):

```java
Bird penguin = new Penguin();
// makeBirdFly(penguin); // Compile-Time Error: Penguin is not FlyableBird
```

## 6) How to Run (Core Java)

From the folder that contains your source root (commonly src):

### Mac/Linux
```shell
javac -d out $(find src -name "*.java")
java -cp out P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Refactored_Code.Main
```

### Windows (PowerShell)
```shell
$files = Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName }
javac -d out $files
java -cp out P3_SOLID_Principles.P3_Liskov_Substitution_Principle.Refactored_Code.Main
```

Adjust the package/class name if your Main package differs.

## 7) Sample Output

```shell
Making bird fly: Sparrow
Sparrow flying...
Done.

Penguin cannot fly!
```

## 8) What I Learned
- **LSP** is about **behavioral correctness**, not just inheritance.
- A base type should define **only what every subtype can truly guarantee**.
- If some subtypes cannot support a behavior, **don’t force it into the parent contract**.
- Prefer designing around capabilities (e.g., `FlyableBird`) so invalid operations are prevented at compile time.

## 9) SOLID Progress

- ✅ **S** — Single Responsibility Principle *(this project)*
- ✅ **O** — Open/Closed Principle
- ✅ **L** — Liskov Substitution Principle
- ⬜ **I** — Interface Segregation Principle
- ⬜ **D** — Dependency Inversion Principle
