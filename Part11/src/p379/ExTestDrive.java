package p379;
/**
 *
 * @author  Stepan M
 * @version 2022.09.26
 * Задача типа (Magnet with code)
 * P379
 */

public class ExTestDrive {
    public static void main(String[] args) {

        String test = args[0];
        System.out.print("t");
        try {
            doRisky(test);
        } catch (MyEx e) {

        } finally {
            System.out.print("w");
            System.out.print("s");
        }
    } //end main

 static class MyEx extends Exception {

 }
   static void doRisky (String t) throws MyEx {
        System.out.print("h");
        if ("yes".equals(t)) {
            System.out.print("a");
            throw new MyEx();
        }
       System.out.print("r");
       System.out.print("o");
    }


}
