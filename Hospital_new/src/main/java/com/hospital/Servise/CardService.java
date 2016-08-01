/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospital.Servise;

import DB.entity.Card;
import java.util.List;

/**
 *
 * @author Жека
 */
public interface CardService {
    public Card getById(int id);
    public int save(Card o);
    public void update(Card o);
    public void remove(Card o);
    public List<Card> getList();
    public void changeStatus(int id);
}
