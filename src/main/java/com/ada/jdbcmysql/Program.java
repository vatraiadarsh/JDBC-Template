/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ada.jdbcmysql;

import com.ada.jdbcmysql.dao.CategoryDAO;
import com.ada.jdbcmysql.dao.impl.CategoryDAOImpl;
import com.ada.jdbcmysql.entity.Category;

import java.sql.SQLException;

/**
 *
 * @author vatrai
 */
public class Program {

    public static void main(String[] args) {
        try {
            CategoryDAO categoryDAO = new CategoryDAOImpl();
            //categoryDAO.insert(new Category(0, "Coke", true));
            //categoryDAO.update(new Category(2, "Oil", false));
            //categoryDAO.delete(3);
            
            for(Category c: categoryDAO.getAll()){
                System.out.println(c.getName());
            }

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
