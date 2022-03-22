import java.io.IOException;
import java.util.Arrays;


public class Encoder {

    public static StringBuilder encode(StringBuilder sourceText, int key) throws IOException {


        StringBuilder encodedText = new StringBuilder();

                for (int i = 0; i < sourceText.length(); i++) {
                if (Arrays.asList(Const.alphabet).contains(Character.toString(sourceText.charAt(i)))) {
                    int indexOfElement = Arrays.asList(Const.alphabet).indexOf(Character.toString(sourceText.charAt(i)));
                    while (indexOfElement + key < 0) {
                        key = key + Const.alphabet.length;
                    }

                    /** Если ключ за range */
                    while (indexOfElement + key > Const.alphabet.length - 1) {
                        key = key - Const.alphabet.length;
                    }

                    if (indexOfElement + key > Const.alphabet.length)
                        encodedText.append(Const.alphabet[Const.alphabet.length - indexOfElement + key]);
                    else encodedText.append(Const.alphabet[indexOfElement + key]);
                } else encodedText.append(sourceText.charAt(i));

        }
        return encodedText;
    }

}
