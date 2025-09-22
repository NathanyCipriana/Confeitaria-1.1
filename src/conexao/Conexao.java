
package conexao;

import java.sql.Connection;
import java.sql.DriverManager;


public class Conexao {
    

    public static Connection getConexao() {

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost/ confeitaria ", 
                    "root", 
                    "ayla0702"
            );
            return conn;

        } catch (Exception e) {
            System.out.println("Erro ao conectar: " + e.getMessage());
            return null;
        }
    }
    
    
}
