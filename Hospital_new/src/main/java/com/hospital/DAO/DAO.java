/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.DAO;

import DB.entity.Entity1;
import java.util.List;

/**
 *
 * @author Жека
 */
public interface DAO<T extends Entity1> {
    T getById(int id);
    int save(T o);
    void update(T o);
    void remove(T o);
    List<T> getList();
    void changeStatus(int id);
}