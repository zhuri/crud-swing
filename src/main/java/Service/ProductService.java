/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Data.DBConnection;
import Model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jaywalker
 */
public class ProductService {
    private DBConnection conn;
    
    public ProductService() {
        this.conn = new DBConnection();
    }
    
    public void create(Product p) throws SQLException, Exception {
        String query = "insert into product(name, description, qty) values (?,?,?);";
        Connection c = this.conn.getConnection();
        PreparedStatement prepSt = c.prepareStatement(query);
        prepSt.setString(1, p.getName());
        prepSt.setString(2, p.getDescription());
        prepSt.setInt(3, p.getQty());
        
        prepSt.execute();
//        this.conn.closeConnection();
    }
    
    public ArrayList<Product> list() throws SQLException, Exception {
        String query = "select * from product;";
        Connection c = this.conn.getConnection();
        
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        ArrayList<Product> products = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt("id");
            String description = rs.getString("description");
            String name = rs.getString("name");
            int qty = rs.getInt("qty");
            
            products.add(new Product(id, name, description, qty));
        }
        this.conn.closeConnection();
        return products;
    }
    
    public void update(Product p) {
        
    }
    
    public void delete(Product p) {
        
    }
}
