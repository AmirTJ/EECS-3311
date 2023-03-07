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


		for(int i=0;i<bookShelf.size();i++) {
			Book check = bookShelf.get(i);
			if(bookId.equals(check.getBookId())) {
				System.out.print("There has a same book id in the list, please check again!\n");
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

		query = String.format("INSERT INTO library.book "
						+ "(bookID, bookName, author, category, price, borrowTime) "
						+ "VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
				bookId, bookName, author, category, price, LocalDateTime.now());
		try{
			// create connection
			Connection con = DriverManager.getConnection(url, user, password);

			// create statement
			Statement statement = con.createStatement();

			// set fetch size
			statement.setFetchSize(100); // It is used to set the number of rows of data to be read from the database by the JDBC driver at a time.

			// generate result set
			ResultSet result = statement.executeQuery(query);
			// loop through the result set

			while (result.next()) {
				// process current row
				String data = "";
				for (int i = 1; i <= result.getMetaData().getColumnCount(); i++) {
					data += result.getString(i) + " ";
				}
				System.out.println(data);

				// check if we have reached the end of the page
				int rowCount = 0;
				if (++rowCount % 15 == 0) {
					// fetch next page
					result.close();
					result = statement.executeQuery(query + " LIMIT " + rowCount + ", " + 15);
				}
			}

			// close result set and statement
			result.close();
			statement.close();

		} catch (SQLException e) {
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
