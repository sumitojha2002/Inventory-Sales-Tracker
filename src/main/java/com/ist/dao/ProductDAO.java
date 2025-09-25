package com.ist.dao;

import com.ist.models.Product;
import com.ist.dao.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // 1. Insert a new product into the db
    public boolean addProduct(Product product){
        String query = "INSERT INTO products (name,category,quantity,price) VALUES (?,?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstat = conn.prepareStatement(query)){
                pstat.setString(1, product.getName());
                pstat.setString(2, product.getCategory());
                pstat.setInt(3,product.getQuantity());
                pstat.setDouble(4, product.getPrice());

                int rowsInserted = pstat.executeUpdate();
                if(rowsInserted>0){
                    return true;
                }else{
                    return false;
                }
            }catch(SQLException e){
                e.printStackTrace();
                return false;
            }
    }

    // 2. Update existing product by id
    public boolean updateProduct(Product product){
        String query = "UPDATE products SET name=?, category=?, quantity=?, price=? WHERE id = ?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstat = conn.prepareStatement(query)){
            pstat.setString(1, product.getName());
            pstat.setString(2, product.getCategory());
            pstat.setInt(3, product.getQuantity());
            pstat.setDouble(4, product.getPrice());
            pstat.setInt(5,product.getId());

            int rowsUpdated = pstat.executeUpdate();
            if(rowsUpdated>0){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    // 3. Delete a product by ID

    public boolean deleteProduct(int id){
        String query = "DELETE FROM products WHERE id = ?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstat = conn.prepareStatement(query)){
            pstat.setInt(1, id);
            int result = pstat.executeUpdate();
            if(result>0){
                return true;
            }else{
                return false;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    // 4. get a product by id
    public Product getProduct(Product product){
        String query = "SELECT * FROM products WHERE id=?";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstat = conn.prepareStatement(query)){
            pstat.setInt(1, product.getId());
            ResultSet rs = pstat.executeQuery();
            if(rs.next()){
               int id = rs.getInt("id");
               String name = rs.getString("name");
               String category = rs.getString("category");
               int quantity = rs.getInt("quantity");
               double price = rs.getDouble("price");
               Product product2 = new Product(name, category, quantity, price);
               product2.setId(id);
               return product2;
            }else{
                return null;
            }
        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    // 5. Get all products 
    public List<Product> getAllProducts(){
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM products";
        
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstat = conn.prepareStatement(query)){
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String category = rs.getString("category");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                Product product = new Product(name, category, quantity, price);
                product.setId(id);
                list.add(product);
            }
            return list;
        }catch(SQLException e){
            e.printStackTrace();
            return list;
        }   
    }

    // 6. Optional: check stock or search by name/category
    public List<Product> searchProducts(String keyword){
        String query = "SELECT * FROM products WHERE name LIKE ? OR CATEGORY LIKE ?";
        List<Product> products = new ArrayList<>();

        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstat = conn.prepareStatement(query)){
            pstat.setString(1,"%"+keyword+"%");
            pstat.setString(2,"%"+keyword+"%");
            
            ResultSet rs = pstat.executeQuery();
            
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String category = rs.getString("category");
                double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                Product product = new Product(name, category, quantity, price);
                product.setId(id);
                products.add(product);
            }
            return products;
        }catch(SQLException e){
            e.printStackTrace();
            return products;
        }
    }
}
