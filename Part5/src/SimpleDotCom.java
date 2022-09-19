/**
 *
 * @author  Stepan M
 * @version 2022.09.19
 * Задание типа "Создание программ"
 * Потопи сайт v 1.0.0
 *
 */
public class SimpleDotCom {
    int [] locationCells;
    int numOfHits =0;
    public void setLocationCells (int[] locs){
        locationCells = locs;
    }

    public String checkYourself(String stringGuess) {

        //Преобразование типа String в int
        int guess = Integer.parseInt(stringGuess);

        //Создание переменной для хранения результата который будем возвращать.
        // По умолчанию присваиваем строковое значение "Мимо"
        String result = "Мимо";

       // повторяем с каждой ячейкой из массива locationCells (местоположение ячейки объекта).
        for (int cell : locationCells) {
           //Сравниваем ход пользователя с этим элементом (ячейкой) массива.
            if (guess == cell) {
                //Обнаруженно попадание.
                result = "Попал";
                // зафиксированно попадаение
                numOfHits++;
                //выход из цикла (принудительный).
                break;
           } // end if
        }// end for

        if (numOfHits == locationCells.length) {
            //После выхода из цикла проверяем не потоплен ли "сайт"
            //При подтверждении - фиксируем результат.
            result = "Потопил";
        } // end if

        //Вывод результа проверки пользователю - Мимо/Попал/Потопил.
        System.out.println(result);
        //Возвращаем результат для последующей обработки в вызывающий метод.
        return result;
    } //завершаем метод
} //завершаем класс
