public class Test {
    public static void main (String []args){
        BookSearch bb= new BookSearch();
        bb.addBooks("hh", "hh2", "hhh", "goodlarry", 2);
        bb.addBooks("abcab", "aaaa", "bbbb", "cccc", 0);
        bb.addBooks("abcab", "aaab", "bbbb", "cccc", 0);
        bb.addBooks("abcab", "aaaa", "bbcb", "cccc", 0);

        bb.searchById("hh2");
	}
}
