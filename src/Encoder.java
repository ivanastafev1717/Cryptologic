
import java.util.Arrays;


public class Encoder {

    public static StringBuilder encode(StringBuilder sourceText, int key) {


        StringBuilder encodedText = new StringBuilder();

                for (int i = 0; i < sourceText.length(); i++) {
                if (Arrays.asList(Const.ALPHABET).contains(Character.toString(sourceText.charAt(i)))) {
                    int indexOfElement = Arrays.asList(Const.ALPHABET).indexOf(Character.toString(sourceText.charAt(i)));
                    while (indexOfElement + key < 0) {
                        key = key + Const.ALPHABET.length;
                    }

                    // Если ключ за range
                    while (indexOfElement + key > Const.ALPHABET.length - 1) {
                        key = key - Const.ALPHABET.length;
                    }

                    if (indexOfElement + key > Const.ALPHABET.length)
                        encodedText.append(Const.ALPHABET[Const.ALPHABET.length - indexOfElement + key]);
                    else encodedText.append(Const.ALPHABET[indexOfElement + key]);
                } else encodedText.append(sourceText.charAt(i));

        }
        return encodedText;
    }

}
