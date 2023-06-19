import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import exceptions.DivisionByZeroException;
import exceptions.NotSupportedOperationException;
import klase.Calculator;

import static org.hamcrest.Matchers.instanceOf;;

class CalculatorTest {

	private Calculator calc = new Calculator();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calc.setCurrentValue(0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculator() {
		assertNotNull(calc);
	}

	@Test
	void testGetCurrentValue() {
		assertThat(Double.valueOf(0.0), is(calc.getCurrentValue()));
	}

	@Test
	void testSetCurrentValue() {
		calc.setCurrentValue(Double.valueOf(13.39));
		assertThat(Double.valueOf(13.39), is(calc.getCurrentValue()));
	}

	@ParameterizedTest
	@MethodSource("methodWithParameters")
	void testCalculate(Double current, Double other, char operation, Double result) throws DivisionByZeroException, NotSupportedOperationException{
		
		calc.setCurrentValue(current);
		calc.calculate(other, operation);
		assertThat(result, is(calc.getCurrentValue()));
	}
	
	private static Stream<Arguments> methodWithParameters() {
	    return Stream.of(
	      Arguments.of(1.0, 5.45, '+', 6.45),
	      Arguments.of(6.45, 8.91, '-' , -2.46),
	      Arguments.of(-2.46, 11.0, '*', -27.06),
	      Arguments.of(-27.06, -13.53, '/', 2.0)
	    );
	}
	 
	@Test
	 void DivisionByZeroExceptionTest() {
		Exception exception = assertThrows(
        		DivisionByZeroException.class,  
	            () -> calc.calculate(0.0, '/')); 
        assertThat(exception, is(instanceOf(DivisionByZeroException.class)));
	}
	
	@ParameterizedTest
	@MethodSource("methodWithParameters2")
	void NotSupportedOperationExceptionTest(Double current, Double value ,char operator) {
		calc.setCurrentValue(current); 
		Exception exception = assertThrows(
				NotSupportedOperationException.class, 
	            () -> calc.calculate(value, operator)); 
        assertThat(exception, is(instanceOf(NotSupportedOperationException.class)));
	}
	
	private static Stream<Arguments> methodWithParameters2() {
	    return Stream.of(
	      Arguments.of(1.0, 2.0, 'a'),
	      Arguments.of(6.45, 1.0,  '3' ),
	      Arguments.of(-2.46, 7.89, '%')
	    );
	}
	
}
