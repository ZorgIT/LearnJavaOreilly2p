package P66;
/**
 *
 * @author  Stepan M
 * @version 2022.09.13
 * �������� ������� �������
 */
public class Dog {

    //���������� ����������
    int size;
    String breed;
    String name;

    //����� ����������
    void bark () {
        System.out.println("���! ���!");
    }
}

class DogTestDrive {
    public static void main (String [] args) {
        //����������� ��� ��� ������ Dog

        //������� ������ ������ Dog
        Dog d = new Dog();
        // ��������� �������� ������� ����������авав��� �������� ����
        d.size = 40;
        //����� ������ bark()
        d.bark();
    }
}
