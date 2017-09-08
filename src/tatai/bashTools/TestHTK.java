package tatai.bashTools;

public class TestHTK implements HTKRecipient {
	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir"));
		new TestHTK();
	}
	
	public TestHTK() {
		BashCommand bash = new BashCommand();
		bash.runCommand("arecord -d 2 -r 22050 -c 1 -i -t wav -f s16_LE foo.wav; "
				+ "HVite -H HMMs/hmm15/macros -H HMMs/hmm15/hmmdefs -C user/configLR  -w user/wordNetworkNum -o SWT -l '*' -i recout.mlf -p 0.0 -s 5.0  user/dictionaryD user/tiedList foo.wav\n");
		bash.runCommand("ffplay -autoexit foo.wav &> /dev/null");
		
		bash.runCommand("cat recout.mlf");
		
		bash.runCommand("rm foo.wav");
	}

	@Override
	public void receiveHTKguess(String guess) {
		System.out.println(guess);
		
	}
}
