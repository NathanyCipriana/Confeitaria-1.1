
package beans;


public class Pedido {
     int idPedido;
     String nomeProduto;
     String nomeCliente;
     double valor;
     int quantidade;
     double valorTotal;

    public Pedido() {
        
    }

    public Pedido(int idPedido, String nomeProduto, String nomeCliente, double valor, int quantidade, double valorTotal) {
        this.idPedido = idPedido;
        this.nomeProduto = nomeProduto;
        this.nomeCliente = nomeCliente;
        this.valor = valor;
        this.quantidade = quantidade;
        this.valorTotal = valor * quantidade;
    }

    public int getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(int idPedido) {
        this.idPedido = idPedido;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        this.valorTotal = this.valor * this.quantidade;
    }
    
    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    }
