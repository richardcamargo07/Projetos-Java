package DAO;
import DTO.UserDTO;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;

public class UserDAO {
    Connection conn;

    public ResultSet authenticationUser(UserDTO objuserdto) {
        conn = new ConnectionDAO().conectBD();
        
        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Falha ao conectar com o banco de dados.");
            return null;
        }

        try {
            // Query de autenticação
            String sql = "SELECT * FROM usuario WHERE nome_user = ? AND senha_user = ?";
            
            // Preparando a instrução SQL
            PreparedStatement pstm = conn.prepareStatement(sql);
            pstm.setString(1, objuserdto.getNome_user());
            pstm.setString(2, objuserdto.getSenha_user());

            // Executando a query
            return pstm.executeQuery(); // Retorna o ResultSet

        } catch (SQLException erro) {
            // Tratando possíveis exceções
            JOptionPane.showMessageDialog(null, "Erro no UserDAO: " + erro.getMessage());
            return null;
        }
    }

    // Método para fechar a conexão
    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão: " + erro.getMessage());
        }
    }
}


   

