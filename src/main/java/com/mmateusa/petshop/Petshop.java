/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmateusa.petshop;

import com.mmateusa.petshop.dao.*;
import com.mmateusa.petshop.utils.*;
import com.mmateusa.petshop.screens.*;
import javax.persistence.*;
import com.formdev.flatlaf.FlatIntelliJLaf;
/**
 *
 * @author Mateus
 */
public class Petshop {
    
    private static final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("petshop");
    public static final EntityManager entityManager = entityManagerFactory.createEntityManager();
    
    public static void main(String[] args) {
        FlatIntelliJLaf.setup();
        Login l = new Login();
        l.setVisible(true);
    }   
}
