package com.nmr.demo.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnectionManager {
    private static String user;
    private static String password;
    private static String url;
    private static Connection conn;
    private static DatabaseConnectionManager databaseConnectionManager_instance;

    private DatabaseConnectionManager(){

    }

    public static DatabaseConnectionManager getInstance(){
        if(databaseConnectionManager_instance == null)
            databaseConnectionManager_instance = new DatabaseConnectionManager();

        return databaseConnectionManager_instance;
    }

    public static Connection getDatabaseConnection(){
        if (conn != null) return conn;

        Properties properties = new Properties();
        try{
            FileInputStream propertyFile = new FileInputStream("src/main/resources/application.properties");
            properties.load(propertyFile);
            user = properties.getProperty("db.user");
            password = properties.getProperty("db.password");
            url = properties.getProperty("db.url");
        } catch (FileNotFoundException e) {
            System.out.println("Filen kunne ikke findes");
            e.printStackTrace();
        } catch (IOException e){
            System.out.println("Proberty kunne ikke loades");
            e.printStackTrace();
        }
        try{
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e){
            System.out.println("Kunne ikke oprette forbindelse til Databasen");
            e.printStackTrace();
        }
        return conn;
    }
}
