package P92;
/**
 *
 * @author  Stepan M
 * @version 2022.09.15
 * Задание типа "Набери и запусти"
 * отработка использования ссылок
 */
public class Dog {
    String name;
    public static void main (String[] args) {
        //Create object Dog and get access
        Dog dog1 = new Dog();
        dog1.bark();
        dog1.name = "Bart";

        //Create massive type Dog
        Dog[] myDogs = new Dog[3];
        //put into myDogs some elements
        myDogs[0] = new Dog();
        myDogs[1] = new Dog();
        myDogs[2] = dog1;

        // Get access to Dog objects
        // by link from massive
        myDogs[0].name = "Fred";
        myDogs[1].name = "Gorgee";

        // Get field value bu .

        System.out.print("name of last dog - ");
        System.out.println(myDogs[2].name);

        // Loop all elemnt dog massive
        // call method bar() for all

        int x = 0;
        while (x < myDogs.length) {
            myDogs[x].bark();
            x = x + 1;
        }
    }

        //Create public methods for Dog class
    public void bark() {
        System.out.println (name + "say woof!");
    }
    public void eat() {}
    public void chaseCat() {}
}


