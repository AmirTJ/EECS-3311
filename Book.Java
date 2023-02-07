public class Book {

    private String bookId;
    private String bookName;
    private String author;
    private String category;
    private int lend = 0; // Determine whether the book is lent or not, yes for 1, default for 0.

    public Book() {

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
    }
}
