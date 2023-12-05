
package Projeto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class ConexaoJDBC {
    public Connection conectarAdm(){
        String url = "jdbc:postgresql://localhost/postgres";
        String usuario = "administrador";
        String senha = "administrador";
    
        try {
            Class.forName("org.postgresql.Driver");
            Connection conexao = DriverManager.getConnection(url, usuario, senha);
            return conexao; // Retorna a conexão bem-sucedida
        } 
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(
                null,
                "ERRO AO CONECTAR NO BANCO DE DADOS!",
                "LOGIN ADMINISTRADOR",
                0);
            e.printStackTrace();
        }
        return null; // Retorna null se houver um erro na conexão
    }
}
