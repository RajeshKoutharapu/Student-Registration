import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.*;
public class CreatingAccount {
 Scanner sc = new Scanner(System.in);
      //  jdbc jdbcobj = new jdbc();
        public void create (Connection connection) {
            System.out.println("enter student roll number");
            int roll = sc.nextInt();
            boolean DetailsCheck =false;
            try {
                Statement stmt = connection.createStatement();
                ResultSet resultSet = stmt.executeQuery("select * from students where rollnumber=" + roll);
                if (resultSet.next()) {
                    System.out.println("ENTERED ROLL NUMBER IS ALREADY EXISTS");
                } else {
                    DetailsCheck= EnteringDetails(connection,roll);
                }
            } catch (Exception e) {

            }
       if(DetailsCheck){
           System.out.println("DETAILS ARE INSERTED SUCESSFULLY");
      } else {
           System.out.println("FAILED TO INSERT THE DETAILS ENTER AGAIN");
       }
        }
    String sql1 = "INSERT INTO students (rollnumber, name, fathername, address, location, course) VALUES (?, ?, ?, ?, ?, ?)";
        public boolean EnteringDetails(Connection connection,int roll){

               sc.nextLine();
               System.out.println("enter name");
               String sname = sc.nextLine();
               System.out.println("enter father name");
               String sfathername = sc.nextLine();
               System.out.println("enter saddress");
               String saddress = sc.nextLine();
               System.out.println("enter location");
               String slocation = sc.nextLine();
               System.out.println(" enter course");
               String scourse = sc.nextLine();
               try {
                   PreparedStatement stmt1 = connection.prepareStatement(sql1);
                   stmt1.setInt(1, roll);
                   stmt1.setString(2, sname);
                   stmt1.setString(3, sfathername);
                   stmt1.setString(4, saddress);
                   stmt1.setString(5, slocation);
                   stmt1.setString(6, scourse);
                   stmt1.executeUpdate();

               } catch (Exception e){
                 return false;
               }
              return true;
        }

       }


