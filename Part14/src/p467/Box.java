package p467;
import java.io.*;

/**
 *
 * @author  Stepan M
 * @version 2022.10.02
 * Пример сериализации класса
 * P467
 */

//Необходимо реализовать Serializable (нет методов, определять не нужно)
public class Box implements Serializable{

    private int width;
    private int height;

    public void setWidth (int w) {
        width = w;
    }

    public void setHeight (int h) {
        height = h;
    }

    public static void main (String [] args) {

        Box myBox = new Box();
        myBox.setWidth(50);
        myBox.setHeight(20);

        //Операции ввода\вывода могут вызывать исключения, необходим обработчик
        try {
            FileOutputStream fs = new FileOutputStream("foo.ser"); //подключиться к файлу или создать новый.
            ObjectOutputStream os = new ObjectOutputStream(fs); //Связать ObjectOutputStream
            // с потоком соединения, приказываем записать объект
            os.writeObject(myBox);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
