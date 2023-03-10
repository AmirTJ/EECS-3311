package Itr2.Itr2;
import Itr1.*;

import static org.junit.Assert.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;


public class JUnitTest {
	

	private booksOrganization bookOrg;
	private BookSearch bookSea;
	
	@Before
	public void setUp() throws Exception {
		bookOrg = new booksOrganization();
		bookSea = new BookSearch();
		bookOrg.removeAllbooks();
	}
	
	@Test
	public void testAddBooksBaseCase() {
		bookOrg.addBooks("Chinese history", "001", "Yunfei", "History", 10.99);
		ArrayList<Book> books = bookOrg.getBooks();
		assertEquals(1, books.size());
		assertEquals("001", books.get(0).getBookId());
		assertEquals("Chinese history", books.get(0).getBookName());
		assertEquals("Yunfei", books.get(0).getAuthor());
		assertEquals("History", books.get(0).getCategory());
		assertEquals(10.99, books.get(0).getPrice(), 0.001);
	
	}

	@Test
	public void testAddThreeBooks() {
		bookOrg.addBooks("ShangHai history", "002", "Tony", "History", 7.99);
		bookOrg.addBooks("GuangZhou history", "003", "Tony", "History", 9.99);
		bookOrg.addBooks("BeiJing history", "004", "Tony", "History", 8.99);
		ArrayList<Book> books = bookOrg.getBooks();
		assertEquals(3, books.size());
		assertEquals("004", books.get(2).getBookId());
		assertEquals("BeiJing history", books.get(2).getBookName());
		assertEquals("Tony", books.get(2).getAuthor());
		assertEquals("History", books.get(2).getCategory());
		assertEquals(8.99, books.get(2).getPrice(), 0.001);
	}
	@Test
	public void testAddBookEmptyName() {
		bookOrg.addBooks("", "", "", "", 0);
		ArrayList<Book> books = bookOrg.getBooks();
		assertEquals(1, books.size());
		assertEquals("", books.get(0).getBookId());
		assertEquals("", books.get(0).getBookName());
		assertEquals("", books.get(0).getAuthor());
		assertEquals("", books.get(0).getCategory());
		assertEquals(0, books.get(0).getPrice(), 0.001);
	
	}
	
	
	@Test
	public void testDeleteBooksBasecase() {
		bookOrg.addBooks("Chinese history", "001", "Yunfei", "History", 10.99);
		bookOrg.deleteBooks("Chinese history", "001");
		ArrayList<Book> books = bookOrg.getBooks();
		assertEquals(0, books.size());
	}

	@Test
	public void testDeletdSecondBookInThreeBooks() {
		bookOrg.addBooks("ShangHai history", "002", "Tony", "History", 7.99);
		bookOrg.addBooks("GuangZhou history", "003", "Tonyz", "Math", 9.99);
		bookOrg.addBooks("BeiJing history", "004", "Tony", "History", 8.99);
		bookOrg.deleteBooks("GuangZhou history", "003");
		ArrayList<Book> books = bookOrg.getBooks();
		assertEquals(2, books.size());
		assertNotEquals("GuangZhou",books.get(1).getBookName());
		assertNotEquals("003",books.get(1).getBookId());
		assertNotEquals("Tonyz",books.get(1).getAuthor());
		assertNotEquals("Math",books.get(1).getCategory());
		assertNotEquals(9.99,books.get(1).getPrice(), 0.001);
		assertEquals("BeiJing history",books.get(1).getBookName());
		assertEquals("004",books.get(1).getBookId());
	}
	
	@Test
	public void testSearchBookById() {
		Book a = new Book("001", "C", "Y", "H", 10.99);
	bookSea.addBooks("C", "001", "Y", "H", 10.99);
		Book b =bookSea.searchByID("001");
		 assertNotNull(b);
	        assertEquals(a.getBookId(), b.getBookId());
	}
	
	@Test
	public void testSearchBookByBookName() {
		Book a = new Book("001", "Chinese History", "Tony", "History", 9.99);
	bookSea.addBooks("Chinese History", "001", "Tony", "History", 9.99);
		Book b =bookSea.searchByName("Chinese History");
		 assertNotNull(b);
	        assertEquals(a.getBookName(), b.getBookName());
	}
	
	@Test
	public void testSearchBookByAuthor() {
		Book a = new Book("Chinese History", "001", "History", "Tony", 9.99);
	bookSea.addBooks("Chinese History", "001", "Tony", "History", 9.99);
	bookSea.addBooks("GuangZhou History", "002", "Lux", "History", 8.99);
		Book b =bookSea.searchByAuthor("Tony");
		 assertNotNull(b);
	        assertEquals(a.getAuthor(), b.getCategory());
	        assertEquals(a.getBookId(), b.getBookId());
	}
	
	@Test
	public void testSearchBookByCategory() {
		Book a = new Book("GuangZhou History", "002", "Jack", "arts", 8.99);
	bookSea.addBooks("Chinese History", "001", "Tony", "History", 9.99);
	bookSea.addBooks("GuangZhou History", "002", "Jack", "arts", 8.99);
		Book b =bookSea.searchByCategory("arts");
		 assertNotNull(b);
	        assertEquals(a.getCategory(), b.getCategory());
	        assertEquals(a.getBookId(), b.getBookId());
	}
	
	@Test
	public void testRemoveAllBooksBasecase() {
		bookOrg.addBooks("Chinese history", "001", "Yunfei", "History", 10.99);
		bookOrg.addBooks("FIFA word cup 2018", "002", "Yunxiang", "Sport", 9.99);
		bookOrg.removeAllbooks();
		ArrayList<Book> books = bookOrg.getBooks();
		assertEquals(0, books.size());
	}
	
	
}
