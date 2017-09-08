package tatai.bashTools;

public class TestHTK implements HTKRecipient {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		new TestHTK();
	}
	
	public TestHTK() {
		BashCommand bash = new BashCommand();
		bash.runCommand("./GoSpeech");
		bash = new HTKOutput(this);
		bash.runCommand("cat recout.mlf");
	}

	@Override
	public void receiveHTKguess(String guess) {
		System.out.println(guess);
		
	}
}
