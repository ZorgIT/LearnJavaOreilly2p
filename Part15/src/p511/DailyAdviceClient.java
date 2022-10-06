package p511;

import  java.io.*;
import java.net.*;

/**
 * @author  Stepan M
 * @version 2022.10.05
 * ������� ���� "������� ���"
 * ��������� - ��������, ������ �������� ������-���������� ����������.
 * ������� ����� � ������ BufferedReadr � ������� ������ �������,
 * � ����� ��������� ���� ������,
 * ������� �� �������� ��������� ����������, ���������� �� ����� 4242.
 * P511
 */

public class DailyAdviceClient {

    public static void main (String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.go();
    }

    public void go() {
        try {
            //������� ���������� ����� ����� � ����������,
            // ����������� �� ����� 4242� �� ��� �� ���������� ��� ����������� ������ ��� (localhost).
            Socket s = new Socket("127.0.0.1", 4242);

            //���������� BufferedReader � InputStreamREader (������� ��� �������� � �������9�� ������� ������).
            InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
            BufferedReader reader = new BufferedReader(streamReader);

            //Readline �������� ����� ��� �� ��� ���� �� �� ��� ��������� � �����
            String advice = reader.readLine();
            System.out.println("������� �� ������:" + advice);

            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
