package iteration2;

import java.time.LocalDate;
import java.sql.*;
import iteration1.Book;
import iteration1.BookSearch;

public class Borrow {
	private String url="jdbc:mysql://localhost:3306/library"; // localhost:3306 - change here if needed
	private String user="root"; // use your own user name here
	private String password="2000909cao"; // use your own password
	private String query="";
	
    private String bookID;
    private User userName;
    private LocalDate borrowDate;
    private LocalDate returnDate;

    public Borrow(String bookID, User userName, LocalDate borrowDate) {
        this.bookID = bookID;
        this.userName = userName;
        this.borrowDate = borrowDate;
        BookSearch bs= new BookSearch();
    	Book book = bs.searchByID(bookID);
        if(book == null || isBookLent(book.getBookId())) {
        	System.out.println("This book with bookID: "+ bookID +" is not exist or has been lend.");
        }else {
        	book.setLend(1);
        	
        	try (Connection conn = DriverManager.getConnection(url, user, password)) {

                String updateQuery = "UPDATE book SET lend = ?, borrowTime = ? WHERE bookID = ?";
                PreparedStatement stmt = conn.prepareStatement(updateQuery);

                stmt.setInt(1, 1); // set lend to 0
                stmt.setDate(2, java.sql.Date.valueOf(this.borrowDate));
                stmt.setString(3, bookID); // use the id of the current book object
                stmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    public User getUser() {
        return this.userName;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public LocalDate getReturnDate(String bookID) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            this.query = "SELECT returnTime FROM book WHERE bookID = ?";
            PreparedStatement st = conn.prepareStatement(this.query);

            st.setString(1, bookID); // use the id of the current book object

            ResultSet rs = st.executeQuery();

            if (rs.next() && rs.getDate("returnTime")!= null) {
                java.sql.Date returnTime = rs.getDate("returnTime");
                return returnTime.toLocalDate();
            } else {
                System.out.println("There is no return time set.");
                return null;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isBookLent(String bookID) {
    	this.bookID = bookID;
    	BookSearch bs= new BookSearch();
    	Book book = bs.searchByID(this.bookID);
    	if(book != null) return book.getLend() == 1;
    	else return false;
    }

    public void returnBook(String bookID, LocalDate returnDate) {
        // Establishing a connection to the database
        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            String updateQuery = "UPDATE book SET lend = ?, returnTime = ? WHERE bookID = ?";
            PreparedStatement stmt = conn.prepareStatement(updateQuery);

            stmt.setInt(1, 0); // set lend to 0
            stmt.setDate(2, java.sql.Date.valueOf(returnDate));
            stmt.setString(3, bookID); // use the id of the current book object
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void extendBorrow(String bookID) {
        this.bookID = bookID;

        LocalDate newReturnDate = getReturnDate(bookID).plusDays(7); // extend for 7 days
        this.returnDate = newReturnDate;

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            this.query = "UPDATE book SET returnTime = ? WHERE bookID = ?";
            PreparedStatement st = conn.prepareStatement(this.query);

            st.setDate(1, java.sql.Date.valueOf(this.returnDate)); // set the new return time
            st.setString(2, this.bookID); // use the id of the current book object

            int rowsAffected = st.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated extend date.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}