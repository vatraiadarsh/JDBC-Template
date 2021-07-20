/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.jdbcmysql.dbutil;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vatra
 * @param <T>
 */
public class JdbcTemplate<T> {

    private DbConnection db = new DbConnection();

    public List<T> query(String sql, Object[] args, RowMapper<T> mapper) throws ClassNotFoundException, SQLException {
        List<T> rows = new ArrayList<>();
        db.connect();
        PreparedStatement stmt = db.initStatement(sql);
        if (args != null) {
            int counter = 1;
            for (Object param : args) {
                stmt.setObject(counter, param);
                counter++;
            }
        }
        ResultSet rs = db.query();
        while (rs.next()) {
            rows.add(mapper.mapRow(rs));
        }

        db.close();
        return rows;
    }
}
