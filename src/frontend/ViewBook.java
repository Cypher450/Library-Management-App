package frontend;

import java.sql.SQLException;
import java.util.Scanner;

import backend.dao.BookDao;
import backend.dao.BookDaoImpl;
import backend.dao.entity.Books;

public class ViewBook {
	public static void viewBook(Scanner sc) {
		//Scanner sc = new Scanner(System.in);

		int book_id = HomeMenu.compatibleBookId();

		BookDao dao = new BookDaoImpl();
		try {
			Books book = dao.showBookById(book_id);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
