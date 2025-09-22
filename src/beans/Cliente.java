
package beans;


public class Cliente {
    public int idCliente;
    public String nomeCliente;
    public String telefone;
    public String email;
    public String endereco;
    

    public Cliente() {
    }

    public Cliente(int idCliente, String nomeCliente, String telefone, String email, String endereco) {
        this.idCliente= idCliente;
        this.nomeCliente = nomeCliente;
        this.telefone = telefone;
        this.email = email;
        this.endereco= endereco;
        
    }

    public Cliente(String endereco) {
        this.endereco = endereco;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    
}
