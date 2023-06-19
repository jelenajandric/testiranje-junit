package exceptions;

/**
 * This class is a user-defined exception that is thrown when input parameter is not supported.
 * It extends Exception class.
 * @author Jelena Jandric
 * @version 1.0
 * @since   2021-12-05
 */
public class NotSupportedOperationException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * This is constructor that makes objects of this class. It calls parent class constructor.
	 */
	public NotSupportedOperationException() {
		super("Operacija nije podrzana"); 
	} 
	 

}
