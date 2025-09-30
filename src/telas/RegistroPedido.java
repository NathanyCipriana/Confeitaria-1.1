package telas;

import beans.Cliente;
import beans.ItemPedido;
import beans.Pedido;
import beans.Produto;
import Dao.ItemPedidoDao;
import Dao.ProdutoDao;
import Dao.PedidoDao;
import Dao.ClienteDao;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import telas.TelaItemPedido;

public class RegistroPedido extends javax.swing.JFrame {

    public RegistroPedido() {
        initComponents();
        inicializarTabelas();
        atualizarTabelaPedidos();
    }

    private void inicializarTabelas() {
        // Tabela de busca
        String[] colunasBusca = {"Tipo", "ID", "Nome", "Valor", "Quantidade"};
        DefaultTableModel modelBusca = new DefaultTableModel(colunasBusca, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tableBusca.setModel(modelBusca);

        // Tabela de pedido
        String[] colunasPedido = {"ID Pedido", "Produto", "Valor", "Cliente", "Quantidade"};
        DefaultTableModel modelPedido = new DefaultTableModel(colunasPedido, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 5;
            }
        };
        
        tablePedido.setModel(modelPedido);

        cbTipoBusca.setModel(new DefaultComboBoxModel<>(new String[]{"Produto", "Cliente"}));
    }

    private void atualizarTabelaPedidos() {
        DefaultTableModel model = (DefaultTableModel) tablePedido.getModel();

        PedidoDao pedidodao = new PedidoDao();
        List<Pedido> listarpedidos = pedidodao.listarTodos();

        for (Pedido pedido : listarpedidos) {
            model.addRow(new Object[]{
                pedido.getIdPedido(),
                pedido.getNomeProduto(),
                pedido.getValor(),
                pedido.getNomeCliente(),
                pedido.getQuantidade()
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        lblBusca = new javax.swing.JLabel();
        txtBusca = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btnAdicionarItem = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablePedido = new javax.swing.JTable();
        btnBuscar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableBusca = new javax.swing.JTable();
        cbTipoBusca = new javax.swing.JComboBox<>();
        lblTipoBusca = new javax.swing.JLabel();
        btnListaItem = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tela registro de pedidos"));

        lblLogo.setFont(new java.awt.Font("Shree Devanagari 714", 0, 36)); // NOI18N
        lblLogo.setText("Confeitaria Pequena Flor");

        jLabel3.setIcon(new javax.swing.ImageIcon("/Users/nathany/Desktop/_cursos/Tecnico-dev-de-sistemas/Uc15Confeitaria/src/images/bolo.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(267, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(13, Short.MAX_VALUE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(21, 21, 21))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 170));

        lblBusca.setFont(new java.awt.Font("Helvetica Neue", 0, 16)); // NOI18N
        lblBusca.setText("Item de busca:");
        getContentPane().add(lblBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, -1, 30));

        txtBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscaActionPerformed(evt);
            }
        });
        getContentPane().add(txtBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 270, 30));

        btnFinalizar.setBackground(new java.awt.Color(153, 204, 255));
        btnFinalizar.setText("Finalizar  pedido");
        btnFinalizar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(btnFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 630, 140, 30));

