package p511;

import  java.io.*;
import java.net.*;

/**
 * @author  Stepan M
 * @version 2022.10.05
 * Задание типа "Готовый код"
 * Программа - советчик, пример простого клиент-серверного приложения.
 * Создает сокет и объект BufferedReadr с помощью других потоков,
 * а затем счиытвает одну строку,
 * которую ей передает серверное приложение, работающее на порту 4242.
 * P511
 */

public class DailyAdviceClient {

    public static void main (String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }

    public void go() {
        try {
            //Создаем соединение через сокет к приложению,
            // работающему на порту 4242б на том же компьютере где выполняется данный код (localhost).
            Socket s = new Socket("127.0.0.1", 4242);

            //Подключаем BufferedReader к InputStreamREader (который уже соединен с исходящ9им потоком сокета).
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            //Readline работает точно так же как если бы он был подключен к файлу
            String advice = reader.readLine();
            System.out.println("Сегодня ты должен:" + advice);

            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
