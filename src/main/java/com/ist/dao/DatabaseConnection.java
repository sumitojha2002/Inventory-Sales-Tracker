package com.ist.dao;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public static Connection getConnection(){
    try{

        Dotenv dotenv = Dotenv.load();
        
        String url = dotenv.get("DB_URL");
        String user = dotenv.get("DB_USER");
        String password = dotenv.get("DB_PASSWORD");
        
        return DriverManager.getConnection(url, user, password);
    }catch(Exception e){
        e.printStackTrace();
        return null;
    }
  }
}
        
