package p121;
/**
 *
 * @author  Stepan M
 * @version 2022.09.16
 * Задание типа "Puzzle pool"
 * Пример использования объектов
 */

public class Puzzle4 {
    public static void main (String [] args) {
        Puzzle4b [] obs= new Puzzle4b[6]; //
        int y = 1;
        int x = 0;
        int result = 0 ;
        while (x < 6) {
            obs[x] = new Puzzle4b();//
            obs[x].ivar=y;//
            y = y * 10;
            x = x + 1; //
        }
        x=6;
        while (x > 0) {
            x = x - 1;
            result = result + obs[x].doStuff(x);
        }
        System.out.println ("Result " + result);

    }

    static class Puzzle4b{
        int ivar;
        public int doStuff (int factor) {
            if (ivar > 100) {
                return ivar * factor;
            } else {
                return ivar * (5 - factor);
            }
        }
    }

}

/*
ivar = x;
obs.ivar = x;
obs[x].ivar=x;


Puzzle4 [] obs = new Puzzle4[6];

Puzlle4b [] obs = new Puzzle5[6];

doStuff(x);
obs.doStuff(x);
obs[x].doStuff(factor);





private


ivar * (2 + factor);






Puzzle4

Puzzle4b()


short

obs[x] = new Puzzle4b (x);
obs[] = new Puzzle4b();

obs = new Puzzle4b();

*/