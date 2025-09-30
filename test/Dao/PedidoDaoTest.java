
package Dao;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class PedidoDaoTest {
    
    private PedidoDao pedidoDao;
    
    public PedidoDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        pedidoDao= new PedidoDao();
    }
    
    @After
    public void tearDown() {  
    }

    @Test
    public void testarQuantidadePedido(){
        var quantidadePedido= pedidoDao.listarTodos().size();
         assertEquals(quantidadePedido,5);
               
    }

    
    
    
}
