package com.mycompany.bookduck.pessoa;

import com.mycompany.bookduck.Historico.HistoricoPessoa;
import com.mycompany.bookduck.Obra.Obra;
import com.mycompany.bookduck.models.AvaliacaoOO2022;
import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable{
    private int pontoDeFidelidade = 0;
    private HistoricoPessoa historico;
    private AvaliacaoOO2022 avaliacao;

    
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

    public Cliente(AvaliacaoOO2022 avaliacao, String cpf, String email, String name) {
        super(cpf, email, name);
        this.avaliacao = avaliacao;
    }

    public AvaliacaoOO2022 getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(AvaliacaoOO2022 avaliacao) {
        this.avaliacao = avaliacao;
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
