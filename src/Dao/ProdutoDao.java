package Dao;

import beans.Produto;
import conexao.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class ProdutoDao {

    private Conexao conexao;
    private final Connection conn;
    ArrayList<Produto> listagem = new ArrayList<>();

    public ProdutoDao() {
        this.conexao = new Conexao();
        this.conn = this.conexao.getConexao();
    }

    public boolean cadastrarProduto(Produto produto) {
        String sql = "INSERT INTO produto(nome, descricao, valor) VALUES (?, ?, ?)";

        try ( PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setString(1, produto.getNomeProduto());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getValor());

            int linhaAfetada = ps.executeUpdate();

            if (linhaAfetada > 0) {
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Falha ao cadastrar produto",
                        "Erro", JOptionPane.ERROR_MESSAGE);
                return false;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar produto: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public List<Produto> buscarProdutosPorNome(String nomeProduto) {
        String sql = "SELECT * FROM produto WHERE nome LIKE ?";
        List<Produto> produtosEncontrados = new ArrayList<>();

        try ( PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nomeProduto + "%");

            try ( ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Produto produto = criarProduto(rs);
                    produtosEncontrados.add(produto);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produtos: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return produtosEncontrados;
    }

    public List<Produto> listarTodosProdutos() {
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = new ArrayList<>();

        try ( PreparedStatement ps = this.conn.prepareStatement(sql);  ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Produto produto = criarProduto(rs);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return produtos;
    }

    public boolean atualizarProduto(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, descricao = ?, valor = ? WHERE idProduto = ?";

        try ( PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setString(1, produto.getNomeProduto());
            ps.setString(2, produto.getDescricao());
            ps.setDouble(3, produto.getValor());
            ps.setInt(4, produto.getIdProduto());

            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    public Produto buscarProdutoPorId(int idProduto) {
        String sql = "SELECT * FROM produto WHERE idProduto = ?";

        try ( PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setInt(1, idProduto);

            try ( ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return criarProduto(rs);
                }
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao buscar produto: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
        return null;
    }

    private Produto criarProduto(ResultSet rs) throws SQLException {
        Produto produto = new Produto();
        produto.setIdProduto(rs.getInt("idProduto"));
        produto.setNomeProduto(rs.getString("nome"));
        produto.setDescricao(rs.getString("descricao"));
        produto.setValor(rs.getDouble("valor"));
        return produto;
    }

    public boolean excluirProduto(String nomeProduto) {
        String sql = "DELETE FROM produto WHERE nome = ?";

        try ( PreparedStatement ps = this.conn.prepareStatement(sql)) {
            ps.setString(1, nomeProduto);

            int linhaAfetada = ps.executeUpdate();
            return linhaAfetada > 0;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto: " + e.getMessage(),
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
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
