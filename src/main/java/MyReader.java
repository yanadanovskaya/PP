import org.json.simple.JSONObject;

import java.io.*;

public class MyReader {
    String inputFilePath;
    String outputFilePath;
    void jsonReader(String filePath) {
        try {
            JSONObject resultJson = new JSONObject();

            resultJson.put("name", "foo");
            resultJson.put("num", 100);
            resultJson.put("is_vip", true);
            resultJson.put("nickname", null);
            System.out.print(resultJson);

            // Write the JSON string to a file
            FileWriter writer = null;
            try {
                writer = new FileWriter("output.json");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                writer.write("hello");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            try {
                writer.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

            System.out.println("Data written to JSON file: output.json");
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
    }

    void txtReader(){
        String outputFile = "output.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader("C:\\work\\Project\\src\\main\\java\\input.txt"));
            StringBuilder stringBuilder = new StringBuilder();

            String line;

            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            reader.close();

            //Обработка полученной информации
            String lastLettersOfWords = Program.processArithmeticOperations(String.valueOf(stringBuilder));

            //Запись данных в выходной файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(lastLettersOfWords);
            writer.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Processing is complete. The result is written to a file." + outputFile);

    }
}
