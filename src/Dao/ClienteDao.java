
package Dao;

import beans.Cliente;
import beans.Funcionario;
import beans.Pedido;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ClienteDao {
    private final Connection conn;

    public ClienteDao() {
        this.conn =Conexao.getConexao();
    }

    public boolean cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente(nome, telefone, email, endereco) VALUES (?, ?, ?, ?)";

        try ( PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setString(1, cliente.getNomeCliente());
            ps.setString(2, cliente.getTelefone());
            ps.setString(3, cliente.getEmail());
            ps.setString(4, cliente.getEndereco());

            int linhaAfetada = ps.executeUpdate();

            if (linhaAfetada > 0) {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                return true;
            }
            return false;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar cliente: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Cliente> buscarPorNome(String nomeCliente) {
        String sql = "SELECT * FROM cliente WHERE nome LIKE ?";
        List<Cliente> clientes = new ArrayList<>();
        
        try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nomeCliente + "%");
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Cliente cliente = new Cliente();
                    cliente.setIdCliente(rs.getInt("idCliente"));
                    cliente.setNomeCliente(rs.getString("nome"));
                    cliente.setTelefone(rs.getString("telefone"));
                    cliente.setEmail(rs.getString("email"));
                    cliente.setEndereco(rs.getString("endereco"));
                    clientes.add(cliente);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar clientes: " + e.getMessage(), 
                                        "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return clientes;
    }
    
    public List<Cliente> listarTodosClientes() {
        String sql = "SELECT * FROM cliente";
        List<Cliente> clientes = new ArrayList<>();
        
        try (PreparedStatement ps = this.conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setNomeCliente(rs.getString("nome"));
                cliente.setTelefone(rs.getString("telefone"));
                cliente.setEmail(rs.getString("email"));
                cliente.setEndereco(rs.getString("endereco"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar clientes: " + e.getMessage(), 
                                        "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return clientes;
    }
    
    public boolean excluirCliente(String nomeCliente) {
        String sql = "DELETE FROM cliente WHERE nome = ?";

        try ( PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setString(1, nomeCliente);

            int linhaAfetada = ps.executeUpdate();
            return linhaAfetada > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

}
