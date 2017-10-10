package tatai.exceptions;

// A checked exception for when someone tries to get a number
// from a MaoriNumberModel after it has run out of numbers
public class OutOfItemsException extends Exception {

	private static final long serialVersionUID = 1L;

	public OutOfItemsException(String message) {
		super(message);
	}
}
