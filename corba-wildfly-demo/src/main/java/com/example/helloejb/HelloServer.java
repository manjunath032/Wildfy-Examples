package com.example.helloejb;

import javax.naming.InitialContext;

public class HelloServer {
    public static void main(String[] args) throws Exception {
        System.out.println("This demo deploys an EJB to WildFly. Start WildFly and deploy the jar under deployments/ to expose via IIOP.");
        InitialContext ctx = new InitialContext();
        Object o = ctx.lookup("java:module/HelloImpl");
        System.out.println("Lookup succeeded: " + o);
    }
}
