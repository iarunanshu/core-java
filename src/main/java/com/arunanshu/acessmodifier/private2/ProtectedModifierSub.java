package com.arunanshu.acessmodifier.private2;

import com.arunanshu.acessmodifier.protected1.ProtectedModifier;

public class ProtectedModifierSub extends ProtectedModifier {


    public ProtectedModifierSub(String registrationNumber) {
        super(registrationNumber);
    }
    @Override
    public void accelerate(int speed){
        System.out.println("new speeed");
    }
}
