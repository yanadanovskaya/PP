package ArithmeticOperations;

import PathStrings.Strings;

import java.util.StringTokenizer;

public class ArithmeticProcess {

        private String data;

        public ArithmeticProcess(String data) {
            this.data = data;
        }

        private String DeleteLatine() {
            StringTokenizer tokenizer = new StringTokenizer(data, Strings.getAlphabetLH());
            StringBuilder temp = new StringBuilder(new String(""));

            while (tokenizer.hasMoreTokens()) {
                temp.append(tokenizer.nextElement());
            }

            return temp.toString();
        }

        public Double getResult() {

            String[] arr = DeleteLatine().split("(?=([+\\-*/]))");

            Double result = Double.parseDouble(arr[0]);

            for (Integer i = 1; i < arr.length; i++) {

                try {
                    String[] temp = arr[i].split("[.]{2,}");

                    for(var id : temp) {
                        System.out.println(id);
                        result = performCalculation(result, id);
                    }

                } catch (Exception e) {
                    e.getMessage();
                }

            }

            return result;
        }

        private Double performCalculation(Double currentResult, String operationAndNumber) {

            String[] operationAndNumberArr = operationAndNumber.split("");

            String operation = operationAndNumberArr[0];

            Double number = Double.parseDouble(operationAndNumber.substring(1));

            return switch (operation) {
                case "+" -> currentResult + number;
                case "-" -> currentResult - number;
                case "*" -> currentResult * number;
                case "/" -> currentResult / number;
                default -> throw new UnsupportedOperationException("Unsupported operation!");
            };

        }

        public static void main(String[] args) {
            ArithmeticProcess arithmeticProcess = new ArithmeticProcess("khgh9.9+*ghghjgvj75++89");
            System.out.println(arithmeticProcess.getResult());

        }

    }

