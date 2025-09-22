
package beans;


public class Funcionario {
    private int idFunc;
    private String login;
    private String senha;

    public Funcionario() {
    }

    public Funcionario(int idFunc, String login, String senha) {
        this.idFunc = idFunc;
        this.login = login;
        this.senha = senha;
    }

    public int getIdFunc() {
        return idFunc;
    }

    public void setIdFunc(int ididFunc) {
        this.idFunc = idFunc;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
    
    
}
