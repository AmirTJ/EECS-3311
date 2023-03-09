// import java.util.ArrayList;
// import java.util.Scanner;
import java.sql.*;

public class BookSearch extends booksOrganization {
    private static final String URL = "jdbc:mysql://localhost:3306/library"; // localhost:3306 - change here if needed
    private static final String USER = "root"; // use your own user name here
    private static final String PASSWORD = "123456"; // use your own password
    private Connection connection;
    public BookSearch() {
        super();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book searchByID(String ID) {
        for (Book book : bookShelf) {
            if (book.getBookId().equalsIgnoreCase(Id)) {
                System.out.println("book found");
                System.out.println("Book Name: " + book.getBookName());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Book ID: " + book.getBookId());
                System.out.println("Category: " + book.getCategory());
                System.out.println("Price: " + book.getPrice());
                return book;
            }
            }

        try{
            String query = "SELECT * FROM book WHERE bookID=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, ID);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                System.out.println("book found");
                System.out.println("Book ID: " + result.getString("bookID"));
                System.out.println("Book Name: " + result.getString("bookName"));
                System.out.println("Author: " + result.getString("author"));
                System.out.println("Category: " + result.getString("category"));
                System.out.println("Price: " + result.getDouble("price"));
                System.out.println("lent(if show 1 means not in the bookshelf, if shows 0 means exsit: " + result.getInt("lent") );
                return new Book(result.getString("bookName"), result.getString("author"),
                result.getString("bookID"), result.getString("category"), result.getDouble("price"),result.getInt("lent"));
            }
      }   
     catch (Exception e) {
        e.printStackTrace();
     }     
       System.out.println("book not found");
        return null;
    
    }

    public Book searchByName(String title) {
        for (Book book : bookShelf) {
            if (book.getBookName().equalsIgnoreCase(title)) {
                System.out.println("book found");
                System.out.println("Book Name: " + book.getBookName());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Book ID: " + book.getBookId());
                System.out.println("Category: " + book.getCategory());
                System.out.println("Price: " + book.getPrice());
                return book;
            }
            }

        try {
            String query = "SELECT * FROM book WHERE bookName=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, title);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                System.out.println("book found");
                System.out.println("Book ID: " + result.getString("bookID"));
                System.out.println("Book Name: " + result.getString("bookName"));
                System.out.println("Author: " + result.getString("author"));
                System.out.println("Category: " + result.getString("category"));
                System.out.println("Price: " + result.getDouble("price"));
                System.out.println("lent(if show 1 means not in the bookshelf, if shows 0 means exsit: " + result.getInt("lent") );
                return new Book(result.getString("bookName"), result.getString("author"),
                result.getString("bookID"), result.getString("category"), result.getDouble("price"),result.getInt("lent"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    System.out.println("book not found");
        return null;
        }
    

        public Book searchByAuthor(String author) {
            for (Book book : bookShelf) {
                if (book.getBookName().equalsIgnoreCase(author)) {
                System.out.println("book found");
                System.out.println("Book Name: " + book.getBookName());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Book ID: " + book.getBookId());
                System.out.println("Category: " + book.getCategory());
                System.out.println("Price: " + book.getPrice());
                return book;
                }
            }
            try {
                String query = "SELECT * FROM book WHERE author=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, author);
                ResultSet result = ps.executeQuery();
    
                if (result.next()) {
                    System.out.println("book found");
                    System.out.println("Book ID: " + result.getString("bookID"));
                    System.out.println("Book Name: " + result.getString("bookName"));
                    System.out.println("Author: " + result.getString("author"));
                    System.out.println("Category: " + result.getString("category"));
                    System.out.println("Price: " + result.getDouble("price"));
                    System.out.println("lent(if show 1 means not in the bookshelf, if shows 0 means exsit: " + result.getInt("lent") );
                    return new Book(result.getString("bookName"), result.getString("author"),
                    result.getString("bookID"), result.getString("category"), result.getDouble("price"),result.getInt("lent"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
           
        System.out.println("book not found");
            return null;
            }




         public Book searchByCategory(String category) {
            for (Book book : bookShelf) {
                if (book.getBookName().equalsIgnoreCase(category)) {
                        System.out.println("book found");
                        System.out.println("Book Name: " + book.getBookName());
                        System.out.println("Author: " + book.getAuthor());
                        System.out.println("Book ID: " + book.getBookId());
                        System.out.println("Category: " + book.getCategory());
                        System.out.println("Price: " + book.getPrice());
                        return book;
                    }
                }
            try {
                String query = "SELECT * FROM book WHERE category=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, category);
                ResultSet result = ps.executeQuery();
    
                if (result.next()) {
                    System.out.println("book found");
                    System.out.println("Book ID: " + result.getString("bookID"));
                    System.out.println("Book Name: " + result.getString("bookName"));
                    System.out.println("Author: " + result.getString("author"));
                    System.out.println("Category: " + result.getString("category"));
                    System.out.println("Price: " + result.getDouble("price"));
                    System.out.println("lent(if show 1 means not in the bookshelf, if shows 0 means exsit: " + result.getInt("lent") );
                    return new Book(result.getString("bookName"), result.getString("author"),
                    result.getString("bookID"), result.getString("category"), result.getDouble("price"),result.getInt("lent"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
               
            System.out.println("book not found");
                return null;
                }

  

   
    public static void main (String []args){
		BookSearch bb=new BookSearch();
       
        bb.searchByID("hh2");
	}
}
