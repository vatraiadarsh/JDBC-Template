/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.jdbcmysql.dao;

import com.ada.jdbcmysql.entity.Category;
import java.sql.SQLException;

/**
 *
 * @author vatra
 */
public interface CategoryDAO {

    int insert(Category c) throws ClassNotFoundException, SQLException;
}