        jLabel1.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        jLabel1.setText("Registro de pedidos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 180, -1, -1));

        btnAdicionarItem.setBackground(new java.awt.Color(255, 204, 204));
        btnAdicionarItem.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnAdicionarItem.setText("Adicionar itens");
        btnAdicionarItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAdicionarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarItemActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionarItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 280, 140, 30));

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tablePedido.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tablePedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "IDpedido", "NomeProduto", "Valor", "NomeCliente", "Quantidade"
            }
        ));
        tablePedido.setSize(new java.awt.Dimension(200, 80));
        jScrollPane1.setViewportView(tablePedido);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 2, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 450, 850, 170));

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(btnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 280, -1, 30));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        tableBusca.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        tableBusca.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableBusca);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 848, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 850, 120));

        cbTipoBusca.setBackground(new java.awt.Color(153, 204, 255));
        cbTipoBusca.setFont(new java.awt.Font("Helvetica Neue", 0, 14)); // NOI18N
        cbTipoBusca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Produtos", "Clientes" }));
        getContentPane().add(cbTipoBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 230, 130, 30));

        lblTipoBusca.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblTipoBusca.setText("Escolha uma opção:");
        getContentPane().add(lblTipoBusca, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 170, 30));

        btnListaItem.setText("Lista de itens do pedido");
        btnListaItem.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnListaItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaItemActionPerformed(evt);
            }
        });
        getContentPane().add(btnListaItem, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 630, 150, 30));

        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 630, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscaActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablePedido.getModel();
        PedidoDao pedidodao = new PedidoDao();

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhum item no pedido para finalizar!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            for (int i = 0; i < model.getRowCount(); i++) {
                Pedido pedido = new Pedido();
                pedido.setNomeProduto((String) model.getValueAt(i, 1));
                pedido.setValor((double) model.getValueAt(i, 2));
                pedido.setNomeCliente((String) model.getValueAt(i, 3));
                pedido.setQuantidade((int) model.getValueAt(i, 4));

                pedidodao.salvarPedido(pedido);
            }
            model.setRowCount(0);
            atualizarTabelaPedidos();
            JOptionPane.showMessageDialog(this, "Pedido salvo com sucesso!");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao finalizar pedido: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void btnAdicionarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarItemActionPerformed
        int selectedRow = tableBusca.getSelectedRow();

        if (selectedRow >= 0) {
            String tipo = tableBusca.getValueAt(selectedRow, 0).toString();
            DefaultTableModel modelPedido = (DefaultTableModel) tablePedido.getModel();

            if (tipo.equals("Produto")) {
                String nomeProduto = tableBusca.getValueAt(selectedRow, 2).toString();

                for (int i = 0; i < modelPedido.getRowCount(); i++) {
                    if (nomeProduto.equals(modelPedido.getValueAt(i, 1))) {
                        JOptionPane.showMessageDialog(this, "Este produto já está no pedido!");
                        return;
                    }
                }

                String quantidadeP = JOptionPane.showInputDialog(this, "Digite a quantidade:");
                try {
                    int quantidade = Integer.parseInt(quantidadeP);
                    if (quantidade > 0) {
                        double valor = Double.parseDouble(tableBusca.getValueAt(selectedRow, 3).toString());

                        modelPedido.addRow(new Object[]{
                            null,
                            nomeProduto,
                            valor,
                            null,
                            quantidade
                        });
                    } else {
                        JOptionPane.showMessageDialog(this, "Quantidade deve ser maior que zero!");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Quantidade inválida!");
                }
            } else if (tipo.equals("Cliente")) {
                String nomeCliente = tableBusca.getValueAt(selectedRow, 2).toString();

                int selectedPedidoRow = tablePedido.getSelectedRow();
                if (selectedPedidoRow >= 0) {
                    modelPedido.setValueAt(nomeCliente, selectedPedidoRow, 3);
                } else {
                    JOptionPane.showMessageDialog(this, "Selecione um item na tabela de pedidos primeiro!");
                }

            }
        }
    }//GEN-LAST:event_btnAdicionarItemActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
        String busca = txtBusca.getText().trim();
        String tipoBusca = cbTipoBusca.getSelectedItem().toString();

        if (!busca.isEmpty()) {
            DefaultTableModel model = (DefaultTableModel) tableBusca.getModel();
            model.setRowCount(0);

            if (tipoBusca.equals("Produto")) {
                ProdutoDao produtoDao = new ProdutoDao();
                List<Produto> produtos = produtoDao.buscarProdutosPorNome(busca);

                if (produtos != null && !produtos.isEmpty()) {
                    for (Produto p : produtos) {
                        model.addRow(new Object[]{
                            "Produto",
                            p.getIdProduto(),
                            p.getNomeProduto(),
                            p.getValor(),});
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhum produto encontrado!");
                }
            } else if (tipoBusca.equals("Cliente")) {
                ClienteDao clientedao = new ClienteDao();
                List<Cliente> clientes = clientedao.buscarPorNome(busca);

                if (clientes != null && !clientes.isEmpty()) {
                    for (Cliente c : clientes) {
                        model.addRow(new Object[]{
                            "Cliente",
                            c.getIdCliente(),
                            c.getNomeCliente(),
                            null,
                            null
                        });
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Nenhum cliente encontrado!");
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Digite um termo para busca!");
        }
    }//GEN-LAST:event_btnBuscarActionPerformed

    private void btnListaItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaItemActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablePedido.getModel();

        if (model.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Não há itens no pedido!",
            "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            ItemPedidoDao itemDao = new ItemPedidoDao();

            for (int i = 0; i < model.getRowCount(); i++) {
                ItemPedido item = new ItemPedido();

                int idPedido = Integer.parseInt(model.getValueAt(i, 0).toString());
                String nomeProduto = model.getValueAt(i, 1).toString();
                double valor = Double.parseDouble(model.getValueAt(i, 2).toString());
                String nomeCliente = model.getValueAt(i, 3).toString();
                int quantidade = Integer.parseInt(model.getValueAt(i, 4).toString());
                double valorTotal= Double.parseDouble(model.getValueAt(i, 5).toString()); ;
              
                item.setIdPedido(idPedido);
                item.setNomeProduto(nomeProduto);
                item.setValor(valor);
                item.setNomeCliente(nomeCliente);
                item.setQuantidade(quantidade);
                item.setValorTotal(valorTotal);
  
                boolean sucesso = itemDao.salvarItemPedido(item);
                if (!sucesso) {
                    JOptionPane.showMessageDialog(this, "Erro ao salvar item do pedido!",
                    "Erro", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao listar pedido: " + e.getMessage(),
            "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnListaItemActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        int selectedRow = tablePedido.getSelectedRow();

        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this,
                    "Selecione um pedido para excluir!",
                    "Aviso",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            int idPedido = (int) tablePedido.getValueAt(selectedRow, 0);

            PedidoDao pedidoDao = new PedidoDao();
            boolean sucesso = pedidoDao.excluirPedido(idPedido);

            if (sucesso) {
                JOptionPane.showMessageDialog(this,
                        "Pedido excluído com sucesso!",
                        "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);

                ((DefaultTableModel) tablePedido.getModel()).removeRow(selectedRow);

                atualizarTabelaPedidos();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Erro ao excluir pedido: " + e.getMessage(),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_btnExcluirActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistroPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarItem;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JButton btnListaItem;
    private javax.swing.JComboBox<String> cbTipoBusca;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblBusca;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblTipoBusca;
    private javax.swing.JTable tableBusca;
    private javax.swing.JTable tablePedido;
    private javax.swing.JTextField txtBusca;
    // End of variables declaration//GEN-END:variables
}
