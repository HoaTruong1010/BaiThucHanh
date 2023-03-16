
import com.truongthikimhoa.englishapp.PrimaryController;
import com.truongthikimhoa.pojo.Choice;
import com.truongthikimhoa.pojo.Question;
import com.truongthikimhoa.services.JDBCUtils;
import com.truongthikimhoa.services.QuestionService;
import com.truongthikimhoa.utils.MessageBox;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.junit.jupiter.api.Assertions;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class QuestionTester {
    private static Connection conn;
    private static QuestionService s;
    
    @BeforeAll
    public static void beforeALL() {
        try {
            Connection conn = JDBCUtils.createConn();
            s = new QuestionService();
        } 
        catch (SQLException ex) {
            Logger.getLogger(CategoryTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @AfterAll
    public static void afterAll() {
        if (conn != null)
            try {
                conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CategoryTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testAddSuccess() throws SQLException {
        Question q = new Question("TEST", 1);
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice("A", true, q.getId()));
        choices.add(new Choice("B", false, q.getId()));
        choices.add(new Choice("C", false, q.getId()));
        choices.add(new Choice("D", false, q.getId()));
                
        PreparedStatement stm = conn.prepareCall("SELECT * FROM question WHERE id = ?");
        stm.setString(1, q.getId());
        ResultSet r = stm.executeQuery();
        
        try {
            s.addQuestion(q, choices);
            
            Assertions.assertNotNull(r.next());
            Assertions.assertEquals(r.getString("id"), q.getId());
            Assertions.assertEquals("TEST", r.getString("content"));
        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
            MessageBox.getBox("Question", "Add question fail!!!", Alert.AlertType.ERROR).show();
        }
    }
    
    @Test
    public void testSearch() throws SQLException {
        List<Question> list = s.getQuestions("is");
        
        Assertions.assertTrue(!list.isEmpty());
        
        for (Question q: list)
            Assertions.assertTrue(q.getContent().contains("is"));
    }
    
    @Test
    public void testDelete() throws SQLException {
        String id = "a27a1a63-456d-49cb-a34e-88f1d11e6f74";
        
        boolean actual 
    }
}
