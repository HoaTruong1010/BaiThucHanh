package com.truongthikimhoa.bmitester;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import services.BIMService;

public class PrimaryController {
    @FXML private TextField txtWeight;
    @FXML private TextField txtHeight;
    @FXML private Label lblResult;
    
    public void tinhBMI(ActionEvent e) {
        double h = Double.parseDouble(this.txtHeight.getText());
        double w = Double.parseDouble(this.txtWeight.getText());
        double bmi = BIMService.tinhBMI(h, w);
        
        if(bmi < 0) {
            this.lblResult.setTextFill(Color.RED);
            this.lblResult.setText("Gay");
        }
        else if (bmi == 0){
            this.lblResult.setTextFill(Color.GREEN);
            this.lblResult.setText("Binh thuong");
        } else {
            this.lblResult.setTextFill(Color.RED);
            this.lblResult.setText("Thua can");
        }
    }
}
