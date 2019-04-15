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
public class UpdatedBy {
    private int id;
    private String name;
    
    public UpdatedBy(){}
    
    public UpdatedBy(String name) {       
        this.id = (int)(Math.random() * 1000);
        this.name = name;
    }
    
    public UpdatedBy(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
