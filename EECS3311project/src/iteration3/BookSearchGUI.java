package iteration3;
import iteration2.*;
import iteration1.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BookSearchGUI extends JFrame {

    private JTextField searchField;
    private JTextArea resultsArea;
    private String url="jdbc:mysql://localhost:3306/library"; // localhost:3306 - change here if needed
    private String user="root"; // use your own user name here
    private String password="123456";
    private String query="";
    
    public BookSearchGUI() {
        // Set up the main window
        setTitle("Book Search");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLayout(new BorderLayout());

        // Create the search panel with a text field and button
        JPanel searchPanel = new JPanel(new FlowLayout());
        searchField = new JTextField(20);
        JButton searchButton = new JButton("Search By Book Name");
        searchButton.addActionListener(new SearchButtonListener());
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // Create the results panel with a text area
        resultsArea = new JTextArea();
        resultsArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(resultsArea);

        // Add the panels to the main window
        add(searchPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Show the window
        setVisible(true);
    }

    private class SearchButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String searchTerm = searchField.getText();
            BookSearch bookSearch = new BookSearch();
            Book book = null;

            if (searchTerm.startsWith("B") && searchTerm.length() == 6) {
                book = bookSearch.searchByID(searchTerm);
            } else if (searchTerm.matches("[A-Za-z ]+")) {
                book = bookSearch.searchByName(searchTerm);
            } else if (searchTerm.matches("[A-Za-z]+")) {
                book = bookSearch.searchByAuthor(searchTerm);
            } else if (searchTerm.matches("[A-Za-z]+/[A-Za-z]+")) {
                book = bookSearch.searchByCategory(searchTerm);
            }

            if (book != null) {
                resultsArea.setText("Book found:\n" );
             
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
                        resultsArea.append("Book ID: " + bookId + "\n");
                        resultsArea.append("Book Name: " + bookName + "\n");
                        resultsArea.append("Author: " + author + "\n");
                        resultsArea.append("Category: " + category + "\n");
                        resultsArea.append("Price: $" + price + "\n\n");
                      
                    }
                } catch (SQLException x) {
                    x.printStackTrace();
                }
            } else {
                resultsArea.setText("Book not found.");
            }
        }
    }

    public static void main(String[] args) {
        new BookSearchGUI();
    }
}
