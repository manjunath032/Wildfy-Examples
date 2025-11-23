package com.example;

import java.rmi.RemoteException;
import javax.ejb.CreateException;
import javax.ejb.EJBHome;

public interface HelloBeanHome extends EJBHome {
    HelloBeanRemote create() throws RemoteException, CreateException;
}
