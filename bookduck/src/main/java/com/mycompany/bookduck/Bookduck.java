
package com.mycompany.bookduck;

import java.util.Scanner;
import com.mycompany.bookduck.Historico.Catalogo;
import com.mycompany.bookduck.Obra.Obra;
import com.mycompany.bookduck.Clientes;
import com.mycompany.bookduck.pessoa.Cliente;
import com.mycompany.bookduck.pessoa.Funcionario;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Bookduck {
    Scanner entrada = new Scanner(System.in);
    public static void menu(){
        System.out.println("|-----------------------------------|");
        System.out.println("|           (1) Cliente             |");
        System.out.println("|           (2) Obra                |");
        System.out.println("|           (3) Funcionario         |");
        System.out.println("|           (0) Sair                |");
        System.out.println("|-----------------------------------|");
    }
    
    public static void menuCLientes(){
        System.out.println("|-----------------------------------|");
        System.out.println("|       (1) Cadastro de cliente     |");
        System.out.println("|       (2) Pontos de fidelidade    |");
        System.out.println("|       (3) Alteraçao no cliente    |");
        System.out.println("|       (4) Remoção de cliente      |");
        System.out.println("|       (5) printa todos os cliente |");
        System.out.println("|       (6) Aluguel de livro        |");
        System.out.println("|       (7) devolução de livro      |");
        System.out.println("|       (8) printa emprestimos      |");
        System.out.println("|       (9) printa historico        |");
        System.out.println("|       (0) Voltar                  |");
        System.out.println("|-----------------------------------|");
        
    }
    
    public static void menuCLienteAlteracao(){
        System.out.println("|-----------------------------------|");
        System.out.println("|       (1) Alterar  Email          |");
        System.out.println("|       (2) Exibir PF               |");
        System.out.println("|-----------------------------------|");
    }
    
    public static void menuObra(){
        System.out.println("|-----------------------------------|");
        System.out.println("|       (1) Cadastro de obra        |");
        System.out.println("|       (2) Alteraçao de obra       |");
        System.out.println("|       (3) Remoção de obra         |");
        System.out.println("|       (4) printa todos as obras   |");
        System.out.println("|       (0) Voltar                  |");
        System.out.println("|-----------------------------------|");
    }
    
    public static void menuObraAlteracao(){
        System.out.println("|-----------------------------------|");
        System.out.println("|       (1) Alterar id              |");
        System.out.println("|       (2) Alterar local           |");
        System.out.println("|-----------------------------------|");
    }
    
    public static void menuFuncionario(){
        System.out.println("|-----------------------------------|");
        System.out.println("|       (1) Cadastro de funcionario |");
        System.out.println("|       (2) promocao do  func       |");
        System.out.println("|       (3) Remoção de funcionario  |");
        System.out.println("|       (4) printa todos os func    |");
        System.out.println("|       (0) Voltar                  |");
        System.out.println("|-----------------------------------|");
        
    }
     
    private static void clearBuffer(Scanner scanner) {
        if (scanner.hasNextLine()) {
            scanner.nextLine();
        }
    }
    
    

    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        
        Catalogo catalogo = new Catalogo();
        Clientes clientes = new Clientes();
        Funcionarios funcionarios = new Funcionarios();
        catalogo.carregarArquivo(catalogo);
        clientes.carregarArquivo(clientes);
        funcionarios.carregarArquivo(funcionarios);
        
        
        int opcao = 99; 
        int cl = 0;
        int oo = 0;
        int of = 0;
        do{
            Scanner entrada = new Scanner(System.in);
            if (opcao != 0)
                menu();
            System.out.print("-> ");
            opcao = entrada.nextInt();
            System.out.println();
            switch(opcao){
                case 1:
                    do{
                    menuCLientes();
                    System.out.print("-> ");
                    cl = entrada.nextInt();
                    System.out.println();
                    Cliente aux = null;
                    Obra obra = null; 
                    switch(cl){
                        case 1:
                            
                            Cliente c = new Cliente();
                            System.out.print("Nome: ");
                            clearBuffer(entrada);
                            
                            c.setName(entrada.nextLine());
                            
                            System.out.print("Cpf: ");
                            c.setCpf(entrada.next());
                            
                            System.out.print("Email: ");
                            c.setEmail(entrada.next());
                           
                            System.out.println();
                            clientes.addCliente(c);
                            break;
                            
                        case 2:
                            clearBuffer(entrada);
                            System.out.print("Nome do cliente que deseja add pf: ");
                            aux = clientes.procuraCliente(entrada.next());
                            
                            if(aux != null){
                                System.out.print("Quantidade de pontos que deseja add: ");
                                aux.atualizaFidelidade(entrada.nextInt());
                            }
                            else
                                System.out.println("cliente nao encontrado, favor revisar o nome.");
                            
                            break;
                            
                        case 3:
                            
                            clearBuffer(entrada);
                            System.out.print("Nome do cliente que deseja fazer alteraçoes: ");
                            aux = null;
                            aux = clientes.procuraCliente(entrada.nextLine());
                            menuCLienteAlteracao();
                            int cla = entrada.nextInt();
                            if(aux != null){
                                if (cla == 1){
                                    System.out.print("\nDigite o novo email: ");
                                        aux.setEmail(entrada.next());
                                } else if (cla == 2) {
                                    System.out.println("Cliente: " + aux.getName());
                                    System.out.println("pf: " + aux.getPontoDeFidelidade());
                                }
                            }
                            break;
                        
                        case 4:
                            
                            clearBuffer(entrada);
                            System.out.print("Nome do cliente que deseja excluir: ");
                            aux = null;
                            aux = clientes.procuraCliente(entrada.nextLine());
                            if (aux != null)
                                clientes.removerCliente(aux);
                            else 
                                System.out.println("cliente nao encontrado, favor revisar o nome.");
                            break;
                            
                        case 5:

                            clientes.printaClientes();
                            break;
                            
                        case 6:
                            
                            clearBuffer(entrada);
                            obra = null; 
                            aux = null;
                            System.out.print("Nome do cliente: ");
                            aux = clientes.procuraCliente(entrada.nextLine());
                            if(aux == null){
                                System.out.println("cliente nao encontrado.");
                                break;
                            }
                                
                            System.out.print("Nome da obra: ");
                            obra = catalogo.retornaObra(entrada.nextLine());
                            if(obra == null){
                                System.out.println("obra nao encontrada.");
                                break;
                            }
                            int qtd = catalogo.qtdExemplar(obra);
                            if (qtd >= 1){
                            aux.emprestimo(obra, "data emprestimo");
                            catalogo.atualizaQtd(obra, qtd-1);
                            }
                            else{
                                System.out.println("Obra nao disponivel");
                            }
                            break;
                        
                        case 7:
                            
                            clearBuffer(entrada);
                            obra = null; 
                            System.out.print("Nome do cliente: ");
                            aux = null;
                            aux = clientes.procuraCliente(entrada.nextLine());
                            if(aux == null){
                                System.out.println("cliente nao encontrado.");
                                break;
                            }
                            clearBuffer(entrada);
                            System.out.print("Nome da obra: ");
                            obra = catalogo.retornaObra(entrada.nextLine());
                            if(obra == null){
                                System.out.println("obra nao encontrada.");
                                break;
                            }
                            aux.devolucao(obra, "data devolução");
                            catalogo.atualizaQtd(obra, catalogo.qtdExemplar(obra)+1);
                            break;
                            
                        case 8:
                            clearBuffer(entrada);
                            aux = null;
                            System.out.print("Nome do cliente: ");
                            aux = clientes.procuraCliente(entrada.nextLine());
                            aux.printaEmprestados();
                            break;
                            
                        case 9:
                            clearBuffer(entrada);
                            aux = null;
                            System.out.print("Nome do cliente: ");
                            aux = clientes.procuraCliente(entrada.nextLine());
                            aux.printaHistorico();
                            break;

                        }
                        clientes.alterarArquivo();  
                    
                    }while(cl != 0);    
                break; 
                
                case 2:
                    do{
                        menuObra();
                        System.out.print("-> ");
                        oo = entrada.nextInt();
                        System.out.println();
                        Obra aux = null;
                        switch(oo){
                            case 1:
                                
                                Obra obra = new Obra();
                                clearBuffer(entrada);
                                
                                System.out.print("Nome: ");
                                obra.setTitulo(entrada.nextLine());
                                
                                System.out.print("Data de publicação: ");
                                obra.setDataPublicacao(entrada.nextLine());
                                
                                System.out.print("Editora: ");
                                obra.setEditora(entrada.nextLine());
                                
                                System.out.print("Localização: ");
                                obra.setLocalizacao(entrada.nextLine());
                               
                                System.out.print("quantas unidade deseja adcionar: ");
                                int qtd = entrada.nextInt();
                                catalogo.adcObra(obra, qtd);
                                break;
                                
                            case 2:
                                
                                menuObraAlteracao();
                                int oo2 = entrada.nextInt();
                                if(oo2 == 1){
                                    clearBuffer(entrada);
                                    System.out.print("Nome da obra que deseja alterar o id: ");
                                    aux = catalogo.retornaObra(entrada.nextLine());
                                    System.out.print("Id: ");
                                    aux.setId(entrada.nextInt());
                                }
                                if(oo2 == 2){
                                    clearBuffer(entrada);
                                    System.out.print("Nome da obra que deseja alterar o local: ");
                                    aux = catalogo.retornaObra(entrada.nextLine());
                                    clearBuffer(entrada);
                                    System.out.print("Local: ");
                                    aux.setLocalizacao(entrada.nextLine());
                                }
                                break;
                                
                            case 3:
                                clearBuffer(entrada);
                                System.out.print("Nome da obra que deseja remover: ");
                                aux = catalogo.retornaObra(entrada.nextLine());
                                clearBuffer(entrada);
                                catalogo.removerObra(aux);  
                                break;
                                
                            case 4:
                                catalogo.printaObras();
                                break;
                                
                            case 5:
                                clientes.printaEmprestimos();
                        }
                        
                        
                    }while(oo != 0);
                    catalogo.alterarArquivo();
                break; 
                case 3:
                    do{
                        menuFuncionario();
                        System.out.print("-> ");
                        of = entrada.nextInt();
                        System.out.println();
                        Funcionario aux = null;
                        switch(of){
                            case 1:
                                Funcionario f = new Funcionario();
                                System.out.print("Nome: ");
                                clearBuffer(entrada);

                                f.setName(entrada.nextLine());

                                System.out.print("Cpf: ");
                                f.setCpf(entrada.next());

                                System.out.print("Email: ");
                                f.setEmail(entrada.next());
                                
                                System.out.println("Cargos: ");
                                f.printaCargos();
                                System.out.println();
                                System.out.print("Cargo: ");
                                f.setCargo(entrada.nextInt());
                                
                                System.out.print("Salario: ");
                                f.setSalario(entrada.nextDouble());
                                
                                System.out.println();
                                funcionarios.addFuncionarios(f);
                                break;
                                
                            case 2:
                                clearBuffer(entrada);
                                System.out.print("Nome do funcionario a ser promovido: ");
                                aux = funcionarios.procuraFuncionario(entrada.next());
                                if(aux == null){
                                    System.out.println("Funcionario nao encontrado");
                                    break;
                                }
                                 System.out.println("Cargos: ");
                                aux.printaCargos();
                                System.out.println();
                                aux.descricaoCargo();
                                System.out.print("Cargo: ");
                                aux.setCargo(entrada.nextInt());
                                System.out.print("Salario: ");
                                aux.setSalario(entrada.nextDouble());
                                
                                break;
                                
                            case 3:
                                clearBuffer(entrada);
                                System.out.print("Nome do funcionario a ser removido: ");
                                aux = funcionarios.procuraFuncionario(entrada.next());
                                if(aux == null){
                                    System.out.println("Funcionario nao encontrado");
                                    break;
                                }
                                funcionarios.removerFuncionario(aux);
                                break;
                            
                            case 4:
                                funcionarios.printaFuncionarios();
                                break;     
                        }
                        funcionarios.alterarArquivo();
                  
                    }while(of != 0);
                break;
            }
        }while(opcao != 0);
    }
}
