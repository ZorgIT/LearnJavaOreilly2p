package p413;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author  Stepan M
 * @version 2022.09.29 v1.0
 * ¬нутренние классы, проста€ анимаци€
 * —амосто€тельный код поверх модул€ TwoButtons
 * P409
 */


public class TestAnimaion {

    JFrame frame; // ссылка на рабочую область
    JLabel label;
    int x=0;
    int y=0;

    public static void main (String [] args) {
        TestAnimaion gui = new TestAnimaion();
        gui.go();
    }

    //процедура первичной прорисовки интерфейса
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
        frame.setSize(900,900);
        frame.setVisible(true);

        for (int i = 0; i < 100; i+=10) {
            x=x+i;
            y=y+i;
            frame.repaint();
            try {
                Thread.sleep(1000);
            } catch (Exception ex) {

            }

        }

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

            //«акрашивание всей панели черным
            //ƒва первых аргумента x y координаты левого верхнего угла по отношению к панели где начнетс€ рисование.
            // два следующих аргумента - Ўирина пр€моугольника каку панели , высота как у панели.
            g.fillRect(0,0,this.getWidth(), this.getHeight());

            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255) ;

            //Ќазначение сгенерированных случайных чисел
            Color randomColor = new Color(red, green, blue);
            g.setColor(randomColor);
            g.fillOval(x, y, 100, 100);

        }
    } //end MyDrawPanel class
} // end TwoButtons class