package Itr2.Itr2;
import Itr1.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Itr1.Book;
import Itr1.booksOrganization;

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
        library.removeAllbooks();
    }

    
    @Test
    public void testAddThreeBook() throws SQLException {
        

        library.addBooks("Chinese History", "001", "Tony", "History", 8.99);
        library.addBooks("GuangZhou History", "002", "Tony", "History", 9.99);
        library.addBooks("ShanDong History", "003", "Tony", "History", 10.99);

        ArrayList<Book> books = library.getBooks();
        assertEquals(3, books.size());

        Book book = books.get(1);
        assertEquals("GuangZhou History", book.getBookName());
        assertEquals("002", book.getBookId());
        assertEquals("Tony", book.getAuthor());
        assertEquals("History", book.getCategory());
        assertEquals(9.99, book.getPrice());
        library.removeAllbooks();
    }
    
    @Test
    public void testDeleteBook() throws SQLException {
        String bookName = "Chinese History";
        String bookId = "001";

        library.addBooks(bookName, bookId, "Tony", "History", 9.99);
        library.deleteBooks(bookName, bookId);

        ArrayList<Book> books = library.getBooks();
        assertEquals(0, books.size());
        library.removeAllbooks();
    }
    
    @Test
    public void testDeleteSecondBookInThreeBooks() throws SQLException {
    	  library.addBooks("Chinese History", "001", "Tony", "History", 8.99);
          library.addBooks("GuangZhou History", "002", "Tony", "History", 9.99);
          library.addBooks("ShanDong History", "003", "Tony", "History", 10.99);

      
        library.deleteBooks("GuangZhou History", "002");

        ArrayList<Book> books = library.getBooks();
        assertEquals(2, books.size());
        Book book = books.get(1);
        assertEquals("ShanDong History", book.getBookName());
        assertNotEquals("GuangZhou History", book.getBookName());
        assertNotEquals("002", book.getBookId());
        assertEquals("Tony", book.getAuthor());
        assertEquals("History", book.getCategory());
        assertEquals(10.99, book.getPrice());
        library.removeAllbooks();
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
        library.removeAllbooks();
    }

    @AfterAll
    public static void tearDown() throws SQLException {
        connection.close();
    }
}


