package exceptions;

/**
 * This class is a user-defined exception that is thrown when dividing by zero.
 * It extends Exception class.
 * @author Jelena Jandric
 * @version 1.0
 * @since   2021-12-05
 */
public class DivisionByZeroException extends Exception {
	
	private static final long serialVersionUID = 1L;

	/**
	 * This is constructor that makes objects of this class. It calls parent class constructor.
	 */
	public DivisionByZeroException() { 
		super("Dijeljenje sa nulom"); 
	} 
	
}
