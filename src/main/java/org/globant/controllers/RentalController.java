package org.globant.controllers;

import org.globant.entity.Customer;
import org.globant.entity.Rental;
import org.globant.helper.RentalStatus;
import org.globant.models.CustomerModel;
import org.globant.models.RentalModel;

import javax.swing.*;
import java.time.LocalDate;

public class RentalController {

    public static void create(){
        //Use the model
        RentalModel rentalModel = new RentalModel();

        //List the customers availables
        JOptionPane.showMessageDialog(null, CustomerController.getAllString());
        int customerIndex = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the customer"));

        //List the machines availables
        JOptionPane.showMessageDialog(null, MachineController.getAllAvailableString());
        int machineIndex = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the machine"));

        LocalDate start_date = LocalDate.parse(JOptionPane.showInputDialog("Insert date of begining of the rental format(YYYY-MM-DD)"));
        LocalDate end_date = LocalDate.parse(JOptionPane.showInputDialog("Insert date of ending of the rental format(YYYY-MM-DD)"));

        Rental rental = new Rental();
        rental.setStart_date(start_date);
        rental.setEnd_date(end_date);
        rental.setCustomer_id(customerIndex);

        //when a rental is created we need to associated the rental_machine, so it have to be created
        rental.setRental_machine_id(rentalModel.createIdrental());
        MachineController.setMachineRented(machineIndex, rental.getRental_machine_id());

        //Add more machines
        while(true){
            String opc = JOptionPane.showInputDialog("\"Do you want to add another machine. 1. -> Yes 2. No\"\nEnter your choice");
            if(opc.equals("1")){
                //List the machines availables
                JOptionPane.showMessageDialog(null, MachineController.getAllAvailableString());
                machineIndex = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the machine"));
                MachineController.setMachineRented(machineIndex, rental.getRental_machine_id());
            }else if(opc.equals("2")){
                break;
            }else{
                JOptionPane.showMessageDialog(null, "Invalid opction");
            }
        }


        //when creating a rental by default the status will be Active
        rental.setStatus(RentalStatus.ACTIVE);



        rentalModel.insert(rental);
    }

    public static int createRentalMachine(){
        RentalModel RentalModel = new RentalModel();
        return 0;
    }
}
