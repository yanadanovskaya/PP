public class ArithmeticOperationProcessor {

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