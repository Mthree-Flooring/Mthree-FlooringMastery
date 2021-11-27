package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.math.BigDecimal;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author raymondtam
 */
public class FlooringMasteryDaoFileImpl implements FlooringMasteryDao {

    public Map<Integer, Order> order = new HashMap<>();

    public final String ORDER_FILE;
    public static final String DELIMITER = ",";

    public FlooringMasteryDaoFileImpl() {
        ORDER_FILE = "Orders_06012013.txt"; //is a sample file which is included in the sample download above.

    }

    public FlooringMasteryDaoFileImpl(String rosterTextFile) {
        ORDER_FILE = rosterTextFile;
    }

    private Order unmarshallOrder(String orderAsText) {
        // studentAsText is expecting a line read in from our file.
        // For example, it might look like this:
        // 1234::Ada::Lovelace::Java-September1842
        //
        // We then split that line on our DELIMITER - which we are using as ::
        // Leaving us with an array of Strings, stored in studentTokens.
        // Which should look like this:
        // ______________________________________
        // |    |   |        |                  |
        // |1234|Ada|Lovelace|Java-September1842|
        // |    |   |        |                  |
        // --------------------------------------
        //  [0]  [1]    [2]         [3]
        String[] orderTokens = orderAsText.split(DELIMITER);

        // Given the pattern above, the student Id is in index 0 of the array.
        int orderNumber = Integer.parseInt(orderTokens[0]);

        // Which we can then use to create a new Student object to satisfy
        // the requirements of the Student constructor.
        Order orderFromFile = new Order(orderNumber);

        // However, there are 3 remaining tokens that need to be set into the
        // new student object. Do this manually by using the appropriate setters.
        // Index 1 - FirstName
        orderFromFile.setCustomerName(orderTokens[1]);

        // Index 2 - LastName
        orderFromFile.setState(orderTokens[2]);

        // Index 3 - Cohort
        orderFromFile.setProductType(orderTokens[3]);

        BigDecimal taxRate = new BigDecimal(orderTokens[4]);
        orderFromFile.setTaxRate(taxRate);
        orderFromFile.setProductType(orderTokens[5]);

        BigDecimal area = new BigDecimal(orderTokens[6]);
        orderFromFile.setArea(area);
        // We have now created a student! Return it!
        BigDecimal costPerSquareFoot = new BigDecimal(orderTokens[7]);
        orderFromFile.setCostPerSquareFoot(costPerSquareFoot);

        BigDecimal laborCostPerSquareFoot = new BigDecimal(orderTokens[8]);
        orderFromFile.setLaborCostPerSquareFoot(laborCostPerSquareFoot);

        BigDecimal materialCost = new BigDecimal(orderTokens[9]);
        orderFromFile.setMaterialCost(materialCost);

        BigDecimal laborCost = new BigDecimal(orderTokens[10]);
        orderFromFile.setLaborCost(laborCost);

        BigDecimal tax = new BigDecimal(orderTokens[11]);
        orderFromFile.setTax(tax);

        BigDecimal total = new BigDecimal(orderTokens[12]);
        orderFromFile.setTotal(total);

        return orderFromFile;

    }

