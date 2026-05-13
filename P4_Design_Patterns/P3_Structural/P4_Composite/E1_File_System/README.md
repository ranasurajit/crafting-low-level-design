# 📁 Composite Design Pattern — Learning Journey

## 🚀 Problem Statement
Design a File System where:
- Files and Folders coexist
- Folders can contain Files or other Folders
- Operations like showDetails() and getSize() work uniformly

---

## 💡 Key Insight
Treat individual objects and compositions uniformly.

---

## 🧩 Component Interface

```java
public interface FileSystemComponent {
    void showDetails();
    int getSize();
    String getName();
}
```

---

## 📄 File (Leaf)
Handles individual objects with no children.

```java
public class File implements FileSystemComponent {
    private final String name;
    private final int size;

    public File(String name, int size) {
        if (name == null) {
            throw new IllegalArgumentException("File name cannot be null!");
        }
        this.name = name;
        this.size = size;
    }

    @Override
    public void showDetails() {
        System.out.println("FILE: " + name + " : " + size + "Kb");
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public String getName() {
        return name;
    }
}
```

---

## 📂 Folder (Composite)
Contains multiple FileSystemComponent objects and delegates operations.

```java
import java.util.ArrayList;
import java.util.List;

public class Folder implements FileSystemComponent {
    private final List<FileSystemComponent> children;
    private final String name;

    public Folder(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Folder name cannot be null!");
        }
        this.name = name;
        this.children = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public void add(FileSystemComponent component) {
        if (component == null) {
            throw new IllegalArgumentException("Component cannot be null!");
        }
        children.add(component);
    }

    public void remove(FileSystemComponent component) {
        children.remove(component);
    }

    @Override
    public void showDetails() {
        System.out.println("FOLDER: " + name);
        for (FileSystemComponent component : children) {
            component.showDetails(); // polymorphic recursion
        }
    }

    @Override
    public int getSize() {
        int totalSize = 0;
        for (FileSystemComponent component : children) {
            totalSize += component.getSize();
        }
        return totalSize;
    }
}
```

---

## 📂 Client Code

```java
public class Client {
    public static void main(String[] args) {
        FileSystemComponent file1 = new File("file1.txt", 10);
        FileSystemComponent file2 = new File("file2.txt", 20);

        Folder folder1 = new Folder("Documents");
        folder1.add(file1);

        Folder folder2 = new Folder("Images");
        folder2.add(file2);

        Folder root = new Folder("Root");
        root.add(folder1);
        root.add(folder2);

        FileSystemComponent file3 = new File("file3.png", 200);
        root.add(file3);

        root.showDetails();

        System.out.println("Total Size: " + root.getSize() + " KB");
    }
}
```

---

## 🔥 Key Improvements

- Uniform treatment of File & Folder
- Recursive composition (tree structure)
- No instanceof or casting
- Encapsulation preserved (no list exposure)
- Clean polymorphism

---

## ⚠️ Mistakes Fixed

- ❌ Exposing internal list → Removed getter
- ❌ Redundant null checks → Removed
- ❌ Poor naming (addFileSystem) → Improved to add()
- ❌ Type checking → Replaced with polymorphism

---

## 📊 Complexity

- add(): O(1)
- remove(): O(n)
- traversal: O(n)

---

## 🎯 When to Use

- Tree structures (File System, UI, Org hierarchy)
- Need uniform operations across objects
- Want to avoid type-checking logic

---

## 🏁 Final Thought
> Composite simplifies hierarchical systems by treating individual objects and compositions the same way.
