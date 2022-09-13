package P68;

public class Player {
    int number = 0; // Хранение варианта числа

    public void guess() {
        number =(int) (Math.random() * 10);
        System.out.println("Думают, это число " + number);
    }
}