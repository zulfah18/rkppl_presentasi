/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.model;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import org.ifunpas.psbk.supplierRelationManagement.database.ProductDb;

/**
 *
 * @author saeful rizky
 */
@ManagedBean(name = "productView")
@ViewScoped
public class ProductView implements Serializable{

    private List<Product> products;
    private Product product;
    
    @ManagedProperty("#{productDb}")
    private ProductDb productDb;

    @PostConstruct
    public void initProduct() {
        products = productDb.getProduct();
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ProductDb getProductDb() {
        return productDb;
    }

    public void setProductDb(ProductDb productDb) {
        this.productDb = productDb;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}