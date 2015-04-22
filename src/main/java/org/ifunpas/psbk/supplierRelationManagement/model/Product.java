/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import org.ifunpas.psbk.supplierRelationManagement.database.ProductDb;

/**
 *
 * @author saeful rizky
 */
@ManagedBean(name = "product")
@ApplicationScoped
public class Product {
    
    private String productId;
    private String productName;
    private int productPrice;
    private String supplierId;
    private ProductDb productDb;
    private ButtonView buttonView;
    
    public Product() {
    }
    
    public Product(String productId, String productName, int productPrice, String SupplierId) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.supplierId = SupplierId;
    }
    
    public String getProductId() {
        return productId;
    }
    
    public void setProductId(String productId) {
        this.productId = productId;
    }
    
    public String getProductName() {
        return productName;
    }
    
    public void setProductName(String productName) {
        this.productName = productName;
    }
    
    public int getProductPrice() {
        return productPrice;
    }
    
    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    
    public String getSupplierId() {
        return supplierId;
    }
    
    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }
    
    public void insertDataProduct() {
        productDb = new ProductDb();
        productDb.insertProduct(productId, productName, productPrice, supplierId);
    }
    
    public void deleteDataProduct(String productId) {
        productDb = new ProductDb();
        productDb.deleteProduct(productId);
    }
}
