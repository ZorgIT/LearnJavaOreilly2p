package testRMI;

import java.rmi.*;

/**
 *
 * @author  Stepan M
 * @version 2022.10.08
 * Server code -  RMI test
 */

public interface MyRemote extends Remote {

    public String sayHello() throws RemoteException;

}
