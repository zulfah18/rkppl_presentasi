/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.model;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 *
 * @author saeful rizky
 */
@ManagedBean(name = "buttonView")
@ViewScoped
public class ButtonView {
    
    public void save(ActionEvent actionEvent) {
        addMessage("Data saved");
    }
    
    public void update(ActionEvent actionEvent) {
        addMessage("Data updated");
    }
    
    public void delete(ActionEvent actionEvent) {
        addMessage("Data deleted");
    }
    
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
