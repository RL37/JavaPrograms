package com.company;

import java.util.Scanner;

import static com.company.Main.*;
import static com.company.getBooksInput.getBookDetails;
import static com.company.registerUserAccount.registerAccount;

public class menuHandling {
    public static String loginMenu(){
        final String fileToAccess = "usersDetails.txt";
        String userType = "notLoggedIn";
        boolean isLoggedIn = false;
        do {
            int loginOrRegister = Integer.parseInt(getInput("Do you want to\n1:Login\n2:Register\n3:Create/Reset all user details info"));
            switch (loginOrRegister) {
                case 1:
                    String isUser = loginUser(fileToAccess);
                    if (isUser.equals("isUser")) {
                        isLoggedIn = true;
                        userType = "user";
                    }
                    if (isUser.equals("isAdmin")){
                        runAdminMenu();
                        isLoggedIn = true;
                        userType = "admin";
                    }
                    break;
                case 2:
                    String userLoginDetails = registerAccount();
                    saveDetailsToFile(userLoginDetails, fileToAccess);
                    break;
                case 3:
                    createFile(fileToAccess);
                    break;
            }
        }while(isLoggedIn == false);
        return userType;
    }

    public static void runMainMenu() {
        final String fileToAccess = "library.txt";
        boolean exit = false;
        //booksLibrary.add(0, "bookTitle,ISBN number, author, genre");
        do {
            int menuOptionInput = Integer.parseInt(getInput("What do you want to do\nEnter: \n1 for show library\n2 to exit"));
            switch (menuOptionInput) {
                case 1: //shows all book info in the array
                    //showBooksListAll();
                    readLibrary(fileToAccess);
                    break;
                case 2:
                    exit = true;
            }
        }while(exit == false);
    }

    public static void runAdminMenu(){
        final String fileToAccess = "library.txt";
        boolean exit = false;
        do{
            int menuOptionInput = Integer.parseInt(getInput("What do you want to do\nEnter: \n1 for show library\n2 for adding a book\n3 for creating/resetting a file\n4 to exit"));
            switch (menuOptionInput) {
                case 1: //shows all book info in the array
                    //showBooksListAll();
                    readLibrary(fileToAccess);
                    break;
                case 2: //adds a new book and saves it to the array
                    String bookDetails = getBookDetails();
                    saveBookDetailsToArray(bookDetails);
                    saveDetailsToFile(bookDetails,fileToAccess);
                    break;
                case 3: //creates/resets file info about the books
                    createFile(fileToAccess);
                    break;
                case 4:
                    exit = true;
            }
        }while(exit == false);
    }

    private static Integer menuOption() {
        Scanner input = new Scanner(System.in);
        System.out.println("What do you want to do\nEnter: \n1 for show library\n2 for adding a book\n3 for creating/resetting a file\n4 to exit");
        int menuOptionInput = input.nextInt();
        return menuOptionInput;
    }
    public static String getInput(String caption){
        System.out.println(caption);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}
