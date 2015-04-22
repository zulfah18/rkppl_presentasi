/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author saeful rizky
 */
public class DBConnection {

    public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost/SupplierRelationManagement_DB", "postgres", "saeful");
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println(e);
        }
        return connection;
    }
    
}
