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
public class FlooringMasteryProductTypeNotFoundException extends Exception{
    
    public FlooringMasteryProductTypeNotFoundException(String message) {
        super(message);
    }
    
    public FlooringMasteryProductTypeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
