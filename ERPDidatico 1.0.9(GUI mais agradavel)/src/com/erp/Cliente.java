package com.erp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private int id;
    private String nome;
    private String cpf;
    private String email;
    private String telefone;

    private Connection connection;

    public Cliente() {
        try {
            // Conectar ao banco de dados
            this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/er_bd?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Cliente(String nome, String cpf, String email, String telefone) {
        this();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
    }

    // Método para inserir um cliente no banco de dados
    public void inserirCliente() {
        String query = "INSERT INTO clientes (nome, cpf, email, telefone) VALUES (?, ?, ?, ?)";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setString(1, this.nome);
            stmt.setString(2, this.cpf);
            stmt.setString(3, this.email);
            stmt.setString(4, this.telefone);
            stmt.executeUpdate();
            System.out.println("Cliente inserido com sucesso!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para buscar todos os clientes no banco de dados
    public List<Cliente> buscarTodosClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String query = "SELECT * FROM clientes";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setCpf(rs.getString("cpf"));
                cliente.setEmail(rs.getString("email"));
                cliente.setTelefone(rs.getString("telefone"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clientes;
    }

    // Método para deletar um cliente do banco de dados pelo ID
    public void deletarClientePorId(int id) {
        String query = "DELETE FROM clientes WHERE id = ?";
        try {
            PreparedStatement stmt = this.connection.prepareStatement(query);
            stmt.setInt(1, id);
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Cliente com ID " + id + " deletado com sucesso!");
            } else {
                System.out.println("Nenhum cliente encontrado com o ID " + id);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
