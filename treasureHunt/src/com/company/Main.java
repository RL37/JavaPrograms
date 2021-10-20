package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static String[][] setGrid(){
        String[][] board = new String[10][8];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = " [ ] ";
            }
        }
        return board;
    }

    public static void showGrid(String[][] board){
        for (int i = 0; i < 10; i++) {
            System.out.println("");
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j]);
            }
        }
        return;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int goAgain         = 0;
        int coinsPosX       = random.nextInt(7 +1);
        int coinsPosY       = random.nextInt(9 +1);
        int coinsAmount     = random.nextInt(9);
        String[][] board = setGrid();

        // remove this
        System.out.println(coinsPosX);
        System.out.println(coinsPosY);

        do{
            showGrid(board);
            System.out.println("Take a guess at the x coordinate");
            int guessX = input.nextInt();
            System.out.println("Take a guess at the y coordinate");
            int guessY = input.nextInt();
            if (guessX == coinsPosX && guessY == coinsPosY){
                System.out.println("you found "+coinsAmount+ "coins");
                board[coinsPosX][coinsPosY] = " [X] ";
            }
        }while(goAgain == 0);

    }
}
