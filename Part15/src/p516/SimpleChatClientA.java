package p516;

import  java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * @author  Stepan M
 * @version 2022.10.05
 * Задание типа "Готовый код"
 * Клиентская часть
 * Первая версия - умеет отправлять сообщения на сервер,
 * не способна принимать их от других участников.
 * P516
 */

public class SimpleChatClientA {

    JTextField outgoing;
    PrintWriter writer;
    Socket sock;

    public  void go () {
        JFrame frame = new JFrame("Ludicrously Simple CHat Client");
        JPanel mainPanel = new JPanel();
        outgoing = new JTextField(20);
        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(new SendButtonListener());
        mainPanel.add(outgoing);
        mainPanel.add(sendButton);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        setUpNetworking();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setVisible(true);
    }

    private void setUpNetworking() {
        try {
            sock = new Socket("127.0.0.1" , 5000);
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

    public static  void main (String[] args) {
        new SimpleChatClientA().go();
    }


}
