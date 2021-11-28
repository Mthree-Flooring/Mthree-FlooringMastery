package com.sg.flooringmastery.ui;

import com.sg.flooringmastery.dto.Order;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author raymondtam
 */
public class FlooringMasteryView {

    private UserIO io;
    
    public FlooringMasteryView(UserIO io) {
    this.io = io;
}
    
    
    public  int printMenuAndGetSelection() {
        io.print("  * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        io.print("   * <<Flooring Program>>");
        io.print("   * 1. Display Orders");
        io.print("   * 2. Add an Order");
        io.print("   * 3. Edit an Order");
        io.print("   * 4. Remove an Order");
        io.print("   * 5. Export All Data");
        io.print("   * 6. Quit");
        io.print("   *");
        io.print("   * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
        return io.readInt("Please select from the choices above", 1, 6);

    }
    
    public LocalDate getOrderListByDate() {
            io.print("Please enter a Date to display a list of Orders: ");
            return io.readDate("Follow YYYY-MM-DD format when entering Date.");
    }
    
    public void displayOrderListBanner(LocalDate orderDate) {
        io.print("=*=*=*= All Orders for " + orderDate + " =*=*=*=" );
    }
    
    public void displayListOrdersBanner() {
        io.print("=*=*=*= List Orders =*=*=*=");
    }
    
        public String displayOrderList(List<Order> orderList) {
        String format =  "%16s  %16s  %16s  %16s  %16s  %16s  %16s  %16s  %16s  %16s  %16s";
        String headings = String.format(format, 
                "Customer name",
                "State",
                "Tax rate",
                "Product",
                "Area",
                "Cost per square foot ($)",
                "Labor cost per square foot($)",
                "Material cost($)",
                "Labor cost($)",
                "Tax ($)",
                "Total ($)");
        io.print(headings);
        
        io.print("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (Order currentOrder : orderList) {
                     
            String orderInfo = String.format(
                    "%16s  %16s  %16s  %16s  %16s  %16s  %16s  %16s  %16s  %16s  %16s",
                    currentOrder.getCustomerName(),
                    currentOrder.getState(),
                    currentOrder.getProductType(),
                    currentOrder.getTaxRate().toString(),
                    currentOrder.getArea().toString(),
                    currentOrder.getCostPerSquareFoot().toString(),
                    currentOrder.getLaborCostPerSquareFoot().toString(),
                    currentOrder.getMaterialCost().toString(),
                    currentOrder.getLaborCost().toString(),
                    currentOrder.getTax().toString(),
                    currentOrder.getTotal().toString());
            io.print(orderInfo);
        }
        io.print("---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        return io.readString("Please hit enter to continue");
        }   
        
        
        
        
    
    public void displayErrorMessage(String errorMsg) {
        io.print("=== ERROR ===");
        io.print(errorMsg);
    }   
    
    public Order displayAddingSelection(){
        io.print("==Adding Order==");
        
        int orderNumber = io.readInt("Please enter the order number: ");
        String customerName = io.readString("Please enter the customer number: ");
        String state = io.readString("Please enter the state: ");
        String productType = io.readString("Please enter the product type: ");
        BigDecimal area = io.readBigDecimal("Please enter the area");
        
        Order currentOrder = new Order(orderNumber);
        currentOrder.setCustomerName(customerName);
        currentOrder.setState(state);
        currentOrder.setProductType(productType);
        currentOrder.setArea(area);
        return currentOrder;
        
                
               
    }
    public String displayDate(){
        String date = io.readString("Please enter the order date (must be a later date than today): ");
        return date;
    }
       //--------------------------- VIEW FOR REMOVE ORDER ----------------------------------------        
    public void displayRemoveOrderBanner() {
        io.print("=== Remove Order ===");
    }
    
    public LocalDate getOrderDateRemoveOrder() {
        io.print("What is the date of the order you want to remove?");
        return io.readDate("Please enter a date in the format YYYY-MM-DD");
    }
    
    public int getOrderNumberRemoveOrder(){
        return io.readInt("What is the order number of the order you want to remove? ");
    }
   
    public void displayOrderInformation(LocalDate orderDateInput, Order orderToRemove) {
        io.print("=== Order Summary ===");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        io.print("Order date:         " + orderDateInput.format(formatter));
        io.print("Customer Name:      " + orderToRemove.getCustomerName());
        io.print("State: " +               orderToRemove.getState());
        io.print("Product:            " + orderToRemove.getProductType());
        io.print("Area required:      " +orderToRemove.getArea().toString() + " sqft");
        io.print("Material cost:      $"+ orderToRemove.getMaterialCost().toString());
        io.print("Labor cost:         $"+ orderToRemove.getLaborCost());
        io.print("Tax:                $" + orderToRemove.getTax().toString());
        io.print("---------------------------------");
        io.print("Total:              $" + orderToRemove.getTotal().toString());
    }
    
    public String getRemoveConfirmation() {
        return io.readString("Are you sure you want to remove the order? (Y/N)");
    }    
    
    public void displayRemoveSuccessBanner(Order removedOrder){
        if (removedOrder==null) {
            //do nothing, return to main menu
            io.readString("Please hit enter to continue to main menu.");
        } else {
            //If new order is not null
            io.print("=== Order Succesfully Removed ===");
        }
    }

}