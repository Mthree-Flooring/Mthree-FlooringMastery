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
public class FlooringMasteryDateErrorException extends Exception {
    
    public FlooringMasteryDateErrorException(String message) {
        super(message);
    }
    
    public FlooringMasteryDateErrorException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
