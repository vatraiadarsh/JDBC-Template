/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.jdbcmysql;

import com.ada.jdbcmysql.entity.Category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author vatrai
 */
public class Program {

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cmj", "root", "");
            String sql = "INSERT INTO categories(name,status)" + "values(?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            Category category = new Category(0, "Sprite", true);
            stmt.setString(1, category.getName());
            stmt.setBoolean(2, category.isStatus());
            System.out.println(stmt.executeUpdate());
            conn.close();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
