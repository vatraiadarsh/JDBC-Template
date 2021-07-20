/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.jdbcmysql.dao;

import com.ada.jdbcmysql.entity.Category;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vatra
 */
public interface CategoryDAO {

    //integer because 0 -> query is executed 1-> !executed
    int insert(Category c) throws ClassNotFoundException, SQLException;
    int update(Category c) throws ClassNotFoundException, SQLException;
    int delete(int id) throws ClassNotFoundException,SQLException;
    List<Category> getAll() throws ClassNotFoundException,SQLException;
    
    
}
