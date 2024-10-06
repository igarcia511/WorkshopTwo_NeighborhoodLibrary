package com.ps;

import java.util.Scanner;

public class Main {

    static Book[] bookInventory = new Book[20];
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        // String title, int id, String isbn, boolean isCheckedOut, String checkedOutTo
        Book book1 = new Book("The Alchemist", 1, "1234546456412", false, "");
        Book book2 = new Book("Avatar TLA", 2, "1241234134124", false, "");
        Book book3 = new Book("Life of Pi", 3, "23452345234", false, "");
        Book book4 = new Book("Still standing", 4, "56354636365", false, "");

        bookInventory[0] = book1;
        bookInventory[1] = book2;
        bookInventory[2] = book3;
        bookInventory[3] = book4;

        String mainCommandChoice;

        do {
            System.out.println("Welcome to the Neighborhood Library \n Enter 1) to show available book \n Enter 2) to show checked out books \n Enter X) to exit");
            mainCommandChoice = scanner.nextLine();

            switch (mainCommandChoice) {
                case "1":
                    showAvailableBooks();
                    break;
                case "2":
                    showCheckedOutBooks();
                    break;
                case "x":
                    System.out.println("Exiting . . .");
                    break;
                default:
                    System.out.println("Invalid Entry, try again. . .");


            }

        } while (!mainCommandChoice.equals("x"));


    }

    public static void showAvailableBooks() throws InterruptedException {
        String name;
        int bookSelection;
        System.out.println("Available books \n");
        for (Book book : bookInventory) {
            if (book != null) {

                if (!book.isCheckedOut()) {
                    System.out.println("Id: " + book.getId() + " Title: " + book.getTitle() + "\n");
                }

            }

        }
        // loop through all books and if id matches check the book out
        System.out.print("Do you want to check a book out? Enter y) for yes, x) to return to main menu: ");
        String yesOrNo = scanner.nextLine();
        switch (yesOrNo) {
            case "y":
                System.out.print("Enter the Id of the book you wish to check out: ");
                bookSelection = scanner.nextInt();
                scanner.nextLine();


                System.out.print("Enter your name: ");
                name = scanner.nextLine();
                for (Book book : bookInventory) {
                    if (book != null) {
                        if (book.getId() == bookSelection) {

                            book.checkOut(name);

                        }
                    }
                }
                break;
            case "x":
                System.out.println("Returning to main menu. . .\n");
                Thread.sleep(1000);
                break;
            default:
                System.out.println("Invalid Entry try again. . .");
        }


    }

    public static void showCheckedOutBooks() throws InterruptedException {

        String selection;
        int bookId;
        System.out.println("Here are all the checked out books. . . \n");
        for (Book book : bookInventory) {

            if (book != null) {
                if (book.isCheckedOut()) {
                    System.out.println("Id: " + book.getId() + " " + "Isbn: " + book.getIsbn() + " " + "Title: " + book.getTitle() + " " +
                            "Checked out by: " + book.getCheckedOutTo() + "\n");
                }

            }
        }

        do {
            System.out.print("Enter C) to return a book, or X) to exit to main menu. . .");
            selection = scanner.nextLine();

            switch (selection) {
                case "c":
                    System.out.print("Enter the Book Id to return book: ");
                    bookId = scanner.nextInt();
                    scanner.nextLine();
                    for (Book book : bookInventory) {
                        if (book != null) {
                            if (book.getId() == bookId) {
                                book.checkIn();
                            }
                        }
                    }
                    break;
                case "x":
                    System.out.println("Returning to main menu. . .");
                    Thread.sleep(1000);
                    break;
                default:
                    System.out.println("Invalid command, try again");


            }
        } while (!selection.equals("x"));
    }
}
