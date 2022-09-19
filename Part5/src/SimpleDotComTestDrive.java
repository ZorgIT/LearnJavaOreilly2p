/**
 *
 * @author  Stepan M
 * @version 2022.09.19
 * ������� ���� "�������� ��������"
 * ������ ���� v 1.0.0
 * �������� ������ ������������ �������
 */
public class SimpleDotComTestDrive {
    public static void main (String [] args ) {
        //������� ��������� ������ SimpleDotCom
        SimpleDotCom dot = new SimpleDotCom();

        //������� ������ ��� �������������� "�����" (��� ���������������� ����� �� ����)
        int[] locations = {2, 3, 4};
        //�������� ������ "�����"
        dot.setLocationCells(locations);

        //������ ��� �� ����� ������������
        String userGuess = "2";
        //�������� ����� checkYourSelf() ������� SimpleDotCom
        String result = dot.chekYourself(userGuess);
        String testResult = "�������";

        if (result.equals("�����")) {
            //���� ��� (2) ���������� ������ "�����", ������ ��� ��������.
            testResult = "�������";
        }

        System.out.println(testResult);


    }
}

/*������ � �����:
 ��� ����� ��������� �������� �����
 ��� �� �������, ������� ��������� �� ���������, � ��� ��������

 �����:

 �������� ������������ ����� �� ������������ (�������� ���������� ���������� �������)


*/