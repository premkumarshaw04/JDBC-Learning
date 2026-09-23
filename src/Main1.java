import java.sql.*;
public class Main1 {
    public static void main(String[] args) throws ClassNotFoundException{

        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "prem@1234";
        String query = "Select * from employee;";

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
            ResultSet rs = stmt.executeQuery(query);//Storing the data
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String job_title = rs.getString("job_title");
                double salary = rs.getDouble("salary");
                System.out.println();
                System.out.println("===========================");
                System.out.println("ID: "+ id);
                System.out.println("Name: "+name);
                System.out.println("Job Title: "+job_title);
                System.out.println("Salary: "+salary);
            }
            //Closing the Costly Resources....
            rs.close();
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
