package p418;

import javax.sound.midi.*;
/**
 *
 * @author  Stepan M
 * @version 2022.09.29 v1.0.0
 * MusicPlayer
 * Создание и тестирование вспомогательного метода
 *
 * P418-419
 */
public class MiniMusicPlayer1 {
    //Пример использования статического метода MidiEvent
    public static void main (String[] args) {
        try {

            //Создаем и открываем синтезатор
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();


            //Создаем последовательность и дорожку.
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            //Создаем группу событий, чтобы ноты продолжали поднимать (от ноты фортепиано 5 до ноты 61).
            for (int i = 5; i < 61; i+=4) {
                //Вызываем метод makeEvent(), а затем добавляем его  в трек
                // Событие включения 144, выключения 128
                track.add(makeEvent(144,1,i,100,i));
                track.add(makeEvent(128,1,i,100,i+2));
            } //end for

            //Запуск трека
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (Exception ex) {ex.printStackTrace();}
    }

    //Вспомогательный статический метод, который создает и возвращает MidiEvent
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
