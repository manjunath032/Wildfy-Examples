package com.example;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;

public class RemoteEJBClient {
    public static void main(String[] args) throws Exception {
        Properties props = new Properties();
        props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
        props.put(Context.PROVIDER_URL,"remote+http://localhost:8080");
        Context ctx = new InitialContext(props);

        // Lookup EJB (adjust JNDI name to your deployment)
        HelloBeanRemote  bean = (HelloBeanRemote) ctx.lookup(
                "ejb:/hello-world-javax-1.0-SNAPSHOT/HelloBean!com.example.HelloBeanRemote"
        );

        System.out.println(bean.sayHello("Manjappa"));
    }
}
