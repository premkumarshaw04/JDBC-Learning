package hospitalManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Patient {
    private Connection connection;
    private Scanner scanner;

    //Constructor
    public Patient(Connection connection, Scanner scanner){
        this.connection = connection;
        this.scanner = scanner;
    }

    //Methods of Patient Class
    public void addPatient(){
        System.out.print("Enter Patient Name: ");
        String name = scanner.next();
        System.out.print("Enter Patient Age: ");
        int age = scanner.nextInt();
        System.out.print("Enter Patient Gender: ");
        String gender = scanner.next();

        //In case establishing the Connection, we can get SQLException
        try{
            //we have to insert the data in the Patient table using Prepared Statement
            String query = "insert into patients(name, age, gender) values(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, age);
            preparedStatement.setString(3, gender);
            int affectedRows = preparedStatement.executeUpdate();
            if(affectedRows > 0){
                System.out.println("Pateint Added Successfully...");
            }
            else{
                System.out.println("Failed To add Patient");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //Read Operation----------
    public void viewPatients(){
        
    }
}
