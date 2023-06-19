package klase;

import exceptions.NotSupportedOperationException;
import exceptions.NumberNotInAreaException;

/**
* The CalculatorAdvanced program implements an application that provides some advanced mathematical operations such as 
* factorial, degree of number and checking whether the number is an Armstrong number or a perfect number. 
* Class CalculatorAdvanced extends class Calculator.
* @author  Jelena Jandric
* @version 1.0
* @since   2021-12-05
*/
public class CalculatorAdvanced extends Calculator {
	
	/**
	 * This is constructor that makes objects of this class. 
	 * It calls a parent class constructor.
	 */
	public CalculatorAdvanced() {
		super();
	}
	
	
	/**
	 * This method is used to calculate the factorial or degree of a number. That number is integer value of currentValue.
	 * Which operation will be performed depends on the parameter action.
	 * If currentValue is not in the range [0-10] for the factorial calculation, the operation will not be performed.
	 * To calculate the degree of a number, the action parameter must be a number in range [0-9].
	 * @param action This parameter can receive '!' for calculating the factorial of a number 
	 * or numbers from '0' to '9' for calculating degree of a number. For any other option 
	 * it will throw an exception NotSupportedOperationException.
	 * @throws NumberNotInAreaException This exception is thrown when calculating factorial of number,
	 * when the currentValue is not in the range [0-10]
	 * @throws NotSupportedOperationException On input error, when parameter action does not receive one of the expected values.
	 * @see NumberNotInAreaException
	 * @see NotSupportedOperationException
	 */
	public void calculateAdvanced(char action) throws NumberNotInAreaException, NotSupportedOperationException {
		
		int cjelobrojniDio = getCurrentValue().intValue();
		
		if(action == '!') {
			if (getCurrentValue() < 0 || getCurrentValue() > 10) { 
				throw new NumberNotInAreaException();
			}
			
			int i = 1, temp = 1;
			while(i <= cjelobrojniDio) {
				temp *= i;
				i++;
			}
			setCurrentValue((double) temp);
		}
		else {
			  
			int broj = Character.getNumericValue(action); 
			if (broj < 0 || broj > 9) { 
				throw new NotSupportedOperationException();
			}
			else {
				if(broj == 0) {
					setCurrentValue(1.0);
				}
				else {
					int temp = cjelobrojniDio;
					for(int i = 0; i < broj-1; i++) { 
						cjelobrojniDio = cjelobrojniDio*temp;
					}
					setCurrentValue((double) cjelobrojniDio);
				}
			}
		}
	}
	
	 
	/**
	 * This method is used to calculate whether the integer value of currentValue has the 
	 * properties of a perfect number or an Armstrong number.
	 * @param value Parameter value can be 'A' (then it will be checked whether the integer value of currentValue 
	 * is an Armstrong number) or 'P'(then it will be checked whether the integer value of currentValue 
	 * is perfect number). An exception (NotSupportedOperationException) will be thrown for any other input.
	 * @return Boolean If the integer value of currentValue has passed the Armstrong number
	 * or the perfect number check, the value true will be returned, otherwise false.
	 * @throws NumberNotInAreaException This exception will be thrown if the integer part of the currentValue value is less than 1.
	 * @throws NotSupportedOperationException On input error, when parameter value does not receive one of the expected values.
	 * see NumberNotInAreaException
	 * @see NotSupportedOperationException
	 */
	public Boolean hasCharacteristic(char value)  throws NumberNotInAreaException, NotSupportedOperationException {
		
		int cjelobrojniDio = getCurrentValue().intValue();
		if(cjelobrojniDio < 1) {
			throw new NumberNotInAreaException();
		}
		
		switch (value) {
		case 'A': {
			int temp, brojCifara = 0, zadnji = 0, sum = 0;   
			temp = cjelobrojniDio;   
			while(temp > 0) {   
				temp = temp/10;   
				brojCifara++;   
			}   
			temp = cjelobrojniDio; 
			int temp2 = 0;
			while(temp > 0) {   
				zadnji = temp % 10;
				temp2 = zadnji;
				for(int i=0; i<brojCifara-1; i++) {
					zadnji=zadnji*temp2;
				}
				sum = sum + zadnji;
				temp = temp/10;   
			}  
			if(cjelobrojniDio == sum) {
				return true;      
			}
			else {
				return false;
			}	
		}
		case 'P' : {
			int sum = 0;
		      for (int i=1; i < cjelobrojniDio; i++) {
		          if ( cjelobrojniDio % i == 0) {
		            sum = sum + i;
		          }    
		      }
		      if(sum == cjelobrojniDio) {
		    	  return true;
		      }
		      else {
				return false;
			}
		}
		default:
			throw new NotSupportedOperationException();
				
		}
	}
}
