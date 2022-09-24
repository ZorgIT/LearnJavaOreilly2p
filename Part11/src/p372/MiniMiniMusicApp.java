package p372;
import javax.sound.midi.*;

/**
 *
 * @author  Stepan M
 * @version 2022.09.24
 * Первое приложение для проигрывания звуков v 0.1
 * P372
 */

public class MiniMiniMusicApp {
    public static void main (String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    } //end main

    public void play () {

        try {
            //Получаем синтезатор и открываем его что бы можно было использовать (изначально он не открыт)
            Sequencer player = MidiSystem.getSequencer();
            player.open();

            //Пока строчка без подробностей  - заранее подготовленные аргументы
            Sequence seq = new Sequence(Sequence.PPQ, 4);

            //Запрашиваем трек у последовательности. ТРЕК В ПОСЛЕДОВАТЕЛЬНОСТИ, MIDI СОБЫТИЯ В ТРЕКЕ.
            Track track = seq.createTrack();


            // Помещаем в трек MIDI-события. Код подготовлен заранее
            ShortMessage a = new ShortMessage();
            a.setMessage(144, 1, 20, 100);
            MidiEvent noteOn = new MidiEvent (a, 1);
            track.add(noteOn);

            ShortMessage b = new ShortMessage();
            b.setMessage(128, 1, 20, 100);
            MidiEvent noteOff = new MidiEvent (b, 3);
            track.add(noteOff);

            //Передаем последовательность синтезатору
            player.setSequence(seq);

            //Запуск синтезатора
            player.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    } //end play


}// end class
