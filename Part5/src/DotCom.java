import java.util.ArrayList;
/**
 *
 * @author  Stepan M
 * @version 2022.09.19
 * ������� ���� "�������� ��������"
 * ������ ���� v 1.0.0
 *
 */
public class DotCom {
    //int [] locationCells;
    //int numOfHits =0;
    private  ArrayList<String> locationCells;

    public void setLocationCells (ArrayList<String> loc){
        locationCells = loc;
    }

    public String checkYourself(String userInput) {

        String result = "Missed";
        int index = locationCells.indexOf(userInput);
        if (index >= 0) {
            locationCells.remove (index);
            if (locationCells.isEmpty()) {
                result = "�������";
            } else  {
                result = "�����";
           } // end if
        }// end for
        return result;
    } //��������� �����
} //��������� �����
