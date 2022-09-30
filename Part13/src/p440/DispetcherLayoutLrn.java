package p440;

import javax.swing.*;
import java.awt.*;
/**
 *
 * @author  Stepan M
 * @version 2022.10.01
 * Отрабока компановки
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

        JButton button = new JButton("Shok me");
        JButton buttonTwo = new JButton("bliss");
        JButton buttonThree = new JButton("huh?");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.add(button);
        panel.add(buttonTwo);
        panel.add(buttonThree);

        frame.add(panel);

        frame.getContentPane().add(BorderLayout.EAST, panel);
        frame.setSize(250,200);
        frame.setVisible(true);
    }

}
