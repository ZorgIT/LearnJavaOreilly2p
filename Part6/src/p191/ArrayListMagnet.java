package p191;
import java.util.ArrayList;
/**
 *
 * @author  Stepan M
 * @version 2022.09.21
 * ������� ���� "��������� � �����
 */

public class ArrayListMagnet {
    public static void main (String[] args) {
        ArrayList<String> a = new ArrayList<>();
        a.add(0,"null");
        a.add(1,"one");
        a.add(2, "two");
        a.add(3,"three");
        printAL(a);

        a.remove(2);
        if (a.contains("three")) {
            a.add("four");
        }
        printAL(a);
        if (a.indexOf("four") != 4 ) {
            a.add(4, "4.2");
        }
        printAL(a);

        if (a.contains("two")) {
            a.add("2.2");
        }
        printAL(a);

    }

    public static void printAL(ArrayList<String> a1) {
        for (String element : a1) {
            System.out.print(element + " ");
        }
        System.out.println(" ");
    }


}

















