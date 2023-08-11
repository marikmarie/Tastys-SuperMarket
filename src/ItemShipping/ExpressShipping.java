package ItemShipping;

import Tastys.Product.Item;


public abstract class ExpressShipping implements Item {
     protected Item item;
    
    public ExpressShipping (Item item){
        this.item = item;
    }

    public String getName() {
        return item.getName();
    }

    public String getCategory() {
        return item.getCategory();
    }

    public int getId() {
       return item.getId();
    }

    public int getPrice() {
        return item.getPrice();
    }
    public void builditem(int id, String name, int qty, int price) {
        item.builditem(  id, name,qty, price);
    }
}
