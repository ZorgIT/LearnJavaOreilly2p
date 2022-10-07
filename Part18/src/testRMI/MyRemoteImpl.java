package testRMI;

import java.rmi.*;
import java.rmi.server.*;


/**
 *
 * @author  Stepan M
 * @version 2022.10.08
 *
 */

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

    public String sayHello() {
        return "Server say HELLO!";
    }

    public MyRemoteImpl() throws RemoteException {}

    public static void main (String [] args) {

        try {
            MyRemote service = new MyRemoteImpl();
            Naming.rebind("Удаленный привет", service);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
