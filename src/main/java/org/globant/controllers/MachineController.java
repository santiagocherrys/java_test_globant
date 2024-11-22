package org.globant.controllers;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.globant.entity.Country;
import org.globant.entity.Customer;
import org.globant.entity.Machine;
import org.globant.helper.MachineStatus;
import org.globant.models.CustomerModel;
import org.globant.models.MachineModel;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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

    public static void createByExcel(){
        //Use the model
        MachineModel objMachineModel = new MachineModel();
        int cont = 0;
        for(Machine machine: pruebaleerMachine()){
            //this validation is to avoid add to  table machines title of Model and Serie
            if(cont != 0){
                Machine machineAux = new Machine(machine.getModel(),machine.getSerie(),MachineStatus.valueOf("AVAILABLE"));
                machine =  objMachineModel.insertByExcel(machineAux);
            }
            cont +=1;

        }



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

    public static List<Country> pruebaleer() {
        List<Country> countriesList = new ArrayList<>();
        String fileName = "src/main/java/org/globant/controllers/prueba_java.xlsx";
        try {
            //Create the input stream from the xlsx/xls file
            FileInputStream fis = new FileInputStream(fileName);

            //Create Workbook instance for xlsx/xls file input stream
            Workbook workbook = null;
            if(fileName.toLowerCase().endsWith("xlsx")){
                workbook = new XSSFWorkbook(fis);
            }else if(fileName.toLowerCase().endsWith("xls")){
                workbook = new HSSFWorkbook(fis);
            }

            //Get the number of sheets in the xlsx file
            int numberOfSheets = workbook.getNumberOfSheets();

            //loop through each of the sheets
            for(int i=0; i < numberOfSheets; i++){

                //Get the nth sheet from the workbook
                Sheet sheet = workbook.getSheetAt(i);

                //every sheet has rows, iterate over them
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext())
                {
                    String name = "";
                    String shortCode = "";

                    //Get the row object
                    Row row = rowIterator.next();

                    //Every row has columns, get the column iterator and iterate over them
                    Iterator<Cell> cellIterator = row.cellIterator();

                    while (cellIterator.hasNext())
                    {
                        //Get the Cell object
                        Cell cell = cellIterator.next();

                        //check the cell type and process accordingly
                        switch(cell.getCellType()){
                            case STRING:
                                if(shortCode.equalsIgnoreCase("")){
                                    shortCode = cell.getStringCellValue().trim();
                                }else if(name.equalsIgnoreCase("")){
                                    //2nd column
                                    name = cell.getStringCellValue().trim();
                                }else{
                                    //random data, leave it
                                    System.out.println("Random data::"+cell.getStringCellValue());
                                }
                                break;
                            case NUMERIC:
                                System.out.println("Random data::"+cell.getNumericCellValue());
                        }
                    } //end of cell iterator
                    Country c = new Country(name, shortCode);
                    countriesList.add(c);
                } //end of rows iterator


            } //end of sheets for loop

            //close file input stream
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return countriesList;
    }

    public static List<Machine> pruebaleerMachine() {
        List<Machine> machinesList = new ArrayList<>();
        String fileName = "src/main/java/org/globant/controllers/machines.xlsx";
        try {
            // Create the input stream from the xlsx/xls file
            FileInputStream fis = new FileInputStream(fileName);

            // Create Workbook instance for xlsx/xls file input stream
            Workbook workbook = null;
            if (fileName.toLowerCase().endsWith("xlsx")) {
                workbook = new XSSFWorkbook(fis);
            } else if (fileName.toLowerCase().endsWith("xls")) {
                workbook = new HSSFWorkbook(fis);
            }

            // Get the number of sheets in the xlsx file
            int numberOfSheets = workbook.getNumberOfSheets();

            // Loop through each of the sheets
            for (int i = 0; i < numberOfSheets; i++) {

                // Get the nth sheet from the workbook
                Sheet sheet = workbook.getSheetAt(i);

                // Every sheet has rows, iterate over them
                Iterator<Row> rowIterator = sheet.iterator();
                while (rowIterator.hasNext()) {
                    String model = "";
                    String serie = "";

                    // Get the row object
                    Row row = rowIterator.next();

                    // Every row has columns, get the column iterator and iterate over them
                    Iterator<Cell> cellIterator = row.cellIterator();

                    // Iterate over the cells in the current row
                    while (cellIterator.hasNext()) {
                        // Get the Cell object
                        Cell cell = cellIterator.next();

                        // Check the cell type and process accordingly
                        switch (cell.getCellType()) {
                            case STRING:
                                if (model.equals("")) {
                                    model = cell.getStringCellValue().trim();
                                } else if (serie.equals("")) {
                                    serie = cell.getStringCellValue().trim();
                                } else {
                                    // Random data, leave it or handle it
                                    System.out.println("Random data::" + cell.getStringCellValue());
                                }
                                break;

                            case NUMERIC:
                                if (model.equals("")) {
                                    model = String.valueOf(cell.getNumericCellValue());
                                } else if (serie.equals("")) {
                                    serie = String.valueOf(cell.getNumericCellValue());
                                }
                                break;

                            default:
                                break;
                        }
                    }

                    // Now create a Machine object with the data from the row
                    Machine machine = new Machine(model, serie);
                    machinesList.add(machine);
                } // End of rows iterator
            } // End of sheets for loop

            // Close the file input stream
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return machinesList;
    }

}
