package com.sg.flooringmastery.controller;

import com.mycompany.flooringmastery.service.FlooringMasteryDataValidationException;
import com.mycompany.flooringmastery.service.FlooringMasteryDuplicateIdException;
import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dao.FlooringMasteryDaoFileImpl;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.ui.FlooringMasteryView;
import com.sg.flooringmastery.ui.UserIO;
import com.sg.flooringmastery.ui.UserIOConsoleImpl;
import java.util.List;
import com.sg.flooringmastery.dao.FlooringMasteryDao;
import com.mycompany.flooringmastery.service.FlooringMasteryServiceLayer;


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
//
//private void createStudent() throws FlooringMasteryPersistenceException {
//    view.displayCreateStudentBanner();
//    boolean hasErrors = false;
//    do {
//        Order currentStudent = view.getNewStudentInfo();
//        try {
//            service.createStudent(currentStudent);
//            view.displayCreateSuccessBanner();
//            hasErrors = false;
//        } catch (FlooringMasteryDuplicateIdException | FlooringMasteryDataValidationException e) {
//            hasErrors = true;
//            view.displayErrorMessage(e.getMessage());
//        }
//    } while (hasErrors);
//}
//
//private void listStudents() throws FlooringMasteryPersistenceException {
//    List<Order> studentList = service.getAllStudents();
//     
//    view.displayStudentList(studentList);
//}
//
//private void viewStudent() throws FlooringMasteryPersistenceException {
//     String studentId = view.getStudentIdChoice();
//     Order student = service.getStudent(studentId) ;
//     view.displayStudent(student);
//}
//
//
//private void removeStudent() throws FlooringMasteryPersistenceException {
//    view.displayRemoveStudentBanner();
//    String studentId = view.getStudentIdChoice();
//    service.removeStudent(studentId);
//    view.displayRemoveSuccessBanner();
//}
//
//private void unknownCommand() {
//    view.displayUnknownCommandBanner();
//}

//private void exitMessage() {
//    view.displayExitBanner();
//}
  public void run() {
    boolean keepGoing = true;
    int menuSelection = 0;
//    try {
        while (keepGoing) {

            menuSelection = getMenuSelection();

            switch (menuSelection) {
                case 1:
                    System.out.println("1");
                    break;
                case 2:
                    System.out.println("2");
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

 

}

