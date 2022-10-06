package p548;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author  Stepan M
 * @version 2022.10.05
 * ������� ���� "������� ���"
 * ��������� �����
 *
 *
 * P516
 */

public class VerySimpleChatServer {

    // �� ��������� ����� ��� ���������� �������� writer ��� ���������� ������������ � �����
    ArrayList<PrintWriter> clientOutputStreams;
    //����� ������������ � ��������
    public class ClientHandler implements Runnable {
        BufferedReader reader;
        Socket sock;

        //��������� ������ �� �������
        public ClientHandler(Socket clientSocket) {
            try {
                //�������� � ����������� �����
                sock = clientSocket;
                InputStreamReader isReader = new InputStreamReader(sock.getInputStream());
                //���������� ������ � ����� � BufferReader
                reader = new BufferedReader(isReader);

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        //���������� ���������� Runnable
        public void run() {
            //����� ���� message
            String message1;
            try {
                //���� � ������� message ������� ����� ������ ��������� �� ����������
                while ((message1 = reader.readLine()) != null) {
                    System.out.println("read " + message1);
                    // ����� ���������� �� ���� ������������� ��������
                    tellEveryone(message1);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } // end run()
    } //end ClientHandler class

    public static void main (String [] args) {
        //������ ������� � ���������� ������ �������
        new VerySimpleChatServer().go();
    }

    public void go () {
        //������������� - �������� ������� ������� ���������
        clientOutputStreams = new ArrayList<PrintWriter>();
        try {
            //�������� ����� �� �������������
            ServerSocket serverSock = new ServerSocket(5000);

            //����� �������������� ���������� �������� ������ � ����� � ���������� � ����� ���.
            //
            while (true ) {
               //������������� ���������� ����� �������� � ��������
                Socket clientSocket = serverSock.accept();
                //��������� ������ writer - ����������� ������ ���������� �� �������
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream());
                //��������� ������� writer � ������ ��������
                clientOutputStreams.add(writer);

                // ���������� ������ � ClientHandler ������������� � ���������� �����
                Thread t = new Thread(new ClientHandler((clientSocket)));
                // ������� ������ � ���������������.
                t.start();
                System.out.println("got a connection");
            }

        } catch (Exception ex ) { ex.printStackTrace();}
    } // eng go ();

    public void tellEveryone(String message) {
        //����������� ������� ��������� ��������
        Iterator it = clientOutputStreams.iterator();
        // ���� � ��������� ������� ������� ���������� �� ����������
        while (it.hasNext()) {
            try {
                //�������� ������ ������� �� ������ ������ ������ ��������
                PrintWriter writer = (PrintWriter) it.next();
                //������ � ����� ���������
                writer.println(message);
                //��������� ������
                writer.flush();

            } catch (Exception ex) { ex.printStackTrace();}
        } //end while
    } //end tellEveryone





} // end VerySimpleChatServer
