package p385;
import javax.swing.*;
/**
 *
 * @author  Stepan M
 * @version 2022.09.27
 * ������ ����������� ���������� )
 * P385
 */

public class SimpleGui1 {
    public static void main (String [] args) {

        //Create frame and button
        JFrame frame = new JFrame();
        JButton button = new JButton("click me"); // �������� ������������ ����� ������

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // ��� �������� ���� ��������� ���������

        frame.getContentPane().add(button); //��������� ������ �� ������ ������.

        frame.setSize(300,300); // ������ ������

        frame.setVisible(true); //������������� ��������� ������
    }
}
