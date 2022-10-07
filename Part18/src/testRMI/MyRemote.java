package testRMI;

import java.rmi.*;

/**
 *
 * @author  Stepan M
 * @version 2022.10.08
 * Серверный код - тестирование RMI
 */

public interface MyRemote extends Remote { //Интрефейс должен быть унаследован от java.rmi.Remote

    public String sayHello() throws RemoteException;

}
