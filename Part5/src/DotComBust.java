import java.util.ArrayList;

/**
 *
 * @author  Stepan M
 * @version 2022.09.20
 * ������� ���� "�������� ��������"
 * ������ ���� v 1.0.2
 * �������� ������ ���� �� ��������� ����������.
 */
public class DotComBust {
    //���������� ����������
    private GameHelper helper = new GameHelper();
    private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>(3);
    private int numOfGuesses=0;

    //���������� �������

    private void setUpGame() {
       //������� ������� DotCom � ���������� �� ���� � �������
        DotCom one = new DotCom();
        one.setName("Pets.com");
        DotCom two = new DotCom();
        two.setName("eToys.com");
        DotCom three = new DotCom();
        three.setName("Go2.com");

        dotComsList.add(one);
        dotComsList.add(two);
        dotComsList.add(three);

        System.out.println("Your point - sink three \"site\"");
        System.out.println("Pets.com, eToys.com, Go2.com");
        System.out.println("Get it in min turn");

        for (DotCom dotComToSet:
             dotComsList) {
            ArrayList<String> newLocation = helper.placeDotCom(3);
            dotComToSet.setLocationCells(newLocation);
        }
    }
    private void startPlaying() {
        //����������� � ������������ ��� � �������� ����� checkUserGuess()
        while (!dotComsList.isEmpty()){
            String userGuess = helper.getUserInput("input your point:");
            checkUserGuess(userGuess);
        }
        finishGame();

    }
    void checkUserGuess(String userGuess) {
        //������������� ��� ��������� ������� DotCom � �������� ������ ������ DotCom ������ CheckYourself().
        numOfGuesses++;
        String result = "Missed";

        for (DotCom dotComToTest:
             dotComsList) {
            result = dotComToTest.checkYourself(userGuess);
            if (result.equals("Got it!")) {
                break;
            }
            if (result.equals("Sink")) {
                dotComsList.remove(dotComToTest);
                break;
            }
        }
        System.out.println(result);
    }

    private void finishGame() {
        //������� �� ����� ��������� �� ������� ������������
        //����������� �� ��� �� ������� ����� ��� ������� ��� �������
        System.out.println("All \"site\" are sink!");
        if (numOfGuesses <= 18) {
            System.out.println("It has been only " + numOfGuesses + " turn!");
            System.out.println("Some joke about dot.com crisis");
        } else {
            System.out.println("I has been to much time" + numOfGuesses + "turn.");
            System.out.println("you not good");
        }
    }
    public static void main (String[] args) {
        DotComBust game = new DotComBust();
        game.setUpGame();
        game.startPlaying();
    }






}
