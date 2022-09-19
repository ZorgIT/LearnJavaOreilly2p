/**
 *
 * @author  Stepan M
 * @version 2022.09.19
 * ������� ���� "�������� ��������"
 * ������ ���� v 1.0.0
 * �������� ������ ���� �� ��������� ����������.
 */
public class SimpleGotComGame {
    public static void main (String[] args) {
        //��������� ���������� � �������������� ������� ���������
        //������� �������� ��� ������������ ��� �����������.
        //�� ��������� ����������� ���� ��������������� ������� ��������� ���  =0�
        int numOfGuesses = 0;

        GameHelper helper = new GameHelper();

        // ������� ������
        SimpleDotCom theDotCom = new SimpleDotCom();
        //���������� ��� ���� �������������� (��� ���������������� ������ � ����� ����).
        int [] locations = {3,4,5};
        // ��������� ��������� � �������.
        theDotCom.setLocationCells(locations);
        //����������� ������������ ������� ��� (����� ����������� ���������)
        System.out.println("Input your guess");

        //���������� ��� ����� ������������ ��������� ������, ������� �������� ������ � ����.
        String result ="";
        String userGuess;
        while (theDotCom.numOfHits<3) {
            userGuess = String.valueOf(0 + (int) (Math.random() * 5));
            //���������� ������
            numOfGuesses++;
            System.out.println(userGuess);
            theDotCom.checkYourself(userGuess);
         }
        System.out.println("You done it in " + numOfGuesses + " step");
        //����� �������� ������������ �������.
        //����� ����������  � ������������ ����, ������� ����� ������������ ������� ��������.

    }

}
