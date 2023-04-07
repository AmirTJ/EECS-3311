package iteration1;
import java.sql.*;

public class Book {

	private String url="jdbc:mysql://localhost:3306/library"; // localhost:3306 - change here if needed
	private String user="root"; // use your own user name here
	private String password="123456"; // use your own password
	private String query="";
	
    private String bookId; // Each bookId is unique and will not be duplicated.
    private String bookName;
    private String author;
    private String category;
    private int lend = 0; // Determine whether the book is lent or not, yes for 1, default for 0.
    public double price = 0;

    public Book(String bookId, String bookName, String author, String category, double price) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.category = category;
        this.price = price;
    }
    public Book(String bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public String getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public int getLend() {
    	try (Connection conn = DriverManager.getConnection(url, user, password)) {

            String selectQuery = "SELECT lend FROM book WHERE bookID = ?";
            PreparedStatement stmt = conn.prepareStatement(selectQuery);
            stmt.setString(1, this.bookId); 
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                int lend = rs.getInt("lend");
                return lend;
            } else {
                System.out.println("No rows returned.");
                return 0; // Return a default value if no rows are returned
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return 0; // Return a default value if an exception occurs
        }
    }

    public double getPrice() {
        return price;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLend(int lend) {
        this.lend = lend;

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            this.query = "UPDATE book SET lend = ? WHERE bookID = ?";
            PreparedStatement st = conn.prepareStatement(this.query);

            st.setInt(1, this.lend); // set lend to 1
            st.setString(2, this.bookId); // use the id of the current book object

            // Executing the update query
            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setPrice(double price) {
        this.price = price;
    }
    }
