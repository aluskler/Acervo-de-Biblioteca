package library;

import java.util.Scanner;

public class Main {
    private static BookBST bookBST;

    public static void main(String[] args) {
        bookBST = new BookBST();
        Scanner scanner = new Scanner(System.in);
        int option = 0;

        while (option != 5) {
            System.out.println("\n----------------------------------");
            System.out.println("Welcome to the UNIFACISA Library");
            System.out.println("1) Add a new book to the tree (organized by author)");
            System.out.println("2) List books (sorted by author)");
            System.out.println("3) Search books by author");
            System.out.println("4) Recommend books by genre");
            System.out.println("5) Exit");
            System.out.println("----------------------------------");

            option = getIntInput(scanner, "Choose an option: ");
            System.out.println("----------------------------------\n");

            if (option == 1) {
                addBook(scanner);
            } else if (option == 2) {
                bookBST.printBooks();
            } else if (option == 3) {
                System.out.print("Enter the author name: ");
                String author = scanner.nextLine();
                bookBST.searchByAuthor(author);
            } else if (option == 4) {
                System.out.print("Enter the genre: ");
                String genre = scanner.nextLine();
                bookBST.recommendByGenre(genre);
            } else if (option == 5) {
                System.out.println("System Terminated!");
                scanner.close();
                return;
            } else {
                System.out.println("Invalid option!");
            }
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Genre: ");
        String genre = scanner.nextLine();

        int year = getIntInput(scanner, "Publication Year: ");

        Book book = new Book(title, author, year, genre);
        bookBST.insert(book);
        System.out.println("\nBook added successfully.");
    }

    private static int getIntInput(Scanner scanner, String message) {
        int input = -1;
        while (true) {
            System.out.print(message);
            try {
                input = scanner.nextInt();
                scanner.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
        }
        return input;
    }
}
