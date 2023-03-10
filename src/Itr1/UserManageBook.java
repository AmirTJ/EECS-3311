package Itr1;
import java.util.Scanner;
import java.util.InputMismatchException;

public class UserManageBook {

    public static void main(String[] arg) {
        int ch = 1;
        BookSearch manage = new BookSearch();
        Scanner input = new Scanner(System.in);
        while (ch != 0) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Welcome! ");
            System.out.println("Choose whihch function do you want use(for manager): ");
            System.out.println(
                    "Enter 1 for add book\nEnter 2 for delete book\nEnter 3 to delete all book\nEnter 4 to search book\npress 0 to exit the system");

            ch = input.nextInt();
            switch (ch) {
                case 1:
                    System.out.println("Add book\n");
                     try {
                    Scanner sid = new Scanner(System.in);
                    Scanner satu = new Scanner(System.in);
                    Scanner sname = new Scanner(System.in);
                    Scanner spr = new Scanner(System.in);
                    Scanner scategory = new Scanner(System.in);
                    System.out.println("please add the book by book name, id, author, category, and price!");
                    String name = sname.nextLine();
                    String id = sid.nextLine();
                    String atu = satu.nextLine();
                    String category = scategory.nextLine();
                    double price = spr.nextDouble();
                    manage.addBooks(name, id, atu, category, price);
                         }catch(InputMismatchException e) {
                    	System.out.println("Wrong enter, please try again");
                    	break;
                    }
                    break;

                case 2:
                    System.out.println("Delete book\n");
                    Scanner dsname = new Scanner(System.in);
                    Scanner dsid = new Scanner(System.in);
                    System.out.println("please delete the book by book name and id!");
                    String dname = dsname.nextLine();
                    String did = dsid.nextLine();

                    manage.deleteBooks(dname, did);
                    break;

                case 3:
                    System.out.println("Delete all books\n");
                    Scanner scheck = new Scanner(System.in);
                    System.out.println(
                            "please double check if you want to delete all books, yes enter 1, if not enter 2!\n");
                    double check = scheck.nextDouble();
                    if (check == 1) {
                        manage.removeAllbooks();
                        break;
                    }
                    if (check == 2) {
                        break;
                    } else {
                        System.out.println("Wrong enter, please try again!");
                        break;
                    }

                case 4:
                    System.out.println("Book search\n");

                    System.out.println(
                            "please enter the numer to search, 1: search by id, 2: search by name, 3: search by author, 4: search by category\n");

                    Scanner search = new Scanner(System.in);

                    double s = search.nextDouble();
                    if (s == 1) {
                        System.out.println("please input book's id");
                        Scanner ssid = new Scanner(System.in);
                        String nsid = ssid.nextLine();
                        manage.searchByID(nsid);
                        break;
                    }
                    if (s == 2) {
                        System.out.println("please input book's name");
                        Scanner ssname = new Scanner(System.in);
                        String nsname = ssname.nextLine();
                        manage.searchByName(nsname);
                        break;
                    }
                    if (s == 3) {
                        System.out.println("please input author's name");
                        Scanner ssatu = new Scanner(System.in);
                        String nsatu = ssatu.nextLine();
                        manage.searchByAuthor(nsatu);
                        break;
                    }
                    if (s == 4) {
                        System.out.println("please input book's category");
                        Scanner sscategory = new Scanner(System.in);
                        String nscategory = sscategory.nextLine();
                        manage.searchByCategory(nscategory);
                        break;
                    } else {
                        System.out.println("Wrong enter, please try again!");
                    }
                default:
                    ch = 0;
            }

        }
        System.out.println("system finish,thanks for use!");

    }
}
