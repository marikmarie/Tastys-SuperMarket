package Test;
import Tastys.Product.ProductFactory;
import Tastys.Product.Item;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.Test;
public class ItemfactoryTest {

    @Test
    public void testGetItemCategory() {
        ProductFactory itemFactory = new ProductFactory();

      

        // Test getting an electronic item
        Item electronicItem = itemFactory.getItemCategory("Electronics");
        assertEquals("Electronics", electronicItem.getCategory());

        // Test getting a grocery item
        Item groceryItem = itemFactory.getItemCategory("Groceries");
        assertEquals("Groceries", groceryItem.getCategory());

        // Test getting an unknown item category
        Item unknownItem = itemFactory.getItemCategory("Unknown");
        assertNull(unknownItem);
    }
}
