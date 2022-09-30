package p440;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author  Stepan M
 * @version 2022.10.01
 * �������� ����������
 * P440
 */

public class DispetcherLayoutLrn {
    public static void main (String[] args){
        DispetcherLayoutLrn dptLay = new DispetcherLayoutLrn();
        dptLay.go();
    }

    public void go() {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.darkGray);

        //�������� ��������� ���������� ������ �� ����� ���. BoxLayout
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        //������������ ���������� BoxLayout ����� �����, ����� ���������� �� ���������
        // � �����  ��� ����� ������������ (������� Y_AXIS)

        JButton button = new JButton("Shok me");
        JButton buttonTwo = new JButton("bliss");
        JButton buttonThree = new JButton("huh?");

        JPanel panel2 = new JPanel();
        //JTextField field = new JTextField(20);
        JTextField field = new JTextField(10);
        field.setText("���� ������");


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(button);
        panel.add(buttonTwo);
        panel.add(buttonThree);
        panel2.add(field);
        frame.add(panel2);

        frame.add(panel);

        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.getContentPane().add(BorderLayout.WEST, panel2);
        frame.setSize(600,200);
        frame.setVisible(true);
    }

}
