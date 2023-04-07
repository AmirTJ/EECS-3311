package iteration1;


public class Test {
    public static void main (String []args){
        BookSearch bb= new BookSearch();
        bb.removeAllbooks();  // clear the database

        bb.addBooks("hh", "hh2", "hhh", "goodlarry", 2); // Book added successfully
        bb.addBooks("abcab", "aaaa", "bbbb", "cccc", 0); // Book added successfully
        bb.addBooks("abcab", "aaab", "bbbb", "cccc", 0); // Book added successfully
        bb.addBooks("abcab", "aaaa", "bbcb", "cccc", 0); // return error, already have same book ID

        bb.deleteBooks("abcab", "aaaa"); // should delete successfully
        bb.deleteBooks("aaaa", "abcab"); // return error, there is no book to delete

        bb.searchByID("hh2");
	}
}