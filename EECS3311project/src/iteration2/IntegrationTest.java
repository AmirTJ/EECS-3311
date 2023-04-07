package iteration2;


import iteration1.*;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
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
    private static BookSearch BookSea;

    @BeforeAll
    public static void setUp() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/library";
        String user = "root";
        String password = "123456";
        connection = DriverManager.getConnection(url, user, password);

        Statement statement = connection.createStatement();
        statement.execute("TRUNCATE TABLE Book");

        library = new booksOrganization();
        BookSea = new BookSearch();
    }
    
    @Test
    public void testSearchBookByIdInThreeBooks() throws SQLException {
BookSea.addBooks("Chinese History", "001", "Tony", "History", 9.99);
BookSea.addBooks("GuangZhou History", "002", "Tony", "History", 10.99);
BookSea.addBooks("BeiJing History", "003", "Tony", "History", 8.99);
        Book result = BookSea.searchByID("002");
       
        
        assertNotNull(result);
        assertEquals("GuangZhou History", result.getBookName());
        assertEquals("002",result.getBookId());
        assertEquals("Tony", result.getAuthor());
        assertEquals("History", result.getCategory());
        assertEquals(10.99, result.getPrice(), 0.001);
       library.removeAllbooks();
    }
    
    @Test
    public void testSearchBookByNameInThreeBooks() throws SQLException {
BookSea.addBooks("Chinese History", "001", "Tony", "History", 9.99);
BookSea.addBooks("GuangZhou History", "002", "Tony", "History", 10.99);
BookSea.addBooks("BeiJing History", "003", "Tony", "History", 8.99);
        Book result = BookSea.searchByName("BeiJing History");
       
        
        assertNotNull(result);
        assertEquals("BeiJing History", result.getBookName());
        assertEquals("003",result.getBookId());
        assertEquals("Tony", result.getAuthor());
        assertEquals("History", result.getCategory());
        assertEquals(8.99, result.getPrice(), 0.001);
        library.removeAllbooks();
    }
    
    @Test
    public void testSearchBookByAuthorInThreeBooks() throws SQLException {
BookSea.addBooks("Chinese History", "001", "Tony", "History", 9.99);
BookSea.addBooks("GuangZhou History", "002", "Jack", "History", 10.99);
BookSea.addBooks("BeiJing History", "003", "Lux", "History", 8.99);
        Book result = BookSea.searchByAuthor("Jack");
       
        
        assertNotNull(result);
        assertEquals("Jack", result.getBookName());
        assertEquals("002",result.getAuthor());
        assertEquals("GuangZhou History", result.getBookId());
        assertEquals("History", result.getCategory());
        assertEquals(10.99, result.getPrice(), 0.001);
        library.removeAllbooks();
    }
    
    @Test
    public void testSearchBookByCategoryInThreeBooks() throws SQLException {
BookSea.addBooks("Chinese History", "001", "Tony", "History", 9.99);
BookSea.addBooks("GuangZhou History", "002", "Tony", "Arts", 10.99);
BookSea.addBooks("BeiJing History", "003", "Tony", "Music", 8.99);
        Book result = BookSea.searchByCategory("Arts");
       
        
        assertNotNull(result);
        assertEquals("GuangZhou History", result.getBookId());
        assertEquals("002",result.getAuthor());
        assertEquals("Tony", result.getBookName());
        assertEquals("Arts", result.getCategory());
        assertEquals(10.99, result.getPrice(), 0.001);
        library.removeAllbooks();
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

