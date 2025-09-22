package telas;

import Dao.ProdutoDao;
import beans.Produto;
import java.awt.Image;
import java.util.List;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class CadastroProduto extends javax.swing.JFrame {

    public CadastroProduto() {
        initComponents();
        preencherTabela();
    }

    private void preencherTabela() {
        try {
            ProdutoDao pdao = new ProdutoDao();

            String buscaProduto = txtNomeproduto.getText();
            List<Produto> listaProduto = pdao.buscarProdutosPorNome(buscaProduto);

            DefaultTableModel tabelaProduto = (DefaultTableModel) tableProduto.getModel();

            tableProduto.setRowSorter(new TableRowSorter<>(tabelaProduto));

            if (listaProduto != null) {
                for (Produto p : listaProduto) {
                    tabelaProduto.addRow(new Object[]{
                        p.getIdProduto(),
                        p.getNomeProduto(),
                        p.getDescricao(),
                        p.getValor()
                    });
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum produto encontrado!");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar produtos: " + e.getMessage(),
                    "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        btnAdicionar = new javax.swing.JButton();
        lblNomeproduto = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblDescricao = new javax.swing.JLabel();
        txtNomeproduto = new javax.swing.JTextField();
        lblValor = new javax.swing.JLabel();
        txtValor = new javax.swing.JTextField();
        btnLista = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableProduto = new javax.swing.JTable();
        btnVoltar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tela Cadastro de produto"));

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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 170));

        btnExcluir.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        getContentPane().add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 120, 30));

        btnAdicionar.setBackground(new java.awt.Color(153, 204, 255));
        btnAdicionar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnAdicionar.setText("Adicionar");
        btnAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarActionPerformed(evt);
            }
        });
        getContentPane().add(btnAdicionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 280, 120, 40));

        lblNomeproduto.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblNomeproduto.setText("Nome do produto:");
        getContentPane().add(lblNomeproduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, -1, 30));

        txtDescricao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescricaoActionPerformed(evt);
            }
        });
        getContentPane().add(txtDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 390, 30));

        jLabel2.setFont(new java.awt.Font("Helvetica Neue", 0, 24)); // NOI18N
        jLabel2.setText("Cadastro de produto");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 180, -1, -1));

        lblDescricao.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblDescricao.setText("Descrição:");
        getContentPane().add(lblDescricao, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, -1, 30));

        txtNomeproduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNomeprodutoActionPerformed(evt);
            }
        });
        getContentPane().add(txtNomeproduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 230, 290, 30));

        lblValor.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        lblValor.setText("Valor:");
        getContentPane().add(lblValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, -1, 30));

        txtValor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtValorActionPerformed(evt);
            }
        });
        getContentPane().add(txtValor, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 230, 163, 33));

        btnLista.setBackground(new java.awt.Color(204, 204, 0));
        btnLista.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnLista.setText("Listagem de pedidos");
        btnLista.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaActionPerformed(evt);
            }
        });
        getContentPane().add(btnLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 550, 180, 40));

        tableProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NomeProduto", "Descrição", "Valor"
            }
        ));
        jScrollPane1.setViewportView(tableProduto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 210, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 760, 210));

        btnVoltar.setFont(new java.awt.Font("Helvetica Neue", 0, 18)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, 120, 30));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String excluirProduto = txtNomeproduto.getText();

        ProdutoDao pdao = new ProdutoDao();

        Object[] opcoes = {"SIM", "NAO"};
        int confirma = JOptionPane.showOptionDialog(null, "Tem certeza?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoes, opcoes[0]);

        if (confirma == 0) {

            pdao.excluirProduto(excluirProduto);
            JOptionPane.showMessageDialog(null, "Produto excluído com sucesso!");

        } else {
            JOptionPane.showMessageDialog(null, "CANCELAMENTO EXCLUÍDO COM SUCESSO");
        }

        //limpando os campos
        txtNomeproduto.setText("");
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarActionPerformed
        try {
            String nomeProduto = txtNomeproduto.getText();
            String descricao = txtDescricao.getText();
            double valor = Double.parseDouble(txtValor.getText());

            Produto p = new Produto();

            p.setNomeProduto(nomeProduto);
            p.setDescricao(descricao);
            p.setValor(valor);

            ProdutoDao dao = new ProdutoDao();
            dao.cadastrarProduto(p);

            txtNomeproduto.setText("");
            txtDescricao.setText("");
            txtValor.setText("");

            preencherTabela();

            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao cadastrar: " + e.getMessage());
        }

    }//GEN-LAST:event_btnAdicionarActionPerformed

    private void txtDescricaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescricaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescricaoActionPerformed

    private void txtNomeprodutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeprodutoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeprodutoActionPerformed

    private void txtValorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtValorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtValorActionPerformed

    private void btnListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaActionPerformed
        RegistroPedido rp = new RegistroPedido();
        rp.setVisible(true);
    }//GEN-LAST:event_btnListaActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        Telaprincipal principal = new Telaprincipal();
        principal.setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProduto().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnLista;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDescricao;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JLabel lblNomeproduto;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tableProduto;
    private javax.swing.JTextField txtDescricao;
    private javax.swing.JTextField txtNomeproduto;
    private javax.swing.JTextField txtValor;
    // End of variables declaration//GEN-END:variables
}
