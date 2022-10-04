package p497;


import java.io.*;

/**
 * @author  Stepan M
 * @version 2022.10.04
 * ������� ���� "������� � �����"
 * P497
 */
class DungeonTest {

    public static void main(String [] args) {
        DungeonGame d = new DungeonGame();
        //������ ����� �� ������������
        System.out.println(d.getX()+d.getY()+d.getZ());

        try {
            //������������� ������
            FileOutputStream fos = new FileOutputStream("dg.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(d);
            oos.close();

            //��������������� ������
            FileInputStream fis = new FileInputStream("dg.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            d = (DungeonGame) ois.readObject();
            ois.close();

            // fos.writeObject(d);

        } catch (Exception e) {
            e.printStackTrace();
        }
        //������ ����� ����� �������������� (���������� y ������� �������� �� ��������� 0,
        // �.�. ��������� � �� �����������)
        System.out.println(d.getX()+d.getY()+d.getZ());
    }
}

class DungeonGame implements Serializable {
    public int x = 3;
    transient  long y = 4;
    private short z = 5;

    short getZ() {return z;}
    long getY() {return y;}
    long getX() {return x;}
}
