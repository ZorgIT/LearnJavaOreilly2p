package testRMI;

import java.rmi.*;

/**
 *
 * @author  Stepan M
 * @version 2022.10.08
 * ��������� ��� - ������������ RMI
 */

public interface MyRemote extends Remote { //��������� ������ ���� ����������� �� java.rmi.Remote

    public String sayHello() throws RemoteException;

}
