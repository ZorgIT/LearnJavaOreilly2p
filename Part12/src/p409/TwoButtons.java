package p409;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author  Stepan M
 * @version 2022.09.28 v1.5
 * ��������� P400 - ���������� ���� ����� � ���������� ����������� �������
 * P409
 */

public class TwoButtons {

        JFrame frame; // ������ �� ������� �������
        JLabel label;

        public static void main (String [] args) {
            TwoButtons gui = new TwoButtons();
            gui.go();
        }

        //��������� ��������� ���������� ����������
        public void go() {
            frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JButton labelButton = new JButton("Change Label");
            labelButton.addActionListener(new LabelListener());

            JButton colorButton = new JButton("Chane Circle");
            colorButton.addActionListener(new ColorListener());

            label = new JLabel("I'm a label");
            MyDrawPanel drawPanel = new MyDrawPanel();

            frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
            frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
            frame.getContentPane().add(BorderLayout.EAST, labelButton);
            frame.getContentPane().add(BorderLayout.WEST, label);

            frame.setAlwaysOnTop(true);
            frame.setSize(600,300);
            frame.setVisible(true);

        } // end go() method

      class LabelListener implements ActionListener {
            public void  actionPerformed(ActionEvent event) {
                label.setText("Ouch");
            }
      }
    class ColorListener implements ActionListener {
        public void  actionPerformed(ActionEvent event) {
            frame.repaint();
        }
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
        } //end MyDrawPanel class
} // end TwoButtons class
