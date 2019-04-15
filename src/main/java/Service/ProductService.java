/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Data.DBConnection;
import Model.Product;
import Model.UpdatedBy;
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
        String query = "SELECT p.*, ub.id as ub_id, ub.name as ub_name FROM catalog.product as p left join updatedBy as ub\n" +
"on p.updatedBy_id = ub.id;;";
        Connection c = this.conn.getConnection();
        
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        ArrayList<Product> products = new ArrayList<>();
        while(rs.next()) {
            int id = rs.getInt("id");
            String description = rs.getString("description");
            String name = rs.getString("name");
            int qty = rs.getInt("qty");
            int updatedById = rs.getInt("ub_id");
            String ubName = rs.getString("ub_name");
            
            Product prod = new Product(id, name, description, qty);
            prod.setUpdatedBy(new UpdatedBy(updatedById, ubName));
            products.add(prod);
        }
        this.conn.closeConnection();
        return products;
    }
    
    public Product list(Product p) throws SQLException, Exception {
        int pId = p.getId();
        String query = "select * from product where id = " + pId + ";";
        Connection c = this.conn.getConnection();
        
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        Product product = null;
        while(rs.next()) {
            int id = rs.getInt("id");
            String description = rs.getString("description");
            String name = rs.getString("name");
            int qty = rs.getInt("qty");
            
            product = new Product(id, name, description, qty);
        }
        this.conn.closeConnection();
        return product;
    }
    
    public void update(Product p) throws SQLException {
        String query = "update product set name = ?, description = ?, updatedBy_id = ?, qty = ? where id = ?;";
        Connection c = this.conn.getConnection();
        PreparedStatement prepSt = c.prepareStatement(query);
        prepSt.setString(1, p.getName());
        prepSt.setString(2, p.getDescription());
        prepSt.setInt(3, p.getUpdatedBy());
        prepSt.setInt(4, p.getQty());
        prepSt.setInt(5, p.getId());
        
        prepSt.execute();
    }
    
    public void delete(Product p) {
        
    }
}
