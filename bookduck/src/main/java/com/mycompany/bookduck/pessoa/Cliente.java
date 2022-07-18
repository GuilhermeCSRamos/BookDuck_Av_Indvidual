/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookduck.pessoa;

import com.mycompany.bookduck.Historico.HistoricoPessoa;
import com.mycompany.bookduck.Obra.Obra;
import java.io.Serializable;

/**
 *
 * @author davi2
 */
public class Cliente extends Pessoa implements Serializable{
    private int pontoDeFidelidade = 0;
    private HistoricoPessoa historico;
    
    
    public Cliente(){
        historico = new HistoricoPessoa();
    }
    
    public Cliente(String nome, String cpf, String email, int pontos){
        super(cpf, email, nome);
        this.pontoDeFidelidade = pontos;
        historico = new HistoricoPessoa();
    }
    
    public Cliente(int pontoDeFidelidade){
        this.pontoDeFidelidade = pontoDeFidelidade;
    }
    

    public int getPontoDeFidelidade() {
        return pontoDeFidelidade;
    }

    public void setPontoDeFidelidade(int pontoDeFidelidade) {
        this.pontoDeFidelidade = pontoDeFidelidade;
    }
    
    public void emprestimo(Obra obra, String data){
        if(this.historico.emprestimo(obra, data))
            System.out.println("Emprestimo bem sucedido.");
    }
    
    public void printaHistorico(){
        System.out.println("Historico de " + this.getName() + ":");
        this.historico.printaHistorico();
    }
    public void printaEmprestados(){
        System.out.println("livros emprestados por " + this.getName() + ":");
        this.historico.printaEmprestados();
    }
            
    public void devolucao(Obra obra, String data){
        if(this.historico.devolucao(obra, data))
            System.out.println("devolução bem sucedida.");
    }
    
    public void atualizaFidelidade(int valor){
        this.pontoDeFidelidade += valor;
    }
}
