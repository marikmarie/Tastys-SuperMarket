package Tastys.Product;
public class SalesPerson implements Observer {
    private String name;

    public SalesPerson(String name) {
        this.name = name;
    }
    
    @Override
    public String update() {
        return "Item successfully added to cart";
    }

 
}
