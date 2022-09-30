package p418;

import javax.sound.midi.*; //Генерация и воспроизведение звука
import javax.swing.*; // Графический интерфейс
import java.awt.*; // Графический интерфейс, используется отлов событий.

/**
 *
 * @author  Stepan M
 * @version 2022.09.230 v2.0.0
 * MusicPlayer
 * Регистрация событий и отображение в графическим интерфейсе.
 *
 * P421-423
 */



//Нужно отслеживать события ControllerEvent, реализуем интерфейс слушателя
public class MiniMusicPlayer3 {

    //Облявление статических переменных класса изменяемых внутренними классами
    static JFrame f = new JFrame("My first music clip");
    static MyDrawPanel ml;

    public static void main (String[] args) {
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        mini.go();
    } // end main


    //Инициализация интерфейса
    public  void SetUpGui() {
        ml = new MyDrawPanel();
        f.setContentPane(ml);
        f.setBounds(30, 30, 300, 300);
        f.setVisible(true);
    } // end SetUpGui()

    public void go() {
        SetUpGui();
        try {
            //Создаем объект секвенсера и открываем его на прием данных.
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            //Регестрируем отслеживаемое событие генерируемое панелью ml
            // прнимает объект слушателя и целочисленный массив,
            // представляющий собой списко событий ControllerEvent, которе нам нужны (конкретно сейчас  127)
            sequencer.addControllerEventListener(ml, new int[] {127});
            //создаем новый объект секвенции
            Sequence seq =new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            //Создание рандомизированного трека с регистрацией события старта ноты.
            int r = 0;
            for (int i = 0; i < 60; i+=4) {

                r = (int) ((Math.random() * 50) + 1);
                //запуск ноты
                track.add(makeEvent(144,1,r,100,i));
                //регистрация события (момент старта ноты)
                track.add(makeEvent(176,1,127,0,i));
                //окончание проигрывания ноты
                track.add(makeEvent(128,1,r,100,i+2));

            }// end for

            //Передаем секвенсру последовательность
            sequencer.setSequence(seq);
            //Устанавливаем скорость воспроизведения
            sequencer.setTempoInBPM(120);
            //запуск
            sequencer.start();

        } catch (Exception ex) {ex.printStackTrace();}
    } // end go() method

    //Вспомогательный статический метод, который создает и возвращает MidiEvent
    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        // Обнуление ссылки
        MidiEvent event = null;
        try {
            //создание события по заданным параметрам
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {}
        return event;
    }

    //Ручной виджет с интерфейсом прослушивателя
    class MyDrawPanel extends JPanel implements ControllerEventListener {

        //Присваиваем флагу значение false. Смна на True при получении события
        boolean msg = false;

        public void controlChange (ShortMessage event) {
            //При получении события присовить флаг true и произвести перерисовку.
            msg = true;
            repaint();
        }

        public void paintComponent (Graphics g) {
            //Необходимо использовать флаг, потому что другие объекты могут запустить repaint()
            //в данном случае необходимо рисовать только тогда, когда произойдет событие ControllerEvent.
            if (msg) {
                //Генерация случайного цвета и рисование полупроизвольного прямоугольника.
                Graphics2D g2 = (Graphics2D) g;

                int r = (int) (Math.random() * 250);
                int gr = (int) (Math.random() * 250);
                int b = (int) (Math.random() * 250);

                g.setColor(new Color(r,gr,b));

                int ht = (int) ((Math.random() * 120) + 10 );
                int width = (int) ((Math.random() * 120 ) + 10);
                int x = (int) ((Math.random() * 40 ) + 10);
                int y = (int) ((Math.random() * 40) + 10);
                g.fillRect(x,y,ht, width);
                msg = false;
            } // end if
        }// end paintComponent method
    } // end inner class

}




