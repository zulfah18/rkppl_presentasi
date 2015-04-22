/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ifunpas.psbk.supplierRelationManagement.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import org.ifunpas.psbk.supplierRelationManagement.model.Product;

/**
 *
 * @author saeful rizky
 */
@ManagedBean(name = "productDb")
@ApplicationScoped
public class ProductDb {

    public List<Product> getProduct() {
        List<Product> products = null;
        Connection connection = DBConnection.connect();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM \"Product\"");
            products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product();
                product.setProductId(resultSet.getString("pd_id"));
                product.setProductName(resultSet.getString("pd_name"));
                product.setProductPrice(resultSet.getInt("pd_price"));
                product.setSupplierId(resultSet.getString("sp_id"));
                products.add(product);
            }
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
        return products;
    }

    public void insertProduct(String productId, String productName, int productPrice, String supplierId) {
        Connection connection = DBConnection.connect();
        try {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Product\" VALUES (?,?,?,?)");
            statement.setString(1, productId);
            statement.setString(2, productName);
            statement.setInt(3, productPrice);
            statement.setString(4, supplierId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

    public void deleteProduct(String productId) {
        Connection connection = DBConnection.connect();
        try {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM \"Product\" WHERE \"pd_id\" = ?");
            statement.setString(1, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

    public void updateProduct(String productId, String productName, int productPrice, String supplierId) {
        Connection connection = DBConnection.connect();
        try {
            PreparedStatement statement = connection.prepareStatement("UPDATE \"Product\" SET \"pd_name\" = ?, \"pd_price\" = ?, \"sp_id\" = ? WHERE \"pd_id\" = ?");
            statement.setString(1, productName);
            statement.setInt(2, productPrice);
            statement.setString(3, supplierId);
            statement.setString(4, productId);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.err.println(e);
        } finally {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.err.println(ex);
            }
        }
    }

    public static void main(String[] args) {
        ProductDb pd = new ProductDb();
        List<Product> products = pd.getProduct();
        for (Product product : products) {
            System.out.println(product.getProductId()+", "+product.getProductName()+", "+product.getProductPrice()+", "+product.getSupplierId());
        }
//        pd.insertProduct("5", "Kecap Sedap", 11000, "1");
//        pd.deleteProduct("5");
//        pd.updateProduct("4", "Downy", 10000, "2");
    }
}
