package tatai.bashTools;

public class TestHTK implements HTKRecipient {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		new TestHTK();
	}
	
	public TestHTK() {
		BashCommand bash = new BashCommand();
		
	}

	@Override
	public void receiveHTKguess(String guess) {
		System.out.println(guess);
		
	}
}
