package frontend;

import java.sql.SQLException;
import java.util.Scanner;

import backend.dao.BookDao;
import backend.dao.BookDaoImpl;
import backend.dao.entity.Books;

public class UpdateBook {
	
	
	public static void updateBook(Scanner sc) {
		//Scanner sc = new Scanner(System.in);

		BookDao dao = new BookDaoImpl();
		while (true) {
			System.out.println("\n Choose an option to update:");
			System.out.println("\n 1. Update Book Name");
			System.out.println("\n 2. Update Price Of Book");
			System.out.println("\n 3. Update Author Name");
			System.out.println("\n 4. Update All Details");
			System.out.println("\n 5. Exit");

			System.out.print("\n Your option: ");
			int choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {
			case 1:
				try {
					int book_id = enterBookId(sc);
					updateBookName(sc, dao, book_id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 2:
				try {
					int book_id = enterBookId(sc);
					updatePriceOfBook(sc, dao, book_id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				try {
					int book_id = enterBookId(sc);
					updateAuthorName(sc, dao, book_id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				int book_id = enterBookId(sc);
				updateAllDetails(sc, dao, book_id);
				break;
			case 5:
				return;
			default:
				System.out.print("\n Invalid choice! Please choose again.");
			}

		try {
			dao.showBookById(book_id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}

	private static int enterBookId(Scanner sc) {
		System.out.print("\n Enter the book_id of the book that you want to update: ");
		int book_id = sc.nextInt();

		return book_id;
	}

	private static void updateAllDetails(Scanner sc, BookDao dao, int book_id) {
		sc.nextLine();
		System.out.print("\n Enter new book name: ");
		String newName = sc.nextLine();

		double newPrice = HomeMenu.compatiblePrice();

		System.out.print("\n Enter new author name : ");
		String newAuthor = sc.nextLine();

		Books book = new Books(newName, newPrice, newAuthor);

		try {
			if (dao.updateBook(book, book_id)) {
				System.out.println("\n Book all details updated successfully!");
			} else {
				System.out.println("\n Could not update the book details.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	private static void updateAuthorName(Scanner sc, BookDao dao, int book_id) throws SQLException {
		sc.nextLine();
		System.out.print("\n Enter new author name : ");
		String newAuthor = sc.nextLine();
		dao.updateAuthorname(book_id, newAuthor);
		System.out.println("\n Author_name updated successfully.");

	}

	private static void updatePriceOfBook(Scanner sc, BookDao dao, int book_id) throws SQLException {

		double newPrice = HomeMenu.compatiblePrice();
		dao.updatePriceOfBook(book_id, newPrice);
		System.out.println("\n Price updated successfully.");

	}

	private static void updateBookName(Scanner sc, BookDao dao, int bookId) throws SQLException {
		sc.nextLine();
		System.out.print("\n Enter new book name: ");
		String newName = sc.nextLine();
		dao.updateBookName(bookId, newName);
		System.out.println("\n Book name updated successfully.");
	}

}
