package tatai.util;

public class TestVerifier {
    public static void main(String[] args) {
        Verifier verifier = new Verifier("tekau", "tekau");
        System.out.println(verifier.isCorrect());
    }
}
