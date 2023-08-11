package Tastys.Product;
public class Product{
    private String name;
    private int id;
    private String category;
    private int qty;
    private int price;
    public Product(int id, String name,  String category, int qty, int price){ 
        this.id = id;
        this.name = name;
        this.category = category;
        this.qty = qty;
        this.price = price;
    }

    public String getName(){
        return this.name;
    }
    
    public int getId(){
        return this.id;
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