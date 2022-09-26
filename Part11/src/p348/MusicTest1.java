package p348;
import javax.sound.midi.*;
/**
 *
 * @author  Stepan M
 * @version 2022.09.24
 * �������� ����� ��� ������ � javasound
 * P348
 */
public class MusicTest1 {

    public void play () {
        /*
        ��� ����� ������ Sequncer, �� ����������� "����������" �� ���������� � ������� MIDI.
        */
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println ("We got sequenser");
        } catch (MidiUnavailableException ex) {
            System.out.println("�������");
        }

    } // end play

    public static void main (String [] args ){
            MusicTest1 mt = new MusicTest1();
            mt.play();
    }


    } //end class
