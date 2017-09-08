package tatai.bashTools;

public class TestHTK implements HTKRecipient {
	public static void main(String[] args) {
		new TestHTK();
	}
	
	public TestHTK() {
		HTKOutput bash = new HTKOutput(this);
		bash.runCommand("~/HTK/MaoriNumbers/GoSpeech");
	}

	@Override
	public void receiveHTKguess(String guess) {
		System.out.println(guess);
		
	}
}
