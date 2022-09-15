package P94;
/**
 *
 * @author  Stepan M
 * @version 2022.09.15
 * Задание типа "Магниты с кодом"
 * пример использования массивов
 */

public class TestArrays {
    public static void main (String [] args ) {
        int y = 0;

        String [] islands = new String[4];
        islands[0] = "Bermuds";
        islands[1] = "Fiji";
        islands[2] = "University of the Azores";
        islands[3] = "Cozumel";

        int [] index = new int [4];
        index[0] = 1;
        index[1] = 3;
        index[2] = 0;
        index[3] = 2;

        System.out.print("islands =  ");
        int ref;
        while (y < 4) {
            ref = index[y];

            System.out.println (islands[ref]);
            y = y + 1;
        }

    }
}

















