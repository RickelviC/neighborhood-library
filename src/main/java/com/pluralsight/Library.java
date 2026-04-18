package com.pluralsight;

import java.util.Scanner;

public class Library {

    private static Book[] book = new Book[20];
    private static int numOfBook = 7;

    public static void main(String[] args) {

        book[0] = new Book(1, "9780192832696", "the great gatsby", false, "");
        book[1] = new Book(2, "9780061120084", "To Kill a Mockingbird", false, "");
        book[2] = new Book(3, "9781937007683", "prince of thorns", false, "");
        book[3] = new Book(4, "9781839081521", "You Are (Not) Deadpool", false, "");
        book[4] = new Book(5, "9780062971487", "The Man Who Lived Underground", false, "");
        book[5] = new Book(6, "9781416936473", "hatchet", false, "");
        book[6] = new Book(7, "9780261102217", "the hobbit", false, "");

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {

            System.out.println();
            System.out.println("Store Home Screen");
            System.out.println("---------------------------------------");
            System.out.println("  1 - Show Available Books");
            System.out.println("  2 - Show Checked Out Books");
            System.out.println("  3 - closes out of the application");
            System.out.print("Enter your command (1-3): ");

            int userInput = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (userInput) {
                case 1:
                    listAllBooks();
                    pickBook(scanner);
                    break;
                case 2:
                    checkedOutBook();
                    checkInBook(scanner);
                    break;
                case 3:
                    System.out.println("closing out of the application");
                    exit = true;
                    break;
                default:
                    System.out.println("Not an option");
                    break;
            }
        }
    }

    //shows every book
    public static void listAllBooks() {

        System.out.println("Available Books");
        System.out.println("---------------------------------------");

        for (int i = 0; i < numOfBook; i++) {
            System.out.println(book[i]);
        }
        System.out.println("---------------------------------------");
    }

    // made a loop that asked the user for an input for the book they would like to check out and if the input is == 0 it closes the loop
    // also sets name to .checkOut when they do take out a book
    public static void pickBook(Scanner scanner) {

        System.out.print("Enter the ID of the book you want to check out (0 to cancel): ");

        int userInput = scanner.nextInt();
        scanner.nextLine();

        if (userInput == 0) {
            System.out.println("going back");
        } else if (userInput <= numOfBook) {

            String name = getName(scanner);

            System.out.println("Thank you " + name + " you choose " + book[userInput - 1].getTitle());
            System.out.println("---------------------------------------");

            book[userInput - 1].checkOut(name);

        } else {
            System.out.println("Not an option");
        }
    }

    public static void checkedOutBook() {
        System.out.println("Checked Out Books");
        System.out.println("---------------------------------------");

        for (int i = 0; i < numOfBook; i++) {
            if (book[i].isCheckedOut()) {
                System.out.println(book[i] + " -> " + book[i].getCheckedOutTo());
            }
        }
    }

    public static void checkInBook(Scanner scanner){
        System.out.print("Press C to check in a book, or X to go back to Home Screen: ");

        String userInput = scanner.nextLine();

        if(userInput.equalsIgnoreCase("x")){
            System.out.println("going back");
        } else if (userInput.equalsIgnoreCase("c")) {
            System.out.print("enter the id of the book you want to return: ");
            int id = scanner.nextInt();
            book[id -1].checkIn();
        }else {
            System.out.println("Not an option");
        }
    }

    public static String getName(Scanner scanner) {
        System.out.print("please enter your name: ");
        return scanner.nextLine();
    }
}

