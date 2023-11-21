import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.SecretKeySpec;

public class Main {
    public class FileProcessor {

        private static final String KEY = "mysecretkey"; // ключ для шифрования

        public static void main(String[] args) {
            String inputFile = args[0]; // путь к входному файлу
            String outputFile = args[1]; // путь к выходному файлу

            try {
                // архивация файла
                archiveFile(inputFile, outputFile + ".zip");

                // шифрование архива
                encryptFile(outputFile + ".zip", outputFile);

                System.out.println("Processing is complete. The result is written to a file: " + outputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static void archiveFile(String inputFile, String outputFile) throws IOException {
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

        private static void encryptFile(String inputFile, String outputFile) throws IOException {
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
    }

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
            String lastLettersOfWords = processArithmeticOperations(String.valueOf(stringBuilder));

            //Запись данных в выходной файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(lastLettersOfWords);
            writer.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Processing is complete. The result is written to a file." + outputFile);

    }

    private static String processArithmeticOperations(String line) {
        Pattern pattern = Pattern.compile("(\\d+ *[+\\-*/] *\\d+)");//ищет матем выражения
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
        double num1 = Double.parseDouble(tokens[0]);
        double num2 = Double.parseDouble(tokens[2]);
        String operator = tokens[1];


        double result = switch (operator) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        };

        return String.valueOf(result);
    }
    public static class ArithmeticOperationProcessor {

        public static void processFileWithoutRegex(String inputFile, String outputFile) {
            try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                 BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String processedLine = processLineWithoutRegex(line);
                    writer.write(processedLine);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private static String processLineWithoutRegex(String line) {
            StringBuilder processedLine = new StringBuilder();
            int startIndex = 0;
            int endIndex = 0;

            while (endIndex < line.length()) {
                char currentChar = line.charAt(endIndex);
                if (isArithmeticOperator(currentChar)) {
                    processedLine.append(line, startIndex, endIndex);
                    // Find the end index of the arithmetic operation
                    int operationEndIndex = endIndex + 1;
                    while (operationEndIndex < line.length() && Character.isDigit(line.charAt(operationEndIndex))) {
                        operationEndIndex++;
                    }

                    // Evaluate and append the result
                    String operation = line.substring(endIndex, operationEndIndex);
                    int result = evaluateArithmeticOperation(operation);
                    processedLine.append(result);

                    startIndex = operationEndIndex;
                    endIndex = operationEndIndex;
                } else {
                    endIndex++;
                }
            }

            processedLine.append(line, startIndex, endIndex);
            return processedLine.toString();
        }

        private static boolean isArithmeticOperator(char c) {
            return c == '+';
        }

        private static int evaluateArithmeticOperation(String operation) {
            String[] operands = operation.split("[+\\-*/]");
            int operand1 = Integer.parseInt(operands[0]);
            int operand2 = Integer.parseInt(operands[1]);

            if (operation.contains("+")) {
                return operand1 + operand2;
            } else if (operation.contains("-")) {
                return operand1 - operand2;
            } else if (operation.contains("*")) {
                return operand1 * operand2;
            } else if (operation.contains("/")) {
                return operand1 / operand2;
            }

            throw new IllegalArgumentException("Invalid arithmetic operation: " + operation);
        }
    }


}