/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookduck.pessoa;

/**
 *
 * @author davi2
 */
public class Funcionario extends Pessoa {
    private Cargo cargo;
    private int tempoDeServico;
    private double salario;
    private String dataContratacao;
    
    public enum Cargo {
        AuxiliarDeBiblioteca, Bibliotecario, 
        AssistenteAdministrativo, Atendente, Recepcionista;  
    }
    
    public Funcionario(){
        
    }

    public Funcionario(Cargo vinculo, String dataContratacao){
        this.cargo = vinculo;
        this.dataContratacao = dataContratacao;
    }
    
    public Funcionario(String nome, String cpf, String email, String vinculo, String dataContratacao){
        super(cpf, email, nome);
        this.cargo = Cargo.valueOf(vinculo);
        this.dataContratacao = dataContratacao;
    }
    
    public Funcionario(Cargo vinculo, String dataContratacao, double salario){
        this.cargo = vinculo;
        this.dataContratacao = dataContratacao;
        this.salario = salario;
    }   

    public Cargo getCargo() {
        return cargo;
    }
    
    
    public int getTempoDeServico() {
        return tempoDeServico;
    }

    public double getSalario() {
        return salario;
    }

    public String getDataContratacao() {
        return dataContratacao;
    }

    public void setCargo(int numCargo) {
        switch(numCargo){
            case 1:
                this.cargo = Cargo.AuxiliarDeBiblioteca;
                break;
            case 2:
                this.cargo = Cargo.Bibliotecario;
                break;
            case 3:
                this.cargo = Cargo.AssistenteAdministrativo;
                break;
            case 4:
                this.cargo = Cargo.Atendente;
                break;
            case 5:
                this.cargo = Cargo.Recepcionista;
                break;
              
        }
        
    }
    
    public void printaCargos(){
        int i = 1;
        for(Cargo c : Cargo.values()){
            System.out.println(c + " " + i++);
        }
    }


    public void setTempoDeServico(int tempoDeServico) {
        this.tempoDeServico = tempoDeServico;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void setDataContratacao(String dataContratacao) {
        this.dataContratacao = dataContratacao;
    }
    
    public void aumentoSalario(int porcentagem){
        this.salario = salario + this.salario*porcentagem;
    }
    
    public void ferias(int diasFerias){
        
    }
    
    public void descricaoCargo(){
        System.out.println("Descrição do cargo atual:   ");
        switch(this.cargo){
            case  AuxiliarDeBiblioteca-> {
                System.out.println("Auxilia nos serviços de aquisição, classificação, organização");
            }
            case Bibliotecario -> {
                System.out.println("Organizar, manter e disponibilizar os acervos bibliograficos");
            }
            case AssistenteAdministrativo -> {
                System.out.println("Preparar relatórios, formulários e planilhas");
            }
            case Atendente -> {
                System.out.println("esponsável pelo atendimento - pessoal ou telefônico "
                        + "- garantindo o suporte necessário ao cliente");
            }
            case Recepcionista -> {
                System.out.println("Recepcionar membros da comunidade e visitantes");
            }
        }
    }
   
    
}
