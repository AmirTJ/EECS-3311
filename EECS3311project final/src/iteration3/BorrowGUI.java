package iteration3;

import javax.swing.*;

import iteration1.Book;
import iteration1.BookSearch;
import iteration2.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

public class BorrowGUI {
    private JFrame frame;
    private JPanel panel;
    private JLabel bookLabel, userLabel, borrowDateLabel;
    private JTextField bookField, userField, borrowDateField;
    private JButton lendButton, returnButton, extendButton;

    public BorrowGUI() {
        frame = new JFrame("Borrow");
        panel = new JPanel();
        bookLabel = new JLabel("BookID:");
        userLabel = new JLabel("User:");
        borrowDateLabel = new JLabel("Borrow Date (yyyy-mm-dd):");
        bookField = new JTextField(20);
        userField = new JTextField(20);
        borrowDateField = new JTextField(20);
        lendButton = new JButton("Lend");
        returnButton = new JButton("Return");
        extendButton = new JButton("Extend");
        
        panel.setLayout(new FlowLayout(FlowLayout.CENTER));
        panel.add(bookLabel);
        panel.add(bookField);
        panel.add(userLabel);
        panel.add(userField);
        panel.add(borrowDateLabel);
        panel.add(borrowDateField);
        panel.add(lendButton);
        panel.add(returnButton);
        panel.add(extendButton);

        lendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookID = bookField.getText();
                String userStr = userField.getText();
                String borrowDateStr = borrowDateField.getText();
                
                BookSearch bs = new BookSearch();
                Book book = bs.searchByID(bookID);
                if(book == null) JOptionPane.showMessageDialog(frame, "Book is not exsit.");
                else {
                	User user = new User(userStr);
                	LocalDate borrowDate = LocalDate.parse(borrowDateStr);
                	Borrow borrow = new Borrow(book.getBookId(), user, borrowDate);
                
                	if(borrow.isBookLent(book.getBookId()))  JOptionPane.showMessageDialog(frame, "Book has been lent.");
                	else JOptionPane.showMessageDialog(frame, "Book lent by " + userStr);
                }
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String bookID = bookField.getText();
                String userStr = userField.getText();
                String returnDateStr = LocalDate.now().toString();
                
                BookSearch bs = new BookSearch();
                Book book = bs.searchByID(bookID);
                User user = new User(userStr);
                LocalDate returnDate = LocalDate.parse(returnDateStr);
                
                Borrow borrow = new Borrow(book.getBookId(), user, returnDate);
                borrow.returnBook(book.getBookId(),returnDate);
                
                JOptionPane.showMessageDialog(frame, "Book returned.");
            }
        });

        extendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String bookID = bookField.getText();
                String userStr = userField.getText();
                String returnDateStr = LocalDate.now().toString();
                
                BookSearch bs = new BookSearch();
                Book book = bs.searchByID(bookID);
                User user = new User(userStr);
                LocalDate returnDate = LocalDate.parse(returnDateStr);
                
                Borrow borrow = new Borrow(book.getBookId(), user, returnDate);
                borrow.extendBorrow(book.getBookId());
                
                JOptionPane.showMessageDialog(frame, "Borrow has been extended by 7 days.");
            }
        });
        
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BorrowGUI();
    }
}