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

/**
 *
 * @author jaywalker
 */
public class UpdatedByService implements UpdatedByInterface {
    DBConnection conn;
    
    public UpdatedByService() {
        this.conn = new DBConnection();
    }
    
    public void create(UpdatedBy u) throws SQLException, Exception {
        UpdatedBy exists = list(u);
        String query = null;
        if (exists != null) {
            query = "updated updatedBy set name = ? where id = ?;";
        } else {
            query = "insert into updatedBy(id, name) values (?, ?);";
        }        
        Connection c = this.conn.getConnection();
        PreparedStatement prepSt = c.prepareStatement(query);
        prepSt.setInt(1, u.getId());    
        prepSt.setString(2, u.getName());       
        
        prepSt.execute();
    }
    
    public UpdatedBy list(UpdatedBy u) throws SQLException, Exception {
        int uId = u.getId();
        String query = "select * from updatedBy where id = " + uId + ";";
        Connection c = this.conn.getConnection();
        
        Statement st = c.createStatement();
        ResultSet rs = st.executeQuery(query);
        
        UpdatedBy updatedBy = null;
        while(rs.next()) {
            int id = rs.getInt("id");           
            String name = rs.getString("name");           
            
            updatedBy = new UpdatedBy(id, name);
        }
        return updatedBy;
    }
}