    private void loadRoster() throws FlooringMasteryPersistenceException {
        Scanner scanner;

        try {
            // Create Scanner for reading the file
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(ORDER_FILE)));
        } catch (FileNotFoundException e) {
            throw new FlooringMasteryPersistenceException(
                    "-_- Could not load roster data into memory.", e);
        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        Order currentOrder;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentOrder = unmarshallOrder(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            order.put(currentOrder.getOrderNumber(), currentOrder);
        }
        // close scanner
        scanner.close();
    }

    private String marshallOrder(Order aOrder) {
        // We need to turn a Student object into a line of text for our file.
        // For example, we need an in memory object to end up like this:
        // 4321::Charles::Babbage::Java-September1842

        // It's not a complicated process. Just get out each property,
        // and concatenate with our DELIMITER as a kind of spacer. 
        // Start with the student id, since that's supposed to be first.
        String orderAsText = aOrder.getProductType() + DELIMITER;

        // add the rest of the properties in the correct order:
        // FirstName
        orderAsText += aOrder.getTaxRate() + DELIMITER;

        // LastName
        orderAsText += aOrder.getArea().toString() + DELIMITER;

        // Cohort - don't forget to skip the DELIMITER here.
        orderAsText += aOrder.getCostPerSquareFoot().toString() + DELIMITER;

        orderAsText += aOrder.getLaborCostPerSquareFoot().toString() + DELIMITER;

        orderAsText += aOrder.getMaterialCost().toString() + DELIMITER;
        orderAsText += aOrder.getLaborCost().toString() + DELIMITER;
        orderAsText += aOrder.getTax().toString() + DELIMITER;
        orderAsText += aOrder.getTotal().toString() + DELIMITER;

        // We have now turned a student to text! Return it!
        return orderAsText;
    }

    /**
     * Writes all students in the roster out to a ROSTER_FILE. See loadRoster
     * for file format.
     *
     * @throws FlooringMasteryPersistenceException if an error occurs writing to
     * the file
     */
    private void writeRoster() throws FlooringMasteryPersistenceException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(ORDER_FILE));
        } catch (IOException e) {
            throw new FlooringMasteryPersistenceException(
                    "Could not save order data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        String orderAsText;
        List<Order> orderList = this.getAllOrders();
        for (Order currentOrder : orderList) {
            // turn a Student into a String
            orderAsText = marshallOrder(currentOrder);
            // write the Student object to the file
            out.println(orderAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

    interface StringFunction {

        String run(String str);
    }

    public static String printFormatted(String str, StringFunction format) {
        String result = format.run(str);
        System.out.println(result);
        return result;
    }

    private void loadCustomRoster(String date) throws FlooringMasteryPersistenceException {
        Scanner scanner = null;

        try {

            StringFunction orderDate = (s) -> "Orders_" + s;
            scanner = new Scanner(
                    new BufferedReader(
                            new FileReader(printFormatted(date, orderDate))));

        } catch (FileNotFoundException e) {
            StringFunction orderDate = (s) -> "Orders_" + s;
            File newFile = new File(printFormatted(date, orderDate));
            try{
            if(newFile.createNewFile()){
                System.out.println("File Created!");
            }
            }
            catch(IOException ex){
                 throw new FlooringMasteryPersistenceException(
                    "Could not save order data.", ex);
            }
            loadCustomRoster(date);

        }
        // currentLine holds the most recent line read from the file
        String currentLine;
        // currentStudent holds the most recent student unmarshalled
        Order currentOrder;
        // Go through ROSTER_FILE line by line, decoding each line into a 
        // Student object by calling the unmarshallStudent method.
        // Process while we have more lines in the file
        while (scanner.hasNextLine()) {
            // get the next line in the file
            currentLine = scanner.nextLine();
            // unmarshall the line into a Student
            currentOrder = unmarshallOrder(currentLine);

            // We are going to use the student id as the map key for our student object.
            // Put currentStudent into the map using student id as the key
            order.put(currentOrder.getOrderNumber(), currentOrder);
        }
        // close scanner
        scanner.close();
    }
    
       private void writeCustomRoster(String date) throws FlooringMasteryPersistenceException {
        // NOTE FOR APPRENTICES: We are not handling the IOException - but
        // we are translating it to an application specific exception and 
        // then simple throwing it (i.e. 'reporting' it) to the code that
        // called us.  It is the responsibility of the calling code to 
        // handle any errors that occur.
        PrintWriter out;
        
        try {
            StringFunction orderDate = (s) -> "Orders_" + s;
            out = new PrintWriter(new FileWriter(printFormatted(date, orderDate)));
        } catch (IOException e) {
            throw new FlooringMasteryPersistenceException(
                    "Could not save order data.", e);
        }

        // Write out the Student objects to the roster file.
        // NOTE TO THE APPRENTICES: We could just grab the student map,
        // get the Collection of Students and iterate over them but we've
        // already created a method that gets a List of Students so
        // we'll reuse it.
        String orderAsText;
        List<Order> orderList = this.getAllOrders();
        for (Order currentOrder : orderList) {
            // turn a Student into a String
            orderAsText = marshallOrder(currentOrder);
            // write the Student object to the file
            out.println(orderAsText);
            // force PrintWriter to write line to the file
            out.flush();
        }
        // Clean up
        out.close();
    }

    @Override
    public Order addOrder(Integer orderNumber, Order newOrder, String date) throws FlooringMasteryPersistenceException {
        loadCustomRoster(date);
        Order addedOrder = order.put(newOrder.getOrderNumber(), newOrder);
        writeCustomRoster(date);
        return addedOrder;
        
    }
    
        @Override
    public String[] listAllOrders() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Order> getAllOrdersByDate(String orderFile) throws FlooringMasteryPersistenceException {
        List<Order> allOrdersByDate = new ArrayList(order.values());
        this.order.clear();
        return allOrdersByDate;
    }

    @Override
    public List<Order> getAllOrders() throws FlooringMasteryPersistenceException {
        String [] allOrderFiles = listAllOrders();
        
        List<Order> allOrders = new ArrayList<>();
        
        for (String orderFile : allOrderFiles) {
            List<Order> ordersForDate = getAllOrdersByDate(orderFile);
            ordersForDate.forEach(order -> { allOrders.add(order); });
        }
        return allOrders;
    }

    @Override
    public Order getOrder(Integer orderNumber) throws FlooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Order removeOrder(Integer orderNumber) throws FlooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
