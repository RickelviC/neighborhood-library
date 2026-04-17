package com.pluralsight;

import java.util.Scanner;

public class Library {

    private static Book[] book = new Book[20];
    private static String name = "";
    private static int numOfBook = 7;

    public static void main(String[] args) {

        book[0] = new Book( 1,  "9780192832696", "the great gatsby", false, name);
        book[1] = new Book( 2,  "9780061120084", "To Kill a Mockingbird", false, name);
        book[2] = new Book( 3,  "9781937007683", "prince of thorns", false, name);
        book[3] = new Book( 4,  "9781839081521", "You Are (Not) Deadpool", false, name);
        book[4] = new Book( 5,  "9780062971487", "The Man Who Lived Underground", false, name);
        book[5] = new Book( 6,  "9781416936473", "hatchet", false, name);
        book[6] = new Book( 7,  "9780261102217", "the hobbit", false, name);



        Scanner scanner = new Scanner(System.in);

        boolean exit = false;

        while(!exit){

            System.out.println("What do you want to do?");
            System.out.println("  1 - Show Available Books");
            System.out.println("  2 - Show Checked Out Books");
            System.out.println("  3 - closes out of the application");
            System.out.println("Enter your command:");

            int userInput = scanner.nextInt();
            scanner.nextLine();

            switch (userInput){
                case 1:
                    listAllBooks();
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
        // Print a header for the vehicle inventory
        System.out.println("Vehicle inventory:");

        // Iterate over the array of vehicles and print the details of each vehicle
        for (int i = 0; i < numOfBook; i++) {
            System.out.println(book[i]);
        }
    }
}
