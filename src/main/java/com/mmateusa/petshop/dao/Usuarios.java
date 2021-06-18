/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mmateusa.petshop.dao;

import com.mmateusa.petshop.utils.Cargo;
import javax.persistence.*;
/**
 *
 * @author Mateus
 */

@Entity
@Table(name = "usuarios")
public class Usuarios {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column
    private String nome;
    
    @Column
    private String email;
    
    @Column
    private String cpf;
    
    @Column
    private String telefone;
    
    @Column
    private String login;
    
    @Column
    private String senha;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    public Usuarios() {
    }

    public Usuarios(String nome, String email, String cpf, String telefone, String login, String senha, Cargo cargo) {
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
    }

    public Usuarios(int id, String nome, String email, String cpf, String telefone, String login, String senha, Cargo cargo) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.login = login;
        this.senha = senha;
        this.cargo = cargo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
}
