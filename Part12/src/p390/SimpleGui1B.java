package p390;
import p385.SimpleGui1;

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author  Stepan M
 * @version 2022.09.27
 * ����������� ��������� � ActionEvent ������
 * P390
 */

public class SimpleGui1B implements ActionListener { //SimpleGui1B ��������� ActionListener
    JButton button;

    public static  void main (String[] args) {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");
        //��������� � ������ ���������� (������������ ������ ������ ���� �������� ������ ������������ ActionListener
        button.addActionListener(this); //������������ ������������������ � ������

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);
    }

    public void actionPerformed (ActionEvent event) { //��������� ����� actionPerformed() ���������� ActionListener.
        button.setText("I've been clicked!");
    }


}
