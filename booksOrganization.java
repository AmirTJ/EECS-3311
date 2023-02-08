import java.util.ArrayList;

public class booksOrganization {
	
	private ArrayList<Book> bookShelf = new ArrayList<>();
	public void addBooks(String bookName, String bookId, String author, String category, double price) {
        Book book = new Book(bookName, bookId, author, category, price);
        book.setBookName(bookName);
        book.setBookId(bookId);
        book.setAuthor(author);
        book.setCategory(category);
        book.setPrice(price);
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
