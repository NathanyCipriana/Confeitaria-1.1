
package Dao;

import beans.Pedido;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class PedidoDao {

    private final Connection conn;

    public PedidoDao() {
        this.conn = new Conexao().getConexao();
    }

    public boolean salvarPedido(Pedido pedido) {
        String sql = "INSERT INTO pedido(nomeProduto, valor, nomeCliente, quantidade) VALUES (?, ?, ?, ?)";

        try ( PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setString(1, pedido.getNomeProduto());
            ps.setDouble(2, pedido.getValor());
            ps.setString(3, pedido.getNomeCliente());
            ps.setInt(4, pedido.getQuantidade());

            int linhaAfetada = ps.executeUpdate();

            if (linhaAfetada > 0) {
                return true;
            }
            return false;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar pedido: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Pedido> listarTodos() {
        String sql = "SELECT * FROM pedido";
        List<Pedido> pedidos = new ArrayList<>();

        try ( PreparedStatement ps = this.conn.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Pedido pedido = new Pedido();
                pedido.setIdPedido(rs.getInt("idPedido"));
                pedido.setNomeProduto(rs.getString("nomeProduto"));
                pedido.setValor(rs.getDouble("valor"));
                pedido.setNomeCliente(rs.getString("nomeCliente"));
                pedido.setQuantidade(rs.getInt("quantidade"));
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar pedidos: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return pedidos;
    }

    public Pedido buscarPorId(int idPedido) {
        String sql = "SELECT * FROM pedido WHERE idPedido = ?";

        try ( PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setInt(1, idPedido);

            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Pedido pedido = new Pedido();
                    pedido.setIdPedido(rs.getInt("idPedido"));
                    pedido.setNomeProduto(rs.getString("nomeProduto"));
                    pedido.setValor(rs.getDouble("valor"));
                    pedido.setNomeCliente(rs.getString("nomeCliente"));
                    pedido.setQuantidade(rs.getInt("quantidade"));
                    return pedido;
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar pedido: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    public boolean excluirPedido(int idPedido) {
        String sql = "DELETE FROM pedido WHERE idPedido = ?";

        try ( PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setInt(1, idPedido);

            int linhaAfetada = ps.executeUpdate();
            return linhaAfetada > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir pedido: " + e.getMessage(),
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
