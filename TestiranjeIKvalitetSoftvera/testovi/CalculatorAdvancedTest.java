import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import exceptions.NotSupportedOperationException;
import exceptions.NumberNotInAreaException;
import klase.CalculatorAdvanced;

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

class CalculatorAdvancedTest {

	CalculatorAdvanced calcAdv = new CalculatorAdvanced();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		calcAdv.setCurrentValue(0.0);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testCalculatorAdvanced() { 
		assertNotNull(calcAdv);
		assertThat(Double.valueOf(0.0), is(calcAdv.getCurrentValue()));
	}

	@ParameterizedTest
	@MethodSource("methodWithParameters")
	void testCalculateAdvanced(Double current, char opperation, Double result ) throws NumberNotInAreaException, NotSupportedOperationException{
		calcAdv.setCurrentValue(current);
		calcAdv.calculateAdvanced(opperation);
		assertThat(Double.valueOf(result), is(calcAdv.getCurrentValue()));
	}
	
	
	private static Stream<Arguments> methodWithParameters() {
	    return Stream.of(
	      Arguments.of(5.68, '!', 120.0),
	      Arguments.of(5.68, '3', 125.0),
	      Arguments.of(-5.00, '3', -125.0),
	      Arguments.of(-6.00, '4', 1296.0),
	      Arguments.of(5.68, '0', 1.0),
	      Arguments.of(0.0, '!', 1.0),
	      Arguments.of(10.0, '!', 3628800.0),
	      Arguments.of(2.0, '9', 512.0),
	      Arguments.of(0.0, '0', 1.0)
	    );
	}
	

	@ParameterizedTest
	@MethodSource("methodWithParameters2")
	void testHasCharacteristic(Double current, char operation, Boolean result) throws NumberNotInAreaException, NotSupportedOperationException{
		calcAdv.setCurrentValue(current);
		assertThat(result, is(calcAdv.hasCharacteristic(operation)));
	}
	
	private static Stream<Arguments> methodWithParameters2() {
	    return Stream.of(
	      Arguments.of(153.0, 'A', true),
	      Arguments.of(28.0, 'A', false),
	      Arguments.of(28.0, 'P', true),
	      Arguments.of(28.92, 'P', true),
	      Arguments.of(29.0, 'P', false),
	      Arguments.of(1.0, 'A', true) 
	    );
	}
	
	
	@ParameterizedTest
	@MethodSource("methodWithParameters3")
	void NumberNotInAreaExceptionTestCA(Double current, char operation) {
		calcAdv.setCurrentValue(current);
		Exception exception = assertThrows(
       		NumberNotInAreaException.class, 
	            () -> calcAdv.calculateAdvanced(operation));
		assertThat(exception, is(instanceOf(NumberNotInAreaException.class)));
	}
	
	private static Stream<Arguments> methodWithParameters3() {
	    return Stream.of(
	      Arguments.of(-1.0, '!'),
	      Arguments.of(11.0, '!'),
	      Arguments.of(10.1, '!')
	    );
	}
	
	@ParameterizedTest
	@MethodSource("methodWithParameters4")
	void NumberNotInAreaExceptionTestHC(Double current, char operation) {
		calcAdv.setCurrentValue(current);
		Exception exception = assertThrows(
       		NumberNotInAreaException.class, 
	            () -> calcAdv.hasCharacteristic(operation));
		assertThat(exception, is(instanceOf(NumberNotInAreaException.class)));
	}
	
	private static Stream<Arguments> methodWithParameters4() {
	    return Stream.of(
	      Arguments.of(0.73, 'P'),
	      Arguments.of(-1.0, 'A')
	    );
	}
	
	@ParameterizedTest
	@MethodSource("methodWithParameters5")
	 void NotSupportedOperationExceptionTestCA(Double current, char operation) {
		
   		calcAdv.setCurrentValue(current);
		Exception exception = assertThrows(
				NotSupportedOperationException.class, 
	            () -> calcAdv.calculateAdvanced(operation));
		assertThat(exception, is(instanceOf(NotSupportedOperationException.class)));
		
	}
	
	private static Stream<Arguments> methodWithParameters5() {
	    return Stream.of(
	      Arguments.of(2.0, 'a'),
	      Arguments.of(2.0, '%')
	    );
	}
	
	@ParameterizedTest
	@MethodSource("methodWithParameters6")
	 void NotSupportedOperationExceptionTestHC(Double current, char operation) {
		
		calcAdv.setCurrentValue(current); 
	    Exception exception = assertThrows(
	   		   NotSupportedOperationException.class,  
	          () -> calcAdv.hasCharacteristic(operation));
	    assertThat(exception, is(instanceOf(NotSupportedOperationException.class)));
	}
	
	private static Stream<Arguments> methodWithParameters6() {
	    return Stream.of(
	      Arguments.of(2.0, '9'),
	      Arguments.of(28.0, '%')
	    );
	}


}
