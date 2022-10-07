package Client;

import testRMI.MyRemote;

import java.rmi.*;

/**
 *
 * @author  Stepan M
 * @version 2022.10.08
 * Клиентский код
 */
public class MyRemoteClient {
    public  static void main (String[] args) {
        new MyRemoteClient().go();
    }

    public void go() {

        try {
            MyRemote service = (MyRemote) Naming.lookup("rmi://127.0.0.1/Remote Hello");

            String s = service.sayHello();

            System.out.println(s);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
