/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Model.Product;
import Service.ProductService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author jaywalker
 */
public class MainFrame extends javax.swing.JFrame {
    
    ArrayList<Product> products;
    DefaultListModel listModel;

    /**
     * Creates new form MainFrame
     */
    public MainFrame() throws Exception {
        initComponents();      
        this.openProductFrame();
        products = new ArrayList<Product>();
        this.loadDataOnList(new ProductService());
        this.getSelectedItem();
        this.filterList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstProducts = new javax.swing.JList<>();
        btnCreateProduct = new javax.swing.JButton();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lstProducts.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstProducts);

        btnCreateProduct.setText("Add Product");

        txtSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnCreateProduct)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnCreateProduct)
                .addGap(41, 41, 41)
                .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchActionPerformed

    public void openProductFrame() {
        this.btnCreateProduct.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {         
                ProductFrame pf = new ProductFrame(MainFrame.this);
                pf.setVisible(true);
            }
        });
    }
    
    public void loadDataOnList(ProductService productService) throws Exception {
        listModel = new DefaultListModel();        
        products = productService.list();
        for (Product p : products) {
            listModel.addElement(p);
        }
        lstProducts.setModel(listModel);
    }
    
    public void getSelectedItem() {
        lstProducts.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent arg0) {
                if (!arg0.getValueIsAdjusting()) {
                    try {
                        int index = lstProducts.getSelectedIndex();
                        System.out.println(products.get(index));
                    } catch(Exception e) {
                        System.out.println("blla: " + e);
                    }
                }
            }
        });
    }
    
    public void filterList() {
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent arg0) {
                search(txtSearch.getText());
                System.out.println("insertUpdate: " + txtSearch.getText());
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                search(txtSearch.getText());
                System.out.println("removeUpdate: " + txtSearch.getText());
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent arg0) {
                System.out.println("changing: " + txtSearch.getText());
            }
        });
    }
    
    private void search(String input) {
        ArrayList<Product> filtered = products;
        if (input.isEmpty())
            return;
        for (int i = 0; i < products.size(); i++) { 
            if (products.get(i).getName().toLowerCase().startsWith(input.toLowerCase())) {
//                filtered.add(products.get(i));
                listModel.addElement(products.get(i));
            } else {
                listModel.removeElement(products.get(i));
            }
//            if (!s.startsWith(filter)) {
//            if (model.contains(s)) {
//                model.removeElement(s);
//            }
//        } else {
//            if (!model.contains(s)) {
//                model.addElement(s);
//            }
//        }
//            if (products.get(i).getName().toLowerCase().startsWith(input) || products.get(i).getDescription().toLowerCase().startsWith(input)) {
//                
//                System.out.println(products.get(i));
//            }
        }
        
//        this.refreshDataOnList(filtered);
        //return filtered;
    }    
    
    private void refreshDataOnList(ArrayList<Product> data) {                      
        for (int i = 0; i < data.size(); i++) {
            listModel.addElement(data.get(i));
        }
        //lstProducts.setModel(listModel);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreateProduct;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstProducts;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
