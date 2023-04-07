package iteration2;
import iteration1.Book;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class BookGUI extends JFrame {
    private Connection conn;
    private Book book;
    private JTextField bookIdField;
    private JTextField bookNameField;
    private JTextField authorField;
    private JTextField categoryField;
    private JTextField priceField;
    private JButton saveButton;
    private JButton clearButton;

    public BookGUI() {
        super("Book Manager");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        JLabel bookIdLabel = new JLabel("Book ID:");
        panel.add(bookIdLabel);
        bookIdField = new JTextField(20);
        panel.add(bookIdField);

        JLabel bookNameLabel = new JLabel("Book Name:");
        panel.add(bookNameLabel);
        bookNameField = new JTextField(20);
        panel.add(bookNameField);

        JLabel authorLabel = new JLabel("Author:");
        panel.add(authorLabel);
        authorField = new JTextField(20);
        panel.add(authorField);

        JLabel categoryLabel = new JLabel("Category:");
        panel.add(categoryLabel);
        categoryField = new JTextField(20);
        panel.add(categoryField);

        JLabel priceLabel = new JLabel("Price:");
        panel.add(priceLabel);
        priceField = new JTextField(20);
        panel.add(priceField);

        saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveButtonListener());
        panel.add(saveButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(new ClearButtonListener());
        panel.add(clearButton);

        getContentPane().add(panel);

        try {
            String url = "jdbc:mysql://localhost:3306/library";
            String user = "root";
            String password = "2000909cao";
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to database.");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void clearFields() {
        bookIdField.setText("");
        bookNameField.setText("");
        authorField.setText("");
        categoryField.setText("");
        priceField.setText("");
    }

    private class SaveButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String bookId = bookIdField.getText();
            String bookName = bookNameField.getText();
            String author = authorField.getText();
            String category = categoryField.getText();
            double price = Double.parseDouble(priceField.getText());

            book = new Book(bookId, bookName, author, category, price);

            String sql = "INSERT INTO Book (bookID, bookName, author, category, price, borrowTime) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setString(1, book.getBookId());
                stmt.setString(2, book.getBookName());
                stmt.setString(3, book.getAuthor());
                stmt.setString(4, book.getCategory());
                stmt.setDouble(5, book.getPrice());
                stmt.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
                stmt.executeUpdate();
                JOptionPane.showMessageDialog(null, "Book saved successfully!");
                clearFields();

            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error saving book.");
            }
        }
    }

    private class ClearButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            clearFields();
        }
    }

    public static void main(String[] args) {
        BookGUI gui = new BookGUI();
        gui.setVisible(true);
    }
}