package com.company;

public class Books {

    private String bookTitle;
    private int bookISBN;
    private String bookAuthor;
    private String bookGenre;

    public Books(String bookTitle, String bookISBN, String bookAuthor, String bookGenre){
        this.bookTitle = bookTitle;
        this.bookISBN = Integer.parseInt(bookISBN);
        this.bookAuthor = bookAuthor;
        this.bookGenre = bookGenre;
    }

    public String getBookTitle(){return bookTitle;}

    public void setBookTitle(String bookTitle){this.bookTitle = bookTitle;}

    public int getBookISBN(){return bookISBN;}

    public void setBookISBN(int bookISBN){this.bookISBN = bookISBN;}

    public String getBookAuthor(){return bookAuthor;}

    public void setBookAuthor(String bookAuthor){this.bookAuthor = bookAuthor;}

    public String getBookGenre(){return bookGenre;}

    public void setBookGenre(String bookGenre){this.bookGenre = bookGenre;}
    /*
    @Override
    public String toString(){
        return bookTitle+","+bookISBN+","+bookAuthor+","+bookGenre;
    }
     */
}
