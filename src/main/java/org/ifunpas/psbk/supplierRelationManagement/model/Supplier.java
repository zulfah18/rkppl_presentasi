/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.model;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author saeful rizky
 */
@ManagedBean(name="supplier")
@ViewScoped
public class Supplier {

    private String supplierId;
    private String supplierName;
    private String supplierAddress;

    public Supplier() {
    }

    public Supplier(String supplierId, String supplierName, String supplierAddress) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.supplierAddress = supplierAddress;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }
        
}
