# 📦 Adapter Design Pattern — Learning Journey

---

## 🧠 Problem Statement

While designing a **Notification System**, I encountered a common real-world issue:

> Different services expose **incompatible interfaces**.

### Examples:
- Email → `send(message)` ✅
- SMS → `sendSMS(phoneNumber, message)` ❌
- Push → `push(title, body)` ❌

---

## ❌ Initial Problems (Before Adapter)

### 1. Tight Coupling in Client / Manager
```java
if (type.equals("sms")) {
    LegacySMSService sms = new LegacySMSService();
    sms.sendSMS(phone, message);
}
```

---

### 2. Violation of Open-Closed Principle (OCP)

Adding a new service required modifying existing logic.

---

### 3. Inconsistent Interfaces

```
send(message)
vs
sendSMS(phone, message)
vs
push(title, body)
```

---

## 💡 Key Idea (Adapter Pattern)

Convert incompatible interfaces into a unified interface.

---

## ✅ Final Design Overview

```
Client → Manager → NotificationService → Adapters → External APIs
```

---

## 🧩 Core Components

### Target Interface
```java
public interface NotificationService {
    void send(NotificationRequest request);
}
```

### Request Object
```java
public class NotificationRequest {
    private String message;
    private String phoneNumber;
    private String title;
}
```

---

## 🎯 Key Learnings

- Adapter solves interface mismatch
- Request object solves data modeling
- Separation of concerns is critical
- Combines well with Factory pattern

---

## 🧠 Final Takeaway

Adapter Pattern + Request Object = Clean Integration Layer
