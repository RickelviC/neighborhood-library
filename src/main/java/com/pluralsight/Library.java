package com.pluralsight;

import java.util.Scanner;

public class Library {

    private static Book[] book = new Book[20];
    private static String name = "";
    private static int numOfBook = 7;

    public static void main(String[] args) {

        book[0] = new Book(1, "9780192832696", "the great gatsby", false, name);
        book[1] = new Book(2, "9780061120084", "To Kill a Mockingbird", false, name);
        book[2] = new Book(3, "9781937007683", "prince of thorns", false, name);
        book[3] = new Book(4, "9781839081521", "You Are (Not) Deadpool", false, name);
        book[4] = new Book(5, "9780062971487", "The Man Who Lived Underground", false, name);
        book[5] = new Book(6, "9781416936473", "hatchet", false, name);
        book[6] = new Book(7, "9780261102217", "the hobbit", false, name);

        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while (!exit) {

            System.out.println("What do you want to do?");
            System.out.println("  1 - Show Available Books");
            System.out.println("  2 - Show Checked Out Books");
            System.out.println("  3 - closes out of the application");
            System.out.println("Enter your command:");

            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput) {
                case 1:
                    listAllBooks();
                    pickBook(scanner);
                    break;
                case 2:
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

    public static void listAllBooks() {

        System.out.println("Books inventory:");

        for (int i = 0; i < numOfBook; i++) {
            System.out.println(book[i]);
        }
    }

    // made a loop that asked the user for an input for the book they would like to put and if the input is == 0 it closes the loop
    public static void pickBook(Scanner scanner) {

        System.out.println("Enter the ID of the book you want to check out (0 to cancel): ");

        int userInput = scanner.nextInt();
        scanner.nextLine();

        if (userInput == 0) {
            System.out.println("going back");
        } else if (userInput <= numOfBook) {

            System.out.println("please enter your name");
            name = scanner.nextLine();

            System.out.println("Thank you " + name + " you choose " + book[userInput - 1].getTitle());
        } else {
            System.out.println("Not an option");
        }
    }
}

