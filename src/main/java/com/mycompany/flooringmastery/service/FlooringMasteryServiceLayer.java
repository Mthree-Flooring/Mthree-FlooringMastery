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
 
    void createOrder(Order order) throws
            FlooringMasteryDuplicateIdException,
            FlooringMasteryPersistenceException;
 
    List<Order> getAllOrders() throws
            FlooringMasteryPersistenceException;
 
    Order getOrder(Integer orderNumber) throws
            FlooringMasteryPersistenceException;
 
    Order removeOrder(Integer orderNumber) throws
            FlooringMasteryPersistenceException;
 
}
