package tatai.exceptions;

// An unchecked exception for when someone tries to use
// a MaoriNumberModel without advancing to the first number.
public class FirstNumberNotAdvancedToException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public FirstNumberNotAdvancedToException(String message) {
		super(message);
	}
}
