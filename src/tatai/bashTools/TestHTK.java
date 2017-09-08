package tatai.bashTools;

public class TestHTK implements HTKRecipient {
	public static void main(String[] args) {
		new TestHTK();
		System.out.println(System.getProperty("user.dir"));
	}
	
	public TestHTK() {
		HTKOutput bash = new HTKOutput(this);
		bash.runCommand("./GoSpeech");
	}

	@Override
	public void receiveHTKguess(String guess) {
		System.out.println(guess);
		
	}
}
