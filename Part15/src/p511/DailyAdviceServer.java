package p511;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author  Stepan M
 * @version 2022.10.05
 * ������� ���� "������� ���"
 * ��������� �����
 * ��������� - ��������, ������ �������� ������-���������� ����������.
 * ������� ServerSocket � ������� ���������� �������.
 * ��� ��������� ������� (������ �������� new Socket()) ������
 *  ������� ������ Socket � ������������� ���������� � ���� ��������.
 * ������ ������� ��������� PrintWriter( � ������� ���������� ������ �� ������) � ���������� ������� ���������.
 * P511
 */

public class DailyAdviceServer {

    String [] adviceList = {"��������� 20 �� ", " ���������� �����",
            "��������� ����!", "����", "������ ������ �� ������ )"};

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
            //ServerSocket ��������� ���������� ����������� ���������� ������� �� ����� 4242.
            ServerSocket serverSock = new ServerSocket(4242);


            //���������� ���� - �������� ��������� ����������� (� �� ������������).
            while (true) {

                //����� accept() ��������� ���������� �� ��� ���,
                // ���� �� �������� ������, ����� ���� ���������� �����
                // ( �� ��������� ����� ��� �������������� � ��������.)
                Socket sock = serverSock.accept();

                //����� ������������� ���������� � �������� ��� � PrinterWriter
                PrintWriter writer = new PrintWriter(sock.getOutputStream());
                String advice = getAdvice();
                writer.println(advice);
                writer.close();
                //����� ���������� ������ ��������� writer.
                System.out.println(advice);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    } //end go() method.
}
