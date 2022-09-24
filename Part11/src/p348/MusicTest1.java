package p348;
import javax.sound.midi.*;
/**
 *
 * @author  Stepan M
 * @version 2022.09.24
 * Тестовый класс для работы с javasound
 * P348
 */
public class MusicTest1 {

    public void play () {
        /*
        Нам нужен объект Sequncer, он синтезируют "композицию" из информации в формате MIDI.
        */
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println ("We got sequenser");
        } catch (MidiUnavailableException ex) {
            System.out.println("Неудача");
        }

    } // end play

    public static void main (String [] args ){
            MusicTest1 mt = new MusicTest1();
            mt.play();
    }


    } //end class
