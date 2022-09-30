package p400;
import p390.SimpleGui1B;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 *
 * @author  Stepan M
 * @version 2022.09.28
 * �������� ���������� � ����������� ����������� ����������� �� �������.
 * P390
 */

public class HomeWorkGui implements ActionListener {


    //C������ ����� � ����� ��������� (������� ��������� � �������).
    //������� ���������, ������� ����������� � �������.
    //����� ����� ��������� �� ����� � ���� ����� ������������ ������ ������.

    //������������ �������� ������, ��� ������� ������ ������� � �������� ���������� ������� ������������� ���������

    //���������� ��������� ����� repaint (), ������������� ������.
    //������� ��������� ����� paintComponent() � ��������� ������ ��� ���������

    //������������ ����� ����� �� ������� ������.
    JButton button; //������ �� ������
    JPanel testpannel; //������ �� ������

    public static void main (String [] args) {
        HomeWorkGui gui = new HomeWorkGui();
        gui.go();
    }

    //��������� ��������� ���������� ����������
    public void go() {
        JFrame frame = new JFrame();
        testpannel = new MyDrawPanel();
        frame.getContentPane().add(testpannel);

        button = new JButton("�������� ������");
        button.addActionListener(this);

        frame.setAlwaysOnTop(true);
        frame.getContentPane().add(BorderLayout.SOUTH,button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,300);
        frame.setVisible(true);

    }
    public void actionPerformed (ActionEvent event) {
        testpannel.repaint();
    }

    class MyDrawPanel  extends JPanel {
        public void paintComponent(Graphics g) {

            //������������ ���� ������ ������
            //��� ������ ��������� x y ���������� ������ �������� ���� �� ��������� � ������ ��� �������� ���������.
            // ��� ��������� ��������� - ������ �������������� ���� ������ , ������ ��� � ������.
            g.fillRect(0,0,this.getWidth(), this.getHeight());

            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255) ;

            //���������� ��������������� ��������� �����
            Color randomColor = new Color(red, green, blue);
            g.setColor(randomColor);
            g.fillOval(70, 70, 100, 100);

        }
    }
}
