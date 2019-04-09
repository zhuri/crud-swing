/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author jaywalker
 */
public class Order {
    private int id;
    private ArrayList<Product> products;
    private Date date;
    
    public Order() {
        this.products = new ArrayList<Product>();
    }

    public int getId() {
        return this.id;
    }
    
    public ArrayList<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    
}
