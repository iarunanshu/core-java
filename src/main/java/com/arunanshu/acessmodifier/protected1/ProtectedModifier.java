package com.arunanshu.acessmodifier.protected1;

public class ProtectedModifier {

    /*
    The protected keyword provides access to members within the same package, and also to subclasses in any package. It's essentially "package-private + inheritance."
     */
    protected String registrationNumber; // Protected field
    protected int currentSpeed;         // Protected field

    public ProtectedModifier(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        this.currentSpeed = 0;
    }
    protected void accelerate(int speedIncrease) { // Protected method
        this.currentSpeed += speedIncrease;
        System.out.println(registrationNumber + " accelerating. Current speed: " + currentSpeed);
    }
}
