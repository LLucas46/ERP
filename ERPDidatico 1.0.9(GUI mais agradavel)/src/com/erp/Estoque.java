package com.erp;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

public class Estoque {
    private Connection connection;

    public Estoque() {
        try {
            // Inicializar a conexão com o banco de dados
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/er_bd?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addProduto(Scanner scanner) {
        System.out.println("Digite o nome do produto:");
        String nome = scanner.nextLine();
        System.out.println("Digite a quantidade do produto:");
        int quantidade = scanner.nextInt();
        System.out.println("Digite o preço do produto:");
        double preco = scanner.nextDouble();
        scanner.nextLine(); // Consumir a nova linha

        try {
            String query = "INSERT INTO produtos (nome, quantidade, preco) VALUES (?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, nome);
            stmt.setInt(2, quantidade);
            stmt.setDouble(3, preco);
            stmt.executeUpdate();
            System.out.println("Produto adicionado com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void listaProduto() {
        try {
            String query = "SELECT * FROM produtos";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            System.out.println("Lista de Produtos:");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + ", Nome: " + rs.getString("nome") +
                        ", Quantidade: " + rs.getInt("quantidade") + ", Preço: " + rs.getDouble("preco"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void compraProduto(Scanner scanner, int clienteId) {
        
        System.out.println("Digite o ID do produto que deseja comprar:");
        int produtoId = scanner.nextInt();
        System.out.println("Digite a quantidade que deseja comprar:");
        int quantidade = scanner.nextInt();
        scanner.nextLine(); // Consumir a nova linha

        try {
            // Verificar se há estoque disponível
            String queryCheck = "SELECT quantidade FROM produtos WHERE id = ?";
            PreparedStatement stmtCheck = connection.prepareStatement(queryCheck);
            stmtCheck.setInt(1, produtoId);
            ResultSet rsCheck = stmtCheck.executeQuery();

            if (rsCheck.next()) {
                int quantidadeDisponivel = rsCheck.getInt("quantidade");
                if (quantidade > quantidadeDisponivel) {
                    System.out.println("Quantidade em estoque insuficiente!");
                } else {
                    // Atualizar a quantidade de produto no estoque
                    String queryUpdate = "UPDATE produtos SET quantidade = quantidade - ? WHERE id = ?";
                    PreparedStatement stmtUpdate = connection.prepareStatement(queryUpdate);
                    stmtUpdate.setInt(1, quantidade);
                    stmtUpdate.setInt(2, produtoId);
                    stmtUpdate.executeUpdate();

                    // Inserir a compra no banco de dados, associando o cliente
                    String queryCompra = "INSERT INTO compras (cliente_id, produto_id, quantidade, data_compra) VALUES (?, ?, ?, NOW())";
                    PreparedStatement stmtCompra = connection.prepareStatement(queryCompra);
                    stmtCompra.setInt(1, clienteId);
                    stmtCompra.setInt(2, produtoId);
                    stmtCompra.setInt(3, quantidade);
                    stmtCompra.executeUpdate();
                    System.out.println("Compra realizada com sucesso!");
                }
            } else {
                System.out.println("Produto não encontrado!");
            }
        } catch (SQLException e) {
            e.printStackTrace();}

        }
        
        public void listarComprasCliente(int clienteId) {
            try {
                // Consulta para buscar as compras do cliente
                String query = "SELECT p.nome, c.quantidade, c.data_compra FROM compras c JOIN produtos p ON c.produto_id = p.id WHERE c.cliente_id = ?";
                PreparedStatement stmt = connection.prepareStatement(query);
                stmt.setInt(1, clienteId);
                ResultSet rs = stmt.executeQuery();
        
                System.out.println("Compras do cliente (ID: " + clienteId + "):");
                while (rs.next()) {
                    String nomeProduto = rs.getString("nome");
                    int quantidade = rs.getInt("quantidade");
                    String dataCompra = rs.getString("data_compra");
                    System.out.println("Produto: " + nomeProduto + ", Quantidade: " + quantidade + ", Data: " + dataCompra);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

         public void listarCliente() {
        Cliente cliente = new Cliente();
        List<Cliente> clientes = cliente.buscarTodosClientes();
        for (Cliente c : clientes) {
            System.out.println("ID: " + c.getId() + ", Nome: " + c.getNome() + ", CPF: " + c.getCpf());
        }
    
    }

    // Implementar outros métodos como `fazPagamento`, `listarTitulosDeDestaque`, `addCliente`, etc.
    // ...
}
