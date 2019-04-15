/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Data.DBConnection;
import Model.Order;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jaywalker
 */
public class OrderService {
    DBConnection conn;
    
    public OrderService() {
        this.conn = new DBConnection();
    }
    
    public void create(Order o) throws SQLException {
        String query = "insert into orders(name, product_id) values (?,?);";
        Connection c = this.conn.getConnection();
        PreparedStatement prepSt = c.prepareStatement(query);
        prepSt.setString(1, o.getName());
        prepSt.setInt(2, o.getProductId());        
        
        prepSt.execute();
    }
    
    public void list() {
        
    }
    
    public void update(Order o) {
        
    }
    
    public void delete(Order o) {
        
    }
}
