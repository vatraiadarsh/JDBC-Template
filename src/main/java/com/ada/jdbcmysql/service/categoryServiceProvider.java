/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.jdbcmysql.service;

import com.ada.jdbcmysql.dao.CategoryDAO;
import com.ada.jdbcmysql.dao.impl.CategoryDAOImpl;
import com.ada.jdbcmysql.entity.Category;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author vatra
 */
public class categoryServiceProvider {
     CategoryDAO categoryDAO = new CategoryDAOImpl();
     List<Category> categories = null;
     
    public List<Category> getAll() throws ClassNotFoundException,SQLException{
        if (categories == null) {
            categories = categoryDAO.getAll();
        }
        return categories;
    }
    
}
