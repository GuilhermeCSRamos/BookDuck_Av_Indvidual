/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.bookduck.Historico;

import com.mycompany.bookduck.Obra.Obra;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.HashMap;

/**
 *
 * @author davi2
 */
public class Catalogo {
    private HashMap<Obra, Integer> catalogo = new HashMap<>();
    
    public Catalogo(){
        
    }
    
    public void adcObra(Obra obra, int qtd){
        catalogo.put(obra, qtd);
    }
    
    public void atualizaQtd(Obra obra, int qtd){
        catalogo.put(obra, qtd);
    }
    
    
    public void removerObra(Obra obra){
        catalogo.remove(obra);
        System.out.print("obra removida com sucesso");
             
    }
    
    public int qtdExemplar(Obra obra){
        return (catalogo.get(obra));
    }
    
    public void printaObras(){
        
        for(Obra obra : catalogo.keySet()){
            System.out.println("Titulo: " + obra.getTitulo() + 
            "    Quantidade: "  + catalogo.get(obra) + "    Local: " +
            obra.getLocalizacao());
        }
    }
    
    public Obra retornaObra(String nome){
        Obra aux = null;
        for(Obra obra : catalogo.keySet()){
            if(nome.equals(obra.getTitulo()))
                aux = obra;  
        }     
        return aux;
    }
    
    public void alterarArquivo() throws FileNotFoundException, IOException{
        FileWriter file = new FileWriter("catalogo.txt");
        BufferedWriter objeto = new BufferedWriter(file);
        for(Obra o : this.catalogo.keySet()){
            objeto.write(o.getTitulo());
            objeto.append(",");
            objeto.write(o.getDataPublicacao());
            objeto.append(",");
            objeto.write(o.getEditora());
            objeto.append(",");
            objeto.write(o.getLocalizacao());
            objeto.append (",");
            objeto.write(String.valueOf(catalogo.get(o)));
            objeto.append("=");
        }
        objeto.close();
    }
    
    public void carregarArquivo(Catalogo catalogo) throws FileNotFoundException, IOException, ClassNotFoundException{
        try{
            FileReader file = new FileReader("catalogo.txt");
            BufferedReader objeto = new BufferedReader(file);
            StringBuilder content = new StringBuilder();
            
            List<String> obras = new ArrayList<>(Arrays.asList((objeto.readLine()).split("=")));
                        
            for(String o : obras){
                content.append(o);
                ArrayList<String> myList;
                myList = new ArrayList<>(Arrays.asList((o).split(",")));
                Obra obra = new Obra(myList.get(0), myList.get(1), myList.get(2), myList.get(3));
                int aux = Integer.valueOf(myList.get(4));
                catalogo.adcObra(obra, aux);
            }
        } catch(FileNotFoundException e){    
            System.out.println("arquivo inexistente");
        }
    }
}
