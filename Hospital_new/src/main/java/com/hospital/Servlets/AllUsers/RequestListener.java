/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servlets.AllUsers;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;

/**
 * Web application lifecycle list ener.
 *
 * @author stan
 */
public class RequestListener implements ServletRequestListener {

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("req destroy - " + System.currentTimeMillis());
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        sre.getServletRequest().getRemoteAddr();
        System.out.println("req init - " + System.currentTimeMillis());
    }
}
