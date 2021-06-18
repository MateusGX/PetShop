/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmateusa.petshop.dao;

import javax.persistence.*;
import com.mmateusa.petshop.dao.TiposAnimais;
import com.mmateusa.petshop.dao.Usuarios;
/**
 *
 * @author Mateus
 */

@Entity
@Table(name = "animais")
public class Animais {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String nome;

    @Column
    private double tamanho;
    
    @Column
    private double peso;
    
    @Column
    private int idade;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private TiposAnimais tipo;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuarios cliente;

    public Animais() {
    }

    public Animais(String nome, double tamanho, double peso, int idade, TiposAnimais tipo, Usuarios cliente) {
        this.nome = nome;
        this.tamanho = tamanho;
        this.peso = peso;
        this.idade = idade;
        this.tipo = tipo;
        this.cliente = cliente;
    }

    public Animais(int id, String nome, double tamanho, double peso, int idade, TiposAnimais tipo, Usuarios cliente) {
        this.id = id;
        this.nome = nome;
        this.tamanho = tamanho;
        this.peso = peso;
        this.idade = idade;
        this.tipo = tipo;
        this.cliente = cliente;
    }

    public TiposAnimais getTipo() {
        return tipo;
    }

    public void setTipo(TiposAnimais tipo) {
        this.tipo = tipo;
    }

    public Usuarios getCliente() {
        return cliente;
    }

    public void setCliente(Usuarios cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getTamanho() {
        return tamanho;
    }

    public void setTamanho(double tamanho) {
        this.tamanho = tamanho;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
}
