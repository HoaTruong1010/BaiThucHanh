
import com.truongthikimhoa.services.CalculatorServices;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author admin
 */
public class CalculatorTester {
//    @Test
//    public void checkOddNumber() {
//        int n = 4;
//        boolean expected = false;
//        boolean actual = CalculatorServices.isNguyenTo(n);
//        Assertions.assertEquals(expected, actual);
//    }
    
//    @Test
//    public void testException() {
//        Assertions.assertThrows(ArithmeticException.class, ()->{
//        NguyenToServices.isNguyenTo(0);
//        });
//    }
    
    @Test
    @DisplayName("Kiem tra x mu n, voi n = 0:")
    public void checkPowerWithNBang0() {
        int n = 0;
        double x = 1.5;
        double expected = 1;
        double actual = CalculatorServices.Power(x, n);
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Kiem tra x mu n, voi n < 0:")
    public void checkPowerWithNLessThan0() {
        int n = -1;
        double x = 4;
        double expected = 0.25;
        double actual = CalculatorServices.Power(x, n);
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Kiem tra x mu n, voi n > 0:")
    public void checkPowerWithNMoreThan0() {
        int n = 2;
        double x = 3;
        double expected = 9;
        double actual = CalculatorServices.Power(x, n);
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Kiem tra x mu n, voi n > 0 va x am")
    public void checkPowerWithXLessThan0() {
        int n = 2;
        double x = -3;
        double expected = 9;
        double actual = CalculatorServices.Power(x, n);
        Assertions.assertEquals(expected, actual);
    }
    
    @Test
    @DisplayName("Kiem tra x mu n, voi n > 0 va x am")
    public void checkPowerWithXBang0() {
        int n = 2;
        double x = 0;
        double expected = 0;
        double actual = CalculatorServices.Power(x, n);
        Assertions.assertEquals(expected, actual);
    }
}
