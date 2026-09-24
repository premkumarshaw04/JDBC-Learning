//Insert Data into database...

import java.sql.*;
public class Main2 {
    public static void main(String[] args) throws ClassNotFoundException{

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prem@1234";
        String query = "INSERT into employee(id, name, job_title, salary) VALUES(3, 'Harshit', 'Full Stack Web Developer', 87000.0);";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");//Loading the drivers
            System.out.println("Drivers Loaded Successfully");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established Successfully..");
            Statement stmt = con.createStatement();
            int rowsAffected = stmt.executeUpdate(query);

            if(rowsAffected > 0){
                System.out.println("Insert Successful. " + rowsAffected + " rows affected.");
            }
            else System.out.println("Insertion Failed...");

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
