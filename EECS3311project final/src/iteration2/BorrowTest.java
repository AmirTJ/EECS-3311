package iteration2;

import  iteration1.*;

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
    	booksOrganization bOrg = new booksOrganization();
    	bOrg.addBooks("The Great Gatsby","443112", "F. Scott Fitzgerald", "Fiction", 9.99);
    	BookSearch bs = new BookSearch();
        book = bs.searchByID("443112");
    
        user = new User("John Smith", "jsmith123", "password");
        borrowDate = LocalDate.now();
        borrow = new Borrow(book.getBookId(), user, borrowDate);
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
    public void testReturnBook() {
        LocalDate returnDate = LocalDate.now();
        borrow.returnBook(book.getBookId(), returnDate);
        assertFalse(borrow.isBookLent(book.getBookId()));
        assertEquals(returnDate, borrow.getReturnDate(book.getBookId()));
    }

  

    @Test
    public void testGetReturnDateBeforeBookReturned() {
    	booksOrganization bOrg = new booksOrganization();
    	bOrg.addBooks("HH","hh211", "F. Scott Fitzgerald", "Fiction", 99.99);
    	borrowDate = LocalDate.now();
    	User xiaoHong = new User("Xiao Hong", "XiaoHong", "password");
    	Borrow borrow1 = new Borrow("hh211", xiaoHong, borrowDate);
        assertNull(borrow1.getReturnDate("hh211"));
    }

    @Test
    public void testReturnBookWithoutLending() {
    	LocalDate returnDate = LocalDate.now().plusDays(14);
    	borrow.returnBook(book.getBookId(), returnDate);
        assertFalse(borrow.isBookLent(book.getBookId()));
        assertEquals(returnDate, borrow.getReturnDate(book.getBookId()));
    }
    
    @Test
    public void testExtendBorrow() {
        borrow.extendBorrow(book.getBookId());
        assertEquals(LocalDate.now().plusDays(21), borrow.getReturnDate(book.getBookId()));
    }

}
