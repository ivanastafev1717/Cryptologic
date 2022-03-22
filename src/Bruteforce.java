import java.io.IOException;

public class Bruteforce {
    public static int brute(StringBuilder sourceText) throws IOException {
        System.out.println("\nНачинаю брутфорс\n");
        //StringBuilder encodedText = new StringBuilder();
        int keyFinal = 0;
        for (int key = 0; key < Const.alphabet.length; key++) {
            StringBuilder bruteString = Encoder.encode(sourceText, key);
            String[] brute = bruteString.toString().split(" ");
            for (String word : brute) {
                for (int i = 0; i < Const.keyWords.length; i++) {
                    if (Const.keyWords[i].equalsIgnoreCase(word)) {
                        keyFinal = key;
                    }
                }
            }
        }
        System.out.println("Ключ брутфорса = " + keyFinal);

        return keyFinal;
    }
}
