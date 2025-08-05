Inheritance is an OOP principle where one class (the subclass or child class) acquires the properties (fields) and behaviors (methods) of another class (the superclass or parent class). It promotes code reusability and establishes an "is-a" relationship. The theory explained its core

In Java, every class, directly or indirectly, extends the java.lang.Object class. If a class doesn't explicitly extend another class, it implicitly extends Object. This means all Java classes inherit common methods like equals(), hashCode(), toString(), etc.

is-a & has-a Relationships in Java
"is-a" relationship (Inheritance): A subclass is a type of its superclass. (e.g., A Car is a Vehicle). Represented by extends.

"has-a" relationship (Composition/Aggregation): A class has a reference to an object of another class as one of its fields. (e.g., A Car has an Engine). Represented by instance variables.

A subclass inherits all public and protected fields and methods from its superclass. It also inherits default (package-private) members if both classes are in the same package. private members of the superclass are not directly inherited but can be accessed through public/protected methods of the superclass. Constructors are not inherited.

A subclass inherits all public and protected fields and methods from its superclass. It also inherits default (package-private) members if both classes are in the same package. private members of the superclass are not directly inherited but can be accessed through public/protected methods of the superclass. Constructors are not inherited.

Downcasting is explicitly converting a superclass object reference to a subclass type. This is not always safe and requires an explicit cast (SubclassType). It can lead to a ClassCastException if the object being cast is not actually an instance of the target subclass (or one of its subclasses).
Example: Car c = (Car) v; (where v might or might not actually be a Car object).

The instanceof operator is used to check if an object is an instance of a particular class or an interface. It returns true or false.
Example: if (v instanceof Car) { ... }
Java 16 introduced pattern matching for instanceof, which simplifies downcasting by allowing you to declare a new variable of the target type within the if condition, eliminating the need for a separate explicit cast.
Example: if (v instanceof Car c) { c.drive(); }

Static Binding and Dynamic Binding in Java
Static Binding (Early Binding): Method calls are resolved at compile-time. This typically applies to private, static, and final methods, and variables (fields).
Dynamic Binding (Late Binding): Method calls are resolved at runtime. This applies to public, protected, and default instance methods that are overridden in subclasses, allowing Polymorphism.

Polymorphism means "many forms." In Java, it refers to the ability of an object to take on many forms, specifically, a reference variable of a superclass type can refer to objects of its subclasses. This allows a single method call to behave differently based on the actual type of the object at runtime

Method Overriding occurs when a subclass provides its own specific implementation for a method that is already defined in its superclass. The method signature (name and parameters) must be identical. The @Override annotation is highly recommended. This is the mechanism for achieving dynamic polymorphism.

super Keyword to Invoke Super Class Methods from Sub Class
The super keyword is used within a subclass to refer to the superclass's members.
super.methodName(): Invokes a method from the superclass.
super.fieldName: Accesses a field from the superclass (useful if a field is hidden by the subclass).

Method Overloading occurs when a class has multiple methods with the same name but different method signatures (different number, type, or order of parameters). The return type can be different but is not part of the overloading criteria. It enables a single method name to perform different actions based on the arguments provided.

Feature	            Method Overriding	                Method Overloading
Concept	    Runtime Polymorphism (Inheritance)	        Compile-time Polymorphism
Signature	Same name, same parameters	Same name,      different parameters
Classes	Superclass and Subclass	Within the same class   (or super/sub, but distinct)
Return  Type	Must be same or covariant (sub-type)	Can be same or different
Access	    Can't reduce visibility	                    Can be anything
Binding	        Dynamic (runtime)	                    Static (compile-time)

Method Hiding occurs when a static method in a subclass has the same signature as a static method in the superclass. It's not overriding, because static methods are resolved at compile-time (static binding). The superclass's static method is "hidden" by the subclass's static method. You access them via the class name (e.g., SuperClass.staticMethod()).

Field Hiding (or Shadowing) occurs when a subclass declares a field with the same name as a field in its superclass. The subclass's field "hides" the superclass's field. You can still access the superclass's hidden field using the super keyword (e.g., super.fieldName). Access to hidden fields is determined by the reference type, not the actual object type.

When a subclass object is created, the constructors of its superclasses are always invoked first, starting from Object down to the immediate superclass, before the subclass's constructor body executes. This chain is managed by implicit or explicit calls to super() (to invoke the superclass's constructor). If you don't call super(), Java implicitly inserts a super() (no-args constructor call) as the first statement in the subclass constructor.

this and super Keywords in Java
this: Refers to the current object.
this.fieldName: Refers to the current object's field.
this.methodName(): Invokes a method on the current object.
this(): Calls another constructor within the same class (constructor chaining).
super: Refers to the immediate parent (superclass) object.
super.fieldName: Refers to the superclass's field.
super.methodName(): Invokes a method from the superclass.
super(): Calls a constructor of the superclass (must be the first statement in a constructor).

Java supports:
Single Inheritance: A class inherits from only one direct superclass. (Class B extends A)
Multilevel Inheritance: A class inherits from a class, which in turn inherits from another class. (Class C extends B, where B extends A)
Hierarchical Inheritance: Multiple classes inherit from a single superclass. (Class B extends A, Class C extends A)
Multiple Inheritance (via Interfaces): A class can implement multiple interfaces, achieving a form of multiple inheritance of behavior (not state).
Hybrid Inheritance: A combination of two or more types of inheritance. (Not directly supported in classes due to the "diamond problem," but achievable with interfaces).

Abstract Method: A method declared without an implementation (no body), ending with a semicolon. Declared using the abstract keyword. Must be overridden by concrete subclasses.
Abstract Class: A class declared with the abstract keyword. It cannot be instantiated directly. It can contain abstract methods, non-abstract methods, and fields. If a class has even one abstract method, it must be declared abstract. Subclasses of an abstract class must either implement all inherited abstract methods or declare themselves abstract.

final Keyword in Java
The final keyword is used for:
final variable: A constant; its value cannot be changed after initialization.
final method: Cannot be overridden by subclasses.
final class: Cannot be extended (no subclasses allowed).

[JAVA 17] Sealed Classes & Interfaces
Introduced as a standard feature in Java 17, Sealed Classes and Interfaces allow you to restrict which other classes or interfaces can extend or implement them. You use the permits keyword to explicitly list the permitted subclasses/implementations, providing more control over the inheritance hierarchy. This bridges the gap between fully open and fully closed hierarchies.

