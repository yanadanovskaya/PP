import java.io.*;

public class Main {

    public static void main(String[] args) {

        String inputFile = "input.txt";//Путь к входному файлу
        String outputFile = "output.txt";//Путь к выходному файлу

        try {// Чтение данных из  входного файла
            BufferedReader reader = new BufferedReader(new FileReader("C:\\work\\Project\\src\\input.txt"));
            StringBuilder stringBuilder = new StringBuilder();

            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            reader.close();

            //Обработка полученной информации
            String lastLettersOfWords = new processArithmeticOperations(String.valueOf(stringBuilder));
            //String lastLettersOfWords = processArithmeticOperations(String.valueOf(stringBuilder));

            //Запись данных в выходной файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(lastLettersOfWords);
            writer.close();


        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Processing is complete. The result is written to a file." + outputFile);

        //Main lastLetters = new Main();

    }

}