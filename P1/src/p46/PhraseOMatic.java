/**
 *
 * @author  Stepan M
 * @version 2022.09.12
 * Практика набора кода + строковые массивы.
 */
package p46;

public class PhraseOMatic {
    public static void main (String[] args) {
        //Задание - создать три набора слов для выбора. Д
        String [] wordListOne = {"по ГОСТУ"," сделать по месту","обоюдный",
                "пятизвездочный","взаимовыгодный","светлый","тестовый"};
        String [] wordListTwo = {"воскрешенный","торжественный","метод критического пути",
                "сетевой","интероперабельный","кластеризованный","децентрализованный"};
        String [] wordListThree = {"выход из положения","структура данных","вероятностный",
                "битригональный","изумительный"};

        //Вычисление количества слов в каждом списке.

        int oneLength = wordListOne.length;
        int twoLength = wordListTwo.length;
        int threeLenght = wordListThree.length;

        //Генерация случайных чисел
        int rand1 = (int) (Math.random() * oneLength);
        int rand2 = (int) (Math.random() * twoLength);
        int rand3 = (int) (Math.random() * threeLenght);

        //Построение фразы
        String  phrase = wordListOne[rand1] +
                " " + wordListTwo[rand2] +
                " " + wordListThree[rand3];

        //Вывод на экран
        System.out.println("Все, что нам нужно - это " + phrase + "!");
    }
}
