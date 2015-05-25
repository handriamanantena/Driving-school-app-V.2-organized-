/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package organizeapp.controller.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author harrison
 */
public class Database {

    private static Database instance = new Database();
    private String url = "jdbc:mysql://localhost:3306/test";
    private Connection con;

    private Database() {

    }

    public String getUrl() {
        return url;
    }

    public Connection getCon() {
        return con;
    }

    public static Database getInstance() {
        return instance;
    }

    public void connect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
       // con = DriverManager.getConnection(url, "root", "root");     
       // PreparedStatement statement = con.prepareStatement("select * from student_list");
        //ResultSet result = statement.executeQuery();
        
       // while (result.next()) {
        //   System.out.println(result.getString(1) + " " + result.getString(3));
       // }

    }

    public void disconnect() throws SQLException {
        con.close();
    }
}
