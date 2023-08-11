package Tastys.Product;
public interface Item {
    public void builditem(int id, String name,  int qty, int price);
     public int getId();
    public String getName();
    public String getCategory();
    public int getQty();
    public int getPrice();
}
