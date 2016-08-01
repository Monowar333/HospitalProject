/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servise;

/**
 *
 * @author stan
 */
public class ODEException extends RuntimeException {

    public ODEException() {
        super("object doesn't exist");
    }
    public ODEException(String message) {
        super(message);
    }
    
    
}
