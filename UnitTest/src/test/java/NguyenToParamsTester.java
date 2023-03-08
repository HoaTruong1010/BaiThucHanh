
import com.truongthikimhoa.services.CalculatorServices;
import java.util.stream.Stream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import org.junit.jupiter.params.provider.MethodSource;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author HOA TRƯƠNG
 */
public class NguyenToParamsTester {
    @ParameterizedTest
    @ValueSource (ints = {5, 7, 11, 113, 91})
    public void testOddNumber (int n) {
        boolean actual = CalculatorServices.isNguyenTo(n);
        Assertions.assertTrue(actual);
    }
    
    @ParameterizedTest
    @CsvSource (value = {"4,false", "7,true", "113, true", "9,false"}) 
    public void testCommonNumber(int n, boolean expected) {
        boolean actual = CalculatorServices.isNguyenTo(n);
        Assertions.assertEquals(expected, actual);
    }
    
    
    @ParameterizedTest
    @MethodSource (value = "ntData")
    public void testMethod(int n, boolean expected) {
        boolean actual = CalculatorServices.isNguyenTo(n);
        Assertions.assertEquals(expected, actual);
    }
    
    static Stream<Arguments> ntData() {
        return Stream.of(
                Arguments.arguments(6, false),
                Arguments.arguments(8, false),
                Arguments.arguments(5, true)
        );
    }
}
