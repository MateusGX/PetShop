/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmateusa.petshop.dao;

import javax.persistence.*;
import com.mmateusa.petshop.dao.Promocoes;
import com.mmateusa.petshop.dao.TiposAnimais;
import java.util.List;
/**
 *
 * @author Mateus
 */
@Entity
@Table(name = "servicos")
public class Servicos {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private double preco;
    
    @Column
    private String nome;
    
    @Column
    private String descricao;
    
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    private Promocoes promocao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TiposAnimais> tipos_animais;

    public Servicos() {
    }
    
    public Servicos(double preco, String nome, String descricao, Promocoes promocao, List<TiposAnimais> tipos_animais) {
        this.preco = preco;
        this.nome = nome;
        this.descricao = descricao;
        this.promocao = promocao;
        this.tipos_animais = tipos_animais;
    }

    public Servicos(int id, double preco, String nome, String descricao, Promocoes promocao, List<TiposAnimais> tipos_animais) {
        this.id = id;
        this.preco = preco;
        this.nome = nome;
        this.descricao = descricao;
        this.promocao = promocao;
        this.tipos_animais = tipos_animais;
    }

    public Promocoes getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocoes promocao) {
        this.promocao = promocao;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<TiposAnimais> getTipos_animais() {
        return tipos_animais;
    }

    public void setTipos_animais(List<TiposAnimais> tipos_animais) {
        this.tipos_animais = tipos_animais;
    }
}
