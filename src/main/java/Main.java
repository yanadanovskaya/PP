import java.io.*;
public class Main {
    public static void main(String[] args) {
        String inputFile = args[0];
        String outputFile = args[1];

        try {
            // архивация файла
            Program.archiveFile(inputFile, outputFile + ".zip");

            // шифрование архива
            Program.encryptFile(outputFile + ".zip", outputFile);

            System.out.println("Processing is complete. The result is written to a file: " + outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
