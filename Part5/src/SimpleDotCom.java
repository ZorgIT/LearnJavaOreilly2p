/**
 *
 * @author  Stepan M
 * @version 2022.09.19
 * ������� ���� "�������� ��������"
 * ������ ���� v 1.0.0
 *
 */
public class SimpleDotCom {
    int [] locationCells;
    int numOfHits =0;
    public void setLocationCells (int[] locs){
        locationCells = locs;
    }

    public String checkYourself(String stringGuess) {

        //�������������� ���� String � int
        int guess = Integer.parseInt(stringGuess);

        //�������� ���������� ��� �������� ���������� ������� ����� ����������.
        // �� ��������� ����������� ��������� �������� "����"
        String result = "Missed";

       // ��������� � ������ ������� �� ������� locationCells (�������������� ������ �������).
        for (int cell : locationCells) {
           //���������� ��� ������������ � ���� ��������� (�������) �������.
            if (guess == cell) {
                //����������� ���������.
                result = "Got it!";
                // �������������� ����������
                numOfHits++;
                //����� �� ����� (��������������).
                break;
           } // end if
        }// end for

        if (numOfHits == locationCells.length) {
            //����� ������ �� ����� ��������� �� �������� �� "����"
            //��� ������������� - ��������� ���������.
            result = "SINK";
        } // end if

        //����� �������� �������� ������������ - ����/�����/�������.
        System.out.println(result);
        //���������� ��������� ��� ����������� ��������� � ���������� �����.
        return result;
    } //��������� �����
} //��������� �����
