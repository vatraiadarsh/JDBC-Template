/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.jdbcmysql.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vatra
 */
public class DbConnection {

    private Connection conn = null;
    private PreparedStatement stmt = null;
    // useful for garbage collector when using null;

    public void connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        conn = DriverManager.getConnection("jdbc:mysql://localhost/cmj", "root", "");
    }

    public PreparedStatement initStatement(String sql) throws SQLException {
        stmt = conn.prepareStatement(sql);
        return stmt;
    }

    public int update() throws SQLException {
        return stmt.executeUpdate();
    }
    
    public ResultSet query() throws SQLException{
        return stmt.executeQuery();
    }

    public void close() throws SQLException {
        conn.close();
    }
}
