package frontend;

import java.sql.SQLException;
import java.util.Scanner;

import backend.dao.BookDao;
import backend.dao.BookDaoImpl;
import backend.dao.entity.Books;
import backend.utils.DBUtils;

public class AddBook {
	
	
	public static void addBook(Scanner sc) {
		System.out.print("\n Enter the title of the book: ");
		String title = sc.nextLine();

		double price = HomeMenu.compatiblePrice();

		System.out.print("\n Enter author_name: ");
		String author_name = sc.nextLine();

		Books book = new Books(title, price, author_name);

		BookDao bookDao = new BookDaoImpl();
		try {
			if (bookDao.addBook(book) > 0) {
				System.out.println("\n Result: [The Book " + book.getTitle() + " is added successfully]");
			} else {
				System.out.println("\n Can't add the book");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(DBUtils.ERROR_MSG);
		}

	}
}
