package p548;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author  Stepan M
 * @version 2022.10.05
 * Задание типа "Готовый код"
 * Серверная часть
 *
 *
 * P516
 */

public class VerySimpleChatServer {

    // не публичная ссыла для накопления объектов writer для последющей сериализации в сокет
    ArrayList<PrintWriter> clientOutputStreams;
    //Класс коммуникации с клиентом
    public class ClientHandler implements Runnable {
        BufferedReader reader;
        Socket sock;

        //получение данных от клиента
        public ClientHandler(Socket clientSocket) {
            try {
                //привязка к переданному порту
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                //считывание данных с порта в BufferReader
                reader = new BufferedReader(isReader);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        //реализация интерфейса Runnable
        public void run() {
            //общее поле message
            String message1;
            try {
                //пока в объекте message имеются новые строки выполнять их считывание
                while ((message1 = reader.readLine()) != null) {
                    System.out.println("read " + message1);
                    // затем отправлять их всем подклчюченным клиентам
                    tellEveryone(message1);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } // end run()
    } //end ClientHandler class

    public static void main (String [] args) {
        //Запуск сервера и выполнение метода запуска
        new VerySimpleChatServer().go();
    }

    public void go () {
        //инициализация - создание пустого объекта переписки
        clientOutputStreams = new ArrayList<PrintWriter>();
        try {
            //открытие порта на прослушивание
            ServerSocket serverSock = new ServerSocket(5000);

            //после установленного соединения собирать данные с порта и объединять в общий чат.
            //
            while (true ) {
               //Устанавливает соединение между клиентом и сервером
                Socket clientSocket = serverSock.accept();
                //создается объект writer - считывающий данные переданные от клиента
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                //добавлние объекта writer в Массив объектов
                clientOutputStreams.add(writer);

                // Подготовка потока с ClientHandler подключенного в полученном сокте
                Thread t = new Thread(new ClientHandler((clientSocket)));
                // перевод потока в работоспособный.
                t.start();
                System.out.println("got a connection");
            }

        } catch (Exception ex ) { ex.printStackTrace();}
    } // eng go ();

    public void tellEveryone(String message) {
        //Подключение объекта коллекции итератор
        Iterator it = clientOutputStreams.iterator();
        // пока в коллекции имеются объекты продолжать их считывание
        while (it.hasNext()) {
            try {
                //создание нового объекта на основе общего списка объектов
                PrintWriter writer = (PrintWriter) it.next();
                //запись в поток сообщения
                writer.println(message);
                //окончание записи
                writer.flush();

            } catch (Exception ex) { ex.printStackTrace();}
        } //end while
    } //end tellEveryone





} // end VerySimpleChatServer
