package p418;

import javax.sound.midi.*;
/**
 *
 * @author  Stepan M
 * @version 2022.09.29 v1.0.0
 * MusicPlayer
 * �������� � ������������ ���������������� ������
 *
 * P418-419
 */
public class MiniMusicPlayer1 {
    //������ ������������� ������������ ������ MidiEvent
    public static void main (String[] args) {
        try {

            //������� � ��������� ����������
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();


            //������� ������������������ � �������.
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            //������� ������ �������, ����� ���� ���������� ��������� (�� ���� ���������� 5 �� ���� 61).
            for (int i = 5; i < 61; i+=4) {
                //�������� ����� makeEvent(), � ����� ��������� ���  � ����
                // ������� ��������� 144, ���������� 128
                track.add(makeEvent(144,1,i,100,i));
                track.add(makeEvent(128,1,i,100,i+2));
            } //end for

            //������ �����
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (Exception ex) {ex.printStackTrace();}
    }

    //��������������� ����������� �����, ������� ������� � ���������� MidiEvent
    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {}
        return event;
    }
}
