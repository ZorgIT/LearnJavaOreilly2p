package p394;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author  Stepan M
 * @version 2022.09.27
 * Личный виджет для рисования с применением paintComponent()
 * P390
 */


    //Создаем наследника JPanle - виджет, который можно добавить во фрейм ка клюбой другой.
    //только это будет персональный виджет
class MyDrawPanel  extends JPanel {

    //Graphics g - Большой и важный графический метод. Никода не вызывается в ручную
    //Создает поверхность для рисования принадлежащая типу Graphics
 /*   public void paintComponent(Graphics g) {

        //g - условно, машина для рисования которой сообщаются графические иструкнции, что/цвет/как рисовать
        g.setColor(Color.orange);
        g.fillRect(20 , 50 , 100, 100);
    }
    */

/* Изображение JPEG
    public void paintComponent(Graphics g) {
        Image image = new ImageIcon("ИМЯ ФАЙЛА").getImage();
        g.drawImage(image, 3, 4, this);
        //координаты x и y для верхнего левого угла картинки (от левого верхнего угла)
    }
 */

    /*
    //Пример - круг произвольного цвета на черном фоне
    public  void paintComponent(Graphics g) {

        //Закрашиванеи всей панели черным
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

    }*/

    /*
    //Передаем настоящий объек Graphics2D замаскированный под простой объект Graphics
    public void paintComponent(Graphics g) {

        //Указываем его, чтобы иметь возможнсть вызывать методы Graphics2D которые отсутствуют у Graphics.
        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(70, 70 , Color.blue, 150, 150, color.orange);

        //Назначаем для виртуальной кисти градиент вместо сплошного цвета
        g2d.setPaint(gradient);
        //Метод fillOval() в данном случае позволяет закрасить овал тем, что находится на кисти - градиентом.
        g2d.fillOval(70, 70, 100, 100);
    }
     */
    // Метод аналогичный верхнему но со случайными цветами для градиента

    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        int red = (int) (Math.random() * 255 );
        int green = (int) (Math.random() * 255 );
        int blue = (int) (Math.random()* 255 );
        Color startColor = new Color (red, green,blue);

        red = (int) (Math.random() * 255 );
        green = (int) (Math.random() * 255 );
        blue = (int) (Math.random()* 255 );
        Color endColor = new Color (red, green, blue);

        GradientPaint gradient = new GradientPaint(70,70, startColor,150,150, endColor);
        g2d.setPaint(gradient);
        g2d.fillOval(70, 70, 100, 100);
    }

}

