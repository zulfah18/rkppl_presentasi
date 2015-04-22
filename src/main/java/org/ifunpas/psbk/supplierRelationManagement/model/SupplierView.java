/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.model;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.ifunpas.psbk.supplierRelationManagement.database.SupplierDb;

/**
 *
 * @author saeful rizky
 */
@ManagedBean(name = "supplierView")
@ViewScoped
public class SupplierView {

    private String supplierName;
    private List<String> supplierNames;
    private List<String> supplierId;

    @PostConstruct
    public void initSuppliers() {
        List<Supplier> suppliers = new SupplierDb().getSupplier();
        supplierNames = new ArrayList<>();
        supplierId = new ArrayList<>();
        for (Supplier supplier : suppliers) {
            supplierNames.add(supplier.getSupplierName());
            supplierId.add(supplier.getSupplierId());
        }
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public List<String> getSupplierNames() {
        return supplierNames;
    }

    public List<String> getSupplierId() {
        return supplierId;
    }

}
