package backend.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import backend.dao.entity.Books;

public interface BookDao {

	int addBook(Books book) throws SQLException;

	boolean updateBook(Books book, int empId) throws SQLException;

	int deleteABook(int book_id) throws SQLException;

	List<Books> viewAllBooks() throws SQLException;

	Books showBookById(int empId) throws SQLException;

	void displayBooks(String orderBy);

	void updateBookName(int bookId, String newName) throws SQLException;

	void updatePriceOfBook(int book_id, double newPrice) throws SQLException;

	void updateAuthorname(int book_id, String newAuthor) throws SQLException;

}
