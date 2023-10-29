import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class processArithmeticOperations {
private static String processArithmeticOperations(String line) {
        Pattern pattern = Pattern.compile("(\\d+\s*[+\\-*/]\s*\\d+)");//ищет матем выражения
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


    double result;
    switch (operator) {
        case "+":
            result = num1 + num2;
            break;
        case "-":
            result = num1 - num2;
            break;
        case "*":
            result = num1 * num2;
            break;
        case "/":
            result = num1 / num2;
            break;
        default:
            throw new IllegalArgumentException("Invalid operator: " + operator);
    }

    return String.valueOf(result);
}    }