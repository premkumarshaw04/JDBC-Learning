//Update Data into database...

import java.sql.*;
public class Main4 {
    public static void main(String[] args) throws ClassNotFoundException{

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prem@1234";
        String query = "UPDATE employee SET job_title = 'Full Stack Developer', salary = '70000' WHERE id = 2;";

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
            //executeUpdate method will be used in case of: insert, update, delete

            if(rowsAffected > 0){
                System.out.println("Updation Successful. " + rowsAffected + " rows affected.");
            }
            else System.out.println("Updation Failed...");

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


