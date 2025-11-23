package com.example.helloejb;

import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Hashtable;
import java.util.Properties;

public class HelloClient {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
      //  props.put(Context.SECURITY_PRINCIPAL, "admin");  // optional if security enabled
      //  props.put(Context.SECURITY_CREDENTIALS, "admin"); // optional
        props.put("jboss.naming.client.ejb.context", true);

        Context ctx = new InitialContext(props);

        Hello hello = (Hello) ctx.lookup(
                "java:global/hello-ejb-corba-0.1.0-SNAPSHOT/HelloBean!com.example.helloejb.Hello"
        );

        System.out.println(hello.sayHello("World"));


        String jndiName = "ejb:/hello-ejb-corba-0.1.0-SNAPSHOT/HelloBean!com.example.helloejb.Hello";
        Hello bean = (Hello) ctx.lookup(jndiName);


        Object ref = ctx.lookup("java:global/hello-ejb-corba-0.1.0-SNAPSHOT/HelloBean!com.example.helloejb.Hello");
       /* Hello hello = (Hello) ref;
        System.out.println(hello.sayHello("World"));*/
    }
}