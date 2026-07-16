# Single Responsibility Principle (SRP) — Refactoring Demo

A Core Java project demonstrating the **Single Responsibility Principle** (the "S" in SOLID) by refactoring a tightly-coupled "God class" into small, focused, single-purpose components.

> **Single Responsibility Principle:** A class should have one, and only one, reason to change.

---

## 📌 Problem Statement

The original `UserRegistrationService` was a **God class** handling everything:

- Input validation (username, email, password)
- Password hashing
- File persistence
- Sending welcome emails
- Logging

Any change — a new email provider, a different hashing algorithm, a switch from file to database storage — forced modifications to the **same class**, making it fragile and hard to test.

---

## 🏗️ Refactored Architecture

Each responsibility now lives in its own class with **exactly one reason to change**:

| Class | Single Responsibility | Reason to Change |
|---|---|---|
| `UserRegistrationService` | Orchestrates the registration flow | Registration workflow changes |
| `UserValidator` | Validates username | Username rules change |
| `EmailValidator` | Validates email format | Email rules change |
| `PasswordValidator` | Validates password strength | Password policy changes |
| `HashingService` | Hashes passwords | Hashing algorithm changes |
| `FileService` | Persists user data to a file | Storage format/mechanism changes |
| `NotificationService` | Sends welcome emails | Email content/provider changes |
| `LoggerService` | Logs messages with timestamps | Log format/destination changes |
| `IStorageService` (interface) | Abstraction for storage | — (enables swapping implementations) |
| `IValidator` (interface) | Abstraction for validators | — (enables new validators) |

---

## 📁 Project Structure

```
P3_SOLID_Principles/
└── P1_Single_Responsibility_Principle/
    └── Refactored_Code/
        ├── Main.java                      # Composition root — wires dependencies
        ├── models/
        │   ├── IValidator.java            # Validator abstraction
        │   └── impl/
        │       ├── UserValidator.java
        │       ├── EmailValidator.java
        │       └── PasswordValidator.java
        └── services/
            ├── UserRegistrationService.java   # Orchestrator
            ├── IStorageService.java           # Storage abstraction
            ├── LoggerService.java
            ├── HashingService.java
            ├── NotificationService.java
            └── impl/
                └── FileService.java           # File-based storage implementation
```

---

## 🔄 Registration Flow

```
Main (composition root)
   │  creates & injects all dependencies
   ▼
UserRegistrationService.register(username, email, password)
   │
   ├── LoggerService          → log start
   ├── UserValidator          → validate username
   ├── EmailValidator         → validate email
   ├── PasswordValidator      → validate password
   ├── HashingService         → hash password
   ├── IStorageService        → save user  (FileService implementation)
   ├── NotificationService    → send welcome email
   └── LoggerService          → log completion
```

---

## ✨ Key Design Decisions

1. **Orchestration, not implementation** — `UserRegistrationService` only coordinates; it delegates every actual task to a specialist class.
2. **Constructor Injection** — all dependencies are injected via the constructor (no `new` inside the service), making the class testable and loosely coupled.
3. **Depend on abstractions** — storage is accessed through the `IStorageService` interface, so swapping `FileService` for a `DatabaseService` requires **zero changes** to the registration service.
4. **Validators return `boolean`** — `isValid()` methods return `true`/`false` instead of throwing exceptions, keeping validation logic predictable and composable.
5. **Immutable dependencies** — all injected fields are `final`.

---

## ▶️ How to Run (Core Java — no build tools)

From the project root:

**Windows (PowerShell)**
```powershell
$files = Get-ChildItem -Recurse -Filter *.java src | ForEach-Object { $_.FullName }
javac -d out $files
java -cp out P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.Main
```

**Mac/Linux**
```bash
javac -d out $(find src -name "*.java")
java -cp out P3_SOLID_Principles.P1_Single_Responsibility_Principle.Refactored_Code.Main
```

> Adjust the `src` path to match where your source files live.

---

## 🧪 Sample Output

```
[2025-01-15T10:30:00] Starting registration for alice
Sending welcome EMAIL to alice@example.com (Hi alice)
[2025-01-15T10:30:00] Registration completed for alice
```

A `users.txt` file is created/appended with:
```
alice,alice@example.com,HASH(pass123)
```

---

## 📚 Lessons Learned

- SRP is about **reasons to change**, not just "small classes."
- Splitting responsibilities makes each class easier to **test, reuse, and replace**.
- Constructor injection + interfaces naturally follow from SRP and pave the way for **DIP (Dependency Inversion Principle)**.

---

## 🔗 Part of the SOLID Series

- ✅ **S** — Single Responsibility Principle *(this project)*
- ⬜ **O** — Open/Closed Principle
- ⬜ **L** — Liskov Substitution Principle
- ⬜ **I** — Interface Segregation Principle
- ⬜ **D** — Dependency Inversion Principle
