package tatai.exceptions;

// Wrapper class general errors that could occur
public class TataiException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public TataiException(String message) {
		super(message);
	}
}
