package com.arunanshu.acessmodifier;

public class Privatetmodifier {
    /*
        The private keyword is the most restrictive access modifier. Members (fields, methods, nested classes) declared as private are accessible only from within the same class where they are declared. They are not visible to any other class, including subclasses, even within the same package.
     */

    private String username; // Private field

    public Privatetmodifier(String username) {
        this.username = username;
    }

    // Public getter for username
    public String getUsername() {
        return username;
    }
}
