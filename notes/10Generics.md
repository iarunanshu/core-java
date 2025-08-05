## Generics in Java

This section covers Generics, a feature introduced in Java 5 that allows you to write classes, interfaces, and methods that operate on types that are specified as parameters, improving type safety and eliminating the need for explicit casting.

---

## Introduction to Generics in Java

**Generics** allow types (classes and interfaces) to be parameters when defining classes, interfaces, and methods. This is similar to how method parameters are used, but instead of parameters for values, they are parameters for types.

---

## Why We Need Generics in Java

Before generics, collections stored `Object` types, leading to:
* **Lack of Type Safety:** You could add any type of object to a collection, and the compiler couldn't catch type-related errors at compile-time.
* **Casting Issues:** Retrieving elements from collections required explicit type casting, which was verbose and prone to `ClassCastException` at runtime.
  Generics solve these problems by enforcing type checking at compile-time and removing the need for explicit casts.

---

## Generic Class in Java - Demo & Storage Generic Class

A **Generic Class** is a class that is defined with one or more type parameters. These type parameters act as placeholders for actual data types that will be specified when an object of the generic class is created.
Example: `class Box<T> { T content; }`
The demo showed how to create and use such a class, perhaps with a `Storage` class storing a generic type `T`.

---

## Generics Methods in Java - Demo & Generic Method to Swap Array Elements

A **Generic Method** is a method that introduces its own type parameters, allowing it to work with various types independently of the class it belongs to. The type parameter is placed before the return type.
Example: `public static <T> void swap(T[] array, int i, int j)`
The demo for swapping array elements effectively illustrated how a single method can operate on arrays of any type.

---

## Collections Without Generics - Demo & Collections Without Generics

This section likely served as a historical context, demonstrating the problems of using Java Collections (like `ArrayList` or `LinkedList`) *before* generics were introduced. You probably saw `Object` types being stored and the necessity for manual casting and the potential for `ClassCastException`.

---

## Covariance Demo

**Covariance** generally refers to how type parameters behave in relation to subtyping. In Java, arrays are covariant (e.g., an `Integer[]` can be assigned to an `Object[]`), but generics are *invariant* by default (e.g., `ArrayList<Integer>` cannot be assigned to `ArrayList<Object>`). This demo likely highlighted this distinction and why generics are invariant to maintain type safety.

---

## Subtype or Upper Bound Wildcards (`? extends Type`)

An **Upper Bounded Wildcard** (`? extends Type`) specifies that the type parameter can be `Type` itself or any *subtype* of `Type`. It is used when you want to **read** from a generic structure.
Example: `List<? extends Number>` can hold `List<Integer>`, `List<Double>`, etc. You can read `Number` objects from it, but you generally cannot add new elements (except `null`). This follows the **PECS (Producer-Extends, Consumer-Super)** principle.

---

## Supertype or Lower Bound Wildcards (`? super Type`)

A **Lower Bounded Wildcard** (`? super Type`) specifies that the type parameter can be `Type` itself or any *supertype* of `Type`. It is used when you want to **write** (add) to a generic structure.
Example: `List<? super Integer>` can hold `List<Integer>`, `List<Number>`, `List<Object>`. You can add `Integer` objects (or its subtypes) to it, but when reading, you can only assume they are `Object`s. This also follows the **PECS (Producer-Extends, Consumer-Super)** principle.

---

## Unbounded Wildcards (`?`)

An **Unbounded Wildcard** (`?`) means the type parameter can be any type. It's equivalent to `? extends Object`. It's typically used:
1.  When you can write a method that uses functionality provided by the `Object` class.
2.  When you don't care about the specific type argument.
    Example: `List<?>` can hold a `List` of any type. You can only read `Object`s from it, and you cannot add elements (except `null`).

---

## DETAILS OF SOURCE CODE AND PDF CONTENT

This indicates the conclusion of the section, likely pointing to where you can find the example code and supplementary materials for this module.

---

You've now covered Generics, which are vital for writing robust, type-safe, and reusable code in modern Java. Understanding wildcards is particularly important for working with Java Collections and APIs effectively. What's next on your learning journey?