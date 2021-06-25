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
    private String nome;
    
    @Column
    private String descricao;
    
    @Column
    private double preco;
    
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    private Promocoes promocao;

    @OneToMany(cascade = CascadeType.ALL)
    private List<TiposAnimais> tiposAnimais;

    public Servicos() {
    }
    
    public Servicos(String nome, String descricao, double preco, Promocoes promocao, List<TiposAnimais> tiposAnimais) {
        this.preco = preco;
        this.nome = nome;
        this.descricao = descricao;
        this.promocao = promocao;
        this.tiposAnimais = tiposAnimais;
    }

    public Servicos(int id, double preco, String nome, String descricao, Promocoes promocao, List<TiposAnimais> tiposAnimais) {
        this.id = id;
        this.preco = preco;
        this.nome = nome;
        this.descricao = descricao;
        this.promocao = promocao;
        this.tiposAnimais = tiposAnimais;
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

    public List<TiposAnimais> getTiposAnimais() {
        return tiposAnimais;
    }

    public void setTiposAnimais(List<TiposAnimais> tiposAnimais) {
        this.tiposAnimais = tiposAnimais;
    }
}
