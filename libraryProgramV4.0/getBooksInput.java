package com.company;

import java.util.Scanner;

public class getBooksInput{
        //Books myNewBook = new Books(getInput("What is the book called:"),getInput("What is the books ISBN number:"),getInput("Who is the author"),getInput("What is the book's genre:"));
        //return myNewBook;
        public static String getBookDetails() {
            String bookTitle = getInput("What is the book called:");
            String bookISBN = getInput("What is the book ISBN number:");
            String bookAuthor = getInput("Who is the author");
            String bookGenre = getInput("What is the books genre");
            return (bookTitle + "," + bookISBN + "," + bookAuthor + "," + bookGenre);
        }

    public static String getInput(String caption){
        System.out.println(caption);
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }
}