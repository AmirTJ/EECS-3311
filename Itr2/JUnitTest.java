import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class JUnitTest {

	private booksOrganization bookOrg;
	
	@Before
	public void setUp() throws Exception {
		bookOrg = new booksOrganization();
	}
	
	@Test
	public void testAddBooks() {
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
	public void testDeleteBooks() {
		bookOrg.addBooks("Chinese history", "001", "Yunfei", "History", 10.99);
		bookOrg.deleteBooks("Chinese history", "001");
		ArrayList<Book> books = bookOrg.getBooks();
		assertEquals(0, books.size());
	}

	@Test
	public void testRemoveAllBooks() {
		bookOrg.addBooks("Chinese history", "001", "Yunfei", "History", 10.99);
		bookOrg.addBooks("FIFA word cup 2018", "002", "Yunxiang", "Sport", 9.99);
		bookOrg.removeAllbooks();
		ArrayList<Book> books = bookOrg.getBooks();
		assertEquals(0, books.size());
	}
}

