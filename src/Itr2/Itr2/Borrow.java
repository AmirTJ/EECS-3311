package Itr2;

import java.time.LocalDate;

public class Borrow {
    private Book book;
    private User user;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Borrow(Book book, User user, LocalDate borrowDate) {
        this.book = book;
        this.user = user;
        this.borrowDate = borrowDate;
    }

    public Book getBook() {
        return book;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public boolean isBookLent() {
        return book.getLend() == 1;
    }

    public void lendBook() {
        book.setLend(1);
    }

    public void returnBook(LocalDate returnDate) {
        book.setLend(0);
        this.returnDate = returnDate;
    }

    public void extendBorrow() {
        LocalDate newReturnDate = returnDate.plusDays(7); // extend for 7 days
        book.setLend(1);
        this.returnDate = newReturnDate;
    }
}
