package org.globant.controllers;

import org.globant.entity.Customer;
import org.globant.entity.Machine;
import org.globant.helper.MachineStatus;
import org.globant.models.CustomerModel;
import org.globant.models.MachineModel;

import javax.swing.*;
import java.util.List;

public class MachineController {

    public static void create(){
        //Use the model
        MachineModel objMachineModel = new MachineModel();

        //Ask data to admin
        String model = JOptionPane.showInputDialog(("Insert model"));
        String serie = JOptionPane.showInputDialog("Insert serie");
        MachineStatus state = MachineStatus.valueOf(JOptionPane.showInputDialog("Insert state(AVAILABLE-RENTED)"));


        Machine machine = new Machine(model,serie,state);
        //Call the method of insertion y save the object that returns in machine
        machine =  objMachineModel.insert(machine);

        JOptionPane.showMessageDialog(null, machine.toString());
    }

    public static void getAll(){
        MachineModel objMode = new MachineModel();
        String machines = "MACHINES LIST \n";
        int step = 0;
        List<Machine> listMachines = objMode.findAll();


        for(int i=0; i < objMode.findAllMachinesNumber(); i++){

                if(((i+1)%5) == 0){
                    System.out.println("Entro en modulo");
                    machines += "#" + (i+1) + " " + listMachines.get(i).toString() + "\n";
                    JOptionPane.showMessageDialog(null, machines);
                    machines = "";
                }else if(i == (objMode.findAllMachinesNumber() -1)){
                    System.out.println("entro en tamaño i");
                    machines += "#" + (i+1) + " " + listMachines.get(i).toString() + "\n";
                    JOptionPane.showMessageDialog(null, machines);
                    machines = "";
                }else{
                    machines += "#" + (i+1) + " " + listMachines.get(i).toString() + "\n";
                }

        }


    }

    public static String getAllString(){
        CustomerModel objMode = new CustomerModel();
        String listCustomers = "CUSTOMER LIST \n";

        for(Customer customer: objMode.findAll()){
            listCustomers += customer.toString() + "\n";
        }
        return listCustomers;
    }


}
