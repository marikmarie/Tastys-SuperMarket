package Tastys.Product;
public class Groceries implements Item {
    String name;
    int id;
    String category;
    int qty;
    int price;
    Groceries(){
        this.category = "Groceries";
    }
    public void builditem(int id, String name, int qty,int price){
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price= price;
    }
    public int getId(){
        return this.id;
    }
    public String getName(){
        return this.name;
    }
    public String getCategory(){
        return this.category;
    }
    public int getQty(){
        return this.qty;
    }
    public int getPrice(){
        return this.price;
    }
    
}
