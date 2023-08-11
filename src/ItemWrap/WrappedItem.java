package ItemWrap;
import Tastys.Product.Item;

public class WrappedItem extends ItemWrapping {
    private final int wrappingprice = 1000;
    private int newPrice;
    public WrappedItem(Item item){
        super(item);
    }
    
    @Override
    public int getPrice() {
        newPrice = item.getPrice() + wrappingprice;
        return newPrice;
    }
}
