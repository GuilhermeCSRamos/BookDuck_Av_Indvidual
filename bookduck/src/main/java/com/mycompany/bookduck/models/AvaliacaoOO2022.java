package com.mycompany.bookduck.models;

import java.io.Serializable;

public class AvaliacaoOO2022 implements Serializable{
    private String nome;
    private String matricula;
    private String nota;

    public AvaliacaoOO2022(String nome, String matricula, String nota) {
        this.nome = nome;
        this.matricula = matricula;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
