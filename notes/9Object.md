You're now delving into the **`Object` class** and advanced object concepts, which are fundamental to understanding how all Java objects behave and interact! Here's a concise recap for your revision:

---

## Object Class & Advanced Object Concepts

This section explores the root of the Java class hierarchy, the `Object` class, and other crucial concepts related to object behavior, memory, and modern Java features.

---

## Introduction to the Methods in Object Class

The **`java.lang.Object` class** is the superclass of all classes in Java. Every class in Java, directly or indirectly, inherits from `Object`. It provides several common methods that all Java objects possess by default, such as `equals()`, `hashCode()`, `toString()`, `getClass()`, `clone()`, `wait()`, `notify()`, `notifyAll()`, and `finalize()`.

---

## Deep Dive on `getClass()` in Object Class

The `getClass()` method returns a `Class` object that represents the runtime class of the object. This `Class` object can then be used to get information about the class, such as its name, methods, fields, etc., a concept known as **Reflection**.

---

## Deep Dive on `hashCode()` in Object Class - Part 1 & 2

The `hashCode()` method returns an integer hash code value for the object. It's primarily used in hash-based collections like `HashMap`, `HashSet`, and `Hashtable` for efficient storage and retrieval. The contract between `equals()` and `hashCode()` is crucial: if two objects are equal according to the `equals()` method, then calling the `hashCode()` method on each of the two objects *must* produce the same integer result.

---

## Deep Dive on `equals()` in Object Class

The `equals(Object obj)` method is used to compare two objects for equality. The default implementation in `Object` simply checks for reference equality (`this == obj`). For meaningful content-based equality, you often need to **override** this method in your custom classes.

---

## Override `hashCode()` & `equals()` Methods & Override `hashCode()` & `equals()` Methods Using IntelliJ

It's a best practice to **override both `equals()` and `hashCode()` together** when you define custom equality logic for your objects. This ensures the contract mentioned above is maintained, which is vital for collections. IntelliJ IDEA provides powerful automatic generation features to help you correctly override these methods.

---

## Deep Dive on `toString()` in Object Class

The `toString()` method returns a string representation of the object. The default implementation often provides the class name followed by the object's hash code in hexadecimal (`ClassName@hashCode`). It's highly recommended to **override `toString()`** in your custom classes to provide a more meaningful and readable string representation of the object's state, which is very useful for logging and debugging.

---

## Demo of `hashCode()`, `equals()` & `toString()` Methods of String

This demo likely showed how the `String` class (which is immutable and already correctly overrides these methods) behaves when `hashCode()`, `equals()`, and `toString()` are called, illustrating their practical application.

---

## Deep Dive on `finalize()` in Object Class

The `finalize()` method (protected `void finalize() throws Throwable`) was historically called by the Garbage Collector just before an object was reclaimed from memory. It was intended for performing cleanup operations on non-Java resources.
**Important:** It is largely considered deprecated/discouraged in modern Java (since Java 9, replaced by `java.lang.ref.Cleaner`) because its execution is not guaranteed, its timing is unpredictable, and it can cause performance issues and even memory leaks.

---

## Deep Dive on `clone()` in Object Class

The `clone()` method creates and returns a copy of the object. To use `clone()`, a class must implement the `Cloneable` marker interface (otherwise, `CloneNotSupportedException` is thrown). The default `Object` class's `clone()` performs a **shallow copy**.

---

## Details About Shallow Cloning & Deep Cloning - Theory & Demo

* **Shallow Cloning:** Creates a new object, but instead of creating new copies of any *reference type* fields within the object, it copies the *references* to the original objects. Both the original and cloned objects will then share the same underlying objects for their reference type fields. This can lead to unexpected side effects if one object modifies the shared object.
* **Deep Cloning:** Creates a completely independent copy of the original object, including creating new copies of all referenced objects recursively. This ensures no shared state between the original and the clone.
  The theory explained the concepts, and the demos illustrated the difference and how to implement deep cloning.

---

## Mutable and Immutable Objects - Theory & Demo

* **Mutable Objects:** Objects whose state (the values of their fields) can be changed after they are created. (e.g., `StringBuilder`, `ArrayList`, `Date`)
* **Immutable Objects:** Objects whose state *cannot* be changed after they are created. Any operation that seems to modify an immutable object actually creates a new object with the desired changes. (e.g., `String`, wrapper classes like `Integer`, `Double`)
  The theory discussed the benefits of immutability (thread safety, security, caching) and how to design immutable classes. The demo showed examples of both.

---

## [JAVA 16] Record Classes - Part 1 & 2

Introduced as a standard feature in Java 16, **Record Classes** are a concise way to declare immutable data classes. They automatically generate boilerplate code for constructors, accessor methods (for fields), `equals()`, `hashCode()`, and `toString()`. They are ideal for plain data carriers.
Example: `public record Point(int x, int y) {}`

---

## [JAVA 10] `var` (Local Variable Type Inference) - Part 1 & 2

Introduced in Java 10, the **`var` keyword** allows for **local variable type inference**. It means you can declare local variables without explicitly specifying their type; the compiler infers the type from the initializer expression. This can lead to more concise code, especially when dealing with complex generic types.
Example: `var list = new ArrayList<String>();` (compiler infers `list` is `ArrayList<String>`).
**Important:** `var` is for local variables only, not for fields, method parameters, or return types.

---

## DETAILS OF SOURCE CODE AND PDF CONTENT

This marks the end of the section, pointing to where you can find the accompanying source code examples and supplementary materials for this module.

---

You've now covered very advanced and important aspects of Java objects, including their fundamental behavior inherited from `Object` and modern language features. This knowledge is crucial for writing efficient, correct, and modern Java code! What's next?