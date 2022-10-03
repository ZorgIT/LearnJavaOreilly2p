import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author  Stepan M
 * @version 2022.10.01
 * Задача типа "Кухня кода" -
 * P450-453
 */
public class BeatBoxV2 {

    JPanel mainPanel;
    ArrayList<JCheckBox> checkBoxList;
    Sequencer sequencer;
    Sequence sequence;
    Track track;
    JFrame theFrame;

    //Массив наименования инструментов
    String[] instrumentName = {"Bass Drum", "Closed Hi-Hat", "Open Hi-Hat", "Acoustc Snare",
            "Crash Cymbal", "Hand Clap", "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
            "Cowbell", "Vibraslap", "Lowmid Tom", "High Agogo", "Open Hi Conga"};
    //Барабанные клавиши
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    public static void main(String[] args) {
        new BeatBoxV2().buildGUI();
    }

    private void buildGUI() {
        theFrame = new JFrame("Cyber BeatBox");
        theFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        //Пустая граница создает поля между краями панели и метом размещения компонентов
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        checkBoxList = new ArrayList<JCheckBox>();
        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(new MyStartListener());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new MyStopListener());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(new MyUpTempoListener());
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo down");
        downTempo.addActionListener(new MyDownTempoListener());
        buttonBox.add(downTempo);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (int i = 0; i < 16; i++) {
            nameBox.add(new Label(instrumentName[i]));
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        theFrame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);
        mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        //Создание флажков на панели с присвоением снятого положения.
        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkBoxList.add(c);
            mainPanel.add(c);
        } //end for

        setUpMidi();

        theFrame.setBounds(50, 50, 300, 300);
        theFrame.pack();
        theFrame.setVisible(true);

    } // end method

    //Инициализация синтезатора, секвенсора и дорожки
    public void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);

        } catch (Exception e) {
            e.printStackTrace();
        } //End method
    }

    public  void buildTrackAndStart() {
        //Массив из 16 элементов для хранения значения каждого инструмента.
        int[] trackList = null;

        sequence.deleteTrack(track);
        track = sequence.createTrack();

        for (int i = 0; i < 16; i++) {    //Для каждого из 16 рядов
            trackList = new int[16];


            int key = instruments[i]; //Задаем клавишу по инструменту.(В массиве числа для каждого инструмента)

            for (int j = 0; j < 16 ; j++) { //Применить для каждого ряда

                JCheckBox jc = (JCheckBox) checkBoxList.get(j +(16*i));
                if (jc.isSelected()) { // Провека флажка на такте.
                    trackList[j] = key; // устанавливаем в текущую ячейку массива
                } else {
                    trackList[j] = 0; //инструмент не играет
                }
            }// end inner for j

            makeTrack(trackList); // для этого инструмента и для всех 16 тактов
            // создаются события и добавляются на дорожку
            track.add(makeEvent(176,1,127,0,16));
        } // end outer for i

        //Всегда нужно быть уверенным что событие на 16 такте существует
        //Иначе может пройти  16 тактов, перед тем как заново начнется последовательность.
        track.add(makeEvent(192, 9, 1, 0 , 15));
        try {

            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY); //Задает непрерывный цикл
            sequencer.start();
            sequencer.setTempoInBPM(120); // темп

        } catch (Exception e) {e.printStackTrace();}
    } // end buildTrackAndStart

    public  class MyStartListener  implements ActionListener {
        public void actionPerformed (ActionEvent a) {
            buildTrackAndStart();
        }
    }

    public class MyStopListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {
            sequencer.stop();
        }
    } //End MyStopListener

    public class MyUpTempoListener implements ActionListener {
        public void actionPerformed (ActionEvent a) {
            float tempoFactor = sequencer.getTempoFactor();
                sequencer.setTempoFactor((float) (tempoFactor * 1.03));
        }
    } // end MyUpTempoListener

    public class MyDownTempoListener implements ActionListener {
        public void actionPerformed (ActionEvent a) {
            float tempoFactor = sequencer.getTempoFactor();
                sequencer.setTempoFactor((float) (tempoFactor* .97));
        }
    } // end MyDownTempoListener

    public void makeTrack (int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];

            if (key != 0) {
                track.add(makeEvent(144,9, key, 100, i)); //начать воспроизведение ноты
                track.add(makeEvent(128,9, key, 100, i+1)); // окончание воспроизведения ноты
            }
        }
    } // end makeTrack;

    public MidiEvent makeEvent (int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a= new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {e.printStackTrace(); }
        return event;
    }

    public class MySendListener implements ActionListener {
        public void actionPerformed(ActionEvent a) {

            boolean [] checkboxState = new boolean[256];
            for (int i = 0; i < 256; i++) {
                JCheckBox chek = (JCheckBox) checkBoxList.get(i);
                if (chek.isSelected()) {
                    checkboxState[i]=true;
                }

            }

            try {
                FileOutputStream fileStream = new FileOutputStream(new File("Checkbox.ser"));
                ObjectOutputStream os = new ObjectOutputStream(fileStream);
                os.writeObject(checkboxState);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

} // end BeatBox
