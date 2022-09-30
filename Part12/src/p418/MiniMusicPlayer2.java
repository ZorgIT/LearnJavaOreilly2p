package p418;

import javax.sound.midi.*;
/**
 *
 * @author  Stepan M
 * @version 2022.09.29 v1.0.5
 * MusicPlayer
 * –егистраци€ событий и с выводом в консоль
 *
 * P420-421
*/
//ѕример использовани€ статического метода MidiEvent

//Ќужно отслеживать событи€ ControllerEvent, реализуем интерфейс слушател€
public class MiniMusicPlayer2 implements ControllerEventListener {
    public static void main (String[] args) {
        MiniMusicPlayer2 mini = new MiniMusicPlayer2();
        mini.go();
    }

    public void go() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();

            //–егистрируем событи€ синтезатором.ћетод отвечающий за регистрацию,
            // прнимает объект слушател€ и целочисленный массив,
            // представл€ющий собой списко событий ControllerEvent, которе нам нужны (конкретно сейчас  127)
            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(this, eventsIWant);

            Sequence seq = new Sequence(Sequence.PPQ,4);
            Track track = seq.createTrack();

            for (int i=5; i<60; i+= 4) {
                track.add(makeEvent(144,1,i,100,i));
                //¬ этом месте "Ћовитс€ ритм" - добавл€етс€ собственное событие (176 - тип событи€ ControllerEvent)
                //аргумент событи€ 127 - ничего не делает, выставл€етс€
                // дл€ возможнсоти реагировать на восрпоизведение ноты. (отслеживать)
                track.add(makeEvent(176,1,127,0,i));
                track.add(makeEvent(128,1,i,100,i+2));
            } //end for
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception ex) {ex.printStackTrace();}
    } // end go() method

    //”словный метод обработки событи€ ( из интерфейса слушател€ событи€ ControllerEvent)
    // ѕри каждом отслеживани€ событи€ 127 метод выполнитс€.
    public void controlChange (ShortMessage event) {
        System.out.println("л€");
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




