package Test;
import Tastys.Product.ProductCatalog;
import Tastys.Product.Product;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;

public class CatalogTest {
    private ProductCatalog productCatalog;
    
    @Test
    public void setUp() {
        productCatalog = ProductCatalog.getInstance();
    }
    
    @Test
    public void testGetInstance() {
        assertNotNull(productCatalog);
    }
    
    @Test
    public void testGetProducts() {
        ArrayList<Product> products = productCatalog.getProducts();
        assertNotNull(products);
        assertEquals(8, products.size());
    }
    
    @Test
    public void testProductDetails() {
        ArrayList<Product> products = productCatalog.getProducts();
        Product firstProduct = products.get(0);
        assertEquals("TV", firstProduct.getName());
    }
}
