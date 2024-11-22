package org.globant.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {

    //this atribute has the state of connection
    public static Connection objConnection = null;

    //Method to connect to the database
    public static Connection openConnection(){

        try{
            //call the driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Create the connection variables

            String url = "jdbc:mysql://localhost:3306/rental_machines";
            String user = "root";
            String password = "Exito!2025";

            //return the connection
            objConnection = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Connection successfully");


        }catch (ClassNotFoundException error){
            System.out.println("ERROR >> Driver is not installed " + error.getMessage());
        }catch (SQLException e){
            System.out.println("Error:  " + e.getMessage());
        }

        return objConnection;

    }

    //Method to finished and close connection
    public static void closeConnection(){

        try{
            //if there is a open connection it will close it
            if(objConnection != null){
                objConnection.close();
                System.out.println("the connection was closed correctly");
            }
        }catch(SQLException e){
            System.out.println("Error: " + e.getMessage());
        }
    }
}
