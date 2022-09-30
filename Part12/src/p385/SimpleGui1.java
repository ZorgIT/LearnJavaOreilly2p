package p385;
import javax.swing.*;
/**
 *
 * @author  Stepan M
 * @version 2022.09.27
 * Первый графический интерефейс )
 * P385
 */

public class SimpleGui1 {
    public static void main (String [] args) {

        //Create frame and button
        JFrame frame = new JFrame();
        JButton button = new JButton("click me"); // Передаем конструктору текст кнопки

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // при закрытии окна завершить программу

        frame.getContentPane().add(button); //Добавляем кнопку на панель фрейма.

        frame.setSize(300,300); // Размер фрейма

        frame.setVisible(true); //Устанавливаем видимость фрейма
    }
}
