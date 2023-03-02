/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.truongthikimhoa.unittest;

import com.truongthikimhoa.pojo.Choice;
import com.truongthikimhoa.pojo.Question;
import com.truongthikimhoa.services.QuestionService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author admin
 */
public class JDBCDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        QuestionService qs = new QuestionService();
        
        Question q = new Question("this is ... studio", 1);
        qs.addQuestion(q, null);
//        
//        Connection conn = JDBCUtils.createConn();
//        
//        Statement stm = conn.createStatement();
//        
//        ResultSet rs = stm.executeQuery("SELECT * FROM category");
//        while (rs.next()) {
//            int id = rs.getInt("id");
//            String name = rs.getString("name");
//            System.out.printf("%d - %s\n", id, name);
//        }
//        
//        int r = stm.executeUpdate("INSERT INTO category(name) VALUES('People')");
//        System.out.println(r);
//        stm.executeUpdate("DELETE FROM category WHERE id = 6;");
//        
//        conn.close();
    }
}
