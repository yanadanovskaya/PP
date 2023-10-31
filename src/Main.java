import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static String line;

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
            String arithmeticOperations = processArithmeticOperations(String.valueOf(stringBuilder));

            //Запись данных в выходной файл
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
            writer.write(arithmeticOperations);
            writer.close();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Processing is complete. The result is written to a file." + outputFile);

    }

    private static String processArithmeticOperations(String line) {
        Main.line = line;
        Pattern pattern = Pattern.compile("(\\d+\\s*[+\\-*/] *\\d+\\s*[+\\-*/] *\\d+)");
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
        double num2 = Double.parseDouble(tokens[1]);
        double num3 = Double.parseDouble(tokens[2]);
        String operator1 = tokens[1];
        String operator2 = tokens[2];

        double result1;
        double result2;

        result1 = switch (operator1) {
            case "+" -> num1 + num2;
            case "-" -> num1 - num2;
            case "*" -> num1 * num2;
            case "/" -> num1 / num2;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator1);
        };

        result2 = switch (operator2) {
            case "+" -> result1 + num3;
            case "-" -> result1 - num3;
            case "*" -> result1 * num3;
            case "/" -> result1 / num3;
            default -> throw new IllegalArgumentException("Invalid operator: " + operator2);
        };

        return String.valueOf(result2);
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