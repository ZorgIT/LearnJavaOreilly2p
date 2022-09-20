/**
 *
 * @author  Stepan M
 * @version 2022.09.19
 * Задание типа "Создание программ"
 * Потопи сайт v 1.0.0
 * Создание модуля игры на основании всевдокода.
 */
public class SimpleDotComGame {
    public static void main (String[] args) {
        //Объявляем переменную и инициализируем нулевым значением
        //Нулевое значение для корректности при перезапуске.
        //По умолчанию примитивные типы инициализируютя базовым значением инт  =0ж
        int numOfGuesses = 0;

        GameHelper helper = new GameHelper();

        // Создаем объект
        DotCom theDotCom = new DotCom();
        //Загадываем для него местоположение (три последовательные ячейки в одном ряду).
        int randomNum = (int) (Math.random() * 5);
        int [] locations = {randomNum,randomNum + 1,randomNum +2};
        // Фиксируем положение в объекте.
        theDotCom.setLocationCells(locations);
        //Предложение пользователю сделать ход (вызов виртуальной процедуры)
        boolean isAlive = true;
        //Изначально наш метод воспринимает строковые данные, поэтому приводим рандом к нему.
        String userGuess;
        while (isAlive == true) {
            String guess = helper.getUserInput ("Введите число");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("SINK")) {
                isAlive = false;
                System.out.println("You done it in " + numOfGuesses + " step");
            } // end if
         } // edn while
        //Нужна проверка дублирования ответов.
        //Нужна переменная  с размерностью поля, которая будет ограничивать область обстрела.
    } //end main
} // end class
