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
        int randomNum = (int) (Math.random() * 5);
        int [] locations = {randomNum,randomNum + 1,randomNum +2};
        // ��������� ��������� � �������.
        theDotCom.setLocationCells(locations);
        //����������� ������������ ������� ��� (����� ����������� ���������)
        boolean isAlive = true;
        //���������� ��� ����� ������������ ��������� ������, ������� �������� ������ � ����.
        String userGuess;
        while (isAlive == true) {
            String guess = helper.getUserInput ("������� �����");
            String result = theDotCom.checkYourself(guess);
            numOfGuesses++;
            if (result.equals("SINK")) {
                isAlive = false;
                System.out.println("You done it in " + numOfGuesses + " step");
            } // end if
         } // edn while
        //����� �������� ������������ �������.
        //����� ����������  � ������������ ����, ������� ����� ������������ ������� ��������.
    } //end main
} // end class