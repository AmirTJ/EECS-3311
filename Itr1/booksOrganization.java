import java.util.ArrayList;

public class booksOrganization {

	public ArrayList<Book> bookShelf = new ArrayList<>();

	public ArrayList<Book> getBooks() {
		return this.bookShelf;
	}

	public void addBooks(String bookName, String bookId, String author, String category, double price) {
		Book book = new Book(bookName, bookId, author, category, price);
		book.setBookName(bookName);
		book.setBookId(bookId);
		book.setAuthor(author);
		book.setCategory(category);
		book.setPrice(price);
		for(int i=0;i<bookShelf.size();i++) {
			Book check = bookShelf.get(i);
			if(bookId.equals(check.getBookId())) {
				System.out.print("There has a same book id in the list, please check again!\n");
				return;
			}
			
		}
		bookShelf.add(book);
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
