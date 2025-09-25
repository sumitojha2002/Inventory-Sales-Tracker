package com.ist.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.ist.models.Sale;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class SaleDAO {
    
    public boolean addSale(Sale sale){
        String query = "INSERT into sales(product_id, sales_date, quantity) VALUES(?,?,?)";
        try(Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstat = conn.prepareStatement(query)){
            pstat.setInt(1,sale.getProductId());
            pstat.setTimestamp(2, Timestamp.valueOf(sale.getSaleDate()));
            pstat.setInt(3,sale.getQuantity());

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

    public List<Sale> getAllSales(){
        String query = "SELECT * FROM sales";
        List<Sale> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstat = conn.prepareStatement(query)){
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                int id = rs.getInt("id");
                int productId = rs.getInt("product_id");
                LocalDateTime saleDate = rs.getTimestamp("sales_date").toLocalDateTime();
                int quantity = rs.getInt("quantity");
                Sale sale = new Sale(productId, quantity, saleDate);
                sale.setId(id);
                list.add(sale);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public boolean deleteSale(int id){
        String query = "DELETE FROM sales WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstat = conn.prepareStatement(query)){
            pstat.setInt(1, id);
            int statement = pstat.executeUpdate();
            if(statement>0){
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Sale getSaleById(int id){
        String query = "SELECT * FROM sales WHERE id =?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstat = conn.prepareStatement(query)){
            pstat.setInt(1, id);
            ResultSet rs = pstat.executeQuery();
            
            if(rs.next()){
                int sid = rs.getInt("id");
                int spid = rs.getInt("product_id");
                LocalDateTime sldt = rs.getTimestamp("sales_date").toLocalDateTime();
                int squantity = rs.getInt("quantity");
                Sale sale = new Sale(spid, squantity, sldt);
                sale.setId(sid);
                return sale;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean updateSale(Sale sale){
        String queue ="UPDATE sales SET product_id=?,sales_date=?, quantity =? WHERE id=?";
        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstat = conn.prepareStatement(queue)){
            pstat.setInt(1,sale.getProductId());
            pstat.setTimestamp(2, Timestamp.valueOf(sale.getSaleDate()));
            pstat.setInt(3,sale.getQuantity());
            pstat.setInt(4,sale.getId());

            int statement = pstat.executeUpdate();
            if(statement>0){
                return true;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
