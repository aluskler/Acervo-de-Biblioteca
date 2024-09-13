package library;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	private static BooksList booksList;

	public static void main(String[] args) {
		booksList = new BooksList(3);
		Scanner scanner = new Scanner(System.in);
		int quantity = 0;
		int option = 0;

		while (option != 7) {
			System.out.println("\n----------------------------------");
			System.out.println("Welcome to the UNIFACISA Library");
			System.out.println("1) Add a new book to the list");
			System.out.println("2) List books");
			System.out.println("3) Sort books by title");
			System.out.println("4) Sort books by author");
			System.out.println("5) Number of books in the library");
			System.out.println("6) Remove books");
			System.out.println("7) Exit");
			System.out.println("----------------------------------");

			option = getIntInput(scanner, "Choose an option: ");
			System.out.println("----------------------------------\n");

			if (option == 1) {
				addBook(scanner);
			} else if (option == 2) {
				booksList.printBooks();
			} else if (option == 3) {
				booksList.sortByTitle();
				System.out.println("Books sorted by title.");
				booksList.printBooks();
			} else if (option == 4) {
				booksList.sortByAuthor();
				System.out.println("Books sorted by author.");
				booksList.printBooks();
			} else if (option == 5) {
				quantity = booksList.listSize();
				System.out.println("The library has " + quantity + " books!");
			} else if (option == 6) {
				if (booksList.size == 0) {
					System.out.println("List of Books is empty");
				}
				else {
					for (int i = 0; i < booksList.size; i++) {
						System.out.print(i+1);
						System.out.println(booksList.books[i]);
					}
					System.out.println("Enter your book number");
					int numberBook = scanner.nextInt();
					booksList.removeBook(numberBook -1);
				}
			} else if (option == 7 ){
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

		int year = getIntInput(scanner, "Publication Year: ");

		Book book = new Book(title, author, year);
		booksList.addBook(book);
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
			} catch (InputMismatchException e) {
				System.out.println("Invalid input. Please enter a number.");
				scanner.next();
			}
		}
		return input;
	}
}
