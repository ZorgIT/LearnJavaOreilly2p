package P224;
/**
 *
 * @author  Stepan M
 * @version 2022.09.21
 * ������ ���� "Pool puzzle"
 *
 */

public class TestBoats {
    public static void main(String[] args) {
        Boat b1 = new Boat();
        Sailboat b2 = new Sailboat();
        RowBoat b3 = new RowBoat();
        b2.setLength(32);
        b1.move();
        b3.move();
        b2.move();
    }

}
class RowBoat extends  Boat{
    public void rowTheBoat() {
        System.out.println("Go, Natasha!");
    }
}

class Boat {
    private int length;
    public void setLength(int len) {
        length = len;
    }
    public int getLength() {
        return length;
    }
    public void move () {
        System.out.println("Dreif ");
    }

}

class Sailboat extends  Boat{
    public void move() {
        System.out.println("Get the wind!");
    }
}