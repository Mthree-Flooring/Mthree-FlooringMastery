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
public class FlooringMasteryAreaBelowMinException extends Exception {
    
    public FlooringMasteryAreaBelowMinException(String message) {
        super(message);
    }
    
    public FlooringMasteryAreaBelowMinException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
