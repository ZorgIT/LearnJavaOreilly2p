package p342;

import java.io.*;
import java.util.*;
import static java.lang.System.out;

/**
 *
 * @author  Stepan M
 * @version 2022.09.24
 * Задача типа "Moon magnetics"
 * P342
 */

public class FullMoons {
    static int DAY_IM =1000* 60 * 60 * 24;
    public static void main (String [] args) {
        Calendar c = Calendar.getInstance();
        c.set(2022,0,18,2,48,43);
        long day1 = c.getTimeInMillis();

        for (int x = 0; x <10; x ++) {
            out.println (String.format("Foolmoon has been in %tc" , c));
            day1 += (DAY_IM * 29.52);
            c.setTimeInMillis(day1);
        }
    }


}
