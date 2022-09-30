package p394;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author  Stepan M
 * @version 2022.09.27
 * ������ ������ ��� ��������� � ����������� paintComponent()
 * P390
 */


    //������� ���������� JPanle - ������, ������� ����� �������� �� ����� �� ������ ������.
    //������ ��� ����� ������������ ������
class MyDrawPanel  extends JPanel {

    //Graphics g - ������� � ������ ����������� �����. ������ �� ���������� � ������
    //������� ����������� ��� ��������� ������������� ���� Graphics
 /*   public void paintComponent(Graphics g) {

        //g - �������, ������ ��� ��������� ������� ���������� ����������� ����������, ���/����/��� ��������
        g.setColor(Color.orange);
        g.fillRect(20 , 50 , 100, 100);
    }
    */

/* ����������� JPEG
    public void paintComponent(Graphics g) {
        Image image = new ImageIcon("��� �����").getImage();
        g.drawImage(image, 3, 4, this);
        //���������� x � y ��� �������� ������ ���� �������� (�� ������ �������� ����)
    }
 */

    /*
    //������ - ���� ������������� ����� �� ������ ����
    public  void paintComponent(Graphics g) {

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

    }*/

    /*
    //�������� ��������� ����� Graphics2D ��������������� ��� ������� ������ Graphics
    public void paintComponent(Graphics g) {

        //��������� ���, ����� ����� ���������� �������� ������ Graphics2D ������� ����������� � Graphics.
        Graphics2D g2d = (Graphics2D) g;

        GradientPaint gradient = new GradientPaint(70, 70 , Color.blue, 150, 150, color.orange);

        //��������� ��� ����������� ����� �������� ������ ��������� �����
        g2d.setPaint(gradient);
        //����� fillOval() � ������ ������ ��������� ��������� ���� ���, ��� ��������� �� ����� - ����������.
        g2d.fillOval(70, 70, 100, 100);
    }
     */
    // ����� ����������� �������� �� �� ���������� ������� ��� ���������

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

