A Java Class is a blueprint or a template for creating objects. It defines the structure (fields/attributes) and behavior (methods) that all objects of that class will have.

Instance variables are variables declared within a class but outside of any method, constructor, or block. They represent the attributes or characteristics of an object.

A Constructor is a special type of method used to initialize a newly created object. It has the same name as the class and no return type
If you don't define any constructor in your class, Java automatically provides a default (or no-args) constructor. However, if you define any constructor (even one with arguments), the default constructor is not automatically provided, and you'll need to explicitly define it if you still want a no-args option.

Constructor Chaining in Java
    Constructor Chaining is the process of one constructor calling another constructor within the same class (using this()) or a superclass constructor (using super()). This helps avoid code duplication during object initialization.

Instance Initialization Block
    (IIB) is a block of code within a class that is executed every time a new instance (object) of the class is created, before the constructor is called. It's useful for common initialization logic for all constructors.

Static variables (or class variables) belong to the class itself, rather than to any specific object. There's only one copy of a static variable, shared by all instances of the class. They are declared using the static keyword.

You're diving deep into the core of Java with Object-Oriented Programming (OOP)! Here's a concise recap of these crucial topics for your revision:

Object-Oriented Programming (OOP) in Java
Object-Oriented Programming (OOP) is a programming paradigm that organizes software design around "objects" rather than "actions" and data rather than logic. Java is a strongly object-oriented language, meaning it's built around the concepts of classes and objects, enabling key OOP principles like Encapsulation, Inheritance, Polymorphism, and Abstraction.

So, What is a Java Class? & Demo of Creating a Java Class
A Java Class is a blueprint or a template for creating objects. It defines the structure (fields/attributes) and behavior (methods) that all objects of that class will have. The demo showed how to define a class using the class keyword.

Declaring Fields in a Java Class - Theory & Demo
Fields (or instance variables) are variables declared within a class but outside of any method, constructor, or block. They represent the attributes or characteristics of an object. The theory explained their purpose, and the demo showed how to declare them within a class.

Introduction to Methods in Java - Part 1 & 2 & Demo of Java Methods
Methods are blocks of code that define the behavior or actions an object can perform. They encapsulate a set of statements to perform a specific task. The introduction covered their structure (return type, name, parameters) and purpose, and the demos illustrated their creation and invocation.

Introduction to Method Signature
The method signature uniquely identifies a method within its class. It consists of the method's name and the number, type, and order of its parameters. The return type is NOT part of the method signature.

Purpose of a Return Statement in Java Methods
The return statement is used to exit from a method and optionally return a value to the caller. If the method has a non-void return type, it must return a value of that type.

Syntax of Method Invocation in Java
To call or invoke a method, you use the object's reference followed by the dot operator and the method call: objectReference.methodName(arguments);

Let’s Say Hi to Main Method Again
The main method (public static void main(String[] args)) is the entry point for any Java application. When you run a Java program, the Java Virtual Machine (JVM) looks for and executes the main method.

How to Create & Initialize Java Objects - Theory & Demo
An object is an instance of a class. Creating an object involves two steps:

Declaration: Declaring a reference variable of the class type (e.g., ClassName objectName;).

Instantiation: Creating the actual object in memory using the new keyword and a constructor (e.g., objectName = new ClassName();).
Initialization often happens during instantiation or via methods. The theory explained this, and the demo provided practical examples.

Introduction to Constructor in Java & Demo of Constructor in Java & Introduction to Debugging
A Constructor is a special type of method used to initialize a newly created object. It has the same name as the class and no return type. The demo showed how to define and use constructors, and this section also introduced debugging, a crucial skill for finding and fixing errors in code.

Problem with Default or No-Args Constructor
If you don't define any constructor in your class, Java automatically provides a default (or no-args) constructor. However, if you define any constructor (even one with arguments), the default constructor is not automatically provided, and you'll need to explicitly define it if you still want a no-args option.

Constructor Overloading in Java
Constructor Overloading allows a class to have multiple constructors, provided each has a different signature (different number, type, or order of parameters). This enables creating objects with different initial states.

Constructor Chaining in Java
Constructor Chaining is the process of one constructor calling another constructor within the same class (using this()) or a superclass constructor (using super()). This helps avoid code duplication during object initialization.

Usage of Return Statement in Constructor
A return statement without an expression (i.e., just return;) can be used in a constructor to terminate the constructor's execution early. However, constructors do not explicitly return a value.

Instance Initialization Block in Java Class - Part 1 & 2
An Instance Initialization Block (IIB) is a block of code within a class that is executed every time a new instance (object) of the class is created, before the constructor is called. It's useful for common initialization logic for all constructors.

Introduction to Static Variables in Java - Theory & Demo
Static variables (or class variables) belong to the class itself, rather than to any specific object. There's only one copy of a static variable, shared by all instances of the class. They are declared using the static keyword. The demo showed their usage and shared nature.

How to Define Constant Final Static Variables
A constant in Java is typically defined as a public static final variable.
    public: Accessible from anywhere.
    static: Belongs to the class, not an object.
    final: Its value cannot be changed after initialization.

Static methods belong to the class and can be called directly using the class name (e.g., ClassName.staticMethod()) without needing to create an object of the class. They can only access static members (variables and other static methods) of the class directly.

A Static Initialization Block (SIB) is a block of code within a class marked with the static keyword. It is executed only once, when the class is first loaded into the JVM. It's used to initialize static variables or perform static setup tasks.

null is a special literal in Java that indicates that a reference variable does not refer to any object. It signifies the absence of an object. Attempting to call methods or access fields on a null reference will result in a NullPointerException.

