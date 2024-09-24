package com.erp;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        
        @SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque(); // Classe que gerencia o estoque e se conecta ao banco de dados
        Login logar = new Login(); // Classe de Login

        // Menu para seleção de idioma
        System.out.println("--------------------------------");
        System.out.println("|PT-BR: 0 | ");
        System.out.println("--------------------------------");
        System.out.println("|EN: 1 | ");
        System.out.println("--------------------------------");
        int idioma = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        if (idioma == 0) { // PT-BR
            System.out.println("--------------------------------");
            System.out.println("|Continuar como Admin: 0 | ");
            System.out.println("--------------------------------");
            System.out.println("|Continuar como Funcionario: 1 | ");
            System.out.println("--------------------------------");
            int op = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            if (op == 0) { // Admin
                if (logar.login(logar.admin, logar.senha)) {
                    while (true) {
                        System.out.println();
                        System.out.println("Menu:");
                        System.out.println("--------------------------------------------");
                        System.out.println("|1. Adicionar Produto:                      |");
                        System.out.println("|2. Listar Produtos:                        |");
                        System.out.println("|3. Comprar Produto Cliente:                |");//falta configurar o comando para ficar registrado a compra que o cliente fez, e ver se vai precisar alterar banco de dados, mais eu acho que não vai precisar
                        System.out.println("|4. Adicionar Clientes.                     |");
                        System.out.println("|5. Listar Clientes.                        |");
                        System.out.println("|6. Excluir Clientes.                       |");
                        System.out.println("|7. Titulos em Aberto.                      |");//falta a função para listar os titulos em aberto
                        System.out.println("|8. Pagamento Pendente:                     |");//adicionar comando para ver os pagamentos pendentes
                        System.out.println("|9. Efetuar Pagamento:                      |");
                        System.out.println("|12. Sair.                                  |");
                        System.out.println("--------------------------------------------");
                        System.out.println("Escolha uma opção no seu teclado:           ");
                        int choice = scanner.nextInt();
                        scanner.nextLine(); // Consumir nova linha
                        //Qualquer coisa se precisar muda o banco de dados
                        switch (choice) {
                            case 1:
                                estoque.addProduto(scanner);
                                break;
                            case 2:
                                estoque.listaProduto();
                                break;
                            case 3:
                                estoque.compraProduto(scanner, choice);
                                break;
                            case 4:
                                System.out.print("Nome: ");
                                String nome = scanner.nextLine();
                                System.out.print("CPF: ");
                                String cpf = scanner.nextLine();
                                System.out.print("Email: ");
                                String email = scanner.nextLine();
                                System.out.print("Telefone: ");
                                String telefone = scanner.nextLine();
            
                                Cliente novoCliente = new Cliente(nome, cpf, email, telefone);
                                novoCliente.inserirCliente();
                                break;
                            case 5:
                                estoque.listarCliente();
                                break;
                            case 6:
                                System.out.print("Digite o ID do cliente a ser deletado: ");
                                int id = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer
            
                                Cliente cliente = new Cliente();
                                cliente.deletarClientePorId(id);
                                break;
                            case 7:
                                System.out.println("Digite o ID do cliente para ver as compras: ");//fazer testes para garantir a funcionalidade do codigo
                                int clienteId = scanner.nextInt();
                                estoque.listarComprasCliente(clienteId);
                                break;
                            case 12:
                                System.out.println("Saindo...");
                                return;
                            default:
                                System.out.println("Opção inválida. Tente novamente.");
                        }
                    }
                } else {
                    System.out.println("Usuario ou senha incorretos");
                }
            } else { // Funcionario
                // Funções para funcionário
                while (true) {
                    System.out.println("Menu:");
                    System.out.println("--------------------------");
                    System.out.println("|1. Cadastrar pessoa:     |");
                    System.out.println("|2. Deletar pessoa:       |");
                    System.out.println("|3. Carrinho              |");
                    System.out.println("|4. Pagamento Pendente:   |");
                    System.out.println("|5: Efetuar Pagamento     |");
                    System.out.println("|6. Sair:                 |");
                    System.out.println("--------------------------");
                    System.out.println("Escolha uma opção no seu teclado:");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        // Aqui você pode adicionar os métodos necessários para funcionário
                        case 1:
                            System.out.print("Nome: ");
                            String nome = scanner.nextLine();
                            System.out.print("CPF: ");
                            String cpf = scanner.nextLine();
                            System.out.print("Email: ");
                            String email = scanner.nextLine();
                            System.out.print("Telefone: ");
                            String telefone = scanner.nextLine();
        
                            Cliente novoCliente = new Cliente(nome, cpf, email, telefone);
                            novoCliente.inserirCliente();
                            break;
                        case 2:
                            System.out.print("Digite o ID do cliente a ser deletado: ");
                            int id = scanner.nextInt();
                            scanner.nextLine(); // Limpar o buffer
        
                            Cliente cliente = new Cliente();
                            cliente.deletarClientePorId(id);
                            break;
                        case 3:
                            //falta adicionar função
                            break;
                        case 4:
                            //falata adicionar função
                            break;
                        case 5:
                            // falta adicionar função
                        case 6:
                            System.out.println("Saindo...");
                            return;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                }
            }
        } else { // EN
            System.out.println("--------------------------------");
            System.out.println("|Continue as Admin: 0         | ");
            System.out.println("--------------------------------");
            System.out.println("|Continue as Guest: 1         | ");
            System.out.println("--------------------------------");
            int op = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            if (op == 0) { // Admin
                if (logar.login(logar.admin, logar.senha)) {
                    while (true) {
                        System.out.println();
                        System.out.println("Menu:");
                        System.out.println("--------------------------------------------");
                        System.out.println("|1. Add Product:                            |");
                        System.out.println("|2. List Products:                          |");
                        System.out.println("|3. Buy Product:                            |");//falta configurar o comando para ficar registrado a compra que o cliente fez, e ver se vai precisar alterar banco de dados, mais eu acho que não vai precisar
                        System.out.println("|4. Register Person:                        |");
                        System.out.println("|5. List People:                            |");
                        System.out.println("|6. Delete Person:                          |");
                        System.out.println("|7. List Outstanding Payment Titles:        |");//falta a função para listar os titulos em aberto
                        System.out.println("|8. Pending Payment:                        |");
                        System.out.println("|9. Make a Payment:                         |");
                        System.out.println("|12. Sair.                                  |");
                        System.out.println("---------------------------------------------");
                        System.out.println("Choose an option on your keyboard:           ");
                        int choice = scanner.nextInt();
                        scanner.nextLine(); // Consumir nova linha

                        switch (choice) {
                            case 1:
                                estoque.addProduto(scanner);
                                break;
                            case 2:
                                estoque.listaProduto();
                                break;
                            case 3:
                                estoque.compraProduto(scanner, choice);
                                break;
                            case 4:
                                System.out.print("Name: ");
                                String nome = scanner.nextLine();
                                System.out.print("SSN: ");
                                String cpf = scanner.nextLine();
                                System.out.print("Email: ");
                                String email = scanner.nextLine();
                                System.out.print("Cellphone: ");
                                String telefone = scanner.nextLine();
            
                                Cliente novoCliente = new Cliente(nome, cpf, email, telefone);
                                novoCliente.inserirCliente();
                                break;
                            case 5:
                                estoque.listarCliente();
                                break;
                            case 6:
                                System.out.print("Enter the customer ID to be deleted: ");
                                int id = scanner.nextInt();
                                scanner.nextLine(); // Limpar o buffer
            
                                Cliente cliente = new Cliente();
                                cliente.deletarClientePorId(id);
                                break;
                            case 7:// fazer testes para garantir a funcionalidade do codigo
                                System.out.println("Enter customer ID to view purchases: ");
                                int clienteId = scanner.nextInt();
                                estoque.listarComprasCliente(clienteId);
                                break;
                            case 12:
                                System.out.println("Exiting...");
                                return;
                            default:
                                System.out.println("Invalid option. Please try again.");
                        }
                    }
                } else {
                    System.out.println("Incorrect usernam or passoword");
                }
            } else { // Funcionario
                // Funções para funcionário
                while (true) {
                    System.out.println("Menu:");
                    System.out.println("--------------------------");
                    System.out.println("|1. Register Person:      |");
                    System.out.println("|2. Deletar pessoa:       |");
                    System.out.println("|3. Shopping cart:        |");
                    System.out.println("|4. Pending Payment:      |");
                    System.out.println("|5: Make a Payment:       |");
                    System.out.println("|6. Exit:                 |");
                    System.out.println("--------------------------");
                    System.out.println("Choose an option on your keyboard:");
                    int choice = scanner.nextInt();
                    scanner.nextLine();

                    switch (choice) {
                        // Aqui você pode adicionar os métodos necessários para funcionário
                        case 1:
                            System.out.print("Name: ");
                            String nome = scanner.nextLine();
                            System.out.print("SSN: ");
                            String cpf = scanner.nextLine();
                            System.out.print("Email: ");
                            String email = scanner.nextLine();
                            System.out.print("Cellphone: ");
                            String telefone = scanner.nextLine();
        
                            Cliente novoCliente = new Cliente(nome, cpf, email, telefone);
                            novoCliente.inserirCliente();
                            break;
                        case 2:
                            System.out.print("Enter the customer ID to be deleted: ");
                            int id = scanner.nextInt();
                            scanner.nextLine(); // Limpar o buffer
        
                            Cliente cliente = new Cliente();
                            cliente.deletarClientePorId(id);
                            break;
                        case 3:
                            //falta adicionar função
                            break;
                        case 4:
                            //falata adicionar função
                            break;
                        case 5:
                            // falta adicionar função
                        case 6:
                            System.out.println("Exiting...");
                            return;
                        default:
                            System.out.println("Invalid option. Please try again.");
                    }
                }
            }
        }
    }
}