/**
 *
 * @author  Stepan M
 * @version 2022.09.19
 * Задание типа "Создание программ"
 * Потопи сайт v 1.0.0
 *
 */
public class SimpleDotCom {

    public String checkYourself(String stringGuess) {
       int guess = Integer.parseInt(stringGuess);
       String result = "Мимо";

       for (int cell : locationCells) {
           if (guess == cell) {
               result = "Попал";
               numOfHits++;
               break;
           } // end if
       }// end for
        if (numOfHits == locationCells.length) {
            result = "Потопил";
        } // end if
        System.out.println(result);
        return result;
    }
}
