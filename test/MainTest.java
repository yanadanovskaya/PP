import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MainTest {

            @Test
            public void testProcessArithmeticOperations() {
            String input = "2 + 3 * 4 - 5 / 2";
            String expectedOutput = "14.5";
            String actualOutput = Main.processArithmeticOperations(input);
            assertEquals(expectedOutput, actualOutput);
        }

        @Test
        public void testProcessWithoutRegex() {
            String input = "2 + 3 * 4 - 5 / 2";
            String expectedOutput = "14.5";
            String actualOutput = Main.processWithoutRegex(input);
            Assertions.assertEquals(expectedOutput, actualOutput);
        }

        @Test
        public void testMainWithIOException() {
            assertThrows(IOException.class, () -> Main.main(null));
        }
    }

