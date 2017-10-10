package tatai.exceptions;

// A checked exception for when HTK cannot recognise
// the user's voice
public class SpeechNotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	public SpeechNotFoundException(String message) {
		super(message);
	}
}
