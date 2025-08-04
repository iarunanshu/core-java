package com.arunanshu.pillersofoops;

abstract class Abstraction {
    /*
    Abstraction is the process of hiding the complex implementation details and showing only the essential features of an object or system to the user. It focuses on "what" an object does rather than "how" it does it.

    Abstract Classes: Classes that cannot be instantiated directly and may contain abstract methods (methods without an implementation). They can also have concrete methods.

    Interfaces: Blueprints of a class that declare methods but don't provide implementation. All methods in an interface are implicitly public and abstract (before Java 8).

    Interview Focus:
        "What's the difference between an abstract class and an interface?" (Very common!)
        "When would you use an abstract class vs. an interface?"
        "Give a real-world example of abstraction."
        "How does abstraction simplify system design?"

     */

    private String color; // Can have concrete fields

    public Abstraction(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    // Abstract method: no implementation here, must be implemented by subclasses
    public abstract double calculateArea();

    // Concrete method: can have implementation
    public void display() {
        System.out.println("This is a " + color + " shape.");
    }
}
