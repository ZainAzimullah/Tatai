package tatai.exceptions;

// Wrapper exception for when someone creates an Operand for which
// a Maori number cannot be created for (i.e. outside of range 1-99)
public class ResultOutOfRangeException extends Exception {

	private static final long serialVersionUID = 1L;

}
