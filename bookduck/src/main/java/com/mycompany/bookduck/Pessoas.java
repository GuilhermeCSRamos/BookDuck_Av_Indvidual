/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookduck;



import com.mycompany.bookduck.pessoa.Cliente;
import com.mycompany.bookduck.pessoa.Funcionario;
import com.mycompany.bookduck.pessoa.Pessoa;
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author davi2
 */
public class Pessoas {
    private List<Pessoa> pessoas = new ArrayList<Pessoa>();
    private Cliente c = new Cliente();
    private Funcionario f = new Funcionario();
    
    
    public void addPessoa(Pessoa p){
        this.pessoas.add(p);
    }
    
    public Pessoa procuraCliente(String nome){
        Pessoa aux = null;
        
        for(Pessoa c : pessoas){
            if(c.getClass().equals(c.getClass())){
                if(nome.equals(c.getName())){
                    aux = c;
                }
            }
        }
        return aux;   
    }
    
    public void removerPessoa(Pessoa p){
        if(pessoas.remove(p)){
            if(p.getClass().equals(c.getClass()))
                System.out.println("Cliente removido com sucesso");
        }
    }
    
    
}
