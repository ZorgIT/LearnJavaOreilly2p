package p468;
import java.io.*;

/**
 *
 *
 * @author  Stepan M
 * @version 2022.10.02
 * Пример сериализации класса - все внутренние объекты должны подлежать сериализации
 * P467
 */

public class Pond implements Serializable{

    private transient   Duck duck = new Duck ();

    public static void main (String[] args ) {
        Pond myPond =new Pond();
        try {
            FileOutputStream fs = new FileOutputStream("Pond.ser");
            ObjectOutputStream os = new ObjectOutputStream(fs);

            os.writeObject(myPond);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public class Duck {

    }
}
