package frontend;

import java.util.InputMismatchException;
import java.util.Scanner;

import backend.dao.BookDao;
import backend.dao.BookDaoImpl;

public class ViewAllBooks {
	public static void viewAllBooks() {
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("\n How do you want to display the list?");
			System.out.println("\n 1. In Ascending order of id");
			System.out.println("\n 2. In Descending order of id");
			System.out.println("\n 3. In Ascending order of book name");
			System.out.println("\n 4. In Descending order of book name");
			System.out.println("\n 5. In Ascending order of price");
			System.out.println("\n 6. In Descending order of price");
			System.out.println("\n 7. Exit");

			System.out.print("\n Select one option from above: ");
			int option = 0;
			try {
				option = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("\n Please Enter a number!");
			}
			sc.nextLine();

			String orderBy = "";
			switch (option) {
			case 1:
				orderBy = "ORDER BY book_id ASC";
				break;
			case 2:
				orderBy = "ORDER BY book_id DESC";
				break;
			case 3:
				orderBy = "ORDER BY title ASC";
				break;
			case 4:
				orderBy = "ORDER BY title DESC";
				break;
			case 5:
				orderBy = "ORDER BY price ASC";
				break;
			case 6:
				orderBy = "ORDER BY price DESC";
				break;
			case 7:
				return;
			default:
				System.out.println("\n Invalid option. Please try again.");
				continue;
			}

			BookDao dao = new BookDaoImpl();
			dao.displayBooks(orderBy);
		}
	}
}
