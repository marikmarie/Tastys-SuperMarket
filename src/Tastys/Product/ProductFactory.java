package Tastys.Product;

public class ProductFactory {
public Item getItemCategory(String category) {
        if ("Electronics".equalsIgnoreCase(category)) {
            return new Electronics();
        } else if ("Clothing".equalsIgnoreCase(category)) {
            return new Clothing();
        } else if ("Groceries".equalsIgnoreCase(category)) {
            return new Groceries();
        }
        return null;
    }

}
