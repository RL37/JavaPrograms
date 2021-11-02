package com.company;

import javax.swing.*;
import java.awt.*;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String[][] board = new String[10][8];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = " [ ] ";
            }
        }

        JFrame frame = new JFrame("Treasure Hunt");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);

        DefaultListModel dlm = new DefaultListModel();
        JList list = new JList(dlm);
        JScrollPane scrollPane = new JScrollPane(list);

        JPanel panel = new JPanel(); // the panel is not visible in output
        JLabel label = new JLabel("Enter Text");
        JTextField tf = new JTextField(10); // accepts upto 10 characters
        JButton send = new JButton("Send");
        panel.add(label); // Components Added using Flow Layout
        panel.add(tf);
        panel.add(send);
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.setVisible(true);

        int goAgain         = 0;
        int coinsPosX       = random.nextInt(7 +1);
        int coinsPosY       = random.nextInt(9 +1);
        int coinsAmount     = random.nextInt(9);
        //String[][] board = setGrid();

        // remove this
        System.out.println(coinsPosX);
        System.out.println(coinsPosY);

        do{
            dlm.addElement("----------------------------------");
            for (int i = 0; i < 10; i++) {
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < 8; j++) {
                    sb.append(board[i][j]);
                }
                String boardRow = sb.toString();
                dlm.addElement(boardRow);
            }
            dlm.addElement("----------------------------------");
            dlm.addElement("");
            frame.add(scrollPane);
            frame.setVisible(true);

            dlm.addElement("Take a guess at the x coordinate");
            int guessX = input.nextInt();
            dlm.addElement("Take a guess at the y coordinate");
            int guessY = input.nextInt();
            if (guessX == coinsPosX && guessY == coinsPosY){
                dlm.addElement("you found "+coinsAmount+ "coins");
                board[coinsPosX][coinsPosY] = " [X] ";
            }
        }while(goAgain == 0);
    }
}
