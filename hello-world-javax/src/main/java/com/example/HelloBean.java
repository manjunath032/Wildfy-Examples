package com.example;

import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class HelloBean implements SessionBean {

    private SessionContext context;

    public String sayHello(String name) {
        return "Hello, " + name + " from EJB 2.x!";
    }

    // Lifecycle methods required in EJB 2.x
    public void ejbCreate() { }
    public void ejbRemove() { }
    public void ejbActivate() { }
    public void ejbPassivate() { }
    public void setSessionContext(SessionContext ctx) {
        this.context = ctx;
    }
}
