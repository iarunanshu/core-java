An Interface in Java is a blueprint of a class. It can contain method signatures (abstract methods), constant fields, default methods, static methods, and nested types. 

Interfaces offer several key advantages:

Achieve Abstraction: They define a contract without providing implementation details.
Support Multiple Inheritance of Behavior: A class can implement multiple interfaces, allowing it to inherit behaviors from various sources (though not state).
Promote Loose Coupling: Code becomes more flexible and modular as classes interact through interfaces rather than concrete implementations.
Define Type: Interfaces define new types that can be used for polymorphism.
Design Contracts: They serve as formal contracts between different parts of a system.

All fields declared in an interface are implicitly public, static, and final. This means they are constants that belong to the interface itself and cannot be changed. You don't need to explicitly write these keywords, though it's good practice for clarity.
Example: int MAX_VALUE = 100; (implicitly public static final int MAX_VALUE = 100;)

Different Method Declarations Allowed in Interface
Historically, interfaces only allowed public abstract methods. However, with Java 8 and onwards, interfaces can now contain:
Abstract Methods: (implicitly public abstract) Methods without a body.
Default Methods: (since Java 8) Methods with a default implementation.
Static Methods: (since Java 8) Static methods with a body that belong to the interface itself.
Private Methods: (since Java 9) Private methods with a body, used as helper methods for default or static methods within the interface.
Private Static Methods: (since Java 9) Private static methods with a body, also used as helper methods within the interface.

Marker Interface
A Marker Interface is an empty interface (an interface with no methods or fields declared within it). Its sole purpose is to "mark" a class, indicating that it possesses a certain characteristic or capability, which can then be checked at runtime (e.g., Serializable, Cloneable).

Functional Interface
A Functional Interface is an interface that contains exactly one abstract method. They are primarily used to enable lambda expressions and method references in Java 8, providing a concise way to represent functional behavior. They can be optionally annotated with @FunctionalInterface.
Example: Runnable, Comparator.

Class Vs Abstract Class Vs Interface
Feature	                 Class	                Abstract Class	               Interface
Instantiation	Can be instantiated	Cannot be instantiated	Cannot be instantiated
Methods	Concrete methods	Concrete & Abstract methods	Abstract, Default, Static, Private methods
Fields	Variables (non-final) & Constants	Variables (non-final) & Constants	Constants (implicitly public static final)
Constructors	Yes	Yes (for subclass initialization)	No
Inheritance	extends one class	extends one abstract/concrete class	implements multiple interfaces
Accessibility	Can have any access modifier for members	Can have any access modifier for members	All methods implicitly public (before Java 9)
Purpose	Blueprint for objects, full implementation	Partial blueprint, provides common base	Defines contract, behavior specification
"is-a"	Strong "is-a" relationship	Strong "is-a" relationship	"can-do" or "has-a-capability" relationship

