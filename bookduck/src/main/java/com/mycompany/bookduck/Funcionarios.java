/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookduck;

import java.util.List;
import java.util.ArrayList;
import com.mycompany.bookduck.pessoa.Funcionario;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author davi2
 */
public class Funcionarios {
    private  List<Funcionario> funcionarios = new ArrayList<Funcionario>();
    
    
    public Funcionarios(){
        
    }
    
    public void addFuncionarios(Funcionario funcionario){
        this.funcionarios.add(funcionario);
    }
    
    public void removerFuncionario(Funcionario funcionario){
        if(funcionarios.remove(funcionario)){
            System.out.println("funcionario removido");
        }
    }
    
    public Funcionario procuraFuncionario(String nome){
        Funcionario aux = null;
        for(Funcionario f : funcionarios){
            if(nome.equals(f.getName())){
                aux = f;
            }
        }
        return aux;
    }
    
    public void printaFuncionarios(){
        for(Funcionario f : funcionarios)
            System.out.println(f.getName() + " " + f.getCargo());
 
    }
 
    
    public void alterarArquivo() throws FileNotFoundException, IOException{
        FileWriter file = new FileWriter("funcionarios.txt");
        BufferedWriter objeto = new BufferedWriter(file);
        for(Funcionario f : this.funcionarios){
            objeto.write(f.getName());
            objeto.append(",");
            objeto.write(f.getCpf());
            objeto.append(",");
            objeto.write(f.getEmail());
            objeto.append(",");
            objeto.write(String.valueOf(f.getCargo()));
            objeto.append(",");
            objeto.write(String.valueOf(f.getSalario()));
            objeto.append("=");
        }
        objeto.close();        
    }
    
    public void carregarArquivo(Funcionarios funcionarios) throws FileNotFoundException, IOException, ClassNotFoundException{
        try{
            FileReader file = new FileReader("funcionarios.txt");
            BufferedReader objeto = new BufferedReader(file);
            StringBuilder content = new StringBuilder();

            List<String> pessoas = new ArrayList<>(Arrays.asList((objeto.readLine()).split("=")));
                        
            for(String p : pessoas){
                content.append(p);
                ArrayList<String> myList;
                myList = new ArrayList<>(Arrays.asList((p).split(",")));
                Funcionario f = new Funcionario(myList.get(0), myList.get(1), myList.get(2), myList.get(3), myList.get(4));
                addFuncionarios(f);
            }
        } catch(FileNotFoundException e){    
            System.out.println("arquivo inexistente");
        }
    }
}
