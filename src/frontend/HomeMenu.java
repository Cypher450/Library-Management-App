package frontend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;
import backend.utils.DBUtils;

public class HomeMenu {
	
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		createTableAuto();

		
		int option = -1;

		while (true) {
			showMenu();
			System.out.print("\n Your option: ");
			try {
				option = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\n You have entered the wrong input");

			}

			sc.nextLine();

			if (option == 6) {
				while (true) {
					System.out.print("\n Are you sure you want to exit (y/n): ");
					String input = sc.nextLine();

					if (input.length() > 0) {
						input = input.trim();
						if (input.equalsIgnoreCase("yes") || input.equalsIgnoreCase("y")) {
							System.out.println("\n Thanks for using our portal.");
							System.out.println("\n Visit again soon!!");
							System.out.println("\n -------X------X-------X-------X------");
							sc.close();
							return;
						} else if (input.equalsIgnoreCase("no") || input.equalsIgnoreCase("n")) {
							System.out.println("\n Continuing to the portal...");
							break;
						} else {
							System.out.println("\n Invalid input, please enter 'yes' or 'no'.");
							continue;
						}
					}
				}
			}

			handleMenuOption(option);
		}
	}

	private static void createTableAuto() {
		String createTable = "CREATE TABLE `aman_books` (\r\n" + "    `title` varchar(30) DEFAULT NULL,\r\n"
				+ "    `book_id` int NOT NULL AUTO_INCREMENT,\r\n" + "    `author_name` varchar(35) DEFAULT NULL,\r\n"
				+ "    `price` decimal(7,2) DEFAULT NULL,\r\n" + "    PRIMARY KEY (`book_id`)\r\n" + ");\r\n" + "";

		try (Connection conn = DriverManager.getConnection(DBUtils.getUrl(), DBUtils.getUsername(),
				DBUtils.getPassword()); Statement stmt = conn.createStatement();) {

			int result;
			try {
				result = stmt.executeUpdate(createTable);
				if (result == 0) {
					System.out.println("\n Table created successfully!");
				} else {
					System.out.println("\n Table creation failed!");
				}
			} catch (SQLSyntaxErrorException e) {
				System.out.println("\n Table already exists!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void showMenu() {
		System.out.println("\n Select an option:");
		System.out.println("\n 1. Add a Book");
		System.out.println("\n 2. Update a Book");
		System.out.println("\n 3. Delete a Book");
		System.out.println("\n 4. View a book");
		System.out.println("\n 5. View all Books");
		System.out.println("\n 6. Exit Menu");

	}

	private static void handleMenuOption(int option) {
		switch (option) {
		case 1:
			AddBook.addBook(sc);
			break;
		case 2:
			UpdateBook.updateBook();
			break;
		case 3:
			DeleteBook.deleteBook(sc);
			break;
		case 4:
			ViewBook.viewBook();
			break;
		case 5:
			ViewAllBooks.viewAllBooks();
			break;
		case 6:

			break;
		default:
			System.out.println("\n Invalid option. Please try again.");
			break;
		}
	}

	public static double compatiblePrice() {
		Scanner sc = new Scanner(System.in);
		double price = 0;
		boolean validInput = false;

		while (!validInput) {
			System.out.print("\n Enter price of the book: ");
			try {
				price = sc.nextDouble();
				validInput = true;
			} catch (InputMismatchException e1) {
				System.out.println("\n Invalid input. Please enter a valid number.");
				sc.nextLine();
			}
		}
		return price;
	}

	public static int compatibleBookId() {
		Scanner sc = new Scanner(System.in);

		int book_id = 0;
		boolean validInput = false;

		while (!validInput) {
			System.out.print("\n Enter book ID: ");
			try {
				book_id = sc.nextInt();
				validInput = true;
			} catch (InputMismatchException e1) {
				System.out.println("\n Invalid input. Please enter a valid integer.");
				sc.next();
			}
		}
		return book_id;
	}
}
