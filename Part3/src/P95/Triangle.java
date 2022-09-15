package P95;
/**
 *
 * @author  Stepan M
 * @version 2022.09.15
 * ������� ���� "Puzzle pool"
 * ������ ������������� ��������
 */
public class Triangle {
    double area;
    int height;
    int length;
    public static void main(String [] args) {
        Triangle [] ta = new Triangle [4];
        int x=0;
        while(x < 4) {
            ta[x] = new Triangle();
            ta[x].height = (x+1)*2;
            ta[x].length = x + 4;
            ta[x].setArea();
            System.out.print("triangle " + x + ", zone");
            System.out.println(" =" + ta[x].area);
            x = x +1;
        }
        int y = x;
        x = 27;
        Triangle t5 = ta[2];
        ta[2].area = 343;
        System.out.print("y = " + y);
        System.out.println(", zone t5 = " + t5.area);
    }
    void setArea() {
        area =(height * length)/2;
    }
}

//POOL from quest:
/*
x
y


ta.area
ta.x.area
ta[x].area

4, t5 zone = 18.0
4, t5 zone = 343.0
27, t5 zone = 18.0
27.t5 zone = 343.0

// Triangle[] ta = new Triangle(4); - �� ��������������, �������� ��������� � �������� ������� ()
// Triangle ta = new [] Triangle[4]; - �� ��������������, �������� �������� ���� (������ � ������� ��������)


// ta[x] = setArea(); - �������� ��������� � ������
//ta.x = setArea(); - �������� ��������� � ������


ta = new Triangle();
ta[x] = new Triangle();
ta.x = new Triangle();


int y;
int x;
int x =1;
int y = x;
28.0
30


x = x+2;
x = x-1;

//ta.x �������� ���������
// ta(x) �������� ���������



x < 5
*/
