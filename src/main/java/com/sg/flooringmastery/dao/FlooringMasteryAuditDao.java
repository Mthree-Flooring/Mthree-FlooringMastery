/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.sg.flooringmastery.dao;

/**
 *
 * @author raymondtam
 */
public interface FlooringMasteryAuditDao {
   
    public void writeAuditEntry(String entry) throws FlooringMasteryPersistenceException;
   
}
