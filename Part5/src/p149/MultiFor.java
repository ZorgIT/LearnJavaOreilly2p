package p149;

/**
 *
 * @author  Stepan M
 * @version 2022.09.19
 * ������� ���� "��������� � �����
 */

public class MultiFor {
    public static void main(String[] args) {
        for (int x = 0; x< 4; x++) {

            for (int y = 4; y > 2; y --) {
                System.out.println(x + " " + y);
            }
            if (x ==1 ){
                x++;
            }
        }
    }
}
