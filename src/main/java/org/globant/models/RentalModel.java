package org.globant.models;

import org.globant.database.ConfigDB;
import org.globant.entity.Machine;
import org.globant.entity.Rental;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RentalModel{

    public Rental insert(Rental rental){
        //1. Open the connection
        Connection objConnection = ConfigDB.openConnection();

        try{

            //list the customers available


            //3. Write the SQL
            String sql = "INSERT INTO rentals(start_date, end_date, state, customer_id, rental_machine_id) VALUES (?, ?, ?, ?, ?)";

            //4.prepare the Statement, and Add the property RETURN_GENERATED_KEYS that returns the id generated by the database
            //After de insertion it returns the id of the database generated
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //5. values of ? ? ?
            objPrepare.setString(1, rental.getStart_date().toString());
            objPrepare.setString(2, rental.getEnd_date().toString());
            objPrepare.setString(3, rental.getStatus().name());
            objPrepare.setInt(4, rental.getCustomer_id());
            objPrepare.setInt(5, rental.getRental_machine_id());

            //6. Execute the Query
            objPrepare.execute();

            //7. Obtain the result with its id(generated id)
            ResultSet objRest = objPrepare.getGeneratedKeys();

            //8. Loop while there is a register
            while(objRest.next()){
                rental.setId(objRest.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "Rental insertion was successful");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //Close the connection
        ConfigDB.closeConnection();
        return rental;
    }
}
