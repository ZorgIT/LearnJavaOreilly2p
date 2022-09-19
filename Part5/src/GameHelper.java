import  java.io.*;
/**
 *
 * @author  none
 * @version 2022.09.19
 * Задание типа "Создание программ"
 * Потопи сайт v 1.0.0
 * Код "Готовый к употреблению"
 */
public class GameHelper {
    public String getUserInput(String prompt) {
        String inputLine = null;
        System.out.println(prompt + " ");
        try {
            BufferedReader is = new BufferedReader(
                    new  InputStreamReader (System.in));
            inputLine = is.readLine();
            if (inputLine.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputLine;
    }
}
