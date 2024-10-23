
package DAO;

import DTO.FuncionarioDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class FuncionarioDAO {
    
    Connection conn;
    PreparedStatement pstm;
    public void cadastrarfunc(FuncionarioDTO objfuncionariodto){
         conn = new ConnectionDAO().conectBD();
         
        String sql = "INSERT INTO usuario (nome_user, senha_user) VALUES (?,?)";
        
        try {
            
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, objfuncionariodto.getNome_func());
            pstm.setString(2, objfuncionariodto.getSenha_func());
            
            pstm.execute();
            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso");
            pstm.close();
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "FuncionarioDAO" + erro);
        }
    }
}
