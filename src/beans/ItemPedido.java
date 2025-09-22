
package beans;

public class ItemPedido {
    public int idItemPedido;
    public int idPedido;
    public String nomeProduto;
    public double valor;
    public String nomeCliente;
    public int quantidade;
    public double valorTotal;

    public ItemPedido() {
        
    }

    public ItemPedido(int idItemPedido, int idPedido,String nomeProduto,double valor,String nomeCliente, int quantidade, double valorTotal) {
        this.idItemPedido = idItemPedido;
        this.idPedido = idPedido;
        this.nomeProduto = nomeProduto;
        this.valor = valor;
        this.nomeCliente = nomeCliente;
        this.quantidade = quantidade;
        this.valorTotal = valor * quantidade;
    }

    public int getIdItemPedido() {
        return idItemPedido;
    }

    public void setIdItemPedido(int idItemPedido) {
        this.idItemPedido = idItemPedido;
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

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
        this.valorTotal = this.valor * this.quantidade;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
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
