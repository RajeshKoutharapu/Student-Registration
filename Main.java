// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
import java.util.*;
public class Main{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        jdbc obj=new jdbc();
        char valid;
       // modify modifyobj=new modify();
     //   System.out.println("enter your  choice");
      //  int choice=sc.nextInt();
        do {
            System.out.println("------------- Welcome to Student info ---------");
            System.out.println("enter 1 for entering details");
            System.out.println("enter 2 for selecting details");
            System.out.println("enter 3 for modifying details");
            System.out.println("enter 4 for deleting details");
            int select = sc.nextInt();
            obj.jdbcConnection(select);
            System.out.println("Enter 'Y' for MAIN MENU--- ENTER 'N' FOR EXIT");
             valid=sc.next().charAt(0);
        }while (valid=='Y'||valid=='y');


    }
}