
package Dao;

import beans.ItemPedido;
import beans.Produto;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;



public class ItemPedidoDao {
    private final Connection conn;
   
    public ItemPedidoDao(){
         this.conn = new Conexao().getConexao();
    }
    
    public boolean salvarItemPedido(ItemPedido item) {
        String sql = "INSERT INTO itemPedido(idPedido, nomeProduto, valor, nomeCliente, quantidade, valorTotal) "
                   + "VALUES (?, ?, ?, ?, ?, ?)";

        try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
                ps.setInt(1, item.getIdPedido());
                ps.setString(2, item.getNomeProduto());
                ps.setDouble(3, item.getValor());
                ps.setString(4, item.getNomeCliente());
                ps.setInt(5, item.getQuantidade());
                ps.setDouble(6, item.getValorTotal());

                int linhaAfetada = ps.executeUpdate(); 
                return linhaAfetada > 0;

            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao salvar item do pedido: " + e.getMessage(), 
                                            "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }
    }
    
    public List<ItemPedido> getItensPorPedido(int idPedido) {
        String sql = "SELECT * FROM itemPedido WHERE idPedido = ?";
        List<ItemPedido> itens = new ArrayList<>();
        
        try (PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setInt(1, idPedido);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    ItemPedido item = criarItemPedido(rs);
                    itens.add(item);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar itens do pedido: " + e.getMessage(), 
                                        "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return itens;
    }
      
    private ItemPedido criarItemPedido(ResultSet rs) throws SQLException {
        ItemPedido item = new ItemPedido();
        item.setIdItemPedido(rs.getInt("idItemPedido"));
        item.setIdPedido(rs.getInt("idPedido"));
        item.setNomeProduto(rs.getString("nomeProduto"));
        item.setValor(rs.getDouble("valor"));
        item.setNomeCliente(rs.getString("nomeCliente"));
        item.setQuantidade(rs.getInt("quantidade"));
        item.setValorTotal(rs.getDouble("valorTotal"));
        return item;
    }

    public double calcularValorTotal(double valor, int quantidade) {
        double valorTotal = valor * quantidade;
        valorTotal = Math.round(valorTotal * 100.0) / 100.0;
        
        return valorTotal;
    }
    
    public void fecharConexao() {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage(), 
                                        "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
