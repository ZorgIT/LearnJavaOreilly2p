package QuizCardGame;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 *
 *
 * @author  Stepan M
 * @version 2022.10.03
 * Модуль построения игровых карт
 * "Готовый код"
 * P480-481
 */

public class QuizCardBuilder {

    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private JFrame frame;

    public static void main (String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }

    public void go () {
        //формируем GUI

        frame = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);
        question = new JTextArea(6,20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);

        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy (ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        answer = new JTextArea(6,20 );
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);

        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextButton = new JButton("Next Card");

        cardList = new ArrayList<QuizCard>();

        JLabel qLabel = new JLabel("Question: ");
        JLabel aLabel = new JLabel("Answer: ");


        //Создается объект JMenuBar и добавляем в него меню File с пунктами Создать и сСохранить.
        // Далее передаем меню главной панели. Пункты меню могут запускать ActionEvent.

        mainPanel.add(qLabel);
        mainPanel.add(qScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem =  new JMenuItem("Save");
        newMenuItem.addActionListener(new NewMenuListener());

        saveMenuItem.addActionListener(new SaveMenuListener());
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500,600);
        frame.setVisible(true);
    }

    public class NextCardListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {

            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);
            clearCard();
        }
    }

    public class  SaveMenuListener implements ActionListener {
        public void actionPerformed (ActionEvent ev) {
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);

            //Вызывается диалогове окно и работа приостанавливается на этой строке,
            // пока пользователь не выберет меню Save. За навигацию, выбор файла и тд. обрабатывает JFileChooser
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }
    } //end SaveMenuListener

    public class NewMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            cardList.clear();
            clearCard();
        }
    }

    private void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

    //Метод записывает переданный объект File файл
    private  void saveFile (File file) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));

            //Перебор массива с картами и запись их по одной на строку, разделяя вопрос и ответ символом "/"
            for(QuizCard card:cardList) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
            writer.close();

        } catch (IOException ex) {
            System.out.println("couldn't write the cardList out");
            ex.printStackTrace();
        }
    }
}
