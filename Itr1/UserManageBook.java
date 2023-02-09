
import java.util.Scanner;
public class UserManageBook {

   
    public static void main (String []arg){ 
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose whihch function do you want use(for manager): ");
        System.out.println("Press 1 for books organization, press 2 for search book");
        int choice = sc.nextInt();
        if (choice==1){
            
            Scanner sid = new Scanner(System.in);
            Scanner satu = new Scanner(System.in);
            Scanner sname = new Scanner(System.in);
            Scanner spr = new Scanner(System.in);
            Scanner scategory=new Scanner(System.in);
            System.out.println("please add the book by book name, id, author, category, and price");
            String name =sname.nextLine();
            String id=sid.nextLine();
            String atu=satu.nextLine();
            String category=scategory.nextLine();
            double price=spr.nextDouble();
            booksOrganization add=new booksOrganization();
            add.addBooks(name, id, atu, category, price);
       return ;

        }
        if (choice==2){

        }
         if(choice!=2||choice!=1) {
            System.out.println("plese press the valid word!");
        }

    }
    
}
