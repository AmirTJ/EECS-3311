package iteration2;

import  iteration1.Book;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;



public class BorrowTest {

    private Book book;
    private User user;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private Borrow borrow;

    @Before
    public void setup() {
        book = new Book("1234", "The Great Gatsby", "F. Scott Fitzgerald", "Fiction", 9.99);
        user = new User("John Smith", "jsmith123", "password");
        borrowDate = LocalDate.now();
        borrow = new Borrow(book, user, borrowDate);
    }

    @Test
    public void testGetBook() {
        assertEquals(book, borrow.getBook());
    }

    @Test
    public void testGetUser() {
        assertEquals(user, borrow.getUser());
    }

    @Test
    public void testGetBorrowDate() {
        assertEquals(borrowDate, borrow.getBorrowDate());
    }

    @Test
    public void testIsBookLent() {
        assertFalse(borrow.isBookLent());
        borrow.lendBook();
        assertTrue(borrow.isBookLent());
    }

    @Test
    public void testLendBook() {
        assertFalse(borrow.isBookLent());
        borrow.lendBook();
        assertTrue(borrow.isBookLent());
    }

    @Test
    public void testReturnBook() {
        borrow.lendBook();
        LocalDate returnDate = LocalDate.now().plusDays(14);
        borrow.returnBook(returnDate);
        assertFalse(borrow.isBookLent());
        assertEquals(returnDate, borrow.getReturnDate());
    }

  

    @Test
    public void testGetReturnDateBeforeBookReturned() {
        assertNull(borrow.getReturnDate());
    }

    @Test
    public void testReturnBookWithoutLending() {
        LocalDate returnDate = LocalDate.now().plusDays(14);
        borrow.returnBook(returnDate);
        assertFalse(borrow.isBookLent());
        assertEquals(returnDate, borrow.getReturnDate());
    }


    @Test
    public void testLendBookMultipleTimes() {
        borrow.lendBook();
        borrow.lendBook();
        borrow.lendBook();
        assertTrue(borrow.isBookLent());
    }

}