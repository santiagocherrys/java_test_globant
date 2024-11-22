package org.globant.models;

import org.globant.database.ConfigDB;
import org.globant.entity.Customer;
import org.globant.entity.Machine;
import org.globant.helper.MachineStatus;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MachineModel {

    public Machine insert(Machine machine){
        //1. Open the connection
        Connection objConnection = ConfigDB.openConnection();

        try{
            //3. Write the SQL
            String sql = "INSERT INTO machines(model, serie, state) VALUES (?, ?, ?)";

            //4.prepare the Statement, and Add the property RETURN_GENERATED_KEYS that returns the id generated by the database
            //After de insertion it returns the id of the database generated
            PreparedStatement objPrepare = objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            //5. values of ? ? ?
            objPrepare.setString(1, machine.getModel());
            objPrepare.setString(2, machine.getSerie());
            objPrepare.setString(3, machine.getState().name());

            //6. Execute the Query
            objPrepare.execute();

            //7. Obtain the result with its id(generated id)
            ResultSet objRest = objPrepare.getGeneratedKeys();

            //8. Loop while there is a register
            while(objRest.next()){
                machine.setId(objRest.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "Machine insertion was successful");
        }catch (SQLException e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        //Close the connection
        ConfigDB.closeConnection();
        return machine;
    }

    public int findAllMachinesNumber(){

        //2.Open the connection
        Connection objConnection = ConfigDB.openConnection();
        int quantity_machines = 0;

        try{
            //3.write the query in Sql
            String sql = "SELECT COUNT(*) AS quantity_machines FROM machines;";

            //4. Use the prepareStatement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //5.Execute the query and obtain the result(ResultSet)

            ResultSet objResult = objPrepare.executeQuery();

            //6. while there is a result
            while(objResult.next()){

                quantity_machines = objResult.getInt("quantity_machines");

            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        ConfigDB.closeConnection();


        return quantity_machines;
    }

    public List<Machine> findAll(){

        //1. Crete a list fr saving the return of the database
        List<Machine> machines = new ArrayList<>();

        //2.Open the connection
        Connection objConnection = ConfigDB.openConnection();

        try{
            //3.write the query in Sql
            String sql = "SELECT * FROM machines;";

            //4. Use the prepareStatement
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            //5.Execute the query and obtain the result(ResultSet)

            ResultSet objResult = objPrepare.executeQuery();

            //6. while there is a result
            while(objResult.next()){

                //6.1 Create a user
                Machine machine = new Machine();

                machine.setId(objResult.getInt("id"));
                machine.setModel(objResult.getString("model"));
                machine.setSerie(objResult.getString("serie"));
                machine.setState(MachineStatus.valueOf(objResult.getString("state")));
                machine.setRental_machine_id(objResult.getInt("rental_machine_id"));

                machines.add(machine);

            }
        }catch (SQLException error){
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        ConfigDB.closeConnection();


        return machines;
    }
}