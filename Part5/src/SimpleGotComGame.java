/**
 *
 * @author  Stepan M
 * @version 2022.09.19
 * Задание типа "Создание программ"
 * Потопи сайт v 1.0.0
 * Создание модуля игры на основании всевдокода.
 */
public class SimpleGotComGame {
    public static void main (String[] args) {
        //Объявляем переменную и инициализируем нулевым значением
        //Нулевое значение для корректности при перезапуске.
        //По умолчанию примитивные типы инициализируютя базовым значением инт  =0ж
        int numOfGuesses = 0;

        GameHelper helper = new GameHelper();

        // Создаем объект
        SimpleDotCom theDotCom = new SimpleDotCom();
        //Загадываем для него местоположение (три последовательные ячейки в одном ряду).
        int [] locations = {3,4,5};
        // Фиксируем положение в объекте.
        theDotCom.setLocationCells(locations);
        //Предложение пользователю сделать ход (вызов виртуальной процедуры)
        System.out.println("Input your guess");

        //Изначально наш метод воспринимает строковые данные, поэтому приводим рандом к нему.
        String result ="";
        String userGuess;
        while (theDotCom.numOfHits<3) {
            userGuess = String.valueOf(0 + (int) (Math.random() * 5));
            //Количество ходово
            numOfGuesses++;
            System.out.println(userGuess);
            theDotCom.checkYourself(userGuess);
         }
        System.out.println("You done it in " + numOfGuesses + " step");
        //Нужна проверка дублирования ответов.
        //Нужна переменная  с размерностью поля, которая будет ограничивать область обстрела.

    }

}
