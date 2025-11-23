package com.example.helloejb;

import jakarta.ejb.Stateless;

@Stateless
public class HelloImpl implements Hello {
    @Override
    public String sayHello(String name) {
        return "Hello, " + name + " (from CORBA HelloImpl)";
    }
}
