/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import javafx.scene.paint.Color;

/**
 *
 * @author admin
 */
public class BIMService {
    public static int tinhBMI(double height, double weight) {
        double bmi = weight / Math.pow(height, 2);
        
        if(bmi < 18.5) {
            return -1;
        }
        else if (bmi < 25){
            return 0;
        } else {
            return 1;
        }
    }
}
