/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import java.util.List;

/**
 *
 * @author raymondtam
 */
public interface FlooringMasteryServiceLayer {
 
    void createStudent(Order student) throws
            FlooringMasteryDuplicateIdException,
            FlooringMasteryDataValidationException,
            FlooringMasteryPersistenceException;
 
    List<Order> getAllStudents() throws
            FlooringMasteryPersistenceException;
 
    Order getStudent(String studentId) throws
            FlooringMasteryPersistenceException;
 
    Order removeStudent(String studentId) throws
            FlooringMasteryPersistenceException;
 
}
