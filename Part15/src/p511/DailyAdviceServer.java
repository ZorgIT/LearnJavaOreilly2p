package p511;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author  Stepan M
 * @version 2022.10.05
 * Задание типа "Готовый код"
 * Сервенрая часть
 * Программа - советчик, пример простого клиент-серверного приложения.
 * Создает ServerSocket и ожидает клиентские запросы.
 * При получении запроса (клиент выполнил new Socket()) сервер
 *  создает объект Socket и устанавливает соединение с этим клиентом.
 * Сервер создает экземпляр PrintWriter( с помощью исходящего потока из сокета) и отправляет клиенту сообщение.
 * P511
 */

public class DailyAdviceServer {

    String [] adviceList = {"Пробежать 20 км ", " Радоваться жинзи",
            "Позвонить маме!", "жить", "Никому ничего не дложен )"};

    public static void main (String[] args) {
        DailyAdviceServer server = new DailyAdviceServer();
        server.go();
    }

    public String getAdvice() {
        int random = (int) (Math.random() * adviceList.length);
        return adviceList[random];
    }


    public void go () {
        try {
            //ServerSocket позволяет приложению отслеживать клиентские запросы на порту 4242.
            ServerSocket serverSock = new ServerSocket(4242);


            //Постоянный цикл - ожидание клиентски подключений (и их обслуживание).
            while (true) {

                //Метод accept() блокирует приложение до тех пор,
                // пока не поступит запрос, после чего возвращает сокет
                // ( НА АНОНИМНОМ порту для взаимодействия с клиентом.)
                Socket sock = serverSock.accept();

                //берем установленное соединение и передаем его в PrinterWriter
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                //После завершения работы закрываем writer.
                System.out.println(advice);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    } //end go() method.
}
