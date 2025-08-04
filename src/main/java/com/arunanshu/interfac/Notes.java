package com.arunanshu.interfac;

public class Notes {
    /*
    1. Prior to Java 8 (Java 7 and earlier):
        In these older versions, interfaces were very strict and could only contain:
        Public abstract methods:
            All methods declared in an interface were implicitly public and abstract. You did not need to use these keywords.
            Implementing classes must provide an implementation for all abstract methods.
        Example: void process();
            Public static final fields (Constants):
            All fields declared in an interface were implicitly public, static, and final. You did not need to use these keywords.
            They were constants accessible via the interface name.
            Example: int MAX_RETRIES = 3;

     2. Java 8 Enhancements:
            Java 8 introduced significant new features to interfaces:
        default methods:
            These are concrete (non-abstract) methods with an implementation.
            They are declared with the default keyword.
        Purpose: To allow adding new methods to an existing interface without breaking all existing implementing classes. Implementing classes can either use the default implementation or override it.
            Example: default void resize() { default implementation }
        static methods:
            These are concrete methods that belong to the interface itself, not to any implementing object.
            They are called directly on the interface name (e.g., MyInterface.utilityMethod()).
        Purpose: To provide utility methods related to the interface concept, often used for factory methods or helper functions.
            Example: static void printVersion() { System.out.println("v1.0"); }

      3. Java 9 Enhancements:
            private methods (both instance and static):
            These are concrete methods that can only be called from within the interface itself.
            Purpose: To allow default and static methods to share common, internal helper code without exposing it publicly. This helps in code reusability within the interface itself.
      When to Choose Which:

        Choose interface when:
            You want to define a contract for behavior that disparate classes might share (e.g., Comparable, Serializable, Runnable).
            You need to achieve multiple inheritance of behavior (via default methods).
            You are designing an API where only public contract matters, not implementation details.
            Your classes don't share common state or a common base implementation.
        Choose abstract class when:
            You want to provide a common base implementation for a family of related classes.
            You need to define common fields (state) that subclasses will share.
            You need to provide constructors for common initialization.
            Your classes share a strong "is-a" relationship and common logic that can be partially implemented in the base.
            You expect to add new methods to the base class in the future without breaking existing subclasses (though default methods in interfaces help here too now).
     */
}
