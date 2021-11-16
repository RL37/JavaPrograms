package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int houseNum = getHouseNum();
        int matchesNum = getMatchesNum(houseNum);
        System.out.println("You will need "+matchesNum+" matchsticks");
    }

    private static int getMatchesNum(int houseNum) {
        int matchesNum = 1;
        matchesNum = matchesNum + 5 * houseNum;
        return matchesNum;
    }

    private static int getHouseNum() {
        Scanner input = new Scanner(System.in);
        System.out.println("How many matchstick houses do you want\nand this will calculate how many you need");
        int houseNum = input.nextInt();
        return houseNum;
    }
}
