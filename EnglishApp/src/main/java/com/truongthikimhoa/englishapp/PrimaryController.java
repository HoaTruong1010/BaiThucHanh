package com.truongthikimhoa.englishapp;

import com.truongthikimhoa.pojo.Category;
import com.truongthikimhoa.pojo.Choice;
import com.truongthikimhoa.pojo.Question;
import com.truongthikimhoa.services.CategoryService;
import com.truongthikimhoa.services.QuestionService;
import com.truongthikimhoa.utils.MessageBox;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController implements Initializable{
    @FXML private TableView<Question> tbQuestion;
    @FXML private ComboBox<Category> cbCategories;
    @FXML private TextField txtContent;
    @FXML private TextField txtA;
    @FXML private TextField txtB;
    @FXML private TextField txtC;
    @FXML private TextField txtD;
    @FXML private RadioButton rdA;
    @FXML private RadioButton rdB;
    @FXML private RadioButton rdC;
    @FXML private RadioButton rdD;
    @FXML private TextField txtSearch;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        CategoryService s = new CategoryService();
        try {
            List<Category> cates = s.getCategories();
            this.cbCategories.setItems(FXCollections.observableArrayList(cates));
            
            this.loadTableColumns();
            this.loadQuestions(null);
        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.txtSearch.textProperty().addListener(o -> {
            try {
                this.loadQuestions(this.txtSearch.getText());
            } catch (SQLException ex) {
                Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
    
    public void addQuestionHandler(ActionEvent e) {
        Question q = new Question(this.txtContent.getText(),
        this.cbCategories.getSelectionModel().getSelectedItem().getId());
        List<Choice> choices = new ArrayList<>();
        choices.add(new Choice(this.txtA.getText(), this.rdA.isSelected(), q.getId()));
        choices.add(new Choice(this.txtB.getText(), this.rdB.isSelected(), q.getId()));
        choices.add(new Choice(this.txtC.getText(), this.rdC.isSelected(), q.getId()));
        choices.add(new Choice(this.txtD.getText(), this.rdD.isSelected(), q.getId()));
        
        QuestionService s = new QuestionService();
        try {
            s.addQuestion(q, choices);
            MessageBox.getBox("Question", "Add question successful!!!", Alert.AlertType.INFORMATION).show();
        } catch (SQLException ex) {
            Logger.getLogger(PrimaryController.class.getName()).log(Level.SEVERE, null, ex);
            MessageBox.getBox("Question", "Add question fail!!!", Alert.AlertType.ERROR).show();
        }
    }
    
    private void loadTableColumns() {
        TableColumn colContent = new TableColumn("Question Content");
        colContent.setCellValueFactory(new PropertyValueFactory("content"));
        colContent.setPrefWidth(310);
        
        TableColumn colCate = new TableColumn("Category");
        colCate.setCellValueFactory(new PropertyValueFactory("category_id"));
        
        TableColumn colDelete= new TableColumn();
        colDelete.setCellFactory(cf -> {
            Button btn = new Button("Delete");
            
            btn.setOnAction(evt -> {
                Alert confirm = MessageBox.getBox("Question", "Are you sure to delete?", Alert.AlertType.CONFIRMATION);
                confirm.showAndWait().ifPresent(res -> {
                    if (res == ButtonType.OK) {
                        
                    }
                });
            });
            
            TableCell c = new TableCell();
            c.setGraphic(btn);
            return c;
        });
        
        this.tbQuestion.getColumns().addAll(colContent, colCate, colDelete);
    }
    
    private void loadQuestions (String kw) throws SQLException {
        QuestionService s = new QuestionService();
        List<Question> list = s.getQuestions(kw);
        this.tbQuestion.getItems().clear();
        this.tbQuestion.setItems(FXCollections.observableList(list));
    }
}
