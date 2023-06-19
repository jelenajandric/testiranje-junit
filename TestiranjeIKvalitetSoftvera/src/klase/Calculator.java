package klase;

import exceptions.DivisionByZeroException;
import exceptions.NotSupportedOperationException;

/**
* The Calculator program implements an application that provides basic mathematical operations such as 
* addition, subtraction, multiplication and division. 
* Class Calculator has one attribute (currentValue) whose initial value is zero.
* @author  Jelena Jandric
* @version 1.0
* @since   2021-12-05
*/
public class Calculator {
	
	private Double currentValue;
	
	/**
	 * This is constructor that makes objects of this class. 
	 * The initial value of the attribute is 0.
	 */
	public Calculator() {
		currentValue = 0.0;
	}
	
	
	/**
	 * This method returns value of attribute currentValue which is private.
	 * @return Double This returns value of currentValue.
	 */
	public Double getCurrentValue() {
		return currentValue;
	}
	
	
	/**
	 * This method sets new value to attribute currentValue, that
	 * new value is parameter of this method.
	 * @param currentValue This is parameter whose 
	 * value will be given to the attribute currentValue.
	 */
	public void setCurrentValue(Double currentValue) {
		this.currentValue = currentValue;
	}
	
	
	/**
	 * This method performs basic mathematical operations: addition, subtraction, multiplication and division. 
	 * Operands are the first parameter of a method and an attribute of the class. Parameter operator is operator of operation.
	 * @param value This is the first parameter to calculate method. It is second operand in operations. 
	 * @param operator This is the second parameter to calculate method. Depending on the value of this parameter 
	 * the function will perform: addition ('+'), subtraction ('-'), multiplication ('*'), division ('/') or 
	 * an exception (NotSupporterOperationException) will be thrown (for any other input).
	 * @throws DivisionByZeroException On input error, when zero division is detected.
	 * @throws NotSupportedOperationException On input error, when the operator does not receive one of the expected values.
	 * @see DivisionByZeroException
	 * @see NotSupportedOperationException
	 */
	public void calculate(Double value, char operator) throws DivisionByZeroException, NotSupportedOperationException {
		
		switch (operator) {
			case '+': { 
				currentValue = currentValue + value;
				break; 
			} 
			case '-': {
				currentValue = currentValue - value;
				break;
			}
			case '*': {
				currentValue = currentValue * value;
				break;
			}
			case '/': {
			
				if(value.equals(Double.valueOf(0.0))) {
					throw new DivisionByZeroException();
				}
				currentValue = currentValue / value;
				break;
			}
			default:
				throw new NotSupportedOperationException();
		}
	}
}
