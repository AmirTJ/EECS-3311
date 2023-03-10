package Itr2.Itr2;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.Date;

public class BorrowTest {
    @Test
    public void testBorrowBook() {
        Borrow book = new Borrow("Amir", "Solab");
        book.borrowBook();
        assertTrue(book.isBorrowed());
        assertNotNull(book.getBorrowedDate());
        assertNotNull(book.getDueDate());
    }
    @Test
    public void testBorrowBook2() {
        Borrow book = new Borrow("Ammir", "Kola");
        book.borrowBook();
        assertTrue(book.isBorrowed());
    }

    
    @Test
    public void testExtendDueDate() {
        Borrow book = new Borrow("sadw", "daef");
        book.borrowBook();
        Date oldDueDate = book.getDueDate();
        book.extendDueDate(3);
        assertEquals(oldDueDate.getTime() + (3 * 24 * 60 * 60 * 1000), book.getDueDate().getTime());
    }
    
    @Test
    public void testExtendDueDate2() {
        Borrow book = new Borrow("asddaw", "daae");
        book.borrowBook();
        Date oldDueDate = book.getDueDate();
        book.extendDueDate(7);
        Date newDueDate = book.getDueDate();
        assertNotEquals(oldDueDate, newDueDate);
    }

   
    @Test
    public void testReturnBook() {
        Borrow book = new Borrow("asdae", "eecs3311");
        book.borrowBook();
        book.returnBook();
        assertFalse(book.isBorrowed());
        assertNull(book.getBorrowedDate());
        assertNull(book.getDueDate());
    }
    

    @Test
    public void testBorrowAlreadyBorrowedBook() {
        Borrow book = new Borrow("caedt", "hi");
        book.borrowBook();
        assertTrue(book.isBorrowed());
    }

    
    @Test
    public void testExtendDueDateUnborrowedBook() {
        Borrow book = new Borrow("addwa", "Farankhan");
        book.extendDueDate(7);
        assertNull(book.getDueDate());
    }
    
    @Test
    public void testReturnUnborrowedBook() {
        Borrow book = new Borrow("Cheshm ghashang", "khoshgel");
        book.returnBook();
        assertFalse(book.isBorrowed());
    }
    @Test
    public void testReturnBorrowedBook() {
        Borrow book = new Borrow("jooon", "asdw");
        book.borrowBook();
        book.returnBook();
        assertFalse(book.isBorrowed());
    }
    @Test
    public void testBorrowedDate() {
        Borrow book = new Borrow("sdwt", "Pad");
        book.borrowBook();
        assertNotNull(book.getBorrowedDate());
    }
    @Test
    public void testUnborrowedDate() {
        Borrow book = new Borrow("das", "dawd");
        assertNull(book.getBorrowedDate());
    }
    @Test
    public void testDueDate() {
        Borrow book = new Borrow("adsw", "adwo");
        book.borrowBook();
        assertNotNull(book.getDueDate());
    }
    @Test
    public void testUnborrowedDueDate() {
        Borrow book = new Borrow("daadw", "assdw");
        assertNull(book.getDueDate());
    }

 

}
