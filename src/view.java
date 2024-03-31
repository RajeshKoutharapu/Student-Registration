
import java.sql.*;
import java.util.*;
public class view {
    Scanner sc=new Scanner(System.in);
public  void selectdetauils(Connection connection){
    System.out.println("enter roll number ");
    int rollnumber =sc.nextInt();
    String querry="select *  from  students  where rollnumber= ?";
    try{
        PreparedStatement pr=connection.prepareStatement(querry) ;
        pr.setInt(1,rollnumber);
        ResultSet resultSet=pr.executeQuery();
        if(resultSet.next()) {

                int rollnum = resultSet.getInt(1);
                String NAME = resultSet.getString(2);
                String Fname = resultSet.getString(3);
                String address = resultSet.getString(4);
                String location = resultSet.getString(5);
                String Course = resultSet.getString(6);
                System.out.println("ROLLNUMBER :" + rollnum + "\n" + "NAME :" + NAME + "\n" + "Father_Name :" + Fname);
                System.out.println("ADDRESS :" + address + "\n" + "LOCATION :" + location + " \n" + "COURSE :" + Course);

        }else {
            System.out.println("INVALID ROLL NUMBER");
        }


    }catch (Exception e){
                System.out.println("you entered invalid roll number");
            }



    }

}
