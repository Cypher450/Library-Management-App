package frontend;

import java.sql.SQLException;
import java.util.Scanner;

import backend.dao.BookDao;
import backend.dao.BookDaoImpl;
import backend.dao.entity.Books;

public class UpdateBook {
	
	
	public static void updateBook(Scanner sc) {
		//Scanner sc = new Scanner(System.in);

		int book_id = HomeMenu.compatibleBookId();

		BookDao dao = new BookDaoImpl();
		try {
			Books book = dao.showBookById(book_id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		System.out.print("\n Enter name of the new book: ");
		String name = sc.nextLine();

		double price = HomeMenu.compatiblePrice();

		System.out.print("\n Enter the author name of new book: ");
		String author_name = sc.nextLine();

		Books book = new Books(name, price, author_name);
		try {
			if (dao.updateBook(book, book_id)) {
				System.out
						.println("\n The Book: " + book.getTitle() + " with id: " + book_id + " updated successfully");
			} else {
				System.out.println("\n Can't modify the book with id: " + book_id);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
