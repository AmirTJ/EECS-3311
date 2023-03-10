package Itr2.src;

import java.util.Date;
public class Borrow {
 
     private String title;
     private String author;
     private boolean borrowed;
     private Date borrowedDate;
     private Date dueDate;
     
     public Borrow(String title, String author) {
         this.title = title;
         this.author = author;
         this.borrowed = false;
         this.borrowedDate = null;
         this.dueDate = null;
     }
     
     public String getTitle() {
         return title;
     }
     
     public String getAuthor() {
         return author;
     }
     
     public boolean isBorrowed() {
         return borrowed;
     }
     
     public Date getBorrowedDate() {
         return borrowedDate;
     }
     
     public Date getDueDate() {
         return dueDate;
     }
     
     public void borrowBook() {
         if (borrowed) {
             System.out.println("Sorry, this book is already borrowed.");
         } else {
             borrowed = true;
             borrowedDate = new Date();
             dueDate = new Date(borrowedDate.getTime() + (7 * 24 * 60 * 60 * 1000)); // 7 days from borrowedDate
             System.out.println("Book borrowed successfully. Please return it by " + dueDate);
         }
     }
     
     public void extendDueDate(int days) {
         if (borrowed) {
             dueDate = new Date(dueDate.getTime() + (days * 24 * 60 * 60 * 1000));
             System.out.println("Due date extended successfully. Please return the book by " + dueDate);
         } else {
             System.out.println("Sorry, this book is not borrowed yet.");
         }
     }
     
     public void returnBook() {
         borrowed = false;
         borrowedDate = null;
         dueDate = null;
         System.out.println("Book returned successfully.");
     }
 }