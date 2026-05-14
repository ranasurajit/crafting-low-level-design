# 🧩 Proxy Design Pattern — Learning Journey

## 📌 What I Built
I implemented a **Video Streaming Platform (OTT System)** where:
- Users can play videos
- Some videos are **premium**
- Videos require **heavy loading (simulated delay)**
- System optimizes performance using **caching**

---

## 🚨 Problem I Faced

Initially, direct interaction with the video service caused:

- ❌ No access control → FREE users could access premium content  
- ❌ Performance issues → Every request triggered heavy loading  
- ❌ No caching → Same video loaded multiple times  
- ❌ Tight coupling between client and service  

---

## 💡 Why Proxy Pattern?

I introduced a **Proxy layer** to act as a **gatekeeper** between the client and the real service.

---

## 🏗️ Final Design

### 🎯 Components

- `VideoService` → Interface
- `RealVideoService` → Actual heavy service
- `ProxyVideoService` → Controls access + caching
- `OTTService` → Stores metadata
- `VideoMetadata` → Holds video details
- `UserTypes` → FREE_USER / LICENSED_USER

---

## 🔁 Flow of Execution

```text
Client → Proxy → (Access Check → Cache Check → Load if needed) → Real Service
```

## 🧠 Core Logic (Proxy)

```java
@Override
public void playVideo(String videoName, UserTypes userType) {

    VideoMetadata metadata = ottService.getMediaInformation(videoName);

    if (metadata == null) {
        throw new IllegalArgumentException("Video not found: " + videoName);
    }

    // 1. Access Control
    if (metadata.getIsPremium() && userType == UserTypes.FREE_USER) {
        System.out.println("Access Denied: Premium video");
        return;
    }

    // 2. Lazy Loading (Virtual Proxy)
    if (!metadata.getIsCached()) {
        realVideoService.loadVideoFromServer(metadata);
    }

    // 3. Delegate to Real Service
    realVideoService.playVideo(videoName, userType);
}
```

## ⚡ Key Improvements I Made

### ✅ 1. Fixed Execution Flow

- Removed duplicate playback
- Ensured single responsibility

### ✅ 2. Correct Order of Operations
- Access check BEFORE heavy loading

### ✅ 3. Introduced Caching
- Avoid repeated loading using isCached

### ✅ 4. Optimized Lookup

```java
HashMap<String, VideoMetadata>
```

- Reduced lookup time → O(1)

### 🔐 Responsibilities of Proxy

- Access Control (Protection Proxy)
- Lazy Loading (Virtual Proxy)
- Caching Optimization
- Delegation to Real Service

### 🧠 Types of Proxy I Learned

#### Type	            Description
- Protection Proxy	    Restricts access (e.g., premium content)
- Virtual Proxy	        Loads object only when needed
- Remote Proxy	        Handles remote communication
- Smart Proxy	        Adds logging, caching, monitoring

## ⚖️ Pros & Cons

### ✅ Pros

- Better performance (lazy loading + caching)
- Controlled access
- Cleaner separation of concerns

### ❌ Cons

- Adds extra abstraction layer
- Slightly increases complexity

### 🚀 Real-World Examples

- Netflix / YouTube → Video streaming optimization
- Database access layers
- API rate limiting systems
- Security gateways

## 🧠 Key Takeaways

- Always validate access before heavy operations
- Proxy = Gatekeeper + Optimizer
- Avoid unnecessary object creation using lazy loading
- Cache wisely to improve performance
- Keep Proxy focused on control + delegation

## 🏁 Final Thought

“Don’t do the work unless you’re allowed — and don’t do it twice.”

## 📌 What I’d Improve Next

- Introduce Dependency Injection (remove tight coupling)
- Make caching thread-safe
- Add logging / monitoring (Smart Proxy)
- Implement Remote Proxy simulation

