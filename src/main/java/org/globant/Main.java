package org.globant;

import org.globant.controllers.CustomerController;
import org.globant.controllers.MachineController;
import org.globant.database.ConfigDB;
import org.globant.entity.Customer;

import javax.swing.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        boolean exit = false;



        do{

            switch(menu()){
                case "1":
                    //Create customer
                    CustomerController.create();

                    break;
                case "2":
                    //List customers
                    CustomerController.getAll();

                    break;
                case "3":
                    //Create a Machine
                    MachineController.create();
                    break;

                case "4":
                    //list Machines
                    MachineController.getAll();
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, "Have a good day");
                    exit = true;
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Option not valid");

            }

        }while(!exit);
    }

    public static String menu(){

        return JOptionPane.showInputDialog("""
                    1. Register customer
                    2. List all customer
                    3. Create a Machine
                    4. List machines by 5 registers
                    5. exit
                    
                    Choose an option:
                    """);
    }
}