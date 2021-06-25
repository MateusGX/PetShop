/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmateusa.petshop.dao;

import javax.persistence.*;
import com.mmateusa.petshop.dao.*;
import com.mmateusa.petshop.utils.FormaPagamento;
import com.mmateusa.petshop.utils.VendaStatus;
import java.sql.Timestamp;
/**
 *
 * @author Mateus
 */
@Entity
@Table(name = "vendas")
public class Vendas {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    @Enumerated(EnumType.STRING)
    private VendaStatus status;
    
    @Column
    private Timestamp dataVenda = new Timestamp(System.currentTimeMillis());
    
    @Column(nullable = true)
    @Enumerated(EnumType.STRING)
    private FormaPagamento formaPagamento;

    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    private Usuarios funcionario;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Usuarios cliente;

    @ManyToOne(cascade = CascadeType.ALL)
    private Servicos servico;
    
    @ManyToOne(cascade = CascadeType.ALL, optional = true)
    private Promocoes promocao;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Animais animal;

    @Column
    private double total;
    
    public Vendas() {
    }

    public Vendas(VendaStatus status, FormaPagamento formaPagamento, Usuarios funcionario, Usuarios cliente, Servicos servico, Promocoes promocao, Animais animal, double total) {
        this.status = status;
        this.formaPagamento = formaPagamento;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.servico = servico;
        this.promocao = promocao;
        this.animal = animal;
        this.total = total;
    }

    public Vendas(int id, Timestamp dataVenda, FormaPagamento formaPagamento, Usuarios funcionario, Usuarios cliente, Servicos servico, Promocoes promocao, Animais animal, double total) {
        this.id = id;
        this.dataVenda = dataVenda;
        this.formaPagamento = formaPagamento;
        this.funcionario = funcionario;
        this.cliente = cliente;
        this.servico = servico;
        this.promocao = promocao;
        this.animal = animal;
        this.total = total;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDataVenda() {
        return dataVenda;
    }

    public void setData(Timestamp dataVenda) {
        this.dataVenda = dataVenda;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Usuarios getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Usuarios funcionario) {
        this.funcionario = funcionario;
    }

    public Usuarios getCliente() {
        return cliente;
    }

    public void setCliente(Usuarios cliente) {
        this.cliente = cliente;
    }

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }

    public Promocoes getPromocao() {
        return promocao;
    }

    public void setPromocao(Promocoes promocao) {
        this.promocao = promocao;
    }

    public Animais getAnimal() {
        return animal;
    }

    public void setAnimal(Animais animal) {
        this.animal = animal;
    }

    public VendaStatus getStatus() {
        return status;
    }

    public void setStatus(VendaStatus status) {
        this.status = status;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
}
