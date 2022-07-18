/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookduck.Historico;

import com.mycompany.bookduck.Obra.Obra;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @author davi2
 */
public class HistoricoPessoa implements Serializable {
    private HashMap<Obra, String[]> historico = new HashMap<>();
    //na string contem a data de emprestimo e a data de devolucao
    public HistoricoPessoa(){
        
    }   
    
    private boolean procuraObraHistorico(String nome){
        boolean aux = false;
        for(Obra obra : historico.keySet()){
            if(nome.equals(obra.getTitulo()))
                aux = true;   
        }            
        return aux;
    }
    
    
    public boolean emprestimo(Obra obra, String data){
        String datas[] = new String[2];
        datas[0] = data;
        this.historico.put(obra, datas);
        return true;
    }
    
    public boolean devolucao(Obra obra, String data){
        boolean t = false;
        if (procuraObraHistorico(obra.getTitulo())){
            String[] aux = historico.get(obra).clone();
            aux[1] = data;
            this.historico.put(obra, aux);
            t = true;
            }
        return t;
    }
    
    public void printaHistorico(){
        if(historico.isEmpty())
             System.out.println("não há historico disponivel");
        else{
            for(Obra obra : historico.keySet()){
                String[] aux = historico.get(obra);
                System.out.println("livro: " + obra.getTitulo());
                System.out.println("data de emprestimo: " + aux[0]);
                if(aux[1] != null)
                    System.out.println("obra devolvida em: " + aux[1]);
                else 
                    System.out.println("obra ainda nao devolvida");
            }
                
            }
    }
    
    public void printaEmprestados(){
        for(Obra obra : historico.keySet()){
            String[] aux = historico.get(obra);
            if(aux[1] == null)
                System.out.println("livro: " + obra.getTitulo());
        }
        
    }
}
