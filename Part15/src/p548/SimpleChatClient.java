package p548;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.util.*;

/**
 * @author  Stepan M
 * @version 2022.10.05
 * ??????? ???? "??????? ???"
 * ?????????? ?????
 * ?????? ?????? - ????? ??????????  ? ????????? ????????? ?? ???????
 * ?? ???????? ????????? ?? ?? ?????? ??????????.
 * P516
 */

public class SimpleChatClient {

    JTextArea incoming;
    JTextField outgoing;
    BufferedReader reader;
    PrintWriter writer;
    Socket sock;

    public static  void main (String[] args) {
        SimpleChatClient client = new SimpleChatClient();
        client.go();
    }
    public  void go () {
        JFrame frame = new JFrame("Ludicrously Simple Chat Client");
        JPanel mainPanel = new JPanel();
        incoming = new JTextArea(15,30);
        incoming.setLineWrap(true);
        incoming.setWrapStyleWord(true);
        incoming.setEditable(false);
        JScrollPane qScroller = new JScrollPane(incoming);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(qScroller);
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        setUpNetworking();

        Thread readerThread = new Thread(new IncomingReader());
        readerThread.start();


        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setVisible(true);
    } // end go() method

    private void setUpNetworking() {
        try {
            sock = new Socket("127.0.0.1" , 5000);
            InputStreamReader streamReader=new InputStreamReader(sock.getInputStream());
            reader = new BufferedReader(streamReader);
            writer = new PrintWriter(sock.getOutputStream());
            System.out.println("networking established");
        } catch (Exception ex ) {
            ex.printStackTrace();
        }
    }

    public class SendButtonListener implements  ActionListener {
        public void actionPerformed (ActionEvent ev) {
            try {
                writer.println(outgoing.getText());
                writer.flush();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
            outgoing.setText("");
            outgoing.requestFocus();
        }
    } // End SendButtonListener

    public class  IncomingReader implements Runnable {
        public void run () {
            String message2;
            try {

                while  ((message2 = reader.readLine()) != null) {
                    System.out.println("read " + message2);
                    incoming.append(message2 + "\n");
                }

            } catch (Exception ex) { ex.printStackTrace();}
        } // end run()
    } // end inner class
} //end outer class
