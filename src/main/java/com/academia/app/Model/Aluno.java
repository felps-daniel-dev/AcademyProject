package com.academia.app.Model;

import java.time.LocalDate;

public class Aluno {

    private int idUsuario; // id do aluno
    private String nome;
    private String cpf;
    private String telefone;
    private LocalDate nascimento;
    private LocalDate dia_cadastro;


    // construtores //////////////////////////////


    // construtor vazio pra ser preenchido pelos dados na hora da busca
    public Aluno(){

    }

    //construtor principal do aluno
    public Aluno(String nome, String cpf, String telefone, LocalDate nascimento, LocalDate dia_cadastro) {
        this.dia_cadastro = dia_cadastro;
        this.nascimento = nascimento;
        this.telefone = telefone;
        this.cpf = cpf;
        this.nome = nome;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    // get and setters ///////////////////////////////////////////
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;

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

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public LocalDate getDia_cadastro() {
        return dia_cadastro;
    }

    public void setDia_cadastro(LocalDate dia_cadastro) {
        this.dia_cadastro = dia_cadastro;
    }
}
