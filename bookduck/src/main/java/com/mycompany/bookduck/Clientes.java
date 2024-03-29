/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookduck;

import com.mycompany.bookduck.exceptions.AvaliacaoOO2022NaoInformadaException;
import java.util.ArrayList;
import com.mycompany.bookduck.pessoa.Cliente;
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author guilherme
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
    
    public void alterarArquivo() throws FileNotFoundException, IOException, AvaliacaoOO2022NaoInformadaException{
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
            
//            Avaliação individual
//          Nesse caso, quando o programa é reaberto, pelo motivo de os clientes estarem sendo salvos em texto, 
//          temos o lançamento deste erro para os objetos Cliente que vêm do arquivo de texto (usado como BD), 
//          entretanto no que diz respeito ao objeto Cliente criado no tempo de execução, o try catch tem o 
//          comportamento esperado. Bem, de certa forma até o lançamento de erro citado a cima é esperado.

            try{
                if (c.getAvaliacao() == null){
                    throw new AvaliacaoOO2022NaoInformadaException();
                } 
                else {
                    FileOutputStream arquivo = new FileOutputStream("avaliacao.guilherme");
                    ObjectOutputStream object = new ObjectOutputStream(arquivo);
                    object.writeObject(c);
                    object.close();
                }
            }
            catch(AvaliacaoOO2022NaoInformadaException ex){
                System.out.println(ex.getMessage());
            }
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
