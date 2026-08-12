# Interface Segregation Principle (ISP) — Refactored Java Example

## Overview
This module demonstrates the Interface Segregation Principle (ISP), the "I" in SOLID.

ISP states: **Clients should not be forced to depend on methods they do not use.**

Instead of designing one large interface that contains many unrelated operations, we split it into smaller, capability-based interfaces. Each client (service) depends only on the minimal interface it needs, and each implementation (device) implements only the capabilities it supports.

## Why ISP Matters
A common design problem is a "fat interface" that contains multiple responsibilities (for example: print, scan, fax, staple). When a class supports only one behavior (for example: print-only), it still gets forced to implement all methods, often resulting in:

- Unsupported operations (for example, throwing exceptions for methods the device cannot do)
- Empty method bodies
- Runtime failures
- Unnecessary coupling between unrelated parts of the system
- Frequent breakages when the interface changes

ISP prevents this by keeping interfaces small and focused.

## What This Refactor Demonstrates
This refactored design models office machines using capability-based interfaces:

- Printable
- Scannable
- Faxable
- Stapleable

Devices implement only the capabilities they provide:

- BasicPrinter implements Printable
- ScannablePrinter implements Printable and Scannable
- FaxablePrinter implements Printable and Faxable
- StaplePrinter implements Printable and Stapleable

Services depend only on what they use:

- PrintService depends on Printable
- ScanService depends on Scannable

## Package Location
P3_SOLID_Principles.P4_Interface_Segregation_Principle.Refactored_Code

## Suggested Folder Structure
Refactored_Code/
  Main.java

  models/
    Printable.java
    Scannable.java
    Faxable.java
    Stapleable.java

  models/impl/
    BasicPrinter.java
    ScannablePrinter.java
    FaxablePrinter.java
    StaplePrinter.java

  services/
    PrintService.java
    ScanService.java


## Capability Interfaces (ISP Applied)

```java
public interface Printable {
    void print(String document);
}
```


```java
public interface Scannable {
    void scan(String document);
}
```


```java
public interface Faxable {
    void fax(String document, String phoneNumber);
}
```


```java
public interface Stapleable {
    void staple(int pages);
}
```


```java
public interface Printable {
    void print(String document);
}
```

## Implementations

### BasicPrinter (Print-only)

```java
public class BasicPrinter implements Printable {
    @Override
    public void print(String document) {
        System.out.println("BasicPrinter printing: " + document);
    }
}
```

### ScannablePrinter (Print + Scan)
```java
public class ScannablePrinter implements Printable, Scannable {
    @Override
    public void print(String document) {
        System.out.println("ScannablePrinter printing: " + document);
    }

    @Override
    public void scan(String document) {
        System.out.println("ScannablePrinter scanning: " + document);
    }
}
```

### FaxablePrinter (Print + Fax)
```java
public class FaxablePrinter implements Printable, Faxable {
    @Override
    public void print(String document) {
        System.out.println("FaxablePrinter printing: " + document);
    }

    @Override
    public void fax(String document, String phoneNumber) {
        System.out.println("FaxablePrinter faxing: " + document + " to " + phoneNumber);
    }
}
```

### StaplePrinter (Print + Staple)
```java
public class StaplePrinter implements Printable, Stapleable {
    @Override
    public void print(String document) {
        System.out.println("StaplePrinter printing: " + document);
    }

    @Override
    public void staple(int pages) {
        System.out.println("StaplePrinter stapling " + pages + " pages");
    }
}
```

## Services (Clients) Depend Only on What They Use

### PrintService depends only on Printable
```java
public class PrintService {
    private final Printable machine;

    public PrintService(Printable machine) {
        this.machine = machine;
    }

    public void printInvoice() {
        machine.print("invoice.pdf");
    }
}
```

### ScanService depends only on Scannable
```java
public class ScanService {
    private final Scannable machine;

    public ScanService(Scannable machine) {
        this.machine = machine;
    }

    public void scan(String document) {
        machine.scan(document);
    }
}
```

### Running the Demo
```java
public class Main {
    public static void main(String[] args) {
        PrintService service = new PrintService(new BasicPrinter());
        service.printInvoice();

        ScanService scanService = new ScanService(new ScannablePrinter());
        scanService.scan("contract.pdf");
    }
}
```

### Example output:
```shell
BasicPrinter printing: invoice.pdf
ScannablePrinter scanning: contract.pdf
```

### Compile-Time Safety (Key Benefit)

This incorrect wiring will not compile (which is good):
```java
// Won't compile:
// ScanService bad = new ScanService(new BasicPrinter());
```

## Key Outcomes

### 1) No forced methods
A print-only device does not need to define scan, fax, or staple methods.

### 2) Smaller, safer dependencies
Each service depends on a minimal interface:

- PrintService does not depend on scanning, faxing, or stapling
- ScanService does not depend on printing, faxing, or stapling

This reduces coupling and makes the code easier to change safely.

### 3) Compile-time safety
Wrong wiring is caught at compile time.

Example: passing BasicPrinter into ScanService fails because BasicPrinter does not implement Scannable.

This is a major practical benefit of ISP: failures move from runtime to compile time.

## How to Run
1. Open the project in your IDE (IntelliJ IDEA or Eclipse).
2. Navigate to Main in the refactored package.
3. Run Main.

Main demonstrates:
- Printing using BasicPrinter via PrintService
- Scanning using ScannablePrinter via ScanService

## How to Extend
To add new devices, implement only the capability interfaces the device supports.

Common extensions:
- Add a scanner-only device by implementing Scannable only.
- Add a multi-function device by implementing multiple capability interfaces.
- For more flexibility, build a multi-function machine using composition (delegating printing, scanning, faxing, stapling to separate internal components).

## Summary
This refactor applies ISP by:

- Splitting a large interface into small, capability-specific interfaces
- Ensuring each class implements only what it supports
- Ensuring each client depends only on what it uses
- Preventing unsupported operations and reducing unnecessary coupling
- Improving safety by catching incorrect usage at compile time
