package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        String ticketsList[][] = ticketsList();
        int nextTicketPurchasePos = 0;
        boolean loop = true;
        displayList();
        while (loop == true) {
            try {
                String option = getString();
                if (option.equals("purchase")) { //sets users name to a ticket number
                    String name = getName();
                    ticketsList[nextTicketPurchasePos][0] = String.valueOf(nextTicketPurchasePos);
                    ticketsList[nextTicketPurchasePos][1] = name;
                    nextTicketPurchasePos++;

                }
                if (option.equals("check")) {    //checks if user has a winning ticket and if their name is bound to that ticket number
                    //goes through prime numbers
                    int currentPrime = 0;
                    int currentPrimePos = 0; //this is to generate prime numbers using 6n-1
                    for (int i = 2; i < 100; i++) {
                        switch (currentPrimePos) {
                            case 2:
                                currentPrime = 2;
                                break;
                            case 3:
                                currentPrime = 3;
                                break;
                            default:
                                currentPrime = 6 * i - 1;
                                break;
                        }

                        //checks list for any winners
                        for (int j = 0; j < ticketsList().length; j++) {
                            String currentTicketNum = String.valueOf(ticketsList[j][0]);
                            String currentPrimeStr = String.valueOf(currentPrime);
                            String name = getName();
                            if (name.equals(ticketsList[j][1])) {
                                if (currentTicketNum.equals(currentPrimeStr)) {
                                    System.out.println("You won a prize");
                                }
                                else {
                                    System.out.println("Sorry, your name does not match up to that ticket holder");
                                }
                                i = 100;
                                j = 100;
                            }
                            else{
                                System.out.println("you did not win a prize");
                            }
                        }
                    }
                }
            } catch (Exception e) {
                System.out.println("error" + e);
            }
        }
    }

    //gets users name
    private static String getName() throws IOException {
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        System.out.println("What is your name");
        String name = bufferedReader.readLine();
        return name;
    }

    //print the ticket list
    private static void displayList() {
        String[][] ticketsList = ticketsList();
        for (int i = 0; i < ticketsList.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(ticketsList[i][j]);
                System.out.print(" ");
            }
        }
    }

    //generates the list with the ticket values and name placeholders
    private static String[][] ticketsList() {
        String ticketsList[][] = new String[100][100];
        for (int i = 0; i < ticketsList.length; i++) {
            int count = 0;
            for (int j = 0; j < 2; j++) {
                String ticketValue = String.valueOf(i);
                ticketsList[i][count] = ticketValue;
            }
        }
        return ticketsList;
    }

    //checks if the user want to buy a ticket or check one
    private static String getString() throws IOException {
        BufferedReader bufferedReader = new BufferedReader((new InputStreamReader(System.in)));
        System.out.println("\nDo you want to check a ticket or purchase one\nEnter check or purchase");
        String option = bufferedReader.readLine();
        //String option = String.valueOf(Integer.parseInt(bufferedReader.readLine()));
        return option;
    }
}
