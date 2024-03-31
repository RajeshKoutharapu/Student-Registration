import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Delete {
    Scanner sc=new Scanner(System.in);
    public void DeletingRows(Connection connection){
        System.out.println("Enter The RollNumber of Student you want to delete The Record");
     final String Querry="select * from students where rollnumber=?";
        int RollNumber=sc.nextInt();
        try {
            PreparedStatement preparedStatement=connection.prepareStatement(Querry);
            preparedStatement.setInt(1,RollNumber);
          ResultSet set= preparedStatement.executeQuery();
            if(set.next()){
                deleting(RollNumber,connection);
            }else {
                System.out.println("INVALID ROLL NUMBER");
            }

        }catch (Exception e){

        }
    }
    public boolean deleting(int RollNumber, Connection connection){
        final String Querrydelete="DELETE from students where rollnumber=?";
        try{
            PreparedStatement preparedStatement=connection.prepareStatement(Querrydelete);
            preparedStatement.setInt(1,RollNumber);
               int Check=preparedStatement.executeUpdate();
               if(Check==1){
                   System.out.println("---ROW DELETED SUCCESFULLY----");
               }
        }catch (Exception e){

        }
        return false;
    }
}
