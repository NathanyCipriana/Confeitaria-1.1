package telas;

import java.awt.Image;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Telaprincipal extends javax.swing.JFrame {

    public Telaprincipal() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblLogo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnRegPedido = new javax.swing.JButton();
        btnCatProduto = new javax.swing.JButton();
        btnCadCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(840, 529));
        setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tela de catalogos"));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblLogo.setFont(new java.awt.Font("Shree Devanagari 714", 0, 36)); // NOI18N
        lblLogo.setText("Confeitaria Pequena Flor");
        jPanel1.add(lblLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 41, 420, 52));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/bolo.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(503, 47, 120, 112));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 180));

        btnRegPedido.setBackground(new java.awt.Color(153, 204, 255));
        btnRegPedido.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        btnRegPedido.setText("Registro  pedidos");
        btnRegPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegPedidoActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegPedido, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 250, 210, 250));

        btnCatProduto.setBackground(new java.awt.Color(153, 204, 255));
        btnCatProduto.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        btnCatProduto.setText("Catálogo produtos");
        btnCatProduto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCatProdutoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCatProduto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, 210, 250));

        btnCadCliente.setBackground(new java.awt.Color(153, 204, 255));
        btnCadCliente.setFont(new java.awt.Font("Helvetica Neue", 0, 20)); // NOI18N
        btnCadCliente.setText("Cadastro clientes");
        btnCadCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadClienteActionPerformed(evt);
            }
        });
        getContentPane().add(btnCadCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 250, 210, 250));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegPedidoActionPerformed
        RegistroPedido rp = new RegistroPedido();
        rp.setVisible(true);
    }//GEN-LAST:event_btnRegPedidoActionPerformed

    private void btnCatProdutoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCatProdutoActionPerformed
        CadastroProduto telaCatalogo = new CadastroProduto();
        telaCatalogo.setVisible(true);
    }//GEN-LAST:event_btnCatProdutoActionPerformed

    private void btnCadClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadClienteActionPerformed
        CadastroCliente telaCliente = new CadastroCliente();
        telaCliente.setVisible(true);
    }//GEN-LAST:event_btnCadClienteActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Telaprincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadCliente;
    private javax.swing.JButton btnCatProduto;
    private javax.swing.JButton btnRegPedido;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblLogo;
    // End of variables declaration//GEN-END:variables
}
