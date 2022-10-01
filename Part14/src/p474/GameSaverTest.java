package p474;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 *
 * @author  Stepan M
 * @version 2022.10.02
 * пример сохранения и восстановление игровых персонажей
 * P474-475
 */

public class GameSaverTest {
    public static void main (String [] args ) {
        GameCharacter one = new GameCharacter(50, "Elf", new String[] {"Bow", "Sword", "Fist"});
        GameCharacter two = new GameCharacter(200, "Troll", new String[] {"Free handds", "Big axe"});
        GameCharacter three = new GameCharacter(120, "Mage", new String[] {"Spells","Invisible"});

        //Некоторый код который изменяет значения состояния персонажей, для примера не нужен.

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("Game.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.writeObject(three);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Обнуление объектов чтобы нельзя было обратиться к ним в куче.
        one = null;
        two = null;
        three = null;

        //Пытаемся восстановить трех персонажеий из файла.
        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("Game.ser"));
            GameCharacter oneRestore = (GameCharacter) is.readObject();
            GameCharacter twoRestore = (GameCharacter) is.readObject();
            GameCharacter threeRestore = (GameCharacter) is.readObject();

            //Провекра работоспособности полученных объектов
            System.out.println("First character type " + oneRestore.getType());
            System.out.println("Second restore type " + twoRestore.getType());
            System.out.println("Third restore type "+ threeRestore.getType());
        } catch (Exception ex) {
            ex.printStackTrace();
        }



    }



} //End GameSaverTest class
