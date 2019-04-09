/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.*;
import java.util.Properties;

/**
 *
 * @author jaywalker
 */
public class DBConnection {
    private static final String CONNECTION = "jdbc:mysql://127.0.0.1/catalog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String dbClassName = "com.mysql.jdbc.Driver";
    //com.mysql.cj.jdbc.Driver
    private Properties p;
    private Connection c;
    
    public DBConnection() {
        try {
            this.init();
        } catch(Exception e) {
            System.out.println("Could not connect to db: " + e.getMessage());
        }
    }
    
    public void init() throws Exception {
//        Class.forName(dbClassName);
        this.p = new Properties();
        this.p.put("user","endrit");
        this.p.put("password","endrit");
        this.c = DriverManager.getConnection(CONNECTION, this.p);
    }
    
    public Connection getConnection() {
        return this.c;
    }
    
    public void closeConnection() throws Exception {
        this.c.close();
    }
}

