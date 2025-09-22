
package Dao;

import beans.Funcionario;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class FuncionarioDao {

    private final Connection conn;
    private Conexao conexao;

    public FuncionarioDao() {
        this.conn = this.conexao.getConexao();
    }

    public boolean salvarFuncionario(Funcionario funcionario) {
        String sql = "INSERT INTO funcionario(login, senha) VALUES (?, ?)";

        try ( PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setString(1, funcionario.getLogin());
            ps.setString(2, funcionario.getSenha());

            int linhaAfetada = ps.executeUpdate();
            return linhaAfetada > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public void fecharConexao() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            System.err.println("Erro ao fechar conexão: " + e.getMessage());
        }
    }
}
