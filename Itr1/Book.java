public class Book {

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
        return lend;
    }

    public double getPrice() {
        return price;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId; // The latter needs to check that the bookId is unique.
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setLend(int lend) {
        this.lend = lend;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book Name: " + bookName +
                ",  Book ID: " + bookId +
                ",  Author: " + author +
                ",  Category: " + category +
                ",  Price: " + price + "\n";
    }
}