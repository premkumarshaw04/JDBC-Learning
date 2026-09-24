//Delete Data into database...
//But this is not a good practise.

import java.sql.*;
public class Main3 {
    public static void main(String[] args) throws ClassNotFoundException{

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prem@1234";
        String query = "DELETE FROM employee where id = 3;";

        //Loading the drivers
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Drivers Loaded Successfully");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        //Creating the Connection
        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully..");
            Statement stmt = con.createStatement();
            int rowsAffected = stmt.executeUpdate(query);

            if(rowsAffected > 0){
                System.out.println("Deletion Successful. " + rowsAffected + " rows affected.");
            }
            else System.out.println("Deletion Failed...");

            //Closing the Costly Resources....
            stmt.close();
            con.close();
            System.out.println();
            System.out.println("Connection Closed Successfully....");
        }
        catch (SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
