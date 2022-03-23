import java.io.IOException;

public class Bruteforce {
    public static int brute(StringBuilder sourceText) throws IOException {
        int keyFinal = 0;
        for (int key = -Const.alphabet.length/2-1; key < Const.alphabet.length/2+1; key++) {
            StringBuilder bruteString = Encoder.encode(sourceText, key);
            String[] brute = bruteString.toString().split(" ");
            for (String word : brute) {
                for (int i = 0; i < Const.keyWords.length; i++) {
                    if (Const.keyWords[i].equalsIgnoreCase(word)) {
                        keyFinal = key;break;
                    }
                }
            }
        }
        System.out.println("\nКлюч = " + (keyFinal));

        return keyFinal;
    }
}
