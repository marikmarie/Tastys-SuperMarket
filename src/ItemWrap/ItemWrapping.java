package ItemWrap;
import Tastys.Product.Item;

public abstract class ItemWrapping implements Item {
    protected Item item;
    
    public ItemWrapping (Item item){
        this.item = item;
    }

    @Override
    public String getName() {
        return item.getName();
    }

    @Override
    public String getCategory() {
        return item.getCategory();
    }

    @Override
    public int getId() {
       return item.getId();
    }
    public int getQty(){
        return item.getQty();
    }

    @Override
    public int getPrice() {
        return item.getPrice();
    }

    @Override
    public void builditem(int id, String name, int qty, int price) {
        item.builditem( id, name,qty, price);
    }
}
