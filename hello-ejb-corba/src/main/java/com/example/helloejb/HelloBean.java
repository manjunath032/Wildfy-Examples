package com.example.helloejb;

import jakarta.ejb.Stateless;

@Stateless
public class HelloBean implements Hello {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from HelloBean)";
    }
}