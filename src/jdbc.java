import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc {
    public void jdbcConnection(int select) {
        CreatingAccount modifyobj =new CreatingAccount();
        view viewobj=new view();
        Update updateobj=new Update();
        Delete deleteobj=new Delete();

            final  String JDBC_URL = "jdbc:mysql://localhost:3306/information";
            final String USER = "root";
            final String PASSWORD = "root";

           try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection= DriverManager.getConnection(JDBC_URL,USER,PASSWORD);
                switch (select) {
                    case 1:modifyobj.create(connection);break;
                    case 2: viewobj.selectdetauils(connection); break;
                    case 3: updateobj.DetailsUpdate(connection);break;
                    case 4:deleteobj.DeletingRows(connection);
                }
                connection.close();
           }
           catch(Exception e){
                System.out.println(e);
            }
    }

}

