package Home;

public class Cash {

    private int id;
    private String name;
   
    private String email;
    private String password;
    
    public Cash(int id,String name,String email, String password)
    {
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
        
    }
            
    public int getid()
    {
        return id;
    }
    public String getname()
    {
        return name;
    }
 
    public String getemail()
    {
        return email;
    }
    public String getpassword()
    {
        return password;
    }
}
