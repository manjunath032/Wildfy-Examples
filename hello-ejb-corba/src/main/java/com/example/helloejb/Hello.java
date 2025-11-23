package com.example.helloejb;

import jakarta.ejb.Remote;

@Remote
public interface Hello {
    String sayHello(String name);
}