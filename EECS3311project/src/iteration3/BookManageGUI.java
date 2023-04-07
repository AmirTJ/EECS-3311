
		
package iteration3;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import iteration1.*;

public class BookManageGUI extends JFrame implements ActionListener {

    private JLabel bookNameLabel, bookIdLabel, authorLabel, categoryLabel, priceLabel;
    private JTextField bookNameField, bookIdField, authorField, categoryField, priceField;
    private JButton addButton, deleteButton, removeAllButton, showAllButton;
    private JTextArea bookListArea;
    private JScrollPane scrollPane;
    private String url="jdbc:mysql://localhost:3306/library"; // localhost:3306 - change here if needed
	private String user="root"; // use your own user name here
	private String password="123456"; // use your own password
	private String query="";

    private booksOrganization booksOrg = new booksOrganization();

    public BookManageGUI() {
        setTitle("Book Management System");
        setSize(600, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        bookNameLabel = new JLabel("Book Name:");
        bookNameField = new JTextField();
        bookIdLabel = new JLabel("Book ID:");
        bookIdField = new JTextField();
        authorLabel = new JLabel("Author:");
        authorField = new JTextField();
        categoryLabel = new JLabel("Category:");
        categoryField = new JTextField();
        priceLabel = new JLabel("Price:");
        priceField = new JTextField();

        addButton = new JButton("Add Book");
        addButton.addActionListener(this);
        deleteButton = new JButton("Delete Book");
        deleteButton.addActionListener(this);
        removeAllButton = new JButton("Remove All Books");
        removeAllButton.addActionListener(this);
        showAllButton = new JButton("Show All Books");
        showAllButton.addActionListener(this);
       
        bookListArea = new JTextArea();
        bookListArea.setEditable(false);
        scrollPane = new JScrollPane(bookListArea);

        panel.add(bookNameLabel);
        panel.add(bookNameField);
        panel.add(bookIdLabel);
        panel.add(bookIdField);
        panel.add(authorLabel);
        panel.add(authorField);
        panel.add(categoryLabel);
        panel.add(categoryField);
        panel.add(priceLabel);
        panel.add(priceField);
        panel.add(addButton);
        panel.add(deleteButton);
        panel.add(removeAllButton);
        panel.add(showAllButton);

        add(panel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new BookManageGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String bookName= bookNameField.getText();
            String bookId = bookIdField.getText();
            String author = authorField.getText();
            String category = categoryField.getText();
            String prices = priceField.getText();
            double price = Double.parseDouble(priceField.getText());
            String name=bookName;
            String Id=bookId;
            
            for (Book book : booksOrg.getBooks()) {
                if (bookId.equals(book.getBookId())) {
                    JOptionPane.showMessageDialog(null, "In bookShelf: There is already a book with the same ID!");
                    return;
                }
            }
            booksOrg.addBooks(bookName, bookId, author, category, price);
        

            JOptionPane.showMessageDialog(null, "In bookShelf, book "+ name+ " with ID: " +Id+" has been added!");
       
        } else if (e.getSource() == deleteButton) {
        	
            String bookId = bookIdField.getText();
            String bookName= bookNameField.getText();
            String Id=bookId;
            String name=bookName;
            boolean bookFound = false; // add a boolean variable to check if the book exists
            for (Book book : booksOrg.getBooks()) {
                if (bookId.equals(book.getBookId())) {
                    booksOrg.deleteBooks(bookName, bookId);
                    JOptionPane.showMessageDialog(null, "In bookShelf, book "+ name+ " with ID: " +Id+" has been removed!");
                    bookFound = true; // set the variable to true if the book is found
                }
            }
            if (!bookFound) { // check the value of the variable and display a message accordingly
                JOptionPane.showMessageDialog(null, "In bookShelf: The book "+ name+ " with ID: " +Id+" is not in the bookshelf!");
            }
        } else if (e.getSource() == removeAllButton) {
            booksOrg.removeAllbooks();
            JOptionPane.showMessageDialog(null, "In bookShelf: All books had been removed!");
        } else if (e.getSource() == showAllButton) {
        	bookListArea.setText("");
        	  query = "SELECT * FROM library.book";
      	    try (Connection con = DriverManager.getConnection(url, user, password);
      	         Statement statement = con.createStatement();
      	         ResultSet resultSet = statement.executeQuery(query)) {
      	        while (resultSet.next()) {
      	            String bookId = resultSet.getString("bookID");
      	            String bookName = resultSet.getString("bookName");
      	            String author = resultSet.getString("author");
      	            String category = resultSet.getString("category");
      	            double price = resultSet.getDouble("price");
      	            int lend=resultSet.getInt("lend");
      	           
      	            bookListArea.append("Book ID: " + bookId + "\n");
      	            bookListArea.append("Book Name: " + bookName + "\n");
      	            bookListArea.append("Author: " + author + "\n");
      	            bookListArea.append("Category: " + category + "\n");
      	            bookListArea.append("Price: $" + price + "\n\n");
      	            bookListArea.append("lend statu: " + lend + "\n\n");
      	        }
      	    } catch (SQLException x) {
      	        x.printStackTrace();
      	    }
        	
        
            /*for (Book book : booksOrg.getBooks()) {
                bookListArea.append("Book Name: " + book.getBookName() + "\n");
                bookListArea.append("Book ID: " + book.getBookId() + "\n");
                bookListArea.append("Author: " + book.getAuthor() + "\n");
                bookListArea.append("Category: " + book.getCategory() + "\n");
                bookListArea.append("Price: $" + book.getPrice() + "\n\n");
            }*/
        }
        }
    }