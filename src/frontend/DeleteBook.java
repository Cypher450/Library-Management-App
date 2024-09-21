package frontend;

import java.sql.SQLException;
import java.util.Scanner;

import backend.dao.BookDao;
import backend.dao.BookDaoImpl;
import backend.dao.entity.Books;

public class DeleteBook {
	public static void deleteBook() {
		Scanner sc = new Scanner(System.in);

		int book_id = HomeMenu.compatibleBookId();

		BookDao dao = new BookDaoImpl();
		Books book = null;
		try {
			book = dao.showBookById(book_id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		try {
			if (dao.deleteABook(book_id) > 0) {
				System.out.println(
						"\n The book: " + book.getTitle() + " with id:  " + book_id + " is deleted successfully!");
			} else {
				System.out.println("\n Book with id: " + book_id + " not found!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
