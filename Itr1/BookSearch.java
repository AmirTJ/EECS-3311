import java.util.ArrayList;
// import java.util.Scanner;

public class BookSearch extends booksOrganization {
    public BookSearch() {
        super();
    }

    public Book searchById(String Id) {
        for (Book book : bookShelf) {
            if (book.getBookId().equalsIgnoreCase(Id)) {
                System.out.println("book found");
                return book;
            }
        }System.out.println("book not found");
        return null;
    }

    public Book searchByName(String title) {
        for (Book book : bookShelf) {
            if (book.getBookName().equalsIgnoreCase(title)) {
                return book;
            }
        }
       
    System.out.println("book not found");
        return null;
        }
    

    public ArrayList<Book> searchByAuthor(String author) {
        ArrayList<Book> results = new ArrayList<Book>();
        for (Book book : bookShelf) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                results.add(book);
            }
        }
        return results;
    }

    public ArrayList<Book> searchByCategory(String category) {
        ArrayList<Book> results = new ArrayList<Book>();
        for (Book book : bookShelf) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                results.add(book);
            }
        }
        return results;
    }

    /*
     * Version 2:
     *
     * public BookSearch(ArrayList<Book> bookShelf) {
     * Scanner s = new Scanner(System.in);
     * System.out.println("Enter the String for search (author, id or bookName): ");
     * String searchResult = s.nextLine();
     * boolean bookFound = false;
     * for (int i = 0; i < bookShelf.size(); i++) {
     * Book book = bookShelf[i];
     * if (book.getAuthor().equalsIgnoreCase(searchResult) ||
     * book.getBookId().equalsIgnoreCase(searchResult)
     * || book.getBookName().equalsIgnoreCase(searchResult)) {
     * System.out.println("Book Name: " + book.getBookName());
     * System.out.println("Author: " + book.getAuthor());
     * System.out.println("Book ID: " + book.getBookId());
     * System.out.println("Category: " + book.getCategory());
     * System.out.println("Price: " + book.getPrice());
     * bookFound = true;
     * break;
     * }
     * 
     * }
     * if (!bookFound) {
     * System.out.println("Book not found!");
     * }
     * }
     */
    public static void main (String []args){
		BookSearch bb=new BookSearch();
       
        bb.searchById("hh2");
	}
}
