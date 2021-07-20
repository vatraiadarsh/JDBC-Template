/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.jdbcmysql.dbutil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author vatra
 * @param <T>
 */
public interface RowMapper<T> {
    T mapRow(ResultSet rs) throws SQLException;
}
