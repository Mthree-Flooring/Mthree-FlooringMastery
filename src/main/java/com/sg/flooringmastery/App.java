/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.sg.flooringmastery;

import com.mycompany.flooringmastery.service.FlooringMasteryDateValidationException;
import com.mycompany.flooringmastery.service.FlooringMasteryDuplicateIdException;
import com.mycompany.flooringmastery.service.FlooringMasteryNoOrdersException;
import com.mycompany.flooringmastery.service.FlooringMasteryServiceLayerImpl;
import com.sg.flooringmastery.controller.FlooringMasteryController;
import com.sg.flooringmastery.dao.FlooringMasteryAuditDaoFileImpl;
import com.sg.flooringmastery.dao.FlooringMasteryDaoFileImpl;
import com.sg.flooringmastery.ui.FlooringMasteryView;
import com.sg.flooringmastery.ui.UserIO;
import com.sg.flooringmastery.ui.UserIOConsoleImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.sg.flooringmastery.dao.FlooringMasteryAuditDao;
import com.sg.flooringmastery.dao.FlooringMasteryDao;
import com.mycompany.flooringmastery.service.FlooringMasteryServiceLayer;
import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;

/**
 *
 * @author raymondtam
 */
public class App {

//public static void main(String[] args) {
//    // Instantiate the UserIO implementation
//    UserIO myIo = new UserIOConsoleImpl();
//    // Instantiate the View and wire the UserIO implementation into it
//    FlooringMasteryView myView = new FlooringMasteryView(myIo);
//    // Instantiate the DAO
//    FlooringMasteryDao myDao = new FlooringMasteryDaoFileImpl();
//    // Instantiate the Audit DAO
//    FlooringMasteryAuditDao myAuditDao = new FlooringMasteryAuditDaoFileImpl();
//    
//    // Instantiate the Service Layer and wire the DAO and Audit DAO into it
//    FlooringMasteryServiceLayer myService = new FlooringMasteryServiceLayerImpl(myDao, myAuditDao);
//    // Instantiate the Controller and wire the Service Layer into it
//    FlooringMasteryController controller = new FlooringMasteryController(myService, myView);
//    // Kick off the Controller
//    controller.run();
//}
    public static void main(String[] args) throws FlooringMasteryDateValidationException, FlooringMasteryDuplicateIdException, FlooringMasteryPersistenceException, FlooringMasteryNoOrdersException {
//        UserIO myIo = new UserIOConsoleImpl();
//        FlooringMasteryView myView = new FlooringMasteryView(myIo);
//        FlooringMasteryDao myDao = new FlooringMasteryDaoFileImpl();
//        FlooringMasteryAuditDao myAuditDao = 
//           new FlooringMasteryAuditDaoFileImpl();
//        FlooringMasteryServiceLayer myService = 
//           new FlooringMasteryServiceLayerImpl(myDao, myAuditDao);
//        FlooringMasteryController controller = 
//           new FlooringMasteryController(myService, myView);
//        controller.run();

        ApplicationContext ctx
                = new ClassPathXmlApplicationContext("applicationContext.xml");
        FlooringMasteryController controller
                = ctx.getBean("controller", FlooringMasteryController.class);
        controller.run();

    }

}
