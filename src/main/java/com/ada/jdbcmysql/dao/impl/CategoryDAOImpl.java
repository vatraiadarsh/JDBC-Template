/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.jdbcmysql.dao.impl;

import com.ada.jdbcmysql.dao.CategoryDAO;
import com.ada.jdbcmysql.entity.Category;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vatra
 */
public class CategoryDAOImpl implements CategoryDAO {
    
    @Override
    public int insert(Category c) throws ClassNotFoundException, SQLException {
        int result;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cmj", "root", "")) {
            String sql = "INSERT INTO categories(name,status)" + "values(?,?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getName());
            stmt.setBoolean(2, c.isStatus());
            result = stmt.executeUpdate();
        }
        return result;
    }
    
    @Override
    public int update(Category c) throws ClassNotFoundException, SQLException {
        int result;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cmj", "root", "")) {
            String sql = "UPDATE categories set name=?, modified_date= CURRENT_TIMESTAMP, status=? where id=? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, c.getName());
            stmt.setBoolean(2, c.isStatus());
            stmt.setInt(3, c.getId());
            result = stmt.executeUpdate();
        }
        return result;
    }
    
    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
        int result;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cmj", "root", "")) {
            String sql = "DELETE FROM categories where id=? ";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            result = stmt.executeUpdate();
        }
        return result;
    }
    
    @Override
    public List<Category> getAll() throws ClassNotFoundException, SQLException {
        System.out.println("I got hit");
        List<Category> categories = new ArrayList<>();
        
    
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/cmj", "root", "")) {
            String sql = "SELECT * from categories";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            // for listing(select stmt) we use resultSet and execute query unlike other insert,update,delete with executeUpdate
            while (rs.next()) {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setStatus(rs.getBoolean("status"));
                categories.add(category);
            }
            return categories;
        }
       
    }
    
}
