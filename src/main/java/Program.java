import org.json.simple.JSONObject;

import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Program {

    private static final String KEY = "mysecretkey"; // ключ для шифрования

    static void archiveFile(String inputFile, String outputFile) throws IOException {
            byte[] buffer = new byte[1024];
            FileOutputStream fos = new FileOutputStream(outputFile);
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry ze = new ZipEntry(new File(inputFile).getName());
            zos.putNextEntry(ze);
            FileInputStream in = new FileInputStream(inputFile);
            int len;
            while ((len = in.read(buffer)) > 0) {
                zos.write(buffer, 0, len);
            }
            in.close();
            zos.closeEntry();
            zos.close();
        }

        static void encryptFile(String inputFile, String outputFile) throws IOException {
            byte[] keyBytes = KEY.getBytes();
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");
            Cipher cipher;
            try {
                cipher = Cipher.getInstance("AES");
                cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            FileInputStream fis = new FileInputStream(inputFile);
            FileOutputStream fos = new FileOutputStream(outputFile);
            CipherOutputStream cos = new CipherOutputStream(fos, cipher);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                cos.write(buffer, 0, bytesRead);
            }
            fis.close();
            cos.flush();
            cos.close();
        }


    public static class MyReader {
        void jsonReader() {
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



    static String processArithmeticOperations(String line) {
        Pattern pattern = Pattern.compile("(\\d+ *[+\\-*/] *\\d+( *[+\\-*/] *\\d+)*)");//ищет матем выражения
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            String operation = matcher.group();
            String result = evaluateArithmeticExpression(operation);
            line = line.replace(operation, result);
        }

        return line;
    }

    private static String evaluateArithmeticExpression(String operation) {
        String[] tokens = operation.split("(?:(\\p{Ll}\\p{L}*)\\s+)?");
        double result = Double.parseDouble(tokens[0]);
        for (int i = 1; i < tokens.length; i+=2) {
            double num = Double.parseDouble(tokens[i+1]);
            String operator = tokens[i];
            switch (operator) {
                case "+" -> result += num;
                case "-" -> result -= num;
                case "*" -> result *= num;
                case "/" -> result /= num;
                default -> throw new IllegalArgumentException("Invalid operator: " + operator);
            }
        }

        return String.valueOf(result);
    }
    static String processWithoutRegex(String line) {
        StringBuilder buffer = new StringBuilder();
        double result = 0;
        char lastOperator = '+';

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);
            if (Character.isDigit(c)) {
                buffer.append(c);
            } else if (isOperator(c)) {
                double num = Double.parseDouble(buffer.toString());
                switch (lastOperator) {
                    case '+' -> result += num;
                    case '-' -> result -= num;
                    case '*' -> result *= num;
                    case '/' -> result /= num;
                }
                buffer.setLength(0);
                lastOperator = c;
            }
        }

        double num = Double.parseDouble(buffer.toString());
        switch (lastOperator) {
            case '+' -> result += num;
            case '-' -> result -= num;
            case '*' -> result *= num;
            case '/' -> result /= num;
        }

        return String.valueOf(result);
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

}