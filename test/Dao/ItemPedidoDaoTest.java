
package Dao;

import beans.ItemPedido;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class ItemPedidoDaoTest {
    private ItemPedidoDao itemDao;
    
    public ItemPedidoDaoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        itemDao= new ItemPedidoDao();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void calcularValorTotal(){
        double resultado=itemDao.calcularValorTotal(10.0, 2);
        assertEquals(20.0,resultado,0.001);
       
    }
   
    
}
