import java.util.ArrayList;
import java.util.Scanner;

public class BookSearch extends bookOrganization {
  
    public BookSearch() {
        super();
    }
  
    public BookSearch(ArrayList<Book> bookShelf) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the String for search (author, id or bookName): ");
        String searchResult = s.nextLine();
        boolean bookFound = false;
        for (int i = 0; i < bookShelf.size(); i++) 
        {
            Book book = bookShelf[i];
            if (book.getAuthor().equalsIgnoreCase(searchResult)||book.getBookId().equalsIgnoreCase(searchResult)||book.getBookName().equalsIgnoreCase(searchResult))
            {
                System.out.println("Book Name: " + book.getBookName());
                System.out.println("Author: " + book.getAuthor());
                System.out.println("Book ID: " + book.getBookId());
                System.out.println("Category: " + book.getCategory());
                System.out.println("Price: " + book.getPrice());
                bookFound = true;
                break;
            } 
            
        
    }
        if (!bookFound) {
            System.out.println("Book not found!");
        }
    }
}
