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
        RentalModel RentalModel = new RentalModel();

        //List the customers availables
        JOptionPane.showMessageDialog(null, CustomerController.getAllString());
        int customerIndex = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the customer"));

        //List the machines
        JOptionPane.showMessageDialog(null, MachineController.getAllString());
        int machineIndex = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the machine"));

        LocalDate start_date = LocalDate.parse(JOptionPane.showInputDialog("Insert date of begining of the rental format(YYYY-MM-DD)"));
        LocalDate end_date = LocalDate.parse(JOptionPane.showInputDialog("Insert date of ending of the rental format(YYYY-MM-DD)"));

        Rental rental = new Rental();
        rental.setStart_date(start_date);
        rental.setEnd_date(end_date);
        rental.setCustomer_id(customerIndex);
        rental.setRental_machine_id(machineIndex);

        //when creating a rental by default the status will be Active
        rental.setStatus(RentalStatus.ACTIVE);

        //when a rental is created we need to associated the rental_machine, so it have to be created

    }

    public static int createRentalMachine(){
        RentalModel RentalModel = new RentalModel();
        return 0;
    }
}
