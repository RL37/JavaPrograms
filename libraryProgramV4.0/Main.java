package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static com.company.getBooksInput.getBookDetails;
import static com.company.menuHandling.*;
import static com.company.registerUserAccount.registerAccount;

public class Main {

    private static ArrayList<String> booksLibrary = new ArrayList<>();

    public static void main(String[] args) {
        String userType = loginMenu();
        if (userType.equals("user")){
            runMainMenu();
        }
        if (userType.equals("admin")){
            runAdminMenu();
        }
    }



    public static String loginUser(String fileToAccess){
        File fileHandler = new File(fileToAccess);
        String isUser = "notLoggedIn";
        String userDetails = getInput("What is your email") +","+ getInput("What is your password");
        //String password = getInput("What is your password");
        try {
            Scanner myReader = new Scanner(fileHandler);
            int i =0;
            while (myReader.hasNextLine()) {
                /*
                if (userDetails.equals(myReader.nextLine())) {
                    isUser = true;
                }
                 */
                if (myReader.nextLine().equals(userDetails.split(",")[0]) && myReader.nextLine().equals(userDetails.split(",")[1])) {
                    isUser = "isUser";
                    userDetails = myReader.nextLine();
                    if (myReader.nextLine().equals(userDetails.split(",")[2])){
                        isUser = "isAdmin";
                    }
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        //remove this later
        isUser = "isUser";
        return isUser;
    }

    public static void saveDetailsToFile(String Details,String fileToAccess){
        File fileHandler = new File(fileToAccess);
        try {
            FileWriter myWriter = new FileWriter(fileHandler.getName(), true); //True means append to file contents, False means overwrite
            myWriter.write(Details +"\n"); // Overwrites everything in the file
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void readLibrary(String fileToAccess) {
        File fileHandler = new File(fileToAccess);
        try {
            Scanner myReader = new Scanner(fileHandler);
            while (myReader.hasNextLine()) {

            }
        } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        /*
        File fileHandler = new File(fileToAccess);
        try {
            Scanner myReader = new Scanner(fileHandler);
            while (myReader.hasNextLine()) {
                String currentBookDetails = myReader.nextLine();
                String[] bookDetailsToShow = currentBookDetails.split(",");
                System.out.println("");
                for (int j = 0; j < 4; j++) {
                    System.out.print(bookDetailsToShow[j]+" ");
                }
            }
            System.out.println("");
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

         */
    }

    public static void saveBookDetailsToArray(String bookDetails) {
        System.out.println(bookDetails);
        booksLibrary.add(bookDetails);
    }

    public static void showBooksListAll(){
        for (int i = 0; i < booksLibrary.size(); i++) {
            System.out.println(booksLibrary.get(i));
            //System.out.println(booksLibrary.get(i).split(","));
        }
    }

    public static String getInput(String caption){
        System.out.println(caption);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    public static void createFile(String fileToAccess) {
        File fileHandler = new File(fileToAccess);
        try {
            if (fileHandler.createNewFile()) {
                System.out.println("File created: " + fileHandler.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}