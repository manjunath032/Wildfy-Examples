package com.example;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class HelloClient {
    public static void main(String[] args) {
        try {
            Context ctx = new InitialContext();
            HelloBean bean = (HelloBean) ctx.lookup("java:global/hello-world-ejb/HelloBean");
            System.out.println(bean.sayHello("World"));
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
