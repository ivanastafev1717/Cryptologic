
public class Bruteforce {
    public static int brute(StringBuilder sourceText) {
        int keyFinal = 0;
        for (int key = -Const.ALPHABET.length/2-1; key < Const.ALPHABET.length/2+1; key++) {
            StringBuilder bruteString = Encoder.encode(sourceText, key);
            String[] brute = bruteString.toString().split(" ");
            for (String word : brute) {
                for (int i = 0; i < Const.KEY_WORDS.length; i++) {
                    if (Const.KEY_WORDS[i].equalsIgnoreCase(word)) {
                        keyFinal = key;break;
                    }
                }
            }
        }
        System.out.println("\nКлюч = " + (-keyFinal));

        return keyFinal;
    }
}
