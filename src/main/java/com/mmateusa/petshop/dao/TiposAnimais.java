/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmateusa.petshop.dao;

import javax.persistence.*;
/**
 *
 * @author Mateus
 */

@Entity
@Table(name = "tipos_animais")
public class TiposAnimais {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String tipo;

    public TiposAnimais() {
    }

    public TiposAnimais(String tipo) {
        this.tipo = tipo;
    }

    public TiposAnimais(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
