/**
 *
 * @author  Stepan M
 * @version 2022.09.19
 * Задание типа "Создание программ"
 * Потопи сайт v 1.0.0
 * Создание модуля тестирования запуска
 */
public class SimpleDotComTestDrive {
    public static void main (String [] args ) {
        //Создаем экземпляр класса SimpleDotCom
        DotCom dot = new DotCom();

        //Создаем массив для местоположения "Сайта" (три последовательных числа из семи)
        int[] locations = {2, 3, 4};
        //Вызываем сеттер "Сайта"
        //dot.setLocationCells(locations);

        //Делаем ход от имени пользователя
        String userGuess = "2";
        //Вызываем метод checkYourSelf() объекта SimpleDotCom
        String result = dot.checkYourself(userGuess);
        String testResult = "Неудача";

        if (result.equals("Попал")) {
            //Если ход (2) возвращает строку "Попал", значит все работает.
            testResult = "Пройден";
        }

        System.out.println(testResult);


    }
}

/*Вопрос в книге:
 Как можно дополнить тестовый класс
 Как ие моменты, которые следовало бы проверить, в нем упущенны

 Ответ:

 Проверка корректности ввода от пользователя (диапазон возможного размещения массива)


*/
