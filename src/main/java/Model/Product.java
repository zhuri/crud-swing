/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author jaywalker
 */
public class Product {
    private int id;
    private String name;
    private String description;
    private int qty;
    private UpdatedBy updatedBy;
    
    public Product(){}
    
    public Product(int id, String name, String description, int qty) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.qty = qty;
    }    
    
    public void setUpdatedBy(UpdatedBy updatedBy) {
        this.updatedBy = updatedBy;
    }
    
    public int getUpdatedBy() {
        return this.updatedBy.getId();
    }
    
    public String getUpdatedByName() {
        return this.updatedBy.getName();
    }
    
    public int getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return String.format("Id: %d, Name: %s, Description: %s", this.id, this.name, this.description, this.qty);       
    }
}
