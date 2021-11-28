package com.sg.flooringmastery.controller;

//import com.mycompany.flooringmastery.service.FlooringMasteryDataValidationException;
//import com.mycompany.flooringmastery.service.FlooringMasteryDuplicateIdException;
import com.mycompany.flooringmastery.service.FlooringMasteryDateValidationException;
import com.mycompany.flooringmastery.service.FlooringMasteryDuplicateIdException;
import com.mycompany.flooringmastery.service.FlooringMasteryNoOrdersException;
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
  public void run() throws FlooringMasteryDateValidationException, FlooringMasteryDuplicateIdException, FlooringMasteryPersistenceException, FlooringMasteryNoOrdersException, FlooringMasteryNoOrdersException {
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
          } catch (DateTimeException | FlooringMasteryPersistenceException e) {
              errorsFound = true;
              view.displayErrorMessage(e.getMessage());
          }
      } while (errorsFound);
      view.displayOrderList(allOrders);
  }

 

}

