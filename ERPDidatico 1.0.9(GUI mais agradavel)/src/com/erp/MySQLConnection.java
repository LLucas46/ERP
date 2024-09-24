package com.erp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    
    // Configurações do banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/er_bd?useTimezone=true&serverTimezone=UTC";
    private static final String USER = "root";  // Usuário do MySQL
    private static final String PASSWORD = "";  // Senha do MySQL

    public static void main(String[] args) {
        Connection conn = null;

        try {
            // Conecta ao banco de dados
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            if (conn != null) {
                System.out.println("Conexão bem-sucedida ao banco de dados!");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        } finally {
            // Fecha a conexão
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("Erro ao fechar a conexão: " + e.getMessage());
            }
        }
    }

   
       
}