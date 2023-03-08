import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDateTime;

public class booksOrganization {
	private String url="jdbc:mysql://localhost:3306/library"; // localhost:3306 - change here if needed
	private String user="root"; // use your own user name here
	private String password="123456"; // use your own password
	private String query="";

	public ArrayList<Book> bookShelf = new ArrayList<>();

	public ArrayList<Book> getBooks() {
		return this.bookShelf;
	}

	public void addBooks(String bookName, String bookId, String author, String category, double price) {

		String query = "SELECT COUNT(*) FROM library.book WHERE bookID=?";
		try (Connection con = DriverManager.getConnection(url, user, password);
			 PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, bookId);
			ResultSet resultSet = statement.executeQuery();
			if (resultSet.next() && resultSet.getInt(1) > 0) {
				System.out.println("In database: There has a same book id in the list, please check again!\n");
				return;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		for(int i=0;i<bookShelf.size();i++) {
			Book check = bookShelf.get(i);
			if(bookId.equals(check.getBookId())) {
				System.out.print("In bookShelf: There has a same book id in the list, please check again!\n");
				return;
			}

		}
		Book book = new Book(bookName, bookId, author, category, price);
		book.setBookName(bookName);
		book.setBookId(bookId);
		book.setAuthor(author);
		book.setCategory(category);
		book.setPrice(price);
		bookShelf.add(book);

		query = "INSERT INTO library.book "
				+ "(bookID, bookName, author, category, price, borrowTime) "
				+ "VALUES (?, ?, ?, ?, ?, ?)";
		try(// create connection
			Connection con = DriverManager.getConnection(url, user, password);
			PreparedStatement statement = con.prepareStatement(query)) {
			statement.setString(1, bookId);
			statement.setString(2, bookName);
			statement.setString(3, author);
			statement.setString(4, category);
			statement.setDouble(5, price);
			statement.setObject(6, LocalDateTime.now());
			statement.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Book added successfully!");
	}

	public void deleteBooks(String bookName, String bookId) {
		int i = 0;
		boolean deleted = false;
		while (i < bookShelf.size()) {
			Book book = bookShelf.get(i);
			if (bookName.equals(book.getBookName()) && bookId.equals(book.getBookId())) {
				bookShelf.remove(book);
				System.out.println("Book deleted successfully!");
				deleted = true;
				break;
			}
			i++;
		}
		if (!deleted) {
			System.out.println("Please check the book name and id, try again!");
		}
	}

	public void removeAllbooks() {
		bookShelf.clear();
		System.out.println("All books had been removed!");
	}


}
