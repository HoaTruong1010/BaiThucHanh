/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.truongthikimhoa.services;

import com.truongthikimhoa.pojo.Category;
import com.truongthikimhoa.pojo.Choice;
import com.truongthikimhoa.pojo.Question;
import com.truongthikimhoa.unittest.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author admin
 */
public class QuestionService {

    public boolean addQuestion(Question q, List<Choice> choices) throws SQLException {
        try ( Connection conn = JDBCUtils.createConn()) {
            String sql = "INSERT INTO question(id, content, category_id) VALUES(?, ?, ?)";
            PreparedStatement stm = conn.prepareCall(sql);
            stm.setString(1, q.getId());
            stm.setString(2, q.getContent());
            stm.setInt(3, q.getCategory_id());
            
            int r = stm.executeUpdate();

            return r > 0;
        }
    }
}
