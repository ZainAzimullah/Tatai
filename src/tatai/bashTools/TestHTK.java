package tatai.bashTools;

public class TestHTK {
	public static void main(String[] args) {
		BashCommand bash = new BashCommand();
		bash.runCommand("arecord -d 2 -r 22050 -c 1 -i -t wav -f s16_LE foo.wav");
		bash.runCommand("HVite -H HMMs/hmm15/macros -H "
				+ "HMMs/hmm15/hmmdefs -C user/configLR  -w "
				+ "user/wordNetworkNum -o SWT -l '*' -i recout.mlf "
				+ "-p 0.0 -s 5.0  user/dictionaryD user/tiedList foo.wav");
		bash.runCommand("ffplay -autoexit -nodisp foo.wav &> /dev/null");
		bash.runCommand("rm foo.wav");
		
		bash = new BashCommand();
//		bash.runCommand("more recout.mlf");
		bash.runCommand("cat recout.mlf");
		
	}
}
