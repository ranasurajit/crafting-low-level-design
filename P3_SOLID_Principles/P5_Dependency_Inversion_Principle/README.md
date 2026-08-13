# Dependency Inversion Principle (DIP)

## What DIP says
The Dependency Inversion Principle (DIP) is the “D” in SOLID.

**Definition**
1. High-level modules should not depend on low-level modules. Both should depend on abstractions.
2. Abstractions should not depend on details. Details should depend on abstractions.

In simple terms: **business logic (policy) should not be tightly coupled to implementation details (database, email, SMS, APIs).**

---

## High-level vs Low-level (how I interpret it)
### High-level module (Policy)
- Contains the core business workflow/rules.
- Example: `UserRegistrationService` decides:
  - save user data
  - notify user

### Low-level module (Detail)
- Contains technical implementation details.
- Examples:
  - `MySqlUserRepository`, `MongoUserRepository` (how data is stored)
  - `EmailNotificationSender`, `SMSNotificationSender` (how notification is delivered)

---

## The DIP violation I started with
My initial issue was:

- `UserRegistrationService` directly depended on concrete classes like `MySqlUserRepository`
- and also created concrete dependencies inside itself (hard-coded `new ...()`)

Why that is a problem:
- If I change MySQL to MongoDB, I must change the service code.
- Unit testing becomes hard because the service is “wired” to real implementations.
- Business logic changes just because a low-level detail changes.

---

## How I refactored to follow DIP
### Step 1: Introduced abstractions
I created interfaces (abstractions) that represent what the service needs, not how it’s done:

- `UserRepository`
- `NotificationSender`

### Step 2: Made low-level modules implement the abstractions
Concrete implementations now “plug in” by implementing these interfaces:

- `MySqlUserRepository implements UserRepository`
- `MongoUserRepository implements UserRepository`
- `EmailNotificationSender implements NotificationSender`
- `SMSNotificationSender implements NotificationSender`

### Step 3: Injected dependencies into the high-level module
`UserRegistrationService` now depends only on interfaces and receives them via constructor injection.

I also used `Objects.requireNonNull(...)` to fail fast when dependencies are not provided.

### Step 4: Used `Main` as the composition root
`Main` is responsible for wiring concrete implementations together.  
This is the right place to use `new MySqlUserRepository()` or `new EmailNotificationSender()`.

---

## My final dependency direction (after refactor)
Before (violation):
- `UserRegistrationService -> MySqlUserRepository`
- `UserRegistrationService -> EmailSender`

After (DIP applied):
- `UserRegistrationService -> UserRepository` (interface)
- `UserRegistrationService -> NotificationSender` (interface)
- `MySqlUserRepository -> UserRepository` (implements)
- `MongoUserRepository -> UserRepository` (implements)
- `EmailNotificationSender -> NotificationSender` (implements)
- `SMSNotificationSender -> NotificationSender` (implements)

---

## What I gained (benefits I observed)
### 1) Easy swapping of implementations
I can switch from MySQL to MongoDB or from Email to SMS by changing only the wiring in `Main`.

### 2) Better testability
I can test `UserRegistrationService` using fake or mock implementations of:
- `UserRepository`
- `NotificationSender`

No real database or email/SMS system is required for unit tests.

### 3) Reduced coupling
The business workflow doesn’t care about:
- which DB is used
- which notification channel is used

It only cares that the dependency fulfills the contract (interface).

### 4) More maintainable code
Adding new DB or notification types becomes “add a new class” rather than “modify business logic.”

---

## My refactored package structure (conceptually)
Package:
- `P3_SOLID_Principles.P5_Dependency_Inversion_Principle.Refactored_Code`

Suggested organization:
- `services/`
  - `UserRepository` (interface)
  - `NotificationSender` (interface)
  - `UserRegistrationService` (high-level policy)
- `services/impl/`
  - `MySqlUserRepository`, `MongoUserRepository` (details)
  - `EmailNotificationSender`, `SMSNotificationSender` (details)
- `Main`
  - creates objects and wires them together (composition root)

---

## Key takeaway (my one-liner)
**DIP is about making business logic depend on stable abstractions, not fragile details.**
