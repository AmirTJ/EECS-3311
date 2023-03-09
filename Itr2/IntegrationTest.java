package Itr2;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class IntegrationTest{
    private static booksOrganization library;
    private static Connection connection;

    @BeforeAll
    public static void setUp() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String password = "123456";
        connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();
        statement.execute("TRUNCATE TABLE Book");

        library = new booksOrganization();
    }

    @Test
    public void testAddBook() throws SQLException {
        String bookName = "Chinese History";
        String bookId = "001";
        String author = "Tony";
        String category = "History";
        double price = 9.99;

        library.addBooks(bookName, bookId, author, category, price);

        ArrayList<Book> books = library.getBooks();
        assertEquals(1, books.size());

        Book book = books.get(0);
        assertEquals(bookName, book.getBookName());
        assertEquals(bookId, book.getBookId());
        assertEquals(author, book.getAuthor());
        assertEquals(category, book.getCategory());
        assertEquals(price, book.getPrice());
    }

    @Test
    public void testDeleteBook() throws SQLException {
        String bookName = "Chinese History";
        String bookId = "001";

        library.addBooks(bookName, bookId, "Tony", "History", 9.99);
        library.deleteBooks(bookName, bookId);

        ArrayList<Book> books = library.getBooks();
        assertEquals(0, books.size());
    }

    @Test
    public void testRemoveAllBooks() throws SQLException {
        library.addBooks("GuangZhou History", "001", "Tony", "History", 9.99);
        library.addBooks("ShanDong History", "002", "YunFei Cao", "History", 19.99);
        library.removeAllbooks();

        ArrayList<Book> books = library.getBooks();
        assertEquals(0, books.size());

        Statement statement = connection.createStatement();
        String query = "SELECT COUNT(*) FROM library.book";
        java.sql.ResultSet resultSet = statement.executeQuery(query);
        resultSet.next();
        int count = resultSet.getInt(1);
        assertEquals(0, count);
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        connection.close();
    }
}


