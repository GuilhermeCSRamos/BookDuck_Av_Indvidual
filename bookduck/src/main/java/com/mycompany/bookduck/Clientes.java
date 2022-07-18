/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookduck;

import java.util.ArrayList;
import com.mycompany.bookduck.pessoa.Cliente;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author davi2
 */
public class Clientes implements Serializable {
    private final ArrayList<Cliente> clientes = new ArrayList<>();
    
    
    public Clientes(){
        
    }
    
    public void addCliente(Cliente cliente){
        this.clientes.add(cliente);
    }
    
    public void removerCliente(Cliente cliente){
        if(clientes.remove(cliente)){
            System.out.println("cliente removido");
        }
    }
    
    public Cliente procuraCliente(String nome){
        Cliente aux = null;
        for(Cliente c : clientes){
            if(nome.equals(c.getName())){
                aux = c;
            }
        }
        return aux;   
    }
    
    public void printaClientes(){
        for(Cliente c : clientes)
            System.out.println(c.getName());
            
    }
    
    public void printaEmprestimos(){
        for(Cliente c : clientes)
            c.printaEmprestados();
    }
    
    public void alterarArquivo() throws FileNotFoundException, IOException{
        FileWriter file = new FileWriter("clientes.txt");
        BufferedWriter objeto = new BufferedWriter(file);
        for(Cliente c : this.clientes){
            objeto.write(c.getName());
            objeto.append(",");
            objeto.write(c.getCpf());
            objeto.append(",");
            objeto.write(c.getEmail());
            objeto.append(",");
            objeto.write(String.valueOf(c.getPontoDeFidelidade()));
            objeto.append("=");
        }
        objeto.close();        
    }
    
    public void carregarArquivo(Clientes clientes) throws FileNotFoundException, IOException, ClassNotFoundException{
        try{
            FileReader file = new FileReader("clientes.txt");
            BufferedReader objeto = new BufferedReader(file);
            StringBuilder content = new StringBuilder();

            List<String> pessoas = new ArrayList<>(Arrays.asList((objeto.readLine()).split("=")));
                        
            for(String p : pessoas){
                content.append(p);
                ArrayList<String> myList;
                myList = new ArrayList<>(Arrays.asList((p).split(",")));
                Cliente c = new Cliente(myList.get(0), myList.get(1), myList.get(2), Integer.valueOf(myList.get(3)));
                clientes.addCliente(c);
            }
        } catch(FileNotFoundException e){    
            System.out.println("arquivo inexistente");
        }
    }
}
