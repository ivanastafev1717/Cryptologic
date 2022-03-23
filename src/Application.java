import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IOException {

        /** Выбираем что будем делать */
        System.out.println("Что нужно сделать? Введите число:\n1 - Шифрование\n2 - Дешифрование\n3 - Брутфорс");
        Scanner scanner = new Scanner(System.in);
        int numberFromConsole = Integer.parseInt(scanner.nextLine());


        /** Читаем файл -  */

        System.out.println("\nВведите путь до файла:");
        FileInputStream fileInputFile = new FileInputStream(scanner.nextLine());
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputFile, StandardCharsets.UTF_8));

        /** Переводим почему-то текст файл в StringBuilder -  */

        int i;
        StringBuilder textInputStringBuilder = new StringBuilder();
        while ((i = reader.read()) != -1) {
            textInputStringBuilder.append((char) i);
        }


        FileOutputStream fileOutputStream = new FileOutputStream("test/coded.txt");

        /** Шифрование с ключем -  */

        if (numberFromConsole == 1) {
            System.out.println("\nВведите ключ:");
            int key = Integer.parseInt(scanner.nextLine());
            StringBuilder textEncoded = Encoder.encode(textInputStringBuilder, key);
            fileOutputStream.write(textEncoded.substring(0).getBytes());
            System.out.println("Файл зашифрован и записан в test/coded.txt");
        }

        /** Дешифрование с ключем -  */

        if (numberFromConsole == 2) {
            System.out.println("\nВведите ключ:");
            int key = Integer.parseInt(scanner.nextLine());
            StringBuilder textEncoded = Encoder.encode(textInputStringBuilder, key);
            fileOutputStream.write(textEncoded.substring(0).getBytes());
            System.out.println("Файл дешифрован и записан в test/coded.txt");
        }

        /** Брутфорс по ключевым словам -  */

        if (numberFromConsole == 3) {
            StringBuilder textEncoded = Encoder.encode(textInputStringBuilder,Bruteforce.brute(textInputStringBuilder));
            fileOutputStream.write(textEncoded.substring(0).getBytes());
            System.out.println("Файл взломан и записан в test/coded.txt");
        }

    }
}
