import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws IOException {

        // Выбираем что будем делать

        System.out.println("Что нужно сделать? " + Const.WELCOME_MESSAGE);
        Scanner scanner = new Scanner(System.in);

        String numberFromConsoleString = scanner.nextLine();
        while (!isCorrectNumber(numberFromConsoleString)) {
            numberFromConsoleString = scanner.nextLine();
        }
        int numberFromConsole = Integer.parseInt(numberFromConsoleString);

        // Вводим путь

        System.out.println("\nВведите путь до файла:");
        String pathFile = scanner.nextLine();
        File file = new File(pathFile);

        BufferedReader reader = null;
        FileInputStream fileInputFile = null;

        // Проверка на правильность пути

        while (!file.exists()) {
            System.out.println("Файл не найден");
            file = new File(scanner.nextLine());
        }
        try {
            fileInputFile = new FileInputStream(file);
        } catch (FileNotFoundException e) {

        }

        reader = new BufferedReader(new InputStreamReader(fileInputFile, StandardCharsets.UTF_8));


        // Переводим почему-то текст файл в StringBuilder

        int i;
        StringBuilder textInputStringBuilder = new StringBuilder();
        while ((i = reader.read()) != -1) {
            textInputStringBuilder.append((char) i);
        }
        FileOutputStream fileOutputStream = new FileOutputStream("test/coded.txt");

        // Зашифрование с ключем

        if (numberFromConsole == 1) {
            int key = keyInput();
            StringBuilder textEncoded = Encoder.encode(textInputStringBuilder, key);
            fileOutputStream.write(textEncoded.substring(0).getBytes());
            System.out.println("Файл зашифрован и записан в test/coded.txt");
        }

        // Дешифрование с ключем

        if (numberFromConsole == 2) {
            int key = keyInput();
            StringBuilder textEncoded = Encoder.encode(textInputStringBuilder, -key);
            fileOutputStream.write(textEncoded.substring(0).getBytes());
            System.out.println("Файл дешифрован и записан в test/coded.txt");
        }

        // Брутфорс по ключевым словам

        if (numberFromConsole == 3) {
            StringBuilder textEncoded = Encoder.encode(textInputStringBuilder, Bruteforce.brute(textInputStringBuilder));
            fileOutputStream.write(textEncoded.substring(0).getBytes());
            System.out.println("Файл взломан и записан в test/coded.txt");
        }

    }

    public static boolean isCorrectNumber(String str) {
        try {
            int number = Integer.parseInt(str);
            return isNumber(number);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isNumber(int number) {
        return number == 1 || number == 2 || number == 3;
    }

    public static int keyInput() {
        System.out.println("\nВведите ключ:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }


}
