/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.jdbcmysql.dao.impl;

import com.ada.jdbcmysql.dbutil.DbConnection;
import com.ada.jdbcmysql.dao.CategoryDAO;
import com.ada.jdbcmysql.dbutil.JdbcTemplate;
import com.ada.jdbcmysql.dbutil.RowMapper;
import com.ada.jdbcmysql.entity.Category;
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

    private DbConnection db = new DbConnection();
    private JdbcTemplate<Category> template = new JdbcTemplate<>();

    @Override
    public int insert(Category c) throws ClassNotFoundException, SQLException {
//        int result;
//        db.connect();
//        String sql = "INSERT INTO categories(name,status)" + "values(?,?)";
//        PreparedStatement stmt = db.initStatement(sql);
//        stmt.setString(1, c.getName());
//        stmt.setBoolean(2, c.isStatus());
//        result = db.update();
//        db.close();
//
//        return result;

        String sql = "INSERT INTO categories(name,status)" + "values(?,?)";
        return template.update(sql, new Object[]{
            c.getName(),
            c.isStatus()
        });
    }

    @Override
    public int update(Category c) throws ClassNotFoundException, SQLException {
//        int result;
//        db.connect();
//        String sql = "UPDATE categories set name=?, modified_date= CURRENT_TIMESTAMP, status=? where id=? ";
//        PreparedStatement stmt = db.initStatement(sql);
//        stmt.setString(1, c.getName());
//        stmt.setBoolean(2, c.isStatus());
//        stmt.setInt(3, c.getId());
//        result = db.update();
//        db.close();
//        return result;

        String sql = "UPDATE categories set name=?, modified_date= CURRENT_TIMESTAMP, status=? where id=? ";
        return template.update(sql, new Object[]{
            c.getName(),
            c.isStatus(),
            c.getId()
        });
    }

    @Override
    public int delete(int id) throws ClassNotFoundException, SQLException {
//        int result;
//        db.connect();
//        String sql = "DELETE FROM categories where id=? ";
//        PreparedStatement stmt = db.initStatement(sql);
//        stmt.setInt(1, id);
//        result = db.update();
//        db.close();
//        return result;

        String sql = "DELETE FROM categories where id=? ";
        return template.update(sql, new Object[]{id});
    }

    @Override
    public List<Category> getAll() throws ClassNotFoundException, SQLException {
//        System.out.println("I got hit");
//        List<Category> categories = new ArrayList<>();
//
//        db.connect();
//        String sql = "SELECT * from categories";
//        PreparedStatement stmt = db.initStatement(sql);
//        ResultSet rs = db.query();
//        // for listing(select stmt) we use resultSet and execute query unlike other insert,update,delete with executeUpdate
//        while (rs.next()) {
//            Category category = new Category();
//            category.setId(rs.getInt("id"));
//            category.setName(rs.getString("name"));
//            category.setStatus(rs.getBoolean("status"));
//            categories.add(category);
//
//        }
//        db.close();
//        return categories;

        return template.query("Select * from categories", null, new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet rs) throws SQLException {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setStatus(rs.getBoolean("status"));
                return category;
            }
        });

//If needed whith where can be passed with new Object
//        return template.query("Select * from categories where status=?", new Object[]{true}, new RowMapper<Category>() {
//            @Override
//            public Category mapRow(ResultSet rs) throws SQLException {
//                Category category = new Category();
//                category.setId(rs.getInt("id"));
//                category.setName(rs.getString("name"));
//                category.setStatus(rs.getBoolean("status"));
//                return category;
//            }
//        });
    }

    @Override
    public Category getById(int id) throws ClassNotFoundException, SQLException {
//        Category category = null;
//        db.connect();
//        String sql = "SELECT * from categories where id=?";
//        PreparedStatement stmt = db.initStatement(sql);
//        stmt.setInt(1, id);
//        ResultSet rs = db.query();
//        // for listing(select stmt) we use resultSet and execute query unlike other insert,update,delete with executeUpdate
//        while (rs.next()) {
//            category = new Category();
//            category.setId(rs.getInt("id"));
//            category.setName(rs.getString("name"));
//            category.setStatus(rs.getBoolean("status"));
//
//        }
//
//        db.close();
//        return category;

        return template.queryForObject("Select * from categories where id=?", new Object[]{id}, new RowMapper<Category>() {
            @Override
            public Category mapRow(ResultSet rs) throws SQLException {
                Category category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                category.setStatus(rs.getBoolean("status"));
                return category;
            }
        });
    }
}
