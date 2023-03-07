// import java.util.ArrayList;
// import java.util.Scanner;
import java.sql.*;

public class BookSearch extends booksOrganization {
    private static final String URL = "jdbc:mysql://localhost:3306/library";
    private static final String USER = "username";
    private static final String PASSWORD = "password";
    private Connection connection;
    public BookSearch() {
        super();
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Book searchById(String Id) {
        try{
            String query = "SELECT * FROM books WHERE book_id=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, Id);
            ResultSet result = ps.executeQuery();
            if (result.next()) {
                System.out.println("book found");
                System.out.println("Book Name: " + result.getString("book_name"));
                System.out.println("Author: " + result.getString("author"));
                System.out.println("Book ID: " + result.getString("book_id"));
                System.out.println("Category: " + result.getString("category"));
                System.out.println("Price: " + result.getDouble("price"));
                return new Book(result.getString("book_name"), result.getString("author"),
                        result.getString("book_id"), result.getString("category"), result.getDouble("price"));
            }
      }   
     catch (Exception e) {
        e.printStackTrace();
     }     
       System.out.println("book not found");
        return null;
    }

    public Book searchByName(String title) {
        try {
            String query = "SELECT * FROM books WHERE book_name=?";
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, title);
            ResultSet result = ps.executeQuery();

            if (result.next()) {
                System.out.println("book found");
                System.out.println("Book Name: " + result.getString("book_name"));
                System.out.println("Author: " + result.getString("author"));
                System.out.println("Book ID: " + result.getString("book_id"));
                System.out.println("Category: " + result.getString("category"));
                System.out.println("Price: " + result.getDouble("price"));
                return new Book(result.getString("book_name"), result.getString("author"),
                        result.getString("book_id"), result.getString("category"), result.getDouble("price"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    System.out.println("book not found");
        return null;
        }
    

        public Book searchByAuthor(String author) {
            try {
                String query = "SELECT * FROM books WHERE author=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, author);
                ResultSet result = ps.executeQuery();
    
                if (result.next()) {
                    System.out.println("book found");
                    System.out.println("Book Name: " + result.getString("book_name"));
                    System.out.println("Author: " + result.getString("author"));
                    System.out.println("Book ID: " + result.getString("book_id"));
                    System.out.println("Category: " + result.getString("category"));
                    System.out.println("Price: " + result.getDouble("price"));
                    return new Book(result.getString("book_name"), result.getString("author"),
                            result.getString("book_id"), result.getString("category"), result.getDouble("price"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
           
        System.out.println("book not found");
            return null;
            }




         public Book searchByCategory(String category) {
            try {
                String query = "SELECT * FROM books WHERE book_category=?";
                PreparedStatement ps = connection.prepareStatement(query);
                ps.setString(1, category);
                ResultSet result = ps.executeQuery();
    
                if (result.next()) {
                    System.out.println("book found");
                    System.out.println("Book Name: " + result.getString("book_name"));
                    System.out.println("Author: " + result.getString("author"));
                    System.out.println("Book ID: " + result.getString("book_id"));
                    System.out.println("Category: " + result.getString("category"));
                    System.out.println("Price: " + result.getDouble("price"));
                    return new Book(result.getString("book_name"), result.getString("author"),
                            result.getString("book_id"), result.getString("category"), result.getDouble("price"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
               
            System.out.println("book not found");
                return null;
                }

  

   
    public static void main (String []args){
		BookSearch bb=new BookSearch();
       
        bb.searchById("hh2");
	}
}
