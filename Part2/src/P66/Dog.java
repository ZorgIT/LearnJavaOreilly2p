package P66;
/**
 *
 * @author  Stepan M
 * @version 2022.09.13
 * Создание первого объекта
 */
public class Dog {

    //Переменные экземпляра
    int size;
    String breed;
    String name;

    //Метод экземпляра
    void bark () {
        System.out.println("Гав! Гав!");
    }
}

class DogTestDrive {
    public static void main (String [] args) {
        //проверочный код для класса Dog

        //создаем объект класса Dog
        Dog d = new Dog();
        // Используя оператор доступа устанавливаем значение поля
        d.size = 40;
        //выозв метода bark()
        d.bark();
    }
}
