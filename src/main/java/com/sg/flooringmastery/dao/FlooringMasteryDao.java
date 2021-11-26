/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.flooringmastery.dao;

import com.sg.flooringmastery.dto.Order;
import java.util.List;

/**
 *
 * @author raymondtam
 */
public interface FlooringMasteryDao {
    /**
     * Adds the given Student to the roster and associates it with the given 
     * student id. If there is already a student associated with the given 
     * student id it will return that student object, otherwise it will 
     * return null.
     * 
     * @param studentId id with which student is to be associated
     * @param student student to be added to the roster
     * @return the Student object previously associated with the given  
     * student id if it exists, null otherwise
     * @throws FlooringMasteryPersistenceException
     */
    Order addOrder(Integer orderNumber, Order order)
     throws FlooringMasteryPersistenceException;

    /**
     * Returns a List of all Students on the roster. 
     * 
     * @return Student List containing all students on the roster.
     * @throws FlooringMasteryPersistenceException
     */
    List<Order> getAllOrders()
     throws FlooringMasteryPersistenceException;

    /**
     * Returns the student object associated with the given student id.
     * Returns null if no such student exists
     * 
     * @param studentId ID of the student to retrieve
     * @return the Student object associated with the given student id,  
     * null if no such student exists
     * @throws FlooringMasteryPersistenceException
     */
    Order getOrder(Integer orderNumber)
     throws FlooringMasteryPersistenceException;

    /**
     * Removes from the roster the student associated with the given id. 
     * Returns the student object that is being removed or null if 
     * there is no student associated with the given id
     * 
     * @param studentId id of student to be removed
     * @return Student object that was removed or null if no student 
     * was associated with the given student id
     * @throws FlooringMasteryPersistenceException
     */
    Order removeOrder(Integer orderNumber)
     throws FlooringMasteryPersistenceException;
}
