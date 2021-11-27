/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import com.sg.flooringmastery.ui.FlooringMasteryView;
import java.util.List;
import com.sg.flooringmastery.dao.FlooringMasteryAuditDao;
import com.sg.flooringmastery.dao.FlooringMasteryDao;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author raymondtam
 */
public class FlooringMasteryServiceLayerImpl implements FlooringMasteryServiceLayer {

    FlooringMasteryDao dao;
    private FlooringMasteryAuditDao auditDao;


  public FlooringMasteryServiceLayerImpl(FlooringMasteryDao dao, FlooringMasteryAuditDao auditDao) {
    this.dao = dao;
    this.auditDao = auditDao;
}

//    public FlooringMasteryServiceLayerImpl(FlooringMasteryDao myDao) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//    @Override
//    public void createStudent(Order student) throws 
//        FlooringMasteryDuplicateIdException,
//        FlooringMasteryDataValidationException, 
//        FlooringMasteryPersistenceException {
//
//    // First check to see if there is alreay a student 
//    // associated with the given student's id
//    // If so, we're all done here - 
//    // throw a FlooringMasteryDuplicateIdException
//    if (dao.getStudent(student.getStudentId()) != null) {
//        throw new FlooringMasteryDuplicateIdException(
//                "ERROR: Could not create student.  Student Id "
//                + student.getStudentId()
//                + " already exists");
//    }
//
//    // Now validate all the fields on the given Student object.  
//    // This method will throw an
//    // exception if any of the validation rules are violated.
//    validateStudentData(student);
//
//    // We passed all our business rules checks so go ahead 
//    // and persist the Student object
//    dao.addStudent(student.getStudentId(), student);
//
//    // The student was successfully created, now write to the audit log
//    auditDao.writeAuditEntry(
//            "Student " + student.getStudentId() + " CREATED.");
//
//}
//
//    @Override
//    public List<Order> getAllStudents() throws FlooringMasteryPersistenceException {
//        return dao.getAllStudents();
//    }
//
//    @Override
//    public Order getStudent(String studentId) throws FlooringMasteryPersistenceException {
//        return dao.getStudent(studentId);
//    }
//
//    @Override
//   public Order removeStudent(String studentId) throws FlooringMasteryPersistenceException {
//    Order removedStudent = dao.removeStudent(studentId);
//    // Write to audit log
//    auditDao.writeAuditEntry("Student " + studentId + " REMOVED.");
//    return removedStudent;
//}
//
//    private void validateStudentData(Order student) throws
//            FlooringMasteryDataValidationException {
//
//        if (student.getFirstName() == null
//                || student.getFirstName().trim().length() == 0
//                || student.getLastName() == null
//                || student.getLastName().trim().length() == 0
//                || student.getCohort() == null
//                || student.getCohort().trim().length() == 0) {
//
//            throw new FlooringMasteryDataValidationException(
//                    "ERROR: All fields [First Name, Last Name, Cohort] are required.");
//        }
//    }
  
   @Override
    public void validateDate(String date) throws FlooringMasteryDateValidationException{
        LocalDate now = LocalDate.now();
        LocalDate input = LocalDate.parse(date);
        boolean isAfter = input.isAfter(now);
        
        
        if(isAfter==false){
            throw new FlooringMasteryDateValidationException("Please create an order with a date after today");
        }
    }
    
    
    
    
    

    @Override
    public void createOrder(Order order, String date) throws FlooringMasteryDuplicateIdException,FlooringMasteryDateValidationException, FlooringMasteryPersistenceException {
   
  
      
         
         dao.addOrder(order.getOrderNumber(), order,date);
         
         
      
    }

    @Override
    public List<Order> getAllOrders(String orderWithDate) throws FlooringMasteryPersistenceException {
        return dao.getAllOrdersByDate(orderWithDate);
    }
    
    @Override
    public List<Order> getOrderList(LocalDate enteredOrderDate) throws FlooringMasteryPersistenceException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
