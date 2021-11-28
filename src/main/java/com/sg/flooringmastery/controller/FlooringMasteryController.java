package com.sg.flooringmastery.controller;

//import com.mycompany.flooringmastery.service.FlooringMasteryDataValidationException;
//import com.mycompany.flooringmastery.service.FlooringMasteryDuplicateIdException;
import com.mycompany.flooringmastery.service.FlooringMasteryDateValidationException;
import com.mycompany.flooringmastery.service.FlooringMasteryDuplicateIdException;
import com.mycompany.flooringmastery.service.FlooringMasteryNoOrdersException;
import com.mycompany.flooringmastery.service.FlooringMasteryOrderFileNotExistException;
import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dao.FlooringMasteryDaoFileImpl;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.ui.FlooringMasteryView;
import com.sg.flooringmastery.ui.UserIO;
import com.sg.flooringmastery.ui.UserIOConsoleImpl;
import java.util.List;
import com.sg.flooringmastery.dao.FlooringMasteryDao;
import com.mycompany.flooringmastery.service.FlooringMasteryServiceLayer;
import java.time.DateTimeException;
import java.time.LocalDate;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**1
 *
 * @author raymondtam
 */
public class FlooringMasteryController {

    private FlooringMasteryServiceLayer service;
    public FlooringMasteryController(FlooringMasteryServiceLayer service, FlooringMasteryView view) {
    this.service = service;
    this.view = view;
}

    private FlooringMasteryDao dao;
    private FlooringMasteryView view;
    public FlooringMasteryController(FlooringMasteryDao dao, FlooringMasteryView view) {
    this.dao = dao;
    this.view = view;
}
    
    private UserIO io = new UserIOConsoleImpl();
    
    private int getMenuSelection() {
    return view.printMenuAndGetSelection();
}
    
public void addOrder() throws FlooringMasteryDateValidationException, FlooringMasteryDuplicateIdException, FlooringMasteryPersistenceException{
   String newDate = view.displayDate();
   service.validateDate(newDate);
   Order newOrder = view.displayAddingSelection();
   service.createOrder(newOrder, newDate);
   
   
   
   
   
}


//private void exitMessage() {
//    view.displayExitBanner();
//}
  public void run() throws FlooringMasteryDateValidationException, FlooringMasteryDuplicateIdException, FlooringMasteryPersistenceException {
    boolean keepGoing = true;
    int menuSelection = 0;
//    try {
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    displayOrders();
                    break;
                case 2:
                   addOrder();
                    break;
                case 3:
                     System.out.println("3");
                    break;
                case 4:
                      System.out.println("4");
                    break;
                case 5: 
                    System.out.println("5");
                    break;
                case 6:
                    keepGoing = false;
                    break;
                default:
                      System.out.println("default");
            }

        }
//        exitMessage();
//    } 
//    catch (FlooringMasteryPersistenceException e) {
//        view.displayErrorMessage(e.getMessage());
//    }
}
  
 private void displayOrders() throws FlooringMasteryNoOrdersException, FlooringMasteryPersistenceException {
      view.displayListOrdersBanner();
      boolean errorsFound = false;
      List<Order> allOrders = null;
      
      do {
          try {
              LocalDate enteredOrderDate = view.getOrderListByDate();
              allOrders = service.getAllOrders(enteredOrderDate.toString());
              view.displayOrderListBanner(enteredOrderDate);
              errorsFound = false;
          } catch (DateTimeException | FlooringMasteryNoOrdersException | FlooringMasteryPersistenceException e) {
              errorsFound = true;
              view.displayErrorMessage(e.getMessage());
          }
      } while (errorsFound);
      view.displayOrderList(allOrders);
  }
    private void removeOrder() throws FlooringMasteryNoOrdersException, FlooringMasteryPersistenceException, FlooringMasteryNoOrderNumException, FlooringMasteryOrderFileNotExistException{
            view.displayRemoveOrderBanner();
            boolean errorsFound = false;
            do {
                //Prompt user for the date & order number
                LocalDate orderDateInput = view.getOrderDateRemoveOrder();
                int orderNumberInput = view.getOrderNumberRemoveOrder();
                try {
                    //Check that the order exists
                    //First, check for the file using the orderDateInput
                    String orderFileName = service.createOrderFileNameFromDate(orderDateInput);
                    service.checkOrderFileExists(orderFileName);

                    //If the file exists, check if the order with the specified order number exists in the file
                    int orderNumberToRemove = service.checkOrderNumExists(orderFileName, orderNumberInput);
                    //If it doesn't exist, an exception is thrown. If it is, then remove the order.
                    Order orderToRemove = service.getOrder(orderFileName, orderNumberToRemove);

                    //Display the order information
                    view.displayOrderInformation(orderDateInput, orderToRemove);

                    //Prompt the user if they are sure they want to remove the order
                    String removeConfirmation = view.getRemoveConfirmation();

                    //If they are sure, remove the order, if not return to menu. removedOrder will be null if no order to be removed.
                    Order removedOrder = service.removeOrderIfConfirmed(removeConfirmation, orderFileName, orderNumberInput);

                    view.displayRemoveSuccessBanner(removedOrder);
                    errorsFound = false;
                } catch (DateTimeException | FlooringMasteryNoOrdersException | FlooringMasteryPersistenceException e)  {
                    errorsFound = true;
                    view.displayErrorMessage(e.getMessage());
                }
            } while (errorsFound);
        }
 

}

