/**
 * @class StackException which extends RuntimeExceptions for error handling.
 * */
public class StackException extends RuntimeException{
	
	public StackException(String err){ //defer error-handling to the system
		super(err);
	}

}
