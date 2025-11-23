package com.example;

import java.rmi.RemoteException;
import javax.ejb.EJBObject;

public interface HelloBeanRemote extends EJBObject {
    String sayHello(String name) throws RemoteException;
}
