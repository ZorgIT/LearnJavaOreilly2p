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
 * Написать приложение с графическим интерфейсом реагирующую на событие.
 * P390
 */

public class HomeWorkGui implements ActionListener {


    //Cоздать фрейм с двумя виджетами (панелью рисования и кнопкой).
    //Создать слушатель, который связывается с кнопкой.
    //Далее фрейм выводится на экран и ждет когда пользователь нажмет кнопку.

    //Пользователь нажимает кнопку, она создает объект события и вызывает обработкич события принадлежащий слушателю

    //Обработчик запускает метод repaint (), принадлежащий фрейму.
    //Система ывазывает метод paintComponent() в контексте панели для отрисовки

    //Генерируется новый цвето по нажатию кнопки.
    JButton button; //Ссылка на кнопку
    JPanel testpannel; //Ссылка на панель

    public static void main (String [] args) {
        HomeWorkGui gui = new HomeWorkGui();
        gui.go();
    }

    //процедура первичной прорисовки интерфейса
    public void go() {
        JFrame frame = new JFrame();
        testpannel = new MyDrawPanel();
        frame.getContentPane().add(testpannel);

        button = new JButton("Тестовая кнопка");
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

            //Закрашивание всей панели черным
            //Два первых аргумента x y координаты левого верхнего угла по отношению к панели где начнется рисование.
            // два следующих аргумента - Ширина прямоугольника каку панели , высота как у панели.
            g.fillRect(0,0,this.getWidth(), this.getHeight());

            int red = (int) (Math.random() * 255);
            int green = (int) (Math.random() * 255);
            int blue = (int) (Math.random() * 255) ;

            //Назначение сгенерированных случайных чисел
            Color randomColor = new Color(red, green, blue);
            g.setColor(randomColor);
            g.fillOval(70, 70, 100, 100);

        }
    }
}
