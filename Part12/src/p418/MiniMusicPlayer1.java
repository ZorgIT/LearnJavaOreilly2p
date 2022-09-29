package p418;

import javax.sound.midi.*;
/**
 *
 * @author  Stepan M
 * @version 2022.09.29 v1.0.0
 * MusicPlayer
 * —оздание и тестирование вспомогательного метода
 *
 * P418-419
 */
public class MiniMusicPlayer1 {
    //ѕример использовани€ статического метода MidiEvent
    public static void main (String[] args) {
        try {

            //—оздаем и открываем синтезатор
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();


            //—оздаем последовательность и дорожку.
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            //—оздаем группу событий, чтобы ноты продолжали поднимать (от ноты фортепиано 5 до ноты 61).
            for (int i = 5; i < 61; i+=4) {
                track.add(makeEvent(144,1,i,100,i));
                track.add(makeEvent(128,1,i,100,i+2));
            } //end for

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (Exception ex) {ex.printStackTrace();}
    }

    //¬спомогательный статический метод, который создает и возвращает MidiEvent
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
