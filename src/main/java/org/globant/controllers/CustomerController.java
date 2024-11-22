package org.globant.controllers;

import org.globant.entity.Customer;
import org.globant.models.CustomerModel;

import javax.swing.*;

public class CustomerController {

    public static void create(){
        //Use the model
        CustomerModel objCustomerModel = new CustomerModel();

        //Ask data to the admin
        String name = JOptionPane.showInputDialog(("Insert name"));
        String email = JOptionPane.showInputDialog("Insert email");
        String phone = JOptionPane.showInputDialog("Insert phone");
        String address = JOptionPane.showInputDialog("Insert address");


        Customer customer = new Customer(name, email, phone, address);

        //Call the method of insertion y save the object that returns in customer
        customer =  objCustomerModel.insert(customer);

        JOptionPane.showMessageDialog(null, customer.toString());
    }

    public static void getAll(){
        CustomerModel objMode = new CustomerModel();
        String listCustomers = "CUSTOMER LIST \n";

        for(Customer customer: objMode.findAll()){
            listCustomers += customer.toString() + "\n";
        }

        JOptionPane.showMessageDialog(null, listCustomers);
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
