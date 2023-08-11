package Home;

/**
 *
 * @author MARIAM
 */
public class Stock {

    private String id;
    private String name;
    private double price;
    private int quantity;
    
    public Stock(String id,String name,double price, int quantity)
    {
        this.id=id;
        this.name=name;
        this.price=price;
        this.quantity=quantity;
        
        
    }
            
    public String getid()
    {
        return id;
    }
    public String getname()
    {
        return name;
    }
    public double getprice()
    {
        return price;
    }
    public int getquantity()
    {
        return quantity;
    }

   
  }
