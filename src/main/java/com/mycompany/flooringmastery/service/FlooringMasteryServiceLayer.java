/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.flooringmastery.service;

import com.sg.flooringmastery.dao.FlooringMasteryPersistenceException;
import com.sg.flooringmastery.dto.Order;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author raymondtam
 */
public interface FlooringMasteryServiceLayer  {
    void validateDate(String date) throws FlooringMasteryDateValidationException;
 
    void createOrder(Order order, String date) throws
            FlooringMasteryDuplicateIdException,
            FlooringMasteryPersistenceException,
            FlooringMasteryDateValidationException;
 
    List<Order> getAllOrders(String orderWithDate) throws FlooringMasteryPersistenceException;
    List<Order> getOrderList(LocalDate enteredOrderDate) throws FlooringMasteryPersistenceException;
 
    Order getOrder(Integer orderNumber) throws
            FlooringMasteryPersistenceException;
 
    Order removeOrder(Integer orderNumber) throws
            FlooringMasteryPersistenceException;
 
}
