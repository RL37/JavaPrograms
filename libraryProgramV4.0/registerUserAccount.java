package com.company;

import java.util.Scanner;

public class registerUserAccount {
    public static String registerAccount(){
        String email = getInput("What is your email");
        String password = getInput("What do you want your password to be");
        return email+","+password+",user";
    }

    public static String getInput(String caption){
        System.out.println(caption);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
