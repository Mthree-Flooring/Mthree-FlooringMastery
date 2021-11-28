/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.flooringmastery.service;

/**
 *
 * @author cd
 */
public class FlooringMasteryStateNotFoundException extends Exception{
    
    public FlooringMasteryStateNotFoundException(String message) {
        super(message);
    }
    
    public FlooringMasteryStateNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
