package com.arunanshu.pillersofoops;

public class Polymerphism {
    /*
    Polymorphism means "many forms." In OOP, it refers to the ability of an object to take on many forms. Specifically, it allows objects of different classes to be treated as objects of a common type (their superclass or an implemented interface). This enables a single interface to represent different underlying forms of types.

    Method Overloading (Compile-time / Static Polymorphism): Defining multiple methods in the same class with the same name but different parameters (number, type, or order of arguments). The compiler decides which method to call based on the arguments.

    Method Overriding (Runtime / Dynamic Polymorphism): Providing a specific implementation for a method that is already defined in the superclass (as seen in inheritance). The JVM decides which method to call at runtime based on the actual object type.

    Upcasting: Treating a subclass object as its superclass type (Superclass obj = new Subclass();). This is implicitly done.

    Dynamic Behavior: Enables different objects to respond to the same method call in different ways, based on their specific type at runtime.

    Interview Focus:
    "What's the difference between method overloading and method overriding?" (Extremely common!)
    "Explain compile-time vs. runtime polymorphism."
    "What is dynamic method dispatch?" (Another name for runtime polymorphism/method overriding)
    "Provide an example of polymorphism in a real-world scenario."
    "How does polymorphism enhance code flexibility?"
     */

    public int add(int a, int b) {
        return a + b;
    }

    public double add(double a, double b) { // Same name, different parameter types
        return a + b;
    }

    public int add(int a, int b, int c) { // Same name, different number of parameters
        return a + b + c;
    }
}
