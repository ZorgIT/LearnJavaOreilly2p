package p474;
import java.io.*;

/**
 *
 *
 * @author  Stepan M
 * @version 2022.10.02
 * пример сохранения и восстановление игровых персонажей
 * Стандартный класса для тестирования сериализации
 * P474-475
 */

public class GameCharacter implements Serializable{

    int power;
    String type;
    String[] weapons;

    public GameCharacter(int p, String t, String[] w) {
        power = p;
        type = t;
        weapons = w;
    }

    public int getPower() {
        return  power;
    }

    public String getType() {
        return  type;
    }

    public String getWeapons() {
        String weaponList = "";

        for (int i = 0; i < weapons.length; i++) {
            weaponList += weapons[i] + " ";
        }
        return weaponList;
    }
}
