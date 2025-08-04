package com.arunanshu.pillersofoops;

public class Inheritance {
    /*
     It allows a class (subclass or child class) to inherit properties and behaviors (fields and methods) from another class (superclass or parent class). It establishes an "is-a" relationship between classes.

     extends keyword: Used in Java to implement inheritance (class Child extends Parent).
       Method Overriding: Child classes can provide a specific implementation for a method that is already defined in its parent class.
        super keyword: Used to call the parent class's constructor or methods.

       Maintainability: Changes to the parent class are automatically reflected in child classes.
       Extensibility: New functionalities can be added by extending existing classes without modifying them.
       Polymorphism (enabled by inheritance): Allows treating objects of different classes that share a common superclass or interface uniformly.
     */
    protected String brand; // Protected allows access within package and by subclasses

    public Inheritance(String brand) {
        this.brand = brand;
    }

    public void honk() {
        System.out.println("Vehicle honks: Tuut, tuut!");
    }
}
class Car extends Inheritance {
    private int numberOfDoors;

    public Car(String brand, int numberOfDoors) {
        super(brand); // Call to parent class constructor
        this.numberOfDoors = numberOfDoors;
    }

    // Method Overriding: providing specific implementation for honk()
    @Override
    public void honk() {
        System.out.println("Car honks: Beep, beep!");
    }
}