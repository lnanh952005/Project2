package customException;

public class FieldRequiredException extends RuntimeException{

	public FieldRequiredException(String message){
		super(message);
	}

}
