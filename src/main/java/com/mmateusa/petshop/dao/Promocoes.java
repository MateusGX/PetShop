/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmateusa.petshop.dao;

import java.sql.Timestamp;
import javax.persistence.*;
/**
 *
 * @author Mateus
 */

@Entity
@Table(name = "promocoes")
public class Promocoes {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private Timestamp encerramento;
    
    @Column
    private double desconto;

    public Promocoes() {
    }

    public Promocoes(Timestamp encerramento, double desconto) {
        this.encerramento = encerramento;
        this.desconto = desconto;
    }

    public Promocoes(int id, Timestamp encerramento, double desconto) {
        this.id = id;
        this.encerramento = encerramento;
        this.desconto = desconto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getEncerramento() {
        return encerramento;
    }

    public void setEncerramento(Timestamp encerramento) {
        this.encerramento = encerramento;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }
}
