# 🧩 Proxy Design Pattern

## 📌 Overview
The **Proxy Design Pattern** is a structural design pattern that provides a **surrogate (placeholder) for another object** to control access to it.

Instead of interacting directly with the real object, the client interacts with a **proxy**, which manages access, adds logic, or optimizes performance.

---

## 🎯 Intent
> Control access to an object while adding additional behavior such as **lazy loading, access control, caching, or logging**.

---

## 🏗️ Structure

### Components

- **Subject (Interface)**
  - Common interface for both RealSubject and Proxy

- **RealSubject**
  - The actual object that performs the core business logic

- **Proxy**
  - Controls access to the RealSubject
  - Can add extra behavior before/after delegating calls

- **Client**
  - Interacts with Proxy as if it were the RealSubject

---

## 📊 UML Representation

```text
Client → Proxy → RealSubject
           │
           └── implements Subject
```

## 🔁 How It Works

- Client calls method on Proxy
- Proxy performs:
- Access validation
- Logging / caching / checks
- Proxy delegates request to RealSubject
- Result is returned to Client

## 💡 When to Use

- When object creation is expensive
- When you need access control
- When adding cross-cutting concerns (logging, caching)
- When dealing with remote objects
- When implementing lazy initialization

## 🧠 Types of Proxy

**1. Protection Proxy**
- Controls access based on permissions

**2. Virtual Proxy**
- Delays object creation until needed

**3. Remote Proxy**
- Represents an object located remotely

**4. Smart Proxy**
- Adds additional logic (logging, caching, reference counting)

## 💻 Example (Java)

### Subject

```java
public interface VideoService {
    void playVideo(String name);
}
```

### RealSubject

```java
public class RealVideoService implements VideoService {
    @Override
    public void playVideo(String name) {
        System.out.println("Playing video: " + name);
    }
}
```

### Proxy

```java
public class ProxyVideoService implements VideoService {

    private RealVideoService realService;

    @Override
    public void playVideo(String name) {

        // Access control
        if (name.equals("premium") ) {
            System.out.println("Access Denied!");
            return;
        }

        // Lazy initialization
        if (realService == null) {
            realService = new RealVideoService();
        }

        // Delegation
        realService.playVideo(name);
    }
}
```

### Client

```java
public class Client {
    public static void main(String[] args) {
        VideoService service = new ProxyVideoService();
        service.playVideo("movie1");
    }
}
```

## ⚖️ Advantages

- ✅ Controls access to sensitive objects
- ✅ Improves performance via lazy loading
- ✅ Enables caching and optimization
- ✅ Separates cross-cutting concerns

## ❌ Disadvantages

- ❌ Adds extra layer of abstraction
- ❌ Can increase complexity
- ❌ May introduce slight latency

## 🚀 Real-World Examples
- Video streaming platforms (Netflix, YouTube)
- Database connection pooling
- API gateways / rate limiters
- Security proxies
- Virtual images in UI frameworks

## 🔑 Key Takeaways
- Proxy acts as a gatekeeper
- It enhances functionality without modifying the original object
- Focuses on control, optimization, and delegation
- Keeps client code simple and unaware of complexities

## 🏁 Final Thought

> “A Proxy stands in front — deciding if, when, and how the real work happens.”
