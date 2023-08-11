package Tastys.Product;

import java.sql.*;
import java.util.ArrayList;

public class ProductCatalog {

    private static ProductCatalog instance = new ProductCatalog();
    private ArrayList<Product> products;
    //Create a constructor

    private ProductCatalog() {
        products = new ArrayList<>();
        String urlstring = "jdbc:mysql://localhost:3306/tasty's";
        String driverName = "com.mysql.cj.jdbc.Driver";
        String username = "root";
        String password = "";
        String sql = "SELECT * FROM catalog";
        Connection con = null;
        Statement stmt = null;
        try {
            Class.forName(driverName);
            try {
                con = DriverManager.getConnection(urlstring, username, password);
                stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");

                    String category = rs.getString("category");
                    int qty = rs.getInt("qty");
                    int price = rs.getInt("price");

                    Product product = new Product(id, name, category , qty, price);
                    products.add(product);
                }
                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException ex) {
                System.out.println("Failed to create the database connection.");
            }
        } catch (ClassNotFoundException ex) {
            System.out.println("Driver not found.");
        }
    }

    public static ProductCatalog getInstance() {
        return instance;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

}
