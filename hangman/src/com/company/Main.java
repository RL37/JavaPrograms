package com.company;

import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	Random random = new Random();

	String[] wordsList          = {"dog","cat","laser","wind","dartboard","cow","keyboard","game","floor","light","chocolate","brain","iron","car","rocket","lava","house","mushroom"};
	String[] hangmanNoPerson    = {"_______","|","|","|","|","|","|"};
	String[] hangmanWithPerson  = {"_______","|    |","|    0","|   -|-","|   ( )","|","|"};

	int letterInWordCheck   = 0;
	int boardState          = 0;
	int gameRun             = 0;
	int wordToGuessNum      = random.nextInt(wordsList.length);
	String wordToGuess      = wordsList[wordToGuessNum];

        char[] wordToGuessArray = new char[wordToGuess.length()];
        for (int i = 0; i < wordToGuess.length(); i++) {
            wordToGuessArray[i] = wordToGuess.charAt(i);
        }
        String[] guessTally = new String[wordToGuess.length()];
        System.out.println(hangmanNoPerson[0]);

        for (int i = 0; i <7 ; i++) {
            switch (boardState){
                case 1:
                    for (int j = 0; j < 6; j++) {
                        System.out.println(hangmanNoPerson[j]);
                    }
                    break;
                case 2:
                    for (int j = 0; j < 3; j++) {
                        System.out.println(hangmanWithPerson[j]);
                    }
                    for (int j = 3; j < 6; j++) {
                        System.out.println(hangmanNoPerson[j]);
                    }
                    break;
                case 3:
                    for (int j = 0; j < 4; j++) {
                        System.out.println(hangmanWithPerson[j]);
                    }
                    for (int j = 4; j < 6; j++) {
                        System.out.println(hangmanNoPerson[j]);
                    }
                    break;
                case 4:
                    System.out.println("case 4");
                    for (int j = 0; j < 6; j++) {
                        System.out.println(hangmanWithPerson[j]);
                    }
                    System.out.println("YOU LOSE");
                    i = 8;
                    gameRun = 1;
                    break;
            }

            if (gameRun == 0) {
                System.out.println("Take a guess, you can either try guess the whole word or just a letter");
                String guess = input.next();
                if (guess.length() > 1) {
                    if (guess.equals(wordToGuess)) {
                        System.out.println("You win");
                        gameRun = 1;
                        i = 8;
                    } else {
                        System.out.println("Incorrect, that is not my word");
                    }
                } else {
                    for (int j = 0; j < wordToGuess.length(); j++) {
                        String wordToGuessJString = String.valueOf(wordToGuessArray[j]);
                        guessTally[j] = guess;
                        if (guess.equals(wordToGuessJString)) {
                            System.out.println("The letter " + guess + " is in my word");
                            letterInWordCheck = 1;
                        }
                    }
                    if (letterInWordCheck == 0) {
                        System.out.println("That letter is not in my word");
                        boardState++;
                    }
                    letterInWordCheck = 0;
                }
                /*
                String currentLetterGuess = "a";
                int letterMatchTally = 0;
                for (int j = 0; j < wordToGuessArray.length; j++) {
                    currentLetterGuess = String.valueOf(wordToGuessArray[j]);
                    for (int k = 0; k < guessTally.length; k++) {
                        String currentLetter = String.valueOf(guessTally[j]);
                        if (currentLetterGuess.equals(currentLetter)){
                            letterMatchTally++;
                        }
                    }
                }
                if(letterMatchTally >= wordToGuess.length()){
                    System.out.println("YOU WIN");
                    gameRun = 1;
                    i = 8;
                }

                 */
            }
        }
    }
}
