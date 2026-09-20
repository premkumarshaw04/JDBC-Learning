//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        //Database URL
        String url = "jdbc:mysql://localhost:3306/studentsyt";

        //database credential
        String username = "root";
        String password = "prem@1234";

        //Establish the connection
        try(Connection connection = DriverManager.getConnection(url, username, password)){
            System.out.println("Connected to the DataBase");
            System.out.println(connection);

            //Perform the database operation here
        }catch(SQLException e){
            System.out.println("Connection Failed: " + e.getMessage());
        }
    }
}