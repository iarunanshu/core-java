
## 💻 Object-Oriented Programming (OOP) in Java

Object-Oriented Programming (OOP) is a programming paradigm focused on "objects" rather than actions. Java is a strongly object-oriented language, built around classes and objects, and it enables key OOP principles like **Encapsulation**, **Inheritance**, **Polymorphism**, and **Abstraction**.

---

## 🧩 Core Components of a Java Class

* **Class**: A class is a **blueprint or template** for creating objects. It defines the structure (**fields/attributes**) and behavior (**methods**) that all objects of that class will have.
* **Fields (Instance Variables)**: These variables are declared within a class but outside of any method. They represent the **attributes** or **characteristics** of an object.
* **Methods**: Methods are blocks of code that define the **behavior** or **actions** an object can perform. They encapsulate a set of statements for a specific task.

---

## ✍️ Working with Methods

* **Method Signature**: This uniquely identifies a method within its class. It consists of the **method's name** and the number, type, and order of its **parameters**.
    * **Note**: The return type is **not** part of the method signature.
* **Return Statement**: Used to exit a method and optionally return a value to the caller. If a method has a non-void return type, it **must** return a value of that type.
* **Method Invocation**: To call a method, you use the syntax `objectReference.methodName(arguments);`.
* **`main` Method**: The `public static void main(String[] args)` method is the **entry point** for any Java application. The JVM looks for and executes it to start the program.

---

## 🛠️ Creating and Initializing Objects

An object is an **instance** of a class. Creating one involves two steps:

1.  **Declaration**: Declaring a reference variable of the class type (e.g., `ClassName objectName;`).
2.  **Instantiation**: Creating the actual object in memory using the `new` keyword and a constructor (e.g., `objectName = new ClassName();`).

---

## 🏗️ Constructors

* **What is a Constructor?**: A special type of method used to **initialize** a newly created object.
    * It has the same name as the class.
    * It has **no return type**.
* **Default Constructor**: If you don't define any constructors, Java automatically provides a **default (no-args)** constructor.
    * **Important**: If you define **any** constructor, the default one is **not** provided automatically. You must explicitly define it if needed.
* **Constructor Overloading**: A class can have multiple constructors as long as each has a different signature (different number, type, or order of parameters). This allows for creating objects in different initial states.
* **Constructor Chaining**: The process of one constructor calling another within the same class (using `this()`) or a superclass (using `super()`) to avoid code duplication.
* **Return Statement in a Constructor**: A `return;` statement can be used to terminate a constructor's execution early, but constructors **do not** explicitly return a value.

---

## 📦 Initialization Blocks

* **Instance Initialization Block (IIB)**:
    * A block of code inside a class that runs **every time** a new object is created.
    * It executes **before** the constructor.
    * Useful for common initialization logic shared by all constructors.
* **Static Initialization Block (SIB)**:
    * A block of code marked with the `static` keyword.
    * It executes **only once**, when the class is first loaded into the JVM.
    * Used to initialize static variables or perform one-time setup tasks.

---

## ⚡ Static Members

* **Static Variables (Class Variables)**:
    * Belong to the **class itself**, not to any specific object.
    * There's only **one copy**, shared by all instances of the class.
    * Declared using the `static` keyword.
* **Static Methods**:
    * Belong to the class and can be called directly using the class name (e.g., `ClassName.staticMethod()`) without needing an object.
    * They can only access other static members of the class directly.
* **Constant Final Static Variables**:
    * Typically defined as `public static final`.
    * `public`: Accessible from anywhere.
    * `static`: Belongs to the class.
    * `final`: The value **cannot be changed** after initialization.

---

## ❌ Null References

* `null` is a special literal that means a reference variable **does not refer to any object**.
* It signifies the **absence of an object**.
* Attempting to call a method or access a field on a `null` reference will result in a **`NullPointerException`**.