import java.io.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MainTest {


        @Test
        public void testMain() throws IOException {
            String inputFile = "test_input.txt";
            String outputFile = "test_output.txt";

            // Создание тестового входного файла
            BufferedWriter inputWriter = new BufferedWriter(new FileWriter(inputFile));
            inputWriter.write("Hello World");
            inputWriter.close();

            // Запуск тестируемого метода
            Main.main(null);

            // Проверка содержимого выходного файла
            BufferedReader outputReader = new BufferedReader(new FileReader(outputFile));
            String result = outputReader.readLine();
            outputReader.close();

            assertEquals("dlroW", result);

            // Удаление тестовых файлов
            File input = new File(inputFile);
            File output = new File(outputFile);
            input.delete();
            output.delete();
        }

        @Test
        public void testMainWithMissingInputFile() {
            assertThrows(FileNotFoundException.class, () -> Main.main(null));
        }

        @Test
        public void testMainWithIOException() {
            assertThrows(IOException.class, () -> Main.main(null));
        }
    }

