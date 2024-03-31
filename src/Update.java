import java.sql.*;
import java.util.*;
public class Update {
Scanner sc= new Scanner(System.in);
public void DetailsUpdate(Connection connection){
    System.out.println("enter the roll number of the student for updating details");
    int checkrollnumber=sc.nextInt();
    String Querry="select * from students where rollnumber=?";
    try{
        PreparedStatement preparedStatement=connection.prepareStatement(Querry);
        preparedStatement.setInt(1,checkrollnumber);
     ResultSet resultSet= preparedStatement.executeQuery();
     if(resultSet.next()){
         updating(connection,checkrollnumber);
     }else {
         System.out.println("INVALID ROLL NUMBER");
     }
    }catch (Exception e){
        System.out.println(e);

    }
}
public void updating(Connection connection ,int targetrollnumber) throws SQLException {
    final String querryname="update students set name=? where rollnumber=?";
    final   String QuerryFather="update students set fathername= ?where rollnumber=?";
    final  String QuerryAddres="update students set address= ?where rollnumber=?";
    final   String QuerryLocation="update students set location= ?where rollnumber=?";
    ArrayList<Integer> arrayList=new ArrayList<>();
    boolean conform=false;
    System.out.println("--------select your field to modify-------");
    System.out.println("modifying name enter 1"+"\n"+"modifying Father Name rnter 2:");
    System.out.println("modifying Address enter 3"+"\n"+"modifying location enter 4");
    System.out.println("enter 0 for exit");
    for(int i=0;i<=4;i++){
        int temp=sc.nextInt();
        if(temp>=0 && temp<=4)
            if(temp==0){
                break;
            }else {
                arrayList.add(temp);
            }else{
            System.out.println(temp+"  IS NOT IN THE LIST");
        }
    }
    for (Integer n:arrayList) {
        switch (n) {
                case 1:
                    System.out.println("enter your name");
                    sc.nextLine();
                    String newname = sc.nextLine();
                    PreparedStatement preparedStatement = connection.prepareStatement(querryname);
                    preparedStatement.setString(1, newname);
                    preparedStatement.setInt(2, targetrollnumber);
                    preparedStatement.executeUpdate(); conform=true;break;
                    //  System.out.println(temp);
                case 2:
                    System.out.println("enter your Father Name");
                    sc.nextLine();
                    String fname = sc.nextLine();
                    PreparedStatement pr = connection.prepareStatement(QuerryFather);
                    pr.setString(1, fname);
                    pr.setInt(2, targetrollnumber);
                    int ack = pr.executeUpdate();conform=true;
                    break;
                case 3:
                    System.out.println("enter your new address");
                    String newAddress = sc.nextLine();
                    PreparedStatement pradress = connection.prepareStatement(QuerryAddres);
                    pradress.setString(1, newAddress);
                    pradress.setInt(2, targetrollnumber);
                    pradress.executeUpdate();
                    conform=true;break;
                case 4:
                    System.out.println("enter now location");
                    sc.nextLine();
                    String newLocation = sc.nextLine();
                    PreparedStatement prlocation = connection.prepareStatement(QuerryLocation);
                    prlocation.setString(1, newLocation);
                    prlocation.setInt(2, targetrollnumber);
                    prlocation.executeUpdate();conform=true;
                    break;
                default:
                    System.out.println("SELECT CHOICE FROM THE GIVEN OPTIONS");break;
            }

    }
    if(conform){
        System.out.println("------YOUR DETAILS UPDATED------");
    }

}
}
